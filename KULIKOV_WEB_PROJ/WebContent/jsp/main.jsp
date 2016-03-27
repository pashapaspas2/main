<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome admin</title></head>
<body>
<h3>Welcome, admin</h3>
<hr/>
 ${user}, hello!
<hr/>
<input type="hidden" name="command" value="goadd" />
Нажмите на кнопку, чтобы книгу добавить
<hr/>
<input type="submit" value="Добавить книгу"/>
${adderror}
Links for admin...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout">Logout</a>
</body></html>