package com.sist.model;

import com.sist.controller.Controlller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;

@Controlller // 어노테이션
public class MainModel {
	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request, HttpServletResponse response)
	{
		FoodDAO dao = new FoodDAO();
		ArrayList<CategoryVO> list =dao.foodCategoryData();
		request.setAttribute("list", list); //home.jsp
		// include할 파일명을 전송
		request.setAttribute("main_jsp","../main/home.jsp"); //main.jsp
		return "../main/main.jsp";
	}
}
