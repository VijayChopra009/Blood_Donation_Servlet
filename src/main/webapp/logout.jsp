<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%  
  session.removeAttribute("email");
	session.removeAttribute("name");
	session.removeAttribute("id");
	session.removeAttribute("A");
	session.removeAttribute("An");
	session.removeAttribute("B");
	session.removeAttribute("Bn");
	session.removeAttribute("AB");
	session.removeAttribute("ABn");
	session.removeAttribute("O");
	session.removeAttribute("On");
	session.invalidate();
   %>
   <jsp:forward page="index.html"/>
</body>
</html>