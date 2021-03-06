<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Sistema de nóminas</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous" />
        <!-- Datatables -->
        <link href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center">Sistema de calcular nóminas</h1>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-warning my-3" data-bs-toggle="modal" data-bs-target="#agregar_nomina">
                Nuevo<i class="fas fa-plus-circle ms-1"></i>
            </button>
            <table id="example" class="table table-striped display nowrap" cellspacing="0" style="width:100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre completo</th>
                        <th>N° Doc</th>
                        <th>D. Trabajados</th>
                        <th>Salario</th>
                        <th>A. Transporte</th>
                        <th>S. Devengos</th>
                        <th>Salud</th>
                        <th>Pensión</th>
                        <th>S. Descuentos</th>
                        <th>Valor Neto</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody id="fila-mostrar-datos">                 
                </tbody>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nombre completo</th>
                        <th>N° Doc</th>
                        <th>D. Trabajados</th>
                        <th>Salario</th>
                        <th>A. Transporte</th>
                        <th>S. Devengos</th>
                        <th>Salud</th>
                        <th>Pensión</th>
                        <th>S. Descuentos</th>
                        <th>Valor Neto</th>
                        <th>Acción</th>
                    </tr>
                </tfoot>
            </table>


            <!-- Modal -->
            <div class="modal fade" id="agregar_nomina" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-primary">
                            <h5 class="modal-title" id="staticBackdropLabel">Registrar nómina</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form class="row g-3" action="CalcularNomina"  method="POST" id="form" required>
                                <div class="col-md-6">
                                    <label for="txtNombre" class="form-label">Nombre:</label>
                                    <input type="text" class="form-control" name="txtNombre" id="txtNombre" placeholder="Jhon" required>
                                </div>
                                <div class="col-md-6">
                                    <label for="txtApellido" class="form-label">Apellido:</label>
                                    <input type="text" class="form-control" name="txtApellido" id="txtApellido" placeholder="Azaustre" required>
                                </div>
                                <div class="col-md-12">
                                    <label for="txtNumDoc" class="form-label">N° Documento:</label>
                                    <input type="number" class="form-control" name="txtNumDoc" id="txtNumDoc" placeholder="123455543" required>
                                </div>
                                <div class="col-md-6">
                                    <label for="txtDiasTrabajados" class="form-label">Días trabajados:</label>
                                    <input type="number" class="form-control" name="txtDiasTrabajados" id="txtDiasTrabajados" placeholder="30" required>
                                </div>
                                <div class="col-md-6">
                                    <label for="txtSueldo" class="form-label">Sueldo</label>
                                    <input type="number" class="form-control" name="txtSueldo" id="txtSueldo" placeholder="908526" required>
                                </div>
                                <button type="submit" class="btn btn-primary">Guardar <i class="far fa-save ms-1"></i></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap5.min.js"></script>
        <script src="https://kit.fontawesome.com/ff77c957bf.js" crossorigin="anonymous"></script>
        <script src="js/app.js"></script>
    </body>
</html>
