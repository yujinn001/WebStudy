<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"/>
<jsp:useBean id="rdao" class="com.sist.dao.ReplyDAO"/>
<%
     String fno=request.getParameter("fno");
     // FoodVO
     FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
     ArrayList<ReplyVO> list=rdao.replyListData(Integer.parseInt(fno));
     int count=rdao.replyCount(Integer.parseInt(fno));
     
     //String sex=(String)session.getAttribute("sex");
     
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['리뷰', '현황'],
          ['맛있다', <%=vo.getGood() %>],
          ['괜찮다',  <%=vo.getSoso() %>],
          ['별로', <%=vo.getBad() %>]
          
        ]);
        var options = {
          title: '리뷰 현황',
          is3D: true,
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
    <script type="text/javascript">
    //사용자 프론트 처리 위치
    /*   
       //실행되는 위치 (자바에서 main메소드)
       window.onload=function(){      //브라우저에 화면이 뜨면
       
       }
       
       제이쿼리는 자바스크립트 라이브러리에 해당됨
    */
    let i=0;
    
    $(function(){
       $('.ups').click(function(){
          $('.updates').hide(); //감추기
          let no=$(this).attr('data-no');
          if(i==0)
          {
             $(this).text("취소");
             $('#r'+no).show();
             i=1;   
          }
          else
          {
             $(this).text("수정");
             $('#r'+no).hide();
             i=0;
          }
       })
    })
    </script>
</head>
<body>
   <table class="table">
     <tr>
       <%
           String poster=vo.getPoster();
           poster=poster.replace("#", "&");
           StringTokenizer st=new StringTokenizer(poster,"^");
           while(st.hasMoreTokens())
           {
       %>
              <td class="text-center">
               <img src="<%=st.nextToken() %>" style="width:100%">
              </td>
       <%
           }
       %>
     </tr>
   </table>
   <div style="height: 10px"></div>
   <div class="row">
    <div class="col-sm-8">
      <table class="table">
       <tr>
        <td colspan="2">
          <h3><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></h3>
        </td>
       </tr>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">주소</span></th>
         <td width="85%"><%=vo.getAddress() %></td>
       </tr>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">전화</span></th>
         <td width="85%"><%=vo.getTel() %></td>
       </tr>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">음식종류</span></th>
         <td width="85%"><%=vo.getType() %></td>
       </tr>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">가격대</span></th>
         <td width="85%"><%=vo.getPrice() %></td>
       </tr>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">영업시간</span></th>
         <td width="85%"><%=vo.getTime() %></td>
       </tr>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">주차</span></th>
         <td width="85%"><%=vo.getParking() %></td>
       </tr>
       <%
          if(!vo.getMenu().equals("no"))
          {
       %>
       <tr>
         <th class="text-right"  width=15%><span style="color:gray">메뉴</span></th>
         <td width="85%">
           <ul>
             <%
                st=new StringTokenizer(vo.getMenu(),"원");
                while(st.hasMoreTokens())
                {
             %>
                   <li><%=st.nextToken() %>원</li>
             <%
                }
             %>
           </ul>
         </td>
       </tr>
       <%
          }
       %>
       <tr>
         <td colspan="2" class="text-right">
           <input type=button class="btn btn-xs btn-success" value="찜하기">
           <input type=button class="btn btn-xs btn-info" value="좋아요">
           <input type=button class="btn btn-xs btn-warning" value="예약">
           <input type=button class="btn btn-xs btn-primary" value="목록" onclick="javascript:history.back()">
           
         </td>
       </tr>
      </table>
      <div style="height: 10px"></div>
      댓글&nbsp;(<%=count %>)
      <hr>
      <%
         String id=(String)session.getAttribute("id");
         if(count==0)
         {
      %>
            <span style="color:gray">등록된 댓글이 없습니다 </span>
      <%   
         }
         else
         {
      %>
            <table class="table">
              <tr>
                <td>
                 <%
                   for(ReplyVO rvo:list)
                   {
                %>
                      <table class="table">
                        <tr>
                          <td class="text-left">◑<%=rvo.getName() %>&nbsp;(<%=rvo.getDbday() %>)</td>
                          <td class="text-right">
                            <%
                               if(id!=null)
                               {
                                  if(id.equals(rvo.getId()))
                                  {
                            %>
                                     <span class="btn btn-xs btn-primary ups" data-no="<%=rvo.getNo()%>">수정</span>
                                     <%--
                                        Ajax => 자바스크립트
                                      --%>
                                     <a href="../reply/reply_delete.jsp?no=<%=rvo.getNo() %>&fno=<%=fno %>" class="btn btn-xs btn-danger">삭제</a>
                            <%           
                                  }
                               }
                            %>
                          </td>
                        </tr>
                        <tr>
                          <td colspan="2" class="text-left" valign="top"><pre style="white-space:pre-wrap;background-color: white;border: none"><%=rvo.getMsg() %></pre></td>
                        </tr>
                        <tr style="display:none" id="r<%=rvo.getNo() %>" class="updates">
                      <td colspan="2">
                         <form method=post action="../reply/reply_update.jsp">
                          <input type =hidden name =no value ="<%=rvo.getNo() %>">
                          <input type=hidden name=fno value="<%= vo.getFno()%>"> <!-- 맛집번호에 댓글을 올리겠다 -->
                          <%-- 화면으로 다시 이동 (맛집 상세보기) --%>
                          <textarea rows="4" cols="50" name="msg" style="float: left"><%=rvo.getMsg() %></textarea>
                          <input type="submit" value="댓글수정" class="btn btn-sm btn-danger" style="float: left; height: 88px">
                          </form>
                      </td>
                    </tr>
                      </table>
                <%   
                   }
                 %>
                </td>
              </tr>
            </table>
      <% 
         }
      %>
      <%
         
         if(id!=null) //로그인이 됐다면 session에 값이 있는지 없는지로 판단 (세션 값의 존재 여부)
         {
      %>
      <table class="table">
        <tr>
          <td>
            <form method=post action="../reply/reply_insert.jsp">

             <input type=hidden name=fno value="<%= vo.getFno()%>"> <!-- 맛집번호에 댓글을 올리겠다 -->
            <textarea rows="4" cols="55" name="msg" style="float: left"></textarea>
            <input type="submit" value="댓글쓰기" class="btn btn-sm btn-danger" style="float: left; height: 88px">
             </form>
          </td>
        </tr>
      </table>
       <%      
         }
      %>
      <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
    </div>
    <div class="col-sm-4">
    
    </div>
   </div>
</body>
</html>