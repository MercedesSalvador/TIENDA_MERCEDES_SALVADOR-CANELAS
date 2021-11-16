<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="curso.java.tienda.model.producto.Producto" %>
<%@ page import="curso.java.tienda.model.pedido.DetallePedido" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Juguetería online</title>

  
    

    <!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

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
    <link href="<%= request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
  </head>
  <body>
    
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Bienvenido admin</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <div class="navbar-nav">
    <div class="nav-item text-nowrap">
      <a class="nav-link px-3" href="<%=request.getContextPath()%>/cerrarSesion">Desconectar</a>
    </div>
  </div>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/jsp/admin/admin.jsp">
              <span data-feather="home"></span>
              Dashboard
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/historialAdmin">
              <span data-feather="file"></span>
              Pedidos
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/catalogoAdmin">
              <span data-feather="shopping-cart"></span>
              Productos
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/usuarioAdmin">
              <span data-feather="users"></span>
              Clientes
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span>
              Reports
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="layers"></span>
              Integrations
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Saved reports</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Current month
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Last quarter
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Social engagement
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Year-end sale
            </a>
          </li>
        </ul>
      </div>
    </nav>

<%
Producto p = (Producto)request.getAttribute("producto");
%>
<main class = "col-md-9 ms-sm-auto col-lg-10 px-md-4">  
 <form  action="<%=request.getContextPath()%>/actualizarProductoAdmin" method="post">

    
    <h1 id="iniciarSesion" class="h3 mb-3 fw-normal">Editar Producto</h1>
    <input type="hidden" id="id" name="id" value="<%= p.getId() %>"/>
     		<div class="form-group col-md-4">
             	<label for="Cedula">ID Categoria</label>
						<select name="id_categoria" class="form-control" value="<%=p.getId_categoria()%>">
							<option value="1">Vehículos agrícolas de juguete</option>
							<option value="2" >Granjas y animales</option>
						</select> 
               
            </div>

    		<div class="form-group col-md-4">
                <label for="Cedula">Nombre Producto</label>
                <input type="text" name="nombre" class="form-control" value="<%=p.getNombre()%>">
            </div>
                        <div class="form-group col-md-4">
                <label for="Cedula">Descripción</label>
                <input type="text" name="descripcion" class="form-control" value="<%=p.getDescripcion()%>">
            </div>
                        <div class="form-group col-md-4">
                <label for="Cedula">Precio</label>
                <input type="text" name="precio" class="form-control" value="<%=p.getPrecio()%>">
            </div>
                        <div class="form-group col-md-4">
                <label for="Cedula">Stock</label>
                <input type="text" name="stock" class="form-control" value="<%=p.getStock()%>" >
            </div>
                      
 			<div class="form-group">
            	<input type="submit" value="Guardar" class="btn btn-success">
        	</div>
    

   
  
    
    <p class="mt-5 mb-3 text-muted">&copy; MercedesSC 2021</p>
  </form >
</main>
    </div>
</div>


    <script src="<%= request.getContextPath() %>/css/bootstrap.bundle.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="<%=request.getContextPath()%>/css/dashboard.js"></script>
  </body>
</html>
