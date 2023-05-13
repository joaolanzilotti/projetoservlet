<%@page import="com.prefeitura.projetoservlet.model.Marcacoes"%>
<%@page import="com.prefeitura.projetoservlet.model.HorarioTrabalho"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
<%
    List<HorarioTrabalho> lista = (ArrayList<HorarioTrabalho>) request.getAttribute("horario");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Registrar seu Horário de Trabalho</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">Ponto</a>
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
                                <li><a class="dropdown-item" href="ponto">Registrar</a></li>
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
        <br>
       
        <h1 class="text-center">Horário de Trabalho</h1>
         <br>
        <div class="container text-center">
            <div class="row">
                <div class="col">
                    <div class="card" style="width: 1300px;">
                        <div class="card-body">
                            <br>
                            <h2>Registre seu Horário de Trabalho</h2>
                            <br>
                      

                            <div class="container-fluid h-100">
                                <form name="formMarcacao" action="add" class="needs-validation"  novalidate>
                                    <div class="form-group">
                                        <div class="row mb-3 justify-content-center align-items-center">
                                            <label for="inputHoraEntrada" class="col-sm-2 col-form-label text-center"><b>Hora de entrada</b></label>
                                            <div class="col-sm-3">
                                                <input type="time" class="form-control form-control-lg" id="inputHoraEntrada" name="entrada" required>
                                            </div>
                                        </div>
                                        <div class="row mb-3 justify-content-center align-items-center">
                                            <label for="inputHoraSaida" class="col-sm-2 col-form-label text-center"><b>Hora de saída</b></label>
                                            <div class="col-sm-3">
                                                <input type="time" class="form-control form-control-lg" id="inputHoraSaida" name="saida" required>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col text-center">
                                                <button type="submit" class="btn btn-lg btn-dark">Registrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <br> <br>
                                <div class="card">
                                    <div class="card-body">
                                        <h2>Tabela Horário de Trabalho</h2>
                                        <br>
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-borderless">
                                                <thead class="table-dark">
                                                    <tr>
                                                        <th scope="col-2">Entrada</th>
                                                        <th scope="col-2">Saida</th>
                                                        <th scope="col-4"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% for (HorarioTrabalho h : lista) {%>
                                                    <tr>
                                                        <td><b><%= h.getEntrada()%></b></td>
                                                        <td><b><%= h.getSaida()%></b></td>
                                                        <td><a href="selectPonto?id=<%= h.getId()%>"> <button type="button" class="btn btn-primary">Editar</button> </a>
                                                            <a href="javascript: confirmar(<%= h.getId()%>)"> <button type="button" class="btn btn-danger">Excluir</button> </a>
                                                        </td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                </div>
            </div>
        </div>





        <script src="js/confirmadorPonto.js"></script>
    </body>
</html>
