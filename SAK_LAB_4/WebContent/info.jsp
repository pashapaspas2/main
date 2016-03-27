<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Jura:400,500&subset=latin,cyrillic' rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="css/info.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<script>
		$(function(){
		  var $form_inputs =   $('form input');
		  var $rainbow_and_border = $('.rain, .border');
		  /* Used to provide loping animations in fallback mode */
		  $form_inputs.bind('focus', function(){
		  	$rainbow_and_border.addClass('end').removeClass('unfocus start');
		  });
		  $form_inputs.bind('blur', function(){
		  	$rainbow_and_border.addClass('unfocus start').removeClass('end');
		  });
		  $form_inputs.first().delay(800).queue(function() {
			$(this).focus();
		  });
		});
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Информация о себе</title>
</head>
${pageContext.session.id }
<h1>HELLO</h1>
<h1>${username}</h1>
<body id="home">
		<div class="rain">
			<div class="border start">
				<form method="post" action="MyServletURL">
				<input type="hidden" name="command" value="step2" />
					<label for="email">Email</label>
					<input name="email" type="text" value="${email }"/>
					<label for="addr">Address</label>
					<input name="addr" type="text" value="${addr }"/>
					<label for="s1">S1</label>
					<input name="s1" type="text" value="${s1 }"/>
					<label for="s2">S2</label>
					<input name="s2" type="text" value="${s2 }"/>
					<label for="s3">S3</label>
					<input name="s3" type="text" value="${s3 }"/>
                                        <input type="submit" value="Confirm"/>
                                        
				</form>
				<a href="index.jsp" class="button">BACK</a>
			</div>
		</div>
	</body>
</html>