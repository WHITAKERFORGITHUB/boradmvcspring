<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script>
$(function(){
	//--게시물 클릭 시작--
	$("section>table tr>td").click(function(event){
		var board_no = $(event.target).parent().children("td.board_no").html().trim();
		$("section>form>input[name=board_no]").val(board_no);
		var $formObj = $("form");
		$formObj.attr("method", "get");
		$formObj.attr("action", "${contextPath}/detail");
		$formObj.submit();
		return false;
	});
	//--게시물 클릭 끝--
	
	//--검색버튼 클릭 시작--
	$("section>form>input[type=button]").click(function(){
		var $formObj = $("form");
		$formObj.attr("method", "get");
		$formObj.attr("action", "${contextPath}/list");
		$formObj.submit();
		return false;
	});
	//--검색버트 클릭 끝--
});
</script>
<style>
*{
  box-sizing: border-box;
}
section>table{
  border: 1px solid; border-collapse: collapse; width:60%;
}
section>table tr>td {
  border: 1px solid;
  text-align: center;
}
section>table tr>td.board_no{ width: 10%;}
section>table tr>td.board_title{ width: 30%; text-align: left;}
section>table tr>td.board_writer{ width: 20%; text-align: left;}
section>table tr>td.board_dt{ width: 30%;}
section>table tr>td.board_cnt{ width: 10%; }
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>

<section>
<form>
  <input type="hidden" name="board_no">
  <input type="search" name="word"><input type="button" value="검색">
</form>
<table>
<c:forEach items="${requestScope.list}" var="board">
 <tr>
   <td class="board_no">${board.board_no}</td>
   <td class="board_title">
      <c:forEach begin="2" end="${board.level}" step="1">&#10149;
      </c:forEach>${board.board_title}
   </td>
   <td class="board_writer">${board.board_writer}</td>
   <td class="board_dt">${board.board_dt}</td>
   <td class="board_cnt">${board.board_cnt}</td>
 </tr>
</c:forEach>
</table>
</section>

<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>