package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    
    private java.sql.Connection conexao;  
    
    public Connection obterConexao(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDataSource");

            conexao = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/agendabd;SecurityMechanism=3",
                    "app", 
                    "app");            
        } catch (Exception e) {
            e.printStackTrace();
        }

      return conexao;
    }
    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
