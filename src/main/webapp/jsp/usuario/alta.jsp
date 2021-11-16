<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../header.jsp" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RefistroUsuario</title>
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

    <form  action="<%=request.getContextPath()%>/alta" method="post">
        <fieldset id="cajaPrincipal">
            <div>
                <h2>Registro Usuario</h2>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/img/iconslogin.png" width="100 px"/>
            </div>
            <div  >
                <input class="input" type="text" name="nombre" placeholder="Nombre" required>
                <br></br>
            </div>  
            <div  >
                <input class="input" type="text" name="apellido1" placeholder="Primer Apellido" required>
                <br></br>
            </div>  
             <div  >
                <input class="input" type="text" name="apellido2" placeholder="Segundo Apellido" required>
                <br></br>
            </div>
             <div  >
                <input class="input" type="text" name="dni" placeholder="DNI" required>
                <br></br>
            </div>
             <div  >
                <input class="input" type="text" name="calle" placeholder="Calle" required>
                <br></br>
            </div>
             <div  >
                <input class="input" type="text" name="localidad" placeholder="Localidad" required>
                <br></br>
            </div>
             <div  >
                <input class="input" type="text" name="provincia" placeholder="Provincia" required>
                <br></br>
            </div>
             <div  >
                <input class="input" type="text" name="telefono" placeholder="Teléfono" required>
                <br></br>
            </div>

            <div  >
                <input class="input" type="text" name="email" placeholder="Email" required>
                <br></br>
            </div>  
            <div >
                <input class="input" type="password" name="clave" placeholder="Contraseña" required>
                <br></br>
            </div>
            <div > 
                <input id="botonLogin" type="submit" name="enviar" value="Registrarse">
                <br></br>
            </div>
           
     
            </div>
            <p class="msg"> <%=mensaje%></p>
        </fieldset>
         
    </form>
    
</body>
</html>
<%@include file="../../footer.jsp" %> 