<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar sua Marcação</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index">Ponto</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">


                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Horário
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="horariotrabalho">Registrar</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Marcações
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="marcacao">Registrar</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <br><br>

        <div class="container text-center">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <br>
                            <h1>Edite sua Marcação</h1>
                            <br>

                            <div class="container">
                                <form name="formPonto" action="update" class="needs-validation"  novalidate>
                                    <div class="form-group">
                                        <div class="row mb-3 justify-content-center align-items-center">
                                            <label for="inputHoraEntrada" class="col-sm-2 col-form-label"><b>ID</b></label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control form-control-lg" id="inputId" name="id" value="<%out.print(request.getAttribute("id"));%>" required>
                                            </div>
                                        </div>
                                        <div class="row mb-3 justify-content-center align-items-center">
                                            <label for="inputHoraEntrada" class="col-sm-2 col-form-label"><b>Hora de entrada</b></label>
                                            <div class="col-sm-3">
                                                <input type="time" class="form-control form-control-lg" id="inputHoraEntrada" name="entrada" value="<%out.print(request.getAttribute("entrada"));%>" required>
                                            </div>
                                        </div>
                                        <div class="row mb-3 justify-content-center align-items-center">
                                            <label for="inputHoraSaida" class="col-sm-2 col-form-label"><b>Hora de saída</b></label>
                                            <div class="col-sm-3">
                                                <input type="time" class="form-control form-control-lg" id="inputHoraSaida" name="saida" value="<%out.print(request.getAttribute("saida"));%>" required>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col text-center">
                                                <button type="submit" class="btn btn-dark btn-lg">Salvar</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>






    </body>
</html>
