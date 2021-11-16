<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../header.jsp" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LoginUser</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
      
</head>
<body id="body">
    <%--  aquí se le pasa un mensaje si el usuario y/o contraseña son incorrectos --%>
<%
	String mensaje = (String) request.getAttribute("mensaje");
	if(mensaje == null) {
		mensaje = "";
	}
%>

    <form  action="<%=request.getContextPath()%>/Login" method="post">
        <fieldset id="cajaPrincipal">
            <div>
                <h2>Iniciar Sesión</h2>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/img/iconslogin.png" width="100 px"/>
            </div>
            <div  >
                <input class="input" type="text" name="email" placeholder="email" required>
                <br></br>
            </div>  
            <div >
                <input class="input" type="password" name="clave" placeholder="contraseña" required>
                <br></br>
            </div>
            <div > 
                <input id="botonLogin" type="submit" name="enviar" value="Iniciar Sesión">
                <br></br>
            </div>
           
            <div>
             	<a  href="<%=request.getContextPath()%>/alta" id="enviar" type="button" >
             		<input id="botonLogin" type="button" value="Registrarse">
            	</a>
     
            </div>
            <p class="msg"> <%=mensaje%></p>
        </fieldset>
         
    </form>
    
</body>
</html>
<%@include file="../../footer.jsp" %> 