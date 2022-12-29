package com.sist.service;

import java.io.File;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class HTMLParser {
	
	// 구분이 있는 경우
	public void htmlGetData()
	{
		try
		{// 외부에서 url 읽을 때는 => connect
	     // 내부의 파일을 읽을 때는  => parse
			// 데이터가 doc에 들어와 있다
			Document doc =Jsoup.parse(new File("C:\\webDev\\webStudy\\HTMLCSSProject2\\src\\main\\webapp\\css\\css_1.html"));
			// 파일이 들어오는지 확인
			//System.out.println(doc.toString());
			// h1에는 h1태그 들어와있다
			//Elements h1 =doc.select("div.b h1"); // 1개 Element , 여러개 => Elements
			// h1의 태그와 값이 보인다
			//System.out.println(h1.toString());
//			for(int i =0; i<h1.size();i++)
//			{   // 값만 보이게 하는 방법!! => 태그와 태그 사이의 값만 나오게 한다
//				System.out.println(h1.get(i).text());
//			}
			Element name = doc.select("div.b h1").get(3);
			System.out.println(name.text());
		}catch(Exception ex) {}
	}
	
	// 실제 망고플레이트 값 가져오기
	// 구분이 없는 경우 => <table> => <td> , <ul> => <li>, <dl> => <dd>
	public void foodDetailData()
	{
		try
		{
			Document doc =Jsoup.parse(new File("C:\\webDev\\webStudy\\HTMLCSSProject2\\src\\main\\webapp\\css\\css_3.html"));
			// doc 데이터가 들어오는 확인하는 방법
			//System.out.println(doc.toString());
			Elements detail =doc.select("table.info tbody tr th");
			String address =" ",tel =" ",type=" ",price=" ",parking=" ",time=" ",menu=" ";
			
			for(int i =0; i<detail.size(); i++)
			{   // 태그안에 있는 값을 가져온다
				//System.out.println(detail.get(i).text());
				String label =detail.get(i).text();
				if(label.equals("주소"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
					address=a.text();
				}
				else if(label.equals("전화번호"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
					tel=a.text();
				}
				else if(label.equals("음식 종류"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
					type=a.text();
				}
				else if(label.equals("가격대"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
					price=a.text();
				}
				else if(label.equals("주차"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
					parking=a.text();
				}
				else if(label.equals("영업시간"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
					time=a.text();
				}
				else if(label.equals("메뉴"))
				{
					Element a =doc.select("table.info tbody tr td").get(i); 
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
			StringTokenizer st = new StringTokenizer(menu, "원");
			while(st.hasMoreTokens())
			{
				System.out.println(st.nextToken()+"원");
			}
		}catch(Exception ex){}
	}
	/*
	 *  <td>데이터값</td> => doc.select("~~~~td") => text()
	 */
	// 속성값 읽기 <img src ="이미지명 "> doc.select ("~~ img") => attr("src")
	public void foodAttributeData()
	{
		try
		{
			Document doc = Jsoup.parse(new File("C:\\webDev\\webStudy\\HTMLCSSProject2\\src\\main\\webapp\\css\\css_4.html"));
			//System.out.println(doc.toString());
			Elements image =doc.select("div.list-photo_wrap img.center-croping"); 
			// 전체 태그 감싸는거 1개  // 태그.클래스 이름 태그.클래스 명칭
			// 이미지 태그 들어오는지 확인
			System.out.println(image.toString());
			for(int i=0; i<image.size(); i++)
			{   // 이미지 태그안에있는 값!!(src)
				System.out.println(image.get(i).attr("src"));
			}
		}catch(Exception ex) {}
	}
		
	// HTML 읽기
	/*
	 *   <div class ="a">
	 *   	<span>Hello</span>
	 *      <span>
	 *       <p> HTML/CSS</p>
	 *      </span>
	 *   </div>
	 *   
	 *   doc.select("div.a") => text() => 데이터만 => HEllo HTML/CSS
	 *   doc.select("div.a") => html() => 안에있는 모든 태그를 =><span>Hello</span>
									       <span>
									        <p> HTML/CSS</p>
									       </span>
	 *   
	 */
	public void htmlData()
	{
		try
		{
			Document doc =Jsoup.parse(new File("C:\\webDev\\webStudy\\HTMLCSSProject2\\src\\main\\webapp\\css\\css_5.html"));
			Elements div = doc.select("div.a");
			System.out.println(div.text()); // 태그안의 값을 읽을때
			System.out.println(div.html()); // div안에 있는 모든 태그를 가져온다
		}catch(Exception ex) {}
	}
	
	// 자바스크립트 읽기
	public void scriptData()
	{
		try {
			Document doc = Jsoup.parse(new File("C:\\webDev\\webStudy\\HTMLCSSProject2\\src\\main\\webapp\\css\\css_6.html"));
			Element script = doc.selectFirst("script#reviewCountInfo");
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
			System.out.println(arr.toString());
			for(int i =0; i<arr.size();i++)
			{
				JSONObject obj =(JSONObject)arr.get(i);
				if(i==0)
				{
					System.out.print("별로("+obj.get("count")+")");
				}
				else if(i==1)
				{
					System.out.print(" 괜찮다("+obj.get("count")+")");
				}
				else if(i==2)
				{
					System.out.print(" 좋아요("+obj.get("count")+")");
				}
			}
		}catch(Exception ex) {}
	}
	/*
	 * text()
	 * attr()
	 * html()
	 * data()
	 */
	
	
	public static void main(String[] args) {
		HTMLParser hp = new HTMLParser();
		//hp.htmlGetData();
		//hp.foodAttributeData();
		hp.scriptData();
	}
}


















