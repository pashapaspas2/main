<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><head><title>Welcome user</title></head>
<body>
<h3>Welcome, user</h3>
<hr/>
 ${user.name}, hello!
<hr/>
Литература библиотеки: <hr/>
<select name="selectbook" >
	<c:forEach var="item" items="${books}">
		<option value="${item.id}">
			${item.name}
		</option>
	</c:forEach>
</select>
Ваши книги: <hr/>
<table>
    <c:forEach items="${userbooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>


<a href="controller?command=logout">Logout</a>
</body></html>