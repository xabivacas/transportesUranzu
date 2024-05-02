
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Camioneros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="estilo.css">
</head>

<body>

	<!-- Header -->
	<header class="bg-light">

		<!-- Nav responsive -->
		<div class="pequeno ">

			<!-- Hamburgesa -->
			<button class="btn col-12" type="button" data-bs-toggle="offcanvas"
				data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">
				<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
					fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">			
						<path fill-rule="evenodd"
						d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5" />
				  	</svg>
			</button>

			<!-- El offcanvas responsive -->
			<div class="offcanvas  offcanvas-start bg-light" tabindex="-1"
				id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
				<div class="offcanvas-header">
					<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
						aria-label="Close"></button>
				</div>
				<div class="offcanvas-body small">
					<%@ include file="/partes/formularioViaje.jsp"%>
					<%@ include file="/partes/navegadorResponsive.jsp"%>
				</div>
			</div>
		</div>

		<!-- Logo -->
		<div class="col-lg-3 col-6 ">
			<img src="recursos/logo-uranzu-transportes.jpg" class="shadow"
				alt="...">
		</div>
		<div class="grande col-lg-7">
			<%@ include file="/partes/navegador.jsp"%>
		</div>
		<!-- Cerrar sesion -->
		<div class="col-lg-2 col-md-2 col-6 ">
			<a href="Index">
				<button type="button" class="btn btn-danger">Cerrar Sesion</button>
			</a>
		</div>

	</header>

	<!--Los datos y el aside para el insert-->

	<main>

		<aside class="shadow bg-light">
			<%@ include file="/partes/formularioCamionero.jsp"%>
			<%@ include file="/partes/asignarViaje.jsp"%>
		</aside>

		<div class="datos m-4">
			
				<table class="table">
					<thead>
						<tr>
							<th scope="col">DNI</th>
							<th scope="col">Nombre</th>
							<th scope="col">Apellido</th>
							<th></th>
						</tr>
					</thead>
						<tbody>
						<c:forEach items="${camioneros}"  var="camionero">
							<tr>
								<td>${camionero.dni}</td>
								<td>${camionero.nombre}</td>
								<td>${camionero.apellido}</td>
								<td>
									<button type="button" class="btn btn-danger" data-bs-toggle="modal"	data-bs-target="#modal${camionero.dni }">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
		                                   <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325" />
		                      			</svg>
									</button> <a href="DestroyCamionero?dni=${camionero.dni}">
										<button type="button" class="btn btn-danger">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-trash3"
												viewBox="0 0 16 16">
												<path
													d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5" />
											</svg>
										</button>
								</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Modales -->
		<c:forEach items="${camioneros}" var="camionero">
			<div class="modal fade" id="modal${camionero.dni }" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="label${camionero.dni }">Modificacion</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>

						<div class="modal-body">
							<form action="UpdateCamionero" method="post">

								<input type="hidden" value="${camionero.dni }" name="dniMod"
									aria-describedby="nombreMod">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Nombre</label>
									<input type="text" class="form-control" id="nombreMod"
										name="nombreMod" aria-describedby="nombreMod"
										value="${camionero.nombre}" placeholder="${camionero.nombre}">
								</div>

								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Apellido</label>
									<input type="text" class="form-control" id="apellidoMod"
										name="apellidoMod" value="${camionero.apellido}"
										placeholder="${camionero.apellido}">
								</div>

								<button type="submit" class="btn btn-danger"
									data-bs-dismiss="modal">Guardar</button>
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Cancelar</button>
							</form>

						</div>
					</div>
				</div>
			</div>
		</c:forEach>

<!-- enaut inicio -->
<!-- 
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="accordion" id="accordionExample">
						
					<c:forEach items="${camioneros}"  var="camionero">
					<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapse${camionero.dni }"
									aria-expanded="false" aria-controls="collapseThree">
									${camionero.nombre}</button>
							</h2>
							<div id="collapse${camionero.dni }" class="accordion-collapse collapse"
								data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<c:forEach items="${camionero.viajes}" var="viaje">
										<p>${viaje.origen} - ${viaje.destino}</p>
									</c:forEach>	
								</div>
							</div>
						</div>
					</c:forEach>
					
					</div>
				</div>
			</div>
		</div>
		-->
		<!-- enaut fin -->
		
	
	</main>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>