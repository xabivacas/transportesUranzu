<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     <p class="h4"> Insertar Camion</p>
     <hr>
      <form action="StoreCamion" method="post" class="bg-light">
            <div class="mb-3">
              <label for="matricula" class="form-label">Matricula</label>
              <input type="text" class="form-control" id="matricula" name="matricula" aria-describedby="matricula" required>
            </div>
            <div class="mb-3">
              <label for="Marca" class="form-label">Marca</label>
              <input type="text" class="form-control" id="marca" name="marca">
            </div>
            <div class="mb-3">
                <label for="modelo" class="form-label">Modelo</label>
                <input type="text" class="form-control" id="modelo" name="modelo">
              </div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-danger">Guardar</button>
          </form>