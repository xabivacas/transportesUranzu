<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     <p class="h4"> Insertar Cliente</p>
     <hr>
      <form action="StoreCliente" method="post" class="bg-light">
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">CIF</label>
              <input type="text" class="form-control" id="cif" name="cif" aria-describedby="cif" required>
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="nombre" name="nombre">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Direccion</label>
                <input type="text" class="form-control" id="direccion" name="direccion">
              </div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-danger">Guardar</button>
          </form>