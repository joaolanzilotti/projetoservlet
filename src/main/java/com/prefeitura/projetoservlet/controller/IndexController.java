
package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.HorarioTrabalho;
import com.prefeitura.projetoservlet.model.Marcacoes;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/index", ""})
public class IndexController extends HttpServlet {
    
    ArrayList<Marcacoes> listMarcacoes;
    ArrayList<HorarioTrabalho> listHorarioTrabalho;
    
    @Override
    public void init() {
        listMarcacoes =  MarcacaoController.marcacoesFeitas;
        listHorarioTrabalho = PontoController.tabelaHorarioTrabalho;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
         if (action.equals("/index")) {
            tabelas(request, response);
        }else if(action.equals("")){
            tabelas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
      protected void tabelas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          
        request.setAttribute("marcacao", listMarcacoes);
        request.setAttribute("horario", listHorarioTrabalho);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }


}
