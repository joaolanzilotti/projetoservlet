<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
          <h1>Edite sua Marcacao</h1>

        <div class="container">
            <form name="formMarcacoes" action="update" class="needs-validation"  novalidate>
                <div class="row mb-3">
                    <label for="inputHoraEntrada" class="col-sm-2 col-form-label">ID</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputId" name="id" value="<%out.print(request.getAttribute("id"));%>" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputHoraEntrada" class="col-sm-2 col-form-label">Hora de entrada</label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="inputHoraEntrada" name="entrada" value="<%out.print(request.getAttribute("entrada"));%>" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputHoraSaida" class="col-sm-2 col-form-label">Hora de saída</label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="inputHoraSaida" name="saida" value="<%out.print(request.getAttribute("saida"));%>" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-center">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
            </form>
           
        </div>
    </body>
</html>
