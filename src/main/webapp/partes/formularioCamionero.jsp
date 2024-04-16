<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <form action="StoreCamionero" method="post">
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">DNI</label>
              <input type="text" class="form-control" id="dni" name="dni" aria-describedby="dni">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="nombre" name="nombre">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Apellido</label>
                <input type="text" class="form-control" id="apellido" name="apellido">
              </div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-primary">Guardar</button>
          </form>