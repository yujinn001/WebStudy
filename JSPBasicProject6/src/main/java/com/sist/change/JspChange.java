package com.sist.change;
// jsp에서 switch~case를 이용해서 변경하지 말고 자바만 수정해서 변경하도록 

public class JspChange {
	private static String[] jsp= {
			"../main/home.jsp", // 경로를 써줘야 한다
			"../seoul/location.jsp",
			"../seoul/nature.jsp",
			"../seoul/shop.jsp",
			"../food/food_find.jsp",
			"../databoard/list.jsp",
			"../food/food_detail.jsp",
			"../databoard/insert.jsp",
			"../databoard/detail.jsp",
			"../databoard/delete.jsp",
			"../databoard/update.jsp"
	};
	
	public static String change(int no)
	{	
		return jsp[no]; // change 클래스와 동일하게 jsp배열도 static을 사용해 준다
	}
}
