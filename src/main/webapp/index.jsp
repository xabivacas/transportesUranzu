<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TransportesUranzu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="landingPageProyecto.css">
  </head>
  <body>

    <!--Nav-->
    <header>    
    	<!-- Logo -->
          <div class="col-lg-4  col-md-4 col-6 ">
            <img src="recursos/logo-uranzu-transportes.jpg" class="shadow" alt="...">
          </div>

		<!-- "Inicio de sesion" -->
          <div class="col-lg-2 col-md-2 col-6 " > 
            <ul class="nav nav-pills nav-fill inicioSesion">
              <li class="nav-item">
                <a class="nav-link " aria-current="page" data-bs-toggle="modal" data-bs-target="#login">Iniciar Sesion</a>
              </li>
            </ul>
          </div>
    
    </header>

    <!--Cabecero falso para que quede bien la pagina-->
    <div class="cabecerofalso"></div>

    <main>
      
      <!--Div del presupuesto-->
      <div class="presupuesto">
        <div class="row patatas container-fluid">
          <div class=" row col-6 col-lg-4 col-md-6  offset-5 ">
                <h3>Unete a nosotros para poder obtener nuestros servicios de paqueteria</h3>
          </div>
          <div class=" row col-1 col-lg-2 col-md-2 offset-5  offset-lg-5 ">
            <ul class="nav nav-pills nav-fill">
              <li class="nav-item">
               <button type="button" class="btn btn-danger nav-link" data-bs-toggle="modal" data-bs-target="#pedirPresupuesto">
  					Pedir Presupuesto
				</button>
              </li>
            </ul>
          </div>
            
          </div>
      </div>
      <div class="servicios">
        <div class="row ">
          <div class="col-lg-4 ps-lg-9 offset-lg-4 mt-5 mt-lg-1"></div>
          <h1>SERVICIOS</h1>

            <div class="col-lg-3 col-md-12 mt-5">

              <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
              </svg>
              <h4>Servicio express</h4>
              <p>Ofrecemos un servicio de transporte Express de envï¿½o urgentes o exclusivos, con vehï¿½culos de acuerdo al tipo, volumen y peso de mercaderï¿½a a trasladar con dos chï¿½feres a nivel nacional y Europeo.</p>
            </div>
            <div class="col-lg-3 col-md-12 mt-5">
              <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-truck" viewBox="0 0 16 16">
                <path d="M0 3.5A1.5 1.5 0 0 1 1.5 2h9A1.5 1.5 0 0 1 12 3.5V5h1.02a1.5 1.5 0 0 1 1.17.563l1.481 1.85a1.5 1.5 0 0 1 .329.938V10.5a1.5 1.5 0 0 1-1.5 1.5H14a2 2 0 1 1-4 0H5a2 2 0 1 1-3.998-.085A1.5 1.5 0 0 1 0 10.5zm1.294 7.456A2 2 0 0 1 4.732 11h5.536a2 2 0 0 1 .732-.732V3.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5v7a.5.5 0 0 0 .294.456M12 10a2 2 0 0 1 1.732 1h.768a.5.5 0 0 0 .5-.5V8.35a.5.5 0 0 0-.11-.312l-1.48-1.85A.5.5 0 0 0 13.02 6H12zm-9 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2m9 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2"/>
              </svg>
              <h4>TRANSPORTE DE MERCANCIAS POR CARRETERA</h4>
              <p>Servicios de envï¿½os de cargas completas, cargas fraccionadas y grupaje tanto en territorio nacional como internacional.</p>
  
            </div>
            <div class="col-lg-3 col-md-12 mt-5 ">
              <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-calendar-check" viewBox="0 0 16 16">
                <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4z"/>
              </svg>
              <h4>HORARIOS</h4>
              <p>Ofrecemos el servicio las 24 horas del dia y los 365 dias del aï¿½o!</p>
            </div>
          </div>
        </div>
    </main>
    
    		
		<!-- Modales -->
		
			<!-- Formulario para pedir presupuesto -->
		<div class="modal fade" id="pedirPresupuesto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	
		    	<!-- Titulo del modal -->
		    	<div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Pedir presupuesto</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		        
		      </div>
		      <div class="modal-body">
		      
		        <form>
		        	<!-- Email -->
					<div class="mb-3">
						<p>Inserte los datos y nuestro equipo contactara con usted en un plazo de 2 meses a 2 aï¿½os</p>
						<label for="email" class="form-label">Email</label>
						<input type="email" class="form-control" id="formEmail" placeholder="ejemplo@ejemplo.com">
					</div>
					<!-- Nombre -->
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" class="form-control" id="formNombre" placeholder="Pepe">
					</div>
					<!-- Datos presu -->
					<div class="mb-3">
						<label for="descripcion" class="form-label" ></label>
						<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" palceholder="Inserte aqui una breve descripcion"></textarea>
					</div>
				  <button type="submit" class="btn btn-danger">Enviar</button>
				  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				</form>
				
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- Login -->
		<div class="modal fade" id="login" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	
		    	<!-- Titulo del modal -->
		    	<div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Pedir presupuesto</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		        
		      </div>
		      <div class="modal-body">
		      
		        <form action="Login">
		        
		        	<!-- Nombre -->
					<div class="mb-3">
						<p>Inserte los datos y nuestro equipo contactara con usted en un plazo de 2 meses a 2 aï¿½os</p>
						<label for="nombre" class="form-label">Nombre de usuario</label>
						<input type="text" class="form-control" id="nombre" placeholder="Usuario123" name="nombre">
					</div>
					
					<!-- Password -->
					<div class="mb-3">
						<label for="contrasenia" class="form-label">Contraseña</label>
						<input type="password" class="form-control" id="contrasenia" name="password">
					</div>

				  <button type="submit" class="btn btn-danger">Enviar</button>
				  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				</form>
				
		      </div>
		    </div>
		  </div>
		</div>
		
    <footer>
      <div class="col-lg-6 offset-lg-3 offset-md-2 container">
        <div class="row">
          <div class="col-12 col-lg-4 col-md-4">
            <h4>Contacta con nosotros</h4>
            <p>Telf: 943 63 41 12</p>
            <p>Email: administracion@transuranzu.com</p>
          </div>          
        <div class="col-12 col-lg-4">
          <h4>Donde Estamos</h4>        
        </p>20305 Irun, Gipuzkoa</p>
      </div>     
        <div class="col-12 col-lg-4">
          <h4>HORARIOS</h4>
          <p>Ofrecemos el servicio las 24 horas del dia y los 365 dias del aï¿½o!</p>
        </div>
        </div>
      </div>
    </footer>
    
    			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
				integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
				crossorigin="anonymous"></script>

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
				integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
				crossorigin="anonymous"></script>
    
  </body>
</html>