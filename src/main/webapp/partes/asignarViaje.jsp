<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <br>
 <hr>
 <form action="AsignarViaje" method="POST" class="bg-light">
	<div class="mb-3">
	<label>Viaje</label>
	<select name="viaje">
	<option value="0"> </option>
								<c:forEach items="${viajes}" var="viaje">
									<option value="${viaje.id }">${viaje.origen} --> ${viaje.destino}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label>Camionero</label>
							<select name="camionero">
								<option value="0"></option>
								<c:forEach items="${camioneros}" var="camionero">
									<option value="${camionero.dni }">${camionero.nombre} ${camionero.apellido }</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label>Camion</label>
							<select name="camion">
								<option value="0"></option>
								<c:forEach items="${camiones}" var="camion">
									<option value="${camion.matricula }">${camion.marca} ${camion.modelo }</option>
								</c:forEach>
							</select>
						</div>
					<input type="submit" value="Guardar" name="Guardar" class="btn btn-danger">