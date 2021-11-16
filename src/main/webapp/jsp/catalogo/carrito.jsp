<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="curso.java.tienda.model.producto.Producto" %>
<%@page import="curso.java.tienda.model.pedido.DetallePedido" %>
<%@include file="/header.jsp" %>

<div>
	<a  href="<%=request.getContextPath()%>/" type="button" class="btn btn-light text-dark me-2">Seguir comprando</a>	
</div>
  <section class="py-5">
      <div class="container py-5">
        <div class="table-responsive mb-3">
          <!-- Cart tabel-->
          <table class="table text-nowrap mb-0" style="min-width: 50rem">
            <thead>
              <tr class="shadow-sm rounded-pill">
                <th class="rounded-pill-start border-0 bg-light px-4 py-3" scope="col"> <span class="h5 text-uppercase">Nombre</span></th>
                <th class="border-0 bg-light px-4 py-3" scope="col"> <span class="h5 text-uppercase">Precio</span></th>
                <th class="border-0 bg-light px-4 py-3" scope="col"> <span class="h5 text-uppercase">Cantidad</span></th>
             
                <th class="rounded-pill-end border-0 bg-light px-4 py-3 text-end" scope="col"> <span class="h5 text-uppercase">Total</span></th>
                <th class="border-0 bg-light px-4 py-3" scope="col"> <span class="h5 text-uppercase"></span></th>
              </tr>
            </thead>
     <%
			ArrayList<DetallePedido> carrito = (ArrayList<DetallePedido>) request.getSession().getAttribute("carrito");

	%>
	<% 
			if(carrito!=null) {
				Double total = 0.0;
			    for(int i=0; i<carrito.size(); i++) {
			    	DetallePedido dp = carrito.get(i);
			    	total += dp.getTotal();
 	%>	
            <tbody>
              
                <td class="p-4 align-middle">
                  <h3 class="h5 fw-normal mb-0"><%= dp.getNombre_producto()%></h3>
                </td>
                 <td class="p-4 align-middle">
                  <h3 class="h5 fw-normal mb-0"><%= dp.getPrecio_unidad()%> €</h3>
                </td>
                 <td class="p-4 align-middle">
                  <h3 class="h5 fw-normal mb-0"><%= dp.getUnidades()%></h3>
                </td>
                </td>
                <td class="p-4 align-middle">
                  <h3 class="h5 fw-normal mb-0"><%= dp.getTotal()%> €</h3>
                </td>
               
                <td class="p-4 align-middle">
	               <h3 class="h5 fw-normal mb-0"> <a href="<%=request.getContextPath()%>/carrito?op=del&id=<%=dp.getId_producto()%>" >
	                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
	  					<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
	  					<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
					</svg>
					</a></h3>
				</td>
                                
               </tbody>
          <%    	
    } //final bucle for
    request.getSession().setAttribute("totalCarrito", total.toString() ); //guardo el total del carrito
    %>
              </table>
            </div>
 
 	<p class="mb-0 text-uppercase text-sm text-end">Total precio</p>
        <h3 class="text-primary text-end"><%=total%></h3>
      </div>
      <%
} //final bucle if
	
%>	
 </section>  

 <section class="pb-5">
      <div class="container pb-5">
		<div class="row gy-3 my-5">
			<div class="col-12">
				 <form action ="<%=request.getContextPath()%>/comprar" method="post">
				    <fieldset>
				        <legend>Método de pago</legend>
				        <label>
				            <input type="radio" name="metodo_pago" value="Transferencia" checked> Transferencia
				        </label>
				        <label>
				            <input type="radio" name="metodo_pago" value="Tarjeta"> Tarjeta
				        </label>
				        <label>
				            <input type="radio" name="metodo_pago" value="PayPal"> PayPal
				        </label>
				    </fieldset>
				    <%
					String msg = (String) request.getAttribute("msg");
					if(msg == null) {
						msg = "";
					}
				 %>
				 <p class="msg"> <%=msg%></p>
				    
				<input type= "submit" value="Finalizar Compra" >
				
				</form>
				<a  href="<%=request.getContextPath()%>/limpiar" type="button" class="btn btn-light text-dark me-2">LIMPIAR CARRITO</a>	
			</div>
		</div>	
	</div>
 </section>


<%@include file="../../footer.jsp" %>
