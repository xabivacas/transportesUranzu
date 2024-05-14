<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	
<!-- Inserts -->
<c:if test="${msg=='stored' }">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
		<strong>OK!</strong> Datos guardados en la base de datos
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>
<c:if test="${msg=='noStored' }">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
		<strong>UPS!</strong> Ha habido un error y no se han podido introducir los datos
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>


<!-- Deletes -->
<c:if test="${msg=='destroy' }">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
		<strong>OK!</strong> Datos borrados correctamente
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>
<c:if test="${msg=='noDestroy' }">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
		<strong>UPS!</strong> Ha habido un error y no se han podido borrar los datos
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>

<!-- Updates -->
<c:if test="${msg=='modificado' }">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
		<strong>OK!</strong> Datos modificados correctamente
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>
<c:if test="${msg=='noModificado' }">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
		<strong>UPS!</strong> Ha habido un error y no se han podido borrar los datos
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>

<!-- Asignar viajes -->
<c:if test="${asig=='asignado' }">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
		<strong>Ok!</strong>Viaje asignado
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if><c:if test="${asig=='noAsignado' }">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
		<strong>UPS!</strong> Ha habido un error y no se ha podido asignar el viaje
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>