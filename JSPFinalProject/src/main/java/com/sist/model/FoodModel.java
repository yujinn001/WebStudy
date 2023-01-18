package com.sist.model;

import com.sist.controller.Controlller;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.*;
// Model => 여기서 요청 처리 메소드를 찾는다
import com.sist.controller.RequestMapping;
/*
 *  food/food_location.do => DispatcherServlet
 *                            => service() => @RequestMapping() => 밑에있는 메소드를 호출한다
 *                                                                 method.invoke()
 *     JSP ==> Model ==> DAO
 *         <==      <==
 */
@Controlller // dispatcherservlet을 찾으려면   Controller가 필요
public class FoodModel {
	@RequestMapping("food/food_location.do")
	public String food_location(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../food/food_location.jsp");
		return "../main/main.jsp"; 
	}
}
