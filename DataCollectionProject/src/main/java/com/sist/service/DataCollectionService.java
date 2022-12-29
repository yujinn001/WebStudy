package com.sist.service;
import com.sist.dao.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataCollectionService {
	public static void main(String[] args) {
		DataCollectionService ds = new DataCollectionService();
		//ds.foodCategoryGetData();
		ds.foodDetailData();
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
			Elements subject= doc.select("div.top_list_slide div.info_inner_wrap p.desc");
			Elements poster= doc.select("div.top_list_slide img.center-croping");
			Elements link= doc.select("div.top_list_slide a");
			System.out.println(link.toString());
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
				   // 2. 맛집명
				   Element name = doc2.selectFirst("span.title h1.restaurant_name"); //첫번째 있는 값을 달라
				   Element score = doc2.selectFirst("strong.rate-point span");
				   System.out.println(name.text()+" "+score.text());
				   // 3. 평점
				   // 4. 주소, 전화, 음식 종료, 가격대, 주차, 시간, 메뉴 , 좋아요, 괜찮다, 별로
				   String address ="no",tel="no",type="no",price="no",time="no",menu="no",parking="no";
				   try
				   {   
					   // .get(?) 
					   // 주소값 읽어 오기 => tr태그에 가장 첫번째 값을 가져온다
					   Element addr =doc2.selectFirst("table.info tbody tr td");
					   System.out.println(addr.text());
					   Element te =doc2.select("table.info tbody tr td").get(1);
					   System.out.println(te.text());
					   Element ty =doc2.select("table.info tbody tr td").get(2);
					   System.out.println(ty.text());
					   
					   // 있는 데이터 / 없는 데이터 => 예외처리를 한다
					   
				   }catch(Exception ex) {}
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
}




















