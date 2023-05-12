/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prefeitura.projetoservlet.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DAO implements Serializable {

    private String driver = "com.mysql.cj.jdbc.Driver";
    
    private String url = "jdbc:mysql://localhost:3306/ponto?useTimezone=true&serverTimezone=UTC";
    
    private String user = "root";
    
    private String password = "";
    
    private Connection conectar(){
        Connection con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void insertHorarioTrabalho(HorarioTrabalho horario){
        
        String createHorarioTrabalho = "insert into horariotrabalho (entrada,saida) values (?,?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(createHorarioTrabalho);
            pst.setString(1, horario.getEntrada());
            pst.setString(2, horario.getSaida());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<HorarioTrabalho> listarHorarioTrabalho(){
        ArrayList<HorarioTrabalho> horariosTrabalhados = new ArrayList<>();
        String listAllHorarioTrabalho = "select * from horariotrabalho";
        try{
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(listAllHorarioTrabalho);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String entrada = rs.getString(2);
                String saida = rs.getString(3);
                horariosTrabalhados.add(new HorarioTrabalho(id,entrada,saida));
            }
            con.close();
            return horariosTrabalhados;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void selecionarHorarioTrabalho(HorarioTrabalho horario){
        String readHorario = "select * from horariotrabalho where id = ?";
        try{
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(readHorario);
            pst.setString(1, horario.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                horario.setId(rs.getString(1));
                horario.setEntrada(rs.getString(2));
                horario.setSaida(rs.getString(3));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void alterarHorarioTrabalho(HorarioTrabalho horario){
    
        String update = "update horariotrabalho set entrada=?, saida=? where id=?";
        try{
             Connection con = conectar();
             PreparedStatement pst = con.prepareStatement(update);
             pst.setString(1, horario.getEntrada());
             pst.setString(2, horario.getSaida());
             pst.setString(3, horario.getId());
             pst.executeUpdate();
             con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void deletarContato(HorarioTrabalho horario){
        
        String delete = "delete from horariotrabalho where id=?";
        try{
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1, horario.getId());
            pst.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
   
    
}
