<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="curso.java.tienda.model.producto.Producto" %>
<%@page import="curso.java.tienda.model.usuario.Usuario" %>
<%@include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ListaUsuarios</title>
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body>
<h3>Usuarios</h3>
<form action="<%=request.getContextPath()%>/usuario">
		<table class="table table-striped" >
		<tr>
			<th>Nombre</th>
			<th>Primer Apellido</th>
			<th>Segundo Apellido</th>
			<th>Email</th>
			<th>Clave</th>
			<th></th>
			<th></th>
		</tr>
		
			<%
			ArrayList<Usuario> listado_Usuarios = (ArrayList<Usuario>) request.getAttribute("listadoUsuarios");
			%>
		<!--  
			String ruta = request.getContextPath();
			
			if(listado_Usuarios!=null) {
		
			for(int i=0; i<listado_Usuarios.size(); i++)  {
				out.println("<tr>");
				//out.println("<td>"+ listado_Usuarios.get(i).getId() + "</td>");
				out.println("<td>"+ listado_Usuarios.get(i).getNombre() + "</td>");
				out.println("<td>" + listado_Usuarios.get(i).getApellido1()+"</td>");
				out.println("<td>" + listado_Usuarios.get(i).getApellido2()+ "</td>");
				out.println("<td>"+ listado_Usuarios.get(i).getEmail()+ "</td>");
				out.println("<td>"+ listado_Usuarios.get(i).getClave()+ "</td>");
				out.println("<td><a href="+ruta+"/carrito?id="+ listado_Usuarios.get(i).getId() + ">Editar</a></td>");
				out.println("<td><a href="+ruta+"/carrito?id="+ listado_Usuarios.get(i).getId() + ">Eliminar</a></td>");
				out.println("<tr>");
				}
			}
	%>
		</tr>
		-->
	<% 
if(listado_Usuarios!=null) {
    for(int i=0; i<listado_Usuarios.size(); i++) {
    	Usuario us = listado_Usuarios.get(i);
    
  	 %>	
	   <tr>
		   <td><%= us.getNombre()%></td>
		   <td><%= us.getApellido1()%></td>
		   <td><%= us.getApellido2()%></td>
		   <td><%= us.getEmail()%></td>
		   <td><%= us.getClave()%></td>
		   <td><a href="<%=request.getContextPath()%>/adminUsuario?op=edit&id=<%=us.getId()%>">Editar </a></td>
		   <td><a href="<%=request.getContextPath()%>/adminUsuario?op=remove&id=<%=us.getId()%>">Eliminar</a></td>
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