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
<h3>Mis pedidos</h3>
<form action="/Inicio">
		<table class="table table-striped" >
		<tr>
			<th>ID</th>
			<th>ID Usuario</th>
			<th>Estado</th>
			<th>Total</th>
			<th></th>
			<th></th>
		</tr>
		
			<%
			ArrayList<Pedido> historial_pedido = (ArrayList<Pedido>) request.getAttribute("historial");
			//Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			%>

<% 
if(usuario !=null){
	if (historial_pedido != null) {
		for(int i=0; i<historial_pedido.size(); i++) {
    		Pedido p = historial_pedido.get(i);
    		 if(usuario.getId()== p.getId_usuario()){
    		

 %>	
   <tr>
    
   	   <td><%= p.getId()%></td>
   	   <td><%= p.getId_usuario()%></td>
	   <td><%=p.getEstado() %></td>
	   <td><%= p.getTotal()%>  &euro;</td>
	  
	  <td>
	   	<div class="line">
			<div class="form-group row">
				<a class="btn btn-secondary" href="<%=request.getContextPath()%>/historialdp?id=<%=p.getId()%>">
                  Ver detalle del pedido
                </a>
            </div>
        </div>
	  <td>
	  
	  
	<%
		if(p.getEstado().equals("pendiente")){
	
	%>
	<td>
		<div class="line">
				<div class="form-group row">
					<a class="btn btn-secondary" href="<%=request.getContextPath()%>/solicitaCancelacion?id=<%=p.getId()%>">
	                  Solicitar cancelación
	                </a>
	            </div>
	    </div>
	</td>
	<%
	}
	 %> 
	  
	   
	   
   </tr>
<%
			}
		}
	}
}
%>
		
	</table>		
</form>


</body>

</html>
<%@include file="/footer.jsp" %>