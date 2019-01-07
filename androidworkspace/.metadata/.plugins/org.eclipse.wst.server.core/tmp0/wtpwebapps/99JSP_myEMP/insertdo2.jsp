<%@page import="test.com.jsp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	//한글처리
	request.setCharacterEncoding("UTF-8");

	// 폼데이터 얻기
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	
	// 오라클로 저장
	EmpDAO dao = new EmpDAO();
	dao.insert(writer,contents);
	
%>

</body>
</html>