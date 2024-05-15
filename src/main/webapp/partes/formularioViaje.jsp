<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <p class="h4"> Insertar Viaje</p>
     <hr>
      <form action="StoreViaje"  method="post" class="bg-light">           
            <div class="mb-3">
              <label for="origen" class="form-label">Origen</label>
              <input type="text" class="form-control" id="origen" name="origen" required>
            </div>
            <div class="mb-3">
                <label for="destino" class="form-label">Destino</label>
                <input type="text" class="form-control" id="destino" name="destino" required>
              </div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-danger">Guardar</button>
          </form>

