
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>CRUD Camioneros</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			  rel="stylesheet"
			  integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			  crossorigin="anonymous">
		<link rel="stylesheet" href="estilo.css">
	</head>
	
	<body>
	
		<!-- Header -->
		<header class="bg-light container-fluid">
			
			
			<!-- Nav responsive -->
			<div class="pequeno ">
				
				<!-- Hamburgesa -->
				<button class="btn col-12" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">			
						<path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
				  	</svg>
				</button>
				
				<!-- El offcanvas responsive -->
				<div class="offcanvas  offcanvas-start bg-light" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
					<div class="offcanvas-header">
						<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body small">
						<%@ include file="/partes/formularioCamion.jsp" %>

						<%@ include file="/partes/navegadorResponsive.jsp" %>
					</div>
				</div>
			</div>
				
			<!-- Logo -->
			<div class="col-lg-3 col-6 ">
				<img src="recursos/logo-uranzu-transportes.jpg" class="shadow" alt="...">
			</div>
			<div class="grande col-lg-7">
				<%@ include file="/partes/navegador.jsp" %>
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
				<%@ include file="/partes/formularioCamionero.jsp" %>
				<%@ include file="/partes/asignarViaje.jsp" %>
			</aside>
			
	      <div class="datos m-4">
	     	 <div class="accordion accordion-flush" id="accordionFlushExample">
			<table class="table">
						<thead>
							<tr>
								<th scope="col">DNI</th>
								<th scope="col">Nombre</th>
								<th scope="col">Apellido</th>
								<th></th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
						<c:forEach items="${camioneros}" var="camionero" >
							<tr class="accordion-item">
								<td>${camionero.dni}</td>
								<td>${camionero.nombre}</td>

								<td>${camionero.apellido}</td>
								<td>	
									<button class="btn type="button" data-bs-toggle="collapse" data-bs-target="#acordeon${camionero.dni }" aria-expanded="false" aria-controls="flush-collapseOne">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-down" viewBox="0 0 16 16">
											<path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708"/>
										</svg>
									</button>				
							  	</td>

								
							</tr>
							
							<!--
							<tr>
							<div id="acordeon${camionero.dni }" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
									${camionero.dni }
									</div>
									</div>	
							</tr>
							-->
						</c:forEach>
						</tbody>
						</table>
				</div>
				</div>
						<!-- Modales -->
						<c:forEach items="${camioneros}" var="camionero">
						<div class="modal fade" id="modal${camionero.dni }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="label${camionero.dni }">Modificacion</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      
							      <div class="modal-body">
							        <form action="UpdateCamionero" method="post">
							        
							        	<input type="hidden" value="${camionero.dni }" name="dniMod" aria-describedby="nombreMod">
									  <div class="mb-3">
									    <label for="exampleInputEmail1" class="form-label">Nombre</label>
									    <input type="text" class="form-control" id="nombreMod" name="nombreMod" aria-describedby="nombreMod" value="${camionero.nombre}"
													placeholder="${camionero.nombre}">
									  </div>
									  
									  <div class="mb-3">
									    <label for="exampleInputPassword1" class="form-label">Apellido</label>
									    <input type="text" class="form-control" id="apellidoMod" name="apellidoMod" value="${camionero.apellido}"
													placeholder="${camionero.apellido}">
									  </div>
	
									  <button type="submit" class="btn btn-danger"  data-bs-dismiss="modal">Guardar</button>
									  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
									</form>
									
							      </div>
							    </div>
							  </div>
						</div>
						</c:forEach>
				
		</main>
	
	
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	</body>
</html>