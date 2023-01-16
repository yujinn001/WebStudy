package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

public class FoodModel {
	public void categoryListData(HttpServletRequest request, HttpServletResponse response)
	{
		//DAO 연결
		FoodDAO dao = new FoodDAO();
		ArrayList<CategoryVO> list = dao.categoryListData();
		
		// JSP 전송 = $표시로 출력가능
		request.setAttribute("list", list);
	}
	public void foodListData(HttpServletRequest request, HttpServletResponse response)
	{
		// JSP => <% %> => 자바 메소드 (JSP에서 자바를 최소화) => EL /JSTL
		String cno =request.getParameter("cno");
		FoodDAO dao = new FoodDAO();
		CategoryVO vo=dao.categoryInfoData(Integer.parseInt(cno));
		ArrayList<FoodVO> list= dao.foodListData(Integer.parseInt(cno));
		
		// 동시에 JSP로 전송(food_list.jsp)
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		// request에 저장해서 보내는 데이터는 여러개 전송이 가능 (화면 출력에 관 련된 데이터를 따로 담아서 전송을한다)
	}
	public void foodDetailData (HttpServletRequest request, HttpServletResponse response)
	{
		String fno =request.getParameter("fno");
		FoodDAO dao = new FoodDAO();
		FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
		
		request.setAttribute("vo", vo);
	}
}
























