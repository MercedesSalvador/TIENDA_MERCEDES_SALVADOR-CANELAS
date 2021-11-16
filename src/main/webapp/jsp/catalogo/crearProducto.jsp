<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Producto</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css" />
    
</head>
<body id="body">
     <%
	String mensaje = (String) request.getAttribute("mensaje");
	if(mensaje == null) {
		mensaje = "";
	}
%>
    
    
    <form  action="<%=request.getContextPath()%>/crearProducto" method="post">
        <fieldset id="cajaPrincipal">
            <div>
                <h2>Crear Producto</h2>
            </div>
            
            <div  >
                <input class="input" type="text" name="nombre" placeholder="Nombre Producto">
                <br></br>
            </div>  
            <div >
                <input class="input" type="text" name="descripcion" placeholder="Descripción">
                <br></br>
            </div>
            <div >
                <input class="input" type="text" name="precio" placeholder="Precio">
                <br></br>
            </div>
            <div >
                <input class="input" type="text" name="stock" placeholder="Stock">
                <br></br>
            </div>
            <div > 
                <input id="botonLogin"  type="submit" name="crear" value="Crear">
            </div>
            
        </fieldset>
    </form>
    <%= mensaje %> 
</body>
</html>