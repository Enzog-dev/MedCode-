package testabanco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "bd_gastos";
    private static String usuario = "root";
    private static String senha = "Julinha2007*";
    
    public static Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bd_gastos?useTimezone=true&serverTimezone=UTC", "root", "Julinha2007*" );
            System.out.println("Banco Conectado com Sucesso!!!!");
            return c;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
