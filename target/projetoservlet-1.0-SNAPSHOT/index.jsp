<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalTime"%>
<%@page import="com.prefeitura.projetoservlet.model.DAO"%>
<%@page import="com.prefeitura.projetoservlet.model.Marcacoes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.prefeitura.projetoservlet.model.HorarioTrabalho"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DAO dao = new DAO();
    List<HorarioTrabalho> lista = dao.listarHorarioTrabalho();
    List<Marcacoes> listaMarcacoes = dao.listarMarcacoes();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
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

        <div class="container text-center">
            <div class="row">
                <div class="card" style="width: 1075px;">
                    <div class="card-body">
                        <h1>Sistema de Ponto</h1>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <div class="container text-center">
            <div class="row align-items-start">
                <div class="col">
                    <div class="card" style="width: 500px;">
                        <div class="card-body">
                            <div class="container text-center">
                                <div class="row">
                                    <div class="col-md">
                                        <h1>Registre seu Ponto</h1>
                                        <a href="ponto"><button type="button" class="btn btn-primary">Registrar Horario de Trabalho</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 500px;">
                        <div class="card-body">
                            <div class="container text-center">
                                <div class="row">
                                    <div class="col-md">
                                        <h1>Registre sua Marcação</h1>
                                        <a href="marcacao"><button type="button" class="btn btn-primary">Registrar Marcações</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>


        <div class="container text-center">
            <div class="row align-items-start">
                <div class="col">
                    <div class="col">
                        <div class="card" style="width: 500px;">
                            <div class="card-body">
                                <h2>Tabela Horário Trabalho</h2>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col-3">Entrada</th>
                                            <th scope="col-3">Saida</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (HorarioTrabalho h : lista) {
                                                String entrada = h.getEntrada();
                                                String saida = h.getSaida();
                                        %>
                                        <tr>
                                            <td><%= h.getEntrada()%></td>
                                            <td><%= h.getSaida()%></td>

                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 500px;">
                        <div class="card-body">
                            <div class="col">
                                <h2>Tabela Marcações</h2>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Entrada</th>
                                            <th scope="col">Saida</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Marcacoes h : listaMarcacoes) {%>
                                        <tr>
                                            <td><%= h.getEntrada()%></td>
                                            <td><%= h.getSaida()%></td>

                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <br>
                    <br>
                    <div class="card" style="width: 500px;">
                        <div class="card-body">
                            <div class="col">
                                <h2>Tabela Atraso</h2>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Atraso</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Marcacoes h : listaMarcacoes) {%>
                                        <% for (HorarioTrabalho ht : lista) {
                                                String saidaMarcacoes = h.getSaida();
                                                String saidaHorarioTrabalho = ht.getSaida();

                                                Double atraso = Double.valueOf(saidaMarcacoes.replace(":", ".")) - Double.valueOf(saidaHorarioTrabalho.replace(":", "."));
                                                String resultado = String.valueOf(atraso);


                                        %>
                                        <tr>
                                            <td><%= resultado.replace(".", ":").replace("-", "")%></td>

                                        </tr>
                                        <%}%>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                                    <div class="col">
                    <br>
                    <br>
                    <div class="card" style="width: 500px;">
                        <div class="card-body">
                            <div class="col">
                                <h2>Tabela Hora Extra</h2>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Hora Extra</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Marcacoes h : listaMarcacoes) {%>
                                        <% for (HorarioTrabalho ht : lista) {
                                                String entradaMarcacao = h.getEntrada();
                                                String entradaHorarioTrabalho = ht.getEntrada();

                                                Double extra = Double.valueOf(entradaMarcacao.replace(":", ".")) - Double.valueOf(entradaHorarioTrabalho.replace(":", "."));
                                                String resultado = String.valueOf(extra);


                                        %>
                                        <tr>
                                            <td><%= resultado.replace(".", ":").replace("-", "")%></td>

                                        </tr>
                                        <%}%>
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
        <br>





    </body>
</html>
