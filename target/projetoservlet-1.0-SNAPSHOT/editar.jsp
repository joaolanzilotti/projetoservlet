<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h1>Registre seu Ponto</h1>

        <div class="container">
            <form name="formPonto" action="" class="needs-validation"  novalidate>
                <div class="row mb-3">
                    <label for="inputHoraEntrada" class="col-sm-2 col-form-label">ID</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputId" name="id" value="<%out.print(request.getAttribute("id"));%>" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputHoraEntrada" class="col-sm-2 col-form-label">Hora de entrada</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputHoraEntrada" name="entrada" value="<%out.print(request.getAttribute("entrada"));%>" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputHoraSaida" class="col-sm-2 col-form-label">Hora de saída</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputHoraSaida" name="saida" value="<%out.print(request.getAttribute("saida"));%>" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-center">
                        <button type="button" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
            </form>
            <h2>Tabela Horário de Trabalho</h2>
           
        </div>
    </body>
</html>
