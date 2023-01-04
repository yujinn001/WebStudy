package com.sist.service;
import com.sist.dao.*;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataCollectionService {
   public static void main(String[] args) {
      DataCollectionService ds = new DataCollectionService();
      //ds.foodCategoryGetData();
      ds.foodDetailData();
      //
      ds.goodsAllData();
   }
   public void foodCategoryGetData()
   {
      FoodDAO dao = new FoodDAO();
      try
      {
         // 사이트 연결 => HTML 태그 읽기 
         Document doc =Jsoup.connect("https://www.mangoplate.com/").get();
         //System.out.println(doc.toString()); // 망고 플레이트의 html이 들어온다
         Elements title= doc.select("div.top_list_slide div.info_inner_wrap span.title"); // class여서 .을 사용한다
         //System.out.println(title.toString());
         Elements subject= doc.select("div.top_list_slide div.info_inner_wrap p.desc");
         Elements poster= doc.select("div.top_list_slide img.center-croping");
         Elements link= doc.select("div.top_list_slide a");
         //System.out.println(link.toString());
         for(int i =0; i<title.size(); i++ )
         {                      // 데이터 값을 읽는 방법 : get()
            System.out.println(i+1);
            System.out.println(title.get(i).text());
            System.out.println(subject.get(i).text());
            System.out.println(poster.get(i).attr("data-lazy"));
            System.out.println(link.get(i).attr("href"));
            System.out.println("====================");
            /*
             *  text() <태그명>데이터</태그명>
             *  attr("속성명") <태그명 속성 ="값"> 
             *  data() <script></script>
             *  html() <태그명>
             *            데이터
             *          </태그명>
             *         </태그명>
             *  <div class ="a">
             *     <ul>
             *       <li>
             *         제목, ...
             *         
             *       </li>
             *  
             */
            CategoryVO vo= new CategoryVO();
            vo.setTitle(title.get(i).text());
            vo.setSubject(subject.get(i).text());
            vo.setPoster(poster.get(i).attr("data-lazy"));
            vo.setLink(link.get(i).attr("href"));
            dao.foodCategoryInsert(vo);
            //데이터 수집 
         }
      }
      catch(Exception ex) {}
   }
   public void foodDetailData()
   {
      FoodDAO dao = new FoodDAO();
      try
      
      {
         ArrayList<CategoryVO> list =dao.foodCategoryInfoData();
         for(CategoryVO vo : list)
         {
            FoodVO fvo = new FoodVO();
            fvo.setCno(vo.getCno());
            
            System.out.println(vo.getCno()+" "+vo.getTitle()+" "+vo.getLink());
            //System.out.println(vo.getCno()+"."+vo.getTitle());
            Document doc = Jsoup.connect(vo.getLink()).get();
            Elements link = doc.select("section#contents_list span.title a");
            
            for(int i =0; i<link.size();i++)
            {
               System.out.println(link.get(i).attr("href"));
               Document doc2= Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();
                //1.이미지
               Elements image =doc2.select("div.list-photo_wrap img.center-croping");
               String poster="";
               for(int j=0; j<image.size();j++)
               {
                  String s =image.get(j).attr("src");
                  poster+=s+"^";
                  
               }
               poster=poster.substring(0,poster.lastIndexOf("^"));
               System.out.println(poster);
               // 오라클에서 &는 값이 없어지므로 임시 대체
               poster=poster.replace("&", "#");
               fvo.setPoster(poster); // 값을 채워서 db로 보내기
               
               // 2. 맛집명
               Element name = doc2.selectFirst("span.title h1.restaurant_name"); //첫번째 있는 값을 달라
               Element score = doc2.selectFirst("strong.rate-point span");
               System.out.println(name.text()+" "+score.text());
               fvo.setName(name.text());
               fvo.setScore(Double.parseDouble(score.text())); // 데이터형을 맞춰서 넣어준다
               // 3. 평점
               
               // 4. 주소, 전화, 음식 종료, 가격대, 주차, 시간, 메뉴 , 좋아요, 괜찮다, 별로
               String address ="no",tel="no",type="no",price="no",time="no",menu="no",parking="no";
               Elements detail =doc2.select("table.info tbody tr th");
               
               for(int k =0; k<detail.size(); k++)
               {   // 태그안에 있는 값을 가져온다
                  //System.out.println(detail.get(i).text());
                  String label =detail.get(k).text();
                  if(label.equals("주소"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                     address=a.text();
                  }
                  else if(label.equals("전화번호"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                     tel=a.text();
                  }
                  else if(label.equals("음식 종류"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                     type=a.text();
                  }
                  else if(label.equals("가격대"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                     price=a.text();
                  }
                  else if(label.equals("주차"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                     parking=a.text();
                  }
                  else if(label.equals("영업시간"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                     time=a.text();
                  }
                  else if(label.equals("메뉴"))
                  {
                     Element a =doc2.select("table.info tbody tr td").get(k); 
                      menu=a.text();
                  }
               }
               String addr1=address.substring(0,address.indexOf("지"));
               String addr2 =address.substring(address.indexOf("지")+3);
               System.out.println("주소 : "+addr1 );
               System.out.println("지번 : "+addr2 );
               
               System.out.println("전화 : "+tel);
               System.out.println("음식종류 : "+type);
               System.out.println("가격대 : "+price);
               System.out.println("시간 : "+ time);
               System.out.println("주차 : "+parking);
               
               fvo.setAddress(address);
               fvo.setTel(tel);
               fvo.setType(type);
               fvo.setPrice(price);
               fvo.setParking(parking);
               fvo.setTime(time);
               fvo.setMenu(menu);

               
               Element script = doc2.selectFirst("script#reviewCountInfo");
               System.out.println(script.data()); //script안에 있는 데이터 읽기 => data()
                //[{"action_value":1,"count":4},{"action_value":2,"count":5},{"action_value":3,"count":49}]
               String s =script.data();
               JSONParser jp =new JSONParser();
               /*
                *  1. HTML 데이터 추출 => HTMLParser => Jsoup
                *  2. Json 데이터 추출 => JSONParser 
                *  3. XML 데이터 추출 => DocumentBuilder
                */
               // => Restful
               JSONArray arr = (JSONArray)jp.parse(s);
               //System.out.println(arr.toString());
               for(int y =0; y<arr.size();y++)
               {
                  JSONObject obj =(JSONObject)arr.get(y);
                  if(y==0)
                  {
                     System.out.print("별로("+obj.get("count")+")");
                      String ss = String.valueOf(obj.get("count"));
                      fvo.setBad(Integer.parseInt(ss));
                  }
                  else if(y==1)
                  {
                     System.out.print(" 괜찮다("+obj.get("count")+")");
                     String ss = String.valueOf(obj.get("count"));
                     fvo.setSoso(Integer.parseInt(ss));
                  }
                  else if(y==2)
                  {
                     System.out.println(" 좋아요("+obj.get("count")+")");
                     String ss = String.valueOf(obj.get("count"));
                     fvo.setGood(Integer.parseInt(ss));
                  }
               }
               
               System.out.println("========================");
               dao.foodDetailInsert(fvo);
            }
         }
         /*
          * 오라클에서&는 값이 없어진다 
          * https://mp-seoul-image-production-s3.mangoplate.com/15964/652152_1632445289291_19886?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^
          * https://mp-seoul-image-production-s3.mangoplate.com/15964/2221854_1656027051275_6948?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^
          * https://mp-seoul-image-production-s3.mangoplate.com/15964/2221854_1656027051275_6995?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^
          * https://mp-seoul-image-production-s3.mangoplate.com/15964/2221854_1656027051275_7005?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80^
          * https://mp-seoul-image-production-s3.mangoplate.com/707184_1648003735535360.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80
          */
      }catch(Exception ex) {}
   }
   
   
   
   /////////////////////////////////////////GOODS
   /*
		<a href="https://shop.10000recipe.com/goods/goods_view.php?goodsNo=1000032512&utm_source=10k_web&utm_medium=category_list&utm_campaign=g1000032512" class="common2_sp_link"></a><div class="common2_sp_thumb"><img src="https://recipe1.ezmember.co.kr/cache/data/goods/22/12/51/1000032512/1000032512_detail_056.jpg"></div>
          <div class="common2_sp_caption">
            <div class="common2_sp_caption_tit line2">[美친특가] 테이스티나인 t9 최현석셰프의 스테이크&구이 특가/블랙앵거스 1+1 클리어런스 세일!</div>
             <div class="common2_sp_caption_price_box"><span class="common2_sp_caption_per"><b>72</b>%</span> <strong class="common2_sp_caption_price"><span>4,900</span><small>원</small></strong></div><div class="common2_sp_caption_rv2">
                  <span class="caption_rv2_img"></span><b class="caption_rv2_pt">4.3</b><span class="caption_rv2_ea">(21)</span>
          </div><div class="common2_sp_caption_icon"><span class="icon_free">무료배송</span> </div></div></li><li class="common2_sp_list_li"><a href="https://shop.10000recipe.com/goods/goods_view.php?goodsNo=1000022330&utm_source=10k_web&utm_medium=category_list&utm_campaign=g1000022330" class="common2_sp_link"></a><div class="common2_sp_thumb"><img src="https://recipe1.ezmember.co.kr/cache/data/goods/21/08/34/1000022330/1000022330_detail_010.jpg">
          </div>                       
    */
   /*
    *  
            <!--상단 썸네일//-->
            <div class="s_view_pic">
                <div class="s_view_pic_zoom"><a href="#lyZoom" id="mainImage" >
                        <img src="https://recipe1.ezmember.co.kr/cache/data/goods/22/12/51/1000032512/1000032512_detail_056.jpg" width="1000" height="1000" alt="[美친특가] 테이스티나인 T9 최현석셰프의 스테이크&amp;구이 특가/블랙앵거스 1+1 클리어런스 세일!" title="[美친특가] 테이스티나인 T9 최현석셰프의 스테이크&amp;구이 특가/블랙앵거스 1+1 클리어런스 세일!" class="middle"  />
                    </a>
                </div>
                <div class="s_view_pic_thumb item_photo_slide">
                    <div class="s_view_pic_thumb_arrow"><button type="button" class="slick_goods_prev"><img src="https://recipe1.ezmember.co.kr/img/store/icon_arrow2_pre.png"></button></div>
                    <div class="s_view_pic_thumb_pic">
                        <ul class="slider_wrap slider_goods_nav">
                            <li style="padding: 0;"><a href="javascript:gd_change_image('0', 'detail');"><img src="https://recipe1.ezmember.co.kr/cache/data/goods/22/12/51/1000032512/1000032512_detail_056.jpg" width="1000" height="1000" alt="[美친특가] 테이스티나인 T9 최현석셰프의 스테이크&amp;구이 특가/블랙앵거스 1+1 클리어런스 세일!" title="[美친특가] 테이스티나인 T9 최현석셰프의 스테이크&amp;구이 특가/블랙앵거스 1+1 클리어런스 세일!" class="middle"  /></a></li>
                        </ul>
                    </div>
                    <div class="s_view_pic_thumb_arrow"><button type="button" class="slick_goods_next"><img src="https://recipe1.ezmember.co.kr/img/store/icon_arrow2_next.png"></button></div>
                </div>
            </div>
            
            

    */
   public void goodsAllData()
   {
	   try
	   {   // 페이지가 있는 경우 for문으로 가져온다
		   for(int i =0; i<=238;i++)
		   {
		     Document doc= Jsoup.connect("https://shop.10000recipe.com/index.php?path=category&sort=popular&page="+i).get();
		     Elements link = doc.select("div.s_list_wrap_vt li.common2_sp_list_li a.common2_sp_link");//<a>
		     for(int j=0; j<link.size(); j++)
		     {
		    	 // 링크 오는거 확인
		    	 System.out.println(link.get(j).attr("href"));
		    	 Document doc2 =Jsoup.connect(link.get(j).attr("href")).get();
		    	 Element poster =doc2.selectFirst("div.s_view_pic div.s_view_pic_zoom img ");
		    	                                                
		    	 // 이미지 태그로 들어옴
		    	 System.out.println(poster.attr("src"));
		    	 
		    	 // 제목 타이틀 가져오깅
		    	 Element title =doc2.selectFirst("div.s_view_info h3 p");
		    	 System.out.println(title.text());
		     }
		   }
	   }catch(Exception ex) {}
   }
   
   /////////////////////////////////////////Recipe
   
   
   /////////////////////////////////////////Seoul
}



















