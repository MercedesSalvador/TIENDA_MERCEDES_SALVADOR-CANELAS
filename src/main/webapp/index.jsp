<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="curso.java.tienda.model.producto.Producto" %>
<%@ page import="curso.java.tienda.model.producto.ProductoDAO" %>


<%@include file="/header.jsp" %>


<%
	ArrayList<Producto> listado_Productos = (ArrayList<Producto>) request.getAttribute("listadoProductos");
%>
 <link href="/css/dropdowns.css" rel="stylesheet">
 






  <div class="album py-5 bg-light">
   <div class="container-fluid d-grid gap-3 align-items-center" style="grid-template-columns: 1fr 2fr;">
      <div class="dropdown">
     	<button type="button" class="btn btn-secondary dropdown-toggle" id="dropdownNavLink" data-bs-toggle="dropdown" aria-expanded="false" >
    		Categoría
 		 </button>
        
        <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownNavLink">
          <!--   <li><a class="dropdown-item active" href="#" aria-current="page">Overview</a></li>-->
          <li><a class="dropdown-item" href="<%=request.getContextPath()%>/filtroCategoria?id_categoria=1">Vehículos agrícolas de juguete</a></li>
          <li><a class="dropdown-item" href="<%=request.getContextPath()%>/filtroCategoria?id_categoria=2">Granjas y animales </a></li>

        </ul>
      </div>
   </div>
<br></br>
    <div class="container">
 
 
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      
      <% 
if(listado_Productos!=null) {
    for(int i=0; i<listado_Productos.size(); i++) {
    	Producto p = listado_Productos.get(i);
    
 %>	
 
        <div class="col">
          <div class="card shadow-sm">
            <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="<%=request.getContextPath()%>/img/productos/<%=p.getImagen()%>"/>

            <div class="card-body">
              <p class="card-text"><%= p.getNombre()%></p>
              <p></p>
              <p></p>
              <!--  <p class="card-text"><%= p.getDescripcion()%></p>-->
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                
                  <a href="<%=request.getContextPath()%>/carrito?op=add&id=<%=p.getId()%>">
                 	<button type="button" class="btn btn-sm btn-outline-secondary"> Añadir</button>
                  </a>
                  <a href="<%=request.getContextPath()%>/detalleProducto?id=<%=p.getId()%>">
                 	<button type="button" class="btn btn-sm btn-outline-secondary">Detalle</button>
                  </a>
                  
                 <!--  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                  -->
                </div>

              </a>
                <small class="text-muted"><%= p.getPrecio()%> €</small>
              </div>
            </div>
          </div>
        </div>
        
  <%    	
    }
}
%>

      </div>
    </div>
  </div>


<div id="footer">
<%@include file="footer.jsp" %>
</div>

