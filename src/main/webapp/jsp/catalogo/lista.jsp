<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="curso.java.tienda.model.producto.Producto" %>
<%@ page import="curso.java.tienda.model.producto.ProductoDAO" %>
<%@include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Mi tienda</title>
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a  href="<%=request.getContextPath()%>/crearProducto" type="button" class="btn btn-light text-dark me-2">CREAR PRODUCTO</a>
<form action="/Inicio">
		<table class="table table-striped" >
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Precio</th>
			<th>Stock</th>
			<th></th>
			<th></th>
		</tr>
		
			<%
			ArrayList<Producto> listado_Productos = (ArrayList<Producto>) request.getAttribute("listadoProductos");
			%>

<% 
if(listado_Productos!=null) {
    for(int i=0; i<listado_Productos.size(); i++) {
    	Producto p = listado_Productos.get(i);
    
 %>	
   <tr>
    
   	   <td><%= p.getId()%></td>
	   <td><%= p.getNombre()%></td>
	   <td><%= p.getDescripcion()%></td>
	   <td><%= p.getPrecio()%> €</td>
	   <td><%= p.getStock()%></td>
	   <td><a href="<%=request.getContextPath()%>/carrito?op=add&id=<%=p.getId()%>">Añadir</a></td>
	   <td><a href="<%=request.getContextPath()%>/carrito?id=<%=p.getId()%>">Eliminar</a></td>
	   
   </tr>
  <%    	
    }
}
%>
		
	</table>		
</form>


</body>

</html>
<%@include file="/footer.jsp" %>