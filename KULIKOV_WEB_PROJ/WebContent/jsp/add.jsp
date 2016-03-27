<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>add book</title>
</head>
<body>
<form name="addBookForm" method="POST" action="controller">
<input type="hidden" name="command" value="add" />
Name
<input type="text" name="b_name" value="" /> <hr/>
Description
<input type="text" name="b_descr" value="" /><hr/>
Author
<input type="text" name="b_author" value="" /><hr/>
Price
<input type="text" name="b_price" value="" /><hr/>
Cathegory
<input type="text" name="b_cath" value="" /><hr/>
Нажмите на кнопку, чтобы книгу добавить
<hr/>
<input type="submit" value="Добавить книгу"/>

</form>
</body>
</html>