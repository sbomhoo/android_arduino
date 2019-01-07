<%@page import="test.com.jsp.EmpDTO"%>
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
String deptno = request.getParameter("deptno");
EmpDAO dao = new EmpDAO();
EmpDTO dto = dao.retrieve(deptno);
String dname = dto.getDname();
String loc = dto.getLoc();
%>

<form action="update.jsp" method="post">
deptno &nbsp; <input type="text" name="deptno" value="<%= deptno %>" readonly="readonly"><br/>
dname&nbsp;<input type="text" name="dname" value="<%= dname %>" ><br/>
loc&nbsp;<input type="text" name="loc" value="<%= loc %>"><br/>
<input type="submit" value="수정" />
</form>
<a href="/99JSP_myEMP/delete.jsp?deptno=<%= deptno%>">삭제</a>

</body>
</html>