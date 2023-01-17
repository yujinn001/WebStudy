package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteModel {
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "데이터 삭제");
	}
}
