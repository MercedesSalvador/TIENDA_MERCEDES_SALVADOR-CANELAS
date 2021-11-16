
<%@page import="curso.java.tienda.model.producto.Producto"%>

<%@include file="/header.jsp"%>



<body>

	<!--  Modal -->

	<div class="modal fade" id="productView" tabindex="-1" role="dialog"
		aria-hidden="true">
		<%
		Producto producto = (Producto) request.getAttribute("producto");
		%>

	</div>

	<section class="py-5">
		<div class="container">
			<div class="row mb-5">
				<div class="col-lg-6">
					<!-- PRODUCT SLIDER-->
					<div class="row m-sm-0">


						<div class="col-sm-10 order-1 order-sm-2">
							<div class="owl-carousel product-slider" data-slider-id="1">

								<img class="img-fluid"
									src="<%=request.getContextPath()%>/img/productos/<%=producto.getImagen()%>"
									alt="...">
							</div>

						</div>
					</div>
				</div>
				<!-- PRODUCT DETAILS-->
				<div class="col-lg-6">
					<ul class="list-inline mb-2">
						<li class="list-inline-item m-0"><i
							class="fas fa-star small text-warning"></i></li>
						<li class="list-inline-item m-0"><i
							class="fas fa-star small text-warning"></i></li>
						<li class="list-inline-item m-0"><i
							class="fas fa-star small text-warning"></i></li>
						<li class="list-inline-item m-0"><i
							class="fas fa-star small text-warning"></i></li>
						<li class="list-inline-item m-0"><i
							class="fas fa-star small text-warning"></i></li>
					</ul>
					<h1><%=producto.getNombre()%></h1>
					<p class="text-muted lead"><%=producto.getPrecio()%>
						&euro;
					</p>
					<p class="text-small mb-4"><%=producto.getDescripcion()%></p>
					<div class="row align-items-stretch mb-4">

						<div class="col-sm-3 pl-sm-0">
							<a
								class="btn btn-dark btn-sm btn-block h-100 d-flex align-items-center justify-content-center px-0"
								href="<%=request.getContextPath()%>/carrito?op=add&id=<%=producto.getId()%>">A&ntildeadir
								a la cesta</a>
						</div>
					</div>
					<div class="row">
						<div class="col-sm">
							<img width="150" height="150"
								src="<%=request.getContextPath()%>/img/productos/<%=producto.getImagen()%>"
								alt="...">
						</div>
						<div class="col-sm">
							<img width="150" height="150"
								src="<%=request.getContextPath()%>/img/productos/<%=producto.getImagen()%>"
								alt="...">
						</div>
						<div class="col-sm">
							<img width="150" height="150"
								src="<%=request.getContextPath()%>/img/productos/<%=producto.getImagen()%>"
								alt="...">
						</div>
					</div>
				</div>

				<!-- DETAILS TABS-->
				<ul class="nav nav-tabs border-0" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active"
						id="description-tab" data-toggle="tab" href="#description"
						role="tab" aria-controls="description" aria-selected="true">Descripcion</a></li>
					<!--  <li class="nav-item"><a class="nav-link" id="reviews-tab"
						data-toggle="tab" href="#reviews" role="tab"
						aria-controls="reviews" aria-selected="false">Reviews</a></li>-->
				</ul>
				<div class="tab-content mb-5" id="myTabContent">
					<div class="tab-pane fade show active" id="description"
						role="tabpanel" aria-labelledby="description-tab">
						<div class="p-4 p-lg-5 bg-white">
							<h6 class="text-uppercase">Descripcion producto</h6>
							<p class="text-muted text-small mb-0"><%=producto.getDescripcion()%>.</p>
						</div>
					</div>
					<div class="tab-pane fade" id="reviews" role="tabpanel"
						aria-labelledby="reviews-tab">
						<div class="p-4 p-lg-5 bg-white">
							<div class="row">
								<div class="col-lg-8">
									<div class="media mb-3">
										<img class="rounded-circle" src="img/customer-1.2909e6e3.png"
											alt="" width="50">
										<div class="media-body ml-3">
											<h6 class="mb-0 text-uppercase">Jason Doe</h6>
											<p class="small text-muted mb-0 text-uppercase">20 May
												2020</p>
											<ul class="list-inline mb-1 text-xs">
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star-half-alt text-warning"></i></li>
											</ul>
											<p class="text-small mb-0 text-muted">Lorem ipsum dolor
												sit amet, consectetur adipisicing elit, sed do eiusmod
												tempor incididunt ut labore et dolore magna aliqua.</p>
										</div>
									</div>
									<div class="media">
										<img class="rounded-circle" src="img/customer-2.f49623e8.png"
											alt="" width="50">
										<div class="media-body ml-3">
											<h6 class="mb-0 text-uppercase">Jason Doe</h6>
											<p class="small text-muted mb-0 text-uppercase">20 May
												2020</p>
											<ul class="list-inline mb-1 text-xs">
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star text-warning"></i></li>
												<li class="list-inline-item m-0"><i
													class="fas fa-star-half-alt text-warning"></i></li>
											</ul>
											<p class="text-small mb-0 text-muted">Lorem ipsum dolor
												sit amet, consectetur adipisicing elit, sed do eiusmod
												tempor incididunt ut labore et dolore magna aliqua.</p>
										</div>
									</div>
								</div>
							</div>
						</div>








					</div>

				</div>
				<!-- final de l detalle de productos -->


			</div>

		</div>
	</section>
</body>


<%@include file="/footer.jsp"%>