
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vsilva18
 */
    public class ConectBD {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/firsts";
    private final String USER = "root";
    private final String PASS = "";
    
    Connection conn;
    
    public Connection conectBD(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexão Realizada com Sucesso!");
  
            return conn;
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.out.println("Falha ao Conectar! \n" + ex.getMessage());
            
            return conn;
        }
    }
    
    public void desconectBD(){
         
        try {
            conn.close();
            System.out.println("Desconectado do Banco de Dados");
        } catch (SQLException sqle) {
            System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage());
        }
    }

}

