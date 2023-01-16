package com.sist.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodLocationVO;

public class FoodModel {
	public void boardListData(HttpServletRequest request, HttpServletResponse response)
	{
		String page =request.getParameter("page");
		if(page==null)
			page="1";
		int curpage =Integer.parseInt(page);
		FoodDAO dao = new FoodDAO();
		ArrayList<FoodLocationVO> list =dao.seoullocationListData(curpage);
		
		request.setAttribute("list", list);		
	}
}
