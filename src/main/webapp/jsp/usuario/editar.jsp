<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="curso.java.tienda.model.usuario.Usuario" %>
<!doctype html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="generator" content="Hugo 0.88.1">
    <title>EditarUsuario</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/signin.css" rel="stylesheet">
  </head>
<body class="text-center">

<%
Usuario u = (Usuario)request.getAttribute("usuario");
%>
    
<main class="form-signin">


  <form  action="<%=request.getContextPath()%>/actualizarUsuario" method="post">

    
    <h1 id="iniciarSesion" class="h3 mb-3 fw-normal">EDITAR USUARIO</h1>
    <img class="mb-4" src="<%=request.getContextPath()%>/img/iconslogin.png" alt="" width="72">
	
	<input type="hidden" id="id" name="id" value="<%= u.getId() %>"/>
	
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Nombre" name="nombre" value="<%= u.getNombre() %>">
      <label for="floatingInput">Nombre</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Primer Apellido" name="apellido1" value="<%= u.getApellido1() %>">
      <label for="floatingInput">Primer Apellido</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Segundo Apellido" name="apellido2" value="<%= u.getApellido2() %>">
      <label for="floatingInput">Segundo Apellido</label>
    </div>
     <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="email" name="email" >
      <label for="floatingInput">email</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Contraseña" name="clave" disabled>
      <label for="floatingPassword">Contraseña</label>
    </div>
     <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Repetir contraseña" name="clave2" disabled>
      <label for="floatingPassword">Repetir Contraseña</label>
    </div>

    <button id="enviar" class="w-100 btn btn-lg btn-primary" onclick="res()" type="submit">Guardar</button>
    
    <p class="mt-5 mb-3 text-muted">&copy; Serbatic 2021</p>
  </form >

</main>


    
  </body>
</html>