<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

      <form action="StoreViaje"  method="post" class="bg-light">           
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Origen</label>
              <input type="text" class="form-control" id="origen" name="origen">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Destino</label>
                <input type="text" class="form-control" id="destino" name="destino">
              </div>
             <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Fecha</label>
                <input type="text" class="form-control" id="fecha" name="fecha">
     		</div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-danger">Guardar</button>
          </form>

