
package testabanco;

import java.lang.*;
import java.sql.*;

public class conexao {
    private String usuario = "root";
    private String senha = "Julinha2007*";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "bd_gastos";
    
    public Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gastos?useTimezone=true&serverTimezone=UTC", "root", "Julinha2007*" );
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

    