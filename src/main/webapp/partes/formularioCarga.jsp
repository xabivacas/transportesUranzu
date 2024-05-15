<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     <p class="h4"> Insertar Carga</p>
     <hr>
      <form action="StoreCarga" method="post" class="bg-light">
            
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Peso</label>
              <input type="number" class="form-control" id="peso" name="peso">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Dimensiones</label>
                <input type="text" class="form-control" id="dimensiones" name="dimensiones">
              </div>
               <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Tipo</label>
                <input type="text" class="form-control" id="tipo" name="tipo">
              </div>
            <button type="submit" value="guardar" name="guardar" class="btn btn-danger">Guardar</button>
          </form>