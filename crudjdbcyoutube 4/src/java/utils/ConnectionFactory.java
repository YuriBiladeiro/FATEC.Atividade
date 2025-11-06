package utils;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConexao () {

        Connection conexao = null;

        try {
        //Carrego o driver
        Class. forName ("com.mysql.cj.jdbc.Driver");
        
        //Caminho do banco de dados
        String url = "jdbc:mysql://localhost/exemplomvcyoutube";
        
        //Retorno o objeto de conexão
        conexao = DriverManager. getConnection (url, "root","admin123");
        

    } catch (SQLException ex) {
        //Registro o erro no lop do tomcat
        System.out.print ("Erro ao abrir a conexao");
        throw new RuntimeException ("Erro ao abrir conexão", ex);
        
    }catch (Exception ex) {
        System.out.print ("Erro ao abrir a conexao");
        throw new RuntimeException ("Erro ao registrar driver do JDBC", ex);
    }
    return conexao;
}
}