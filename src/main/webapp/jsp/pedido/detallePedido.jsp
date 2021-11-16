<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="curso.java.tienda.model.pedido.Pedido" %>
<%@ page import="curso.java.tienda.model.pedido.DetallePedido" %>
<%@include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Mi tienda</title>
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<a  href="<%=request.getContextPath()%>/historial" type="button" class="btn btn-light text-dark me-2">Volver a pedidos</a>
<form action="<%=request.getContextPath()%>" method="get">
		 <table class="table table-striped" >
		
		<tr>
			<!-- <th>ID</th>
			<th>ID Pedido</th>
			<th>ID Producto</th>
			 -->
			<th>Nombre Producto</th>
			<th>Precio</th>
			<th>Unidades</th>
			<th>Total</th>
			
		</tr>
		
			<%
			ArrayList<DetallePedido> historial_dp = (ArrayList<DetallePedido>) request.getAttribute("historialdp");
			//Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

			request.getSession().getAttribute("id_pedido");
			%>

<% 
for(int i=0; i<historial_dp.size(); i++) {
    DetallePedido dp = historial_dp.get(i);
 %>	
   <tr>
    	<!--  
   	   <td><%= dp.getId()%></td>
   	   <td><%= dp.getId_pedido()%></td>
	   <td><%= dp.getId_producto()%></td>
	   -->
	   <td><%= dp.getNombre_producto()%> </td>
	   <td><%= dp.getPrecio_unidad()%> €</td>
	   <td><%= dp.getUnidades()%> </td>
	   <td><%= dp.getTotal()%> €</td>
	  
	 
	   
	   
   </tr>
<%		
			
}

%>
		
	</table>		
</form>


</body>

</html>
<%@include file="/footer.jsp" %>