package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class RecipeModel {
	@RequestMapping("recipe/list.do")
	public String recipe_list(HttpServletRequest request, HttpServletResponse response)
	{
		// 사용자가 보내준 페이지를 ㅏㄷ는다
		String page =request.getParameter("page");
		if(page==null)
			page="1";
		int curpage= Integer.parseInt(page); // 현재 페이지 
		// 오라클연결
		RecipeDAO dao= new RecipeDAO();
		// 데이터 읽기
		List<RecipeVO> list=dao.recipeListData(curpage);
		int count =dao.recipeRowCount();
		int totalpage =(int)(Math.ceil(count/20.0)); // 모델에서 바로 처리가능 => 아니면 sql문장을 한번 더 해야 함
		
		
		// 이전 / 다음 하면 안됨 => recipe관련 데이터가 8만개 이상이여서 ==> 이럴 경우, 블럭단위로 나눈다
		final int BLOCK =10;
		int startPage= ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		/*
		 *    [1] ~~~~~~~~~[10] ======> curpage:1~10
		 *    ---
		 *    startpage  endPage        curpage:11~20
		 *    
		 *    startPage: 1, 11, 21...
		 *    endPage:   10, 20, 30...
		 */
		if(endPage>totalpage)
			endPage=totalpage;
		
		
		// request에 담아서 jsp로전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", count);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("main_jsp", "../recipe/list.jsp");
		CommonsModel.footerData(request);
		// 화면 이동
		return "../main/main.jsp";
	}
}
