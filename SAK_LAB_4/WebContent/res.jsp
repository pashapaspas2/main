<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/res.css" />
<title>Result</title>
</head>
<body>
${pageContext.session.id }</br>
<a  href="info.jsp" class="button1">Назад</a></br></br></br>
<a href="MyServletURL?command=logout" class="button1">Закончить сеанс</a>
<h2>${username}  ${password }</h2>
<table >
<tr>
<th>email = ${email}<img src="https://media2.giphy.com/media/j5MC0FA0EGF2M/200.gif"></th>
<th>address = ${addr}<img src="https://media0.giphy.com/media/mIQ8hrf7puNKo/200.gif"></th>
</tr>
<tr>
<td>s1 = ${s1}<img src="https://media2.giphy.com/media/CE5MnZFgbVZmg/200.gif"></td>
<td> s2 = ${s2}  s3 = ${s3}<img  src="https://media1.giphy.com/media/gsYKROakiJQPu/200.gif"></td>
</tr>
</table> 
</body>
</html>