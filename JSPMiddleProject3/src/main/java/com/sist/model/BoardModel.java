package com.sist.model;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.SimpleAttributeSet;

import com.sist.dao.BoardDAO;
import com.sist.vo.*;

public class BoardModel {
	 public void boardListData(HttpServletRequest request,HttpServletResponse response)
	 {
		 String page =request.getParameter("page");
		 if(page ==null)
			 page="1";
		 int curpage =Integer.parseInt(page);
		 
		  BoardDAO dao = new BoardDAO();
		  ArrayList<BoardVO>  list =dao.boardListData(curpage);
		  
		   request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		  request.setAttribute("list", list); // JSP에 전송
	 }
}
