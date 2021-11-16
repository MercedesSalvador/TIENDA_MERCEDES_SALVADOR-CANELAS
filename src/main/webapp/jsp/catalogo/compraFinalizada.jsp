<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
</head>
<body>
<%
String msg= (String)session.getAttribute("mensaje");
%>

	<div class="text-center">
		<br>
		<br> <i class="fas fa-shipping-fast fa-9x" style="color: #94B3FD"></i><br>
		<br>
		<h1 style="color: #94B3AD">Gracias por comprar!</h1>
		<br>
		<div class="row">
			<div class="col-lg-7 mx-auto">
				<strong class="text-muted mb-4"><%=msg %></strong>
			</div>
		</div>
		<br> <br> <br> <br> <a class="btn btn-primary"
			href="<%=request.getContextPath()%>/"> <i
			class="fas fa-shopping-bag me-2"></i>Continuar
		</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <a class="btn btn-primary" href="<%=request.getContextPath()%>/">
			<i class="fas fa-shopping-bag me-2"></i>Volver a Inicio
		</a>
	</div>

<br><br><br><br>



</body>
</html>

<%@include file="/footer.jsp"%>