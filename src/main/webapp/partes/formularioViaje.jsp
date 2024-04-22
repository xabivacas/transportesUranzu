<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <form action="StoreCamion" method="post">
            <div class="mb-3">
              <label for="id" class="form-label">id</label>
              <input type="text" class="form-control" id="id" name="id" aria-describedby="id">
            </div>
            <div class="mb-3">
              <label for="Origen" class="form-label"></label>
              <input type="text" class="form-control" id="marca" name="marca">
            </div>
            <div class="mb-3">
                <label for="modelo" class="form-label">Modelo</label>
                <input type="text" class="form-control" id="modelo" name="modelo">
              </div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-primary">Guardar</button>
          </form>