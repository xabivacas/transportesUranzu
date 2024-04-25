<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
			<header class="bg-light">
				<div class="pequeno ">
					<div class="container-fluid">
						<div class="row">
							<button class="btn col-12" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
								<path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
							  </svg></button>
		
								<div class="offcanvas  offcanvas-start" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
									<div class="offcanvas-header">
										<h5 class="offcanvas-title" id="offcanvasBottomLabel">Insertar Viaje</h5>
										<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
									</div>
									<div class="offcanvas-body small">
									<%@ include file="/partes/formularioViaje.jsp" %>
									<%@ include file="/partes/navegador.jsp" %>
									</div>
								</div>
						</div>
					</div>
				</div>
				<!-- Logo -->
				<div class="col-lg-4  col-md-4 col-6 ">
					<img src="recursos/logo-uranzu-transportes.jpg" class="shadow" alt="...">
				</div>

				<!-- Iniciar sesion -->
				<div class="col-lg-2 col-md-2 col-6 ">
					<ul class="nav nav-pills nav-fill inicioSesion">
						<li class="nav-item">
							<a class="nav-link " aria-current="page" href="Index">Cerrar Sesion</a>
						</li>
					</ul>
				</div>

			</header>