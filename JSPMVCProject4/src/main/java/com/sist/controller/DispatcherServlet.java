package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import 	org.w3c.dom.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import java.util.*;
import com.sist.model.*;
import java.net.*;
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> list =new ArrayList<String>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		//String path ="C:\\webDev\\webStudy\\JSPMVCProject4\\src\\main\\webapp\\WEB-INF\\application.xml";
				try
				{
					URL url =this.getClass().getClassLoader().getResource(".");
					File file =new File(url.toURI());
					//System.out.println(file.getPath());
					String path =file.getPath();
					path =path.replace("\\", File.separator);
					path = path.substring(0, path.lastIndexOf(File.separator));
					path =path+File.separator+"application.xml";
					System.out.println(path);
					// 1. XML 파서기
					DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
					DocumentBuilder db =dbf.newDocumentBuilder();
					
					Document doc =db.parse(new File(path));
					// Root 태그 => beans
					org.w3c.dom.Element beans=doc.getDocumentElement();
					System.out.println(beans.getTagName());
					NodeList node =beans.getElementsByTagName("bean");
					for(int i=0; i<node.getLength();i++)
					{
						Element bean =(Element)node.item(i);
						String clsName =bean.getAttribute("class");
						System.out.println(clsName);
						list.add(clsName);
					}
				}catch(Exception ex) {}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//uri 받기
		try
		{
			//http://localhost:8080/JSPMVCProject4/main/main.do
			String uri=request.getRequestURI();///JSPMVCProject4/main/main.do 
			uri=uri.substring(request.getContextPath().length()+1);// main/main.do 
			
			for(String cls:list)
			{
				Class clsName=Class.forName(cls);
				if(clsName.isAnnotationPresent(Controller.class)==false) // 클래스 위에 @Controller가 없는 경우 
					continue; // 제외를 한다
				Object obj =clsName.getDeclaredConstructor().newInstance(); //객체 생성 (model)
				// 선언된 모든 메소드 읽기
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m: methods)
				{
					RequestMapping rm =m.getAnnotation(RequestMapping.class); //메소드 위에 @RequestMapping
					if(rm.value().equals(uri))
					{
						String jsp =(String)m.invoke(obj, request,response);
						RequestDispatcher rd =request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						break;
					}
				}
			}
		}catch(Exception ex) {}
	}

}

















