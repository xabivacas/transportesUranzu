<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <p class="h4 mt-5"> Asignar Viaje</p>
 <hr>
 <form action="AsignarViaje" method="POST" class="bg-light">
	<div class="mb-3">
		<input type="hidden" value="${direccion}" name="direccion">
		<label>Viaje</label>
		<select name="viaje" class="form-select">
			<option value="0"> </option>
				<c:forEach items="${viajes}" var="viaje">
					<option value="${viaje.id}">${viaje.origen} --> ${viaje.destino}</option>
				</c:forEach>
		</select>
	</div>
						
	<div class="mb-3">
		<label>Camionero</label>
			<select class="form-select" name="camionero">
				<option value="0"></option>
				<c:forEach items="${camioneros}" var="camionero">
					<option value="${camionero.dni }">${camionero.nombre} ${camionero.apellido }</option>
				</c:forEach>
			</select>
	</div>
						
	<div class="mb-3">
		<label>Camion</label>
		<select name="camion" class="form-select">
			<option value="0"></option>
			<c:forEach items="${camiones}" var="camion">
				<option value="${camion.matricula }">${camion.matricula} </option>
			</c:forEach>
		</select>
	</div>
	
	
	<input type="submit" value="Guardar" name="Guardar" class="btn btn-danger">
</form>