<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
   body {
    background-image: url(http://gifart.at.ua/_ph/25/130264939.jpg);
    background-size: cover;
   }
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://fonts.googleapis.com/css?family=Jura:400,500&subset=latin,cyrillic' rel='stylesheet' type='text/css'>

<title>Insert title here</title>
</head>
<body>
${pageContext.session.id }
<div class = "center">
<h1> Вас приветствует мастер </h1>
</div>
<form method="post" action="MyServletURL" class="login">
<input type="hidden" name="command" value="step1" />
    <p>
      <label for="login">Имя:</label>
      <input type="text" name="login" id="login" value="${username}">
    </p>

    <p>
      <label for="password">Пароль:</label>
      <input type="password" name="password" id="password" value="${password}">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Войти</button>
    </p>

  </form>

</body>
</html>