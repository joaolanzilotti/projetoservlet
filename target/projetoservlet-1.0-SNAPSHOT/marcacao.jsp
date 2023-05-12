<%@page import="com.prefeitura.projetoservlet.model.Marcacoes"%>
<%@page import="com.prefeitura.projetoservlet.model.HorarioTrabalho"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<%
    List<Marcacoes> lista = (ArrayList<Marcacoes>) request.getAttribute("marcacao");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Registrar sua Marcação</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <h1>Registre sua Marcação</h1>

        <div class="container">
            <form name="formMarcacao" action="insert" class="needs-validation"  novalidate>
                <div class="row mb-3">
                    <label for="inputHoraEntrada" class="col-sm-2 col-form-label">Hora de entrada</label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="inputHoraEntrada" name="entrada" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="inputHoraSaida" class="col-sm-2 col-form-label">Hora de saída</label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="inputHoraSaida" name="saida" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-center">
                        <button type="submit" class="btn btn-primary">Registrar</button>
                    </div>
                </div>
            </form>
            <h2>Tabela Horário de Trabalho</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Entrada</th>
                        <th scope="col">Saida</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Marcacoes h : lista) {%>
                    <tr>
                        <td><%= h.getEntrada()%></td>
                        <td><%= h.getSaida()%></td>
                        <td><a href="select?id=<%= h.getId() %>"> <button type="button" class="btn btn-secondary">Editar</button> </a>
                                <a href="javascript: confirmar(<%= h.getId() %>)"> <button type="button" class="btn btn-danger">Excluir</button> </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

                <script src="js/confirmador.js"></script>
    </body>
</html>
