<%@page import="com.prefeitura.projetoservlet.controller.MarcacaoController"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalTime"%>
<%@page import="com.prefeitura.projetoservlet.model.Marcacoes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.prefeitura.projetoservlet.model.HorarioTrabalho"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<HorarioTrabalho> lista = (ArrayList<HorarioTrabalho>) request.getAttribute("horario");
    List<Marcacoes> listaMarcacoes = (ArrayList<Marcacoes>) request.getAttribute("marcacao");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script> 
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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

        <br>

        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <div class="container text-center">
                        <div class="row">
                            <div class="card">
                                <div class="card-body">
                                    <h1>Sistema de Ponto</h1>
                                </div>
                            </div>
                        </div>
                    </div>

                    <br>
                    <div class="container text-center">
                        <div class="row align-items-start">
                            <div class="col-sm-12 col-md-12 col-lg-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="container text-center">
                                            <div class="row">
                                                <div class="col-md">
                                                    <h2>Registre seu Horário de Trabalho</h2>
                                                    <br>
                                                    <br>
                                                    <a href="horariotrabalho"><button type="button" class="btn btn-dark">Registrar Horario de Trabalho</button></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12 col-lg-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="container text-center">
                                            <div class="row">
                                                <div class="col-md">
                                                    <h2>Registre sua Marcação</h2>
                                                    <br>
                                                    <br>
                                                    <a href="marcacao"><button type="button" class="btn btn-dark">Registrar Marcações</button></a>
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
                            <div class="col-sm-12 col-md-12 col-lg-6">
                                <div class="col">
                                    <div class="card">
                                        <div class="card-body">
                                            <h2>Tabela de Horários de Trabalho</h2>
                                            <table class="table table-striped table-bordered table-borderless">
                                                <thead class="table-dark">
                                                    <tr>
                                                        <th scope="col-3">Entrada</th>
                                                        <th scope="col-3">Saida</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% for (HorarioTrabalho t : lista) {%>
                                                    <tr>
                                                        <td><b><%= t.getEntrada()%></b></td>
                                                        <td><b><%= t.getSaida()%></b></td>

                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12 col-lg-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="col">
                                            <h2>Tabela de Marcações</h2>
                                            <table class="table table-striped table-bordered table-borderless">
                                                <thead class="table-dark">
                                                    <tr>
                                                        <th scope="col">Entradas</th>
                                                        <th scope="col">Saidas</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% for (Marcacoes h : listaMarcacoes) {%>
                                                    <tr>
                                                        <td><b><%= h.getEntrada()%></b></td>
                                                        <td><b><%= h.getSaida()%></b></td>

                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-12 col-md-12 col-lg-6">
                                <br>
                                <br>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="col">
                                            <h2>Tabela de Atrasos</h2>
                                            <table class="table table-striped table-bordered table-borderless">
                                                <thead class="table-dark">
                                                    <tr>
                                                        <th scope="col">Atrasos</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% for (Marcacoes h : listaMarcacoes) {%>
                                                    <% for (HorarioTrabalho ht : lista) {

                                                            Double atraso;
                                                            String resultado = "0";

                                                            String saidaMarcacoes = h.getSaida();
                                                            String saidaHorarioTrabalho = ht.getSaida();
                                                            String entradaHorarioTrabalho = ht.getEntrada();
                                                            String entradaMarcacoes = h.getEntrada();

                                                            if (Integer.valueOf(saidaMarcacoes.replace(":", "")) < Integer.valueOf(saidaHorarioTrabalho.replace(":", ""))) {
                                                                atraso = Double.valueOf(saidaMarcacoes.replace(":", ".")) - Double.valueOf(saidaHorarioTrabalho.replace(":", "."));
                                                                resultado = String.valueOf(atraso);
                                                            }

                                                            if (Integer.valueOf(entradaMarcacoes.replace(":", "")) > Integer.valueOf(entradaHorarioTrabalho.replace(":", ""))) {
                                                                atraso = Double.valueOf(entradaHorarioTrabalho.replace(":", ".")) - Double.valueOf(entradaMarcacoes.replace(":", "."));
                                                                resultado = String.valueOf(atraso);
                                                            };
                                                            
                                                             if (Integer.valueOf(entradaMarcacoes.replace(":", "")) < Integer.valueOf(entradaHorarioTrabalho.replace(":", ""))) {
                                                                resultado = "0";
                                                            }
                                                             if (Integer.valueOf(saidaMarcacoes.replace(":", "")) > Integer.valueOf(saidaHorarioTrabalho.replace(":", ""))) {
                                                                resultado = "0";
                                                            }


                                                    %>
                                                    <tr>
                                                        <td><b><%= resultado.replace(".", ":").replace("-", "")%></b></td>

                                                    </tr>
                                                    <%}%>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12 col-lg-6">
                                <br>
                                <br>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="col">
                                            <h2>Tabela de Horas Extras</h2>
                                            <table class="table table-striped table-bordered table-borderless">
                                                <thead class="table-dark">
                                                    <tr>
                                                        <th scope="col">Horas Extras</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% for (Marcacoes h : listaMarcacoes) {%>
                                                    <% for (HorarioTrabalho ht : lista) {
                                                            Double extra;
                                                            String resultado = "0";
                                                            String saidaMarcacao = h.getSaida();
                                                            String saidaHorarioTrabalho = ht.getSaida();
                                                            String entradaMarcacao = h.getEntrada();
                                                            String entradaHorarioTrabalho = ht.getEntrada();

                                                            if (Integer.valueOf(saidaMarcacao.replace(":", "")) > Integer.valueOf(saidaHorarioTrabalho.replace(":", ""))) {
                                                                extra = Double.valueOf(saidaMarcacao.replace(":", ".")) - Double.valueOf(saidaHorarioTrabalho.replace(":", "."));
                                                                resultado = String.valueOf(extra);
                                                            }
                                                            if (Integer.valueOf(saidaMarcacao.replace(":", "")) < Integer.valueOf(saidaHorarioTrabalho.replace(":", ""))) {
                                                                resultado = "0";
                                                            }
                                                            if (Integer.valueOf(entradaMarcacao.replace(":", "")) < Integer.valueOf(entradaHorarioTrabalho.replace(":", ""))) {
                                                                extra = Double.valueOf(entradaMarcacao.replace(":", ".")) - Double.valueOf(entradaHorarioTrabalho.replace(":", "."));
                                                                resultado = String.valueOf(extra);
                                                            }
                                                            if (Integer.valueOf(entradaMarcacao.replace(":", "")) > Integer.valueOf(entradaHorarioTrabalho.replace(":", ""))) {
                                                                resultado = "0";
                                                            };


                                                    %>
                                                    <tr>
                                                        <td><b><%= resultado.replace(".", ":").replace("-", "")%></b></td>

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
                </div>
            </div>
        </div>







    </body>
</html>
