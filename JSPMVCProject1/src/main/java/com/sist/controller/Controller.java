package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;


/*
 *  MVC
 *    M(Model) => DAO,VO , Service, Manager => 사용자 요청을 받아서 처리하고 결과값을 넘겨주는 형태(일반 자바)
 *    V(View) => JSP (전송받은 데이터를 출력만 하는 기능)
 *    C(Controller) => 요청받고 Model을 이용해서 처리 => 처리 결과를 View에게 전송
 *    *** 요청받기 : 브라우저에서 (JSP,Servlet)
 *                            |   | 기능을 처리 (보안) => 스프링은 이미 제작 (Servlet)
 *                          화면 출력 
 *  실행 순서 
 *    JSP 
 *     요청하는 부분 => Controller 
 *      <a href ="">
 *      <form action="">
 *      ajax
 */

@WebServlet("/Controller") // 맨마지막주소로 /Controller가 붙는다

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // /Controller?cmd=list
	
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	// doGet() / doPost() => 통합 service()
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd =request.getParameter("cmd");
		if(cmd.equals("list"))
		{
			ListModel model =new ListModel();
			model.execute(request);
		}
		else if(cmd.equals("update"))
		{
			UpdateModel model =new UpdateModel();
			model.execute(request);
		}
		else if(cmd.equals("delete"))
		{
			DeleteModel model =new DeleteModel();
			model.execute(request);
		}
		else if(cmd.equals("insert"))
		{
			InsertModel model =new InsertModel();
			model.execute(request);
		}
		
		// 해당 JSP로 값을 전송 (request)
		RequestDispatcher rd =request.getRequestDispatcher("view/"+cmd+".jsp");
		rd.forward(request, response);

	}


}
