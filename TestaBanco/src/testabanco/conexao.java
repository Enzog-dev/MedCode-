/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabanco;

/**
 *
 * @author DENISE NEVES
 */
import java.lang.*;
import java.sql.*;

public class conexao {
    
    private String usuario = "root";
    private String senha = "admin";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "bd_planos";
    
    public Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd+"?useTimezone=true&serverTimezone=UTC", usuario, senha);
            System.out.println("Banco Conectado com Sucesso!!!!");
            return c;
        }
        catch (Exception e){
            System.out.println("Banco NAO Conectado!!!!");
            e.printStackTrace();
            return null;
        }
    }
    
}

    