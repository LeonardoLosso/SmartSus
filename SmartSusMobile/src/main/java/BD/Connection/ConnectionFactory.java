package BD.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/smartsus?zeroDateTimeBehavior=CONVERT_TO_NULL ";
    
    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection(URL, USERNAME, SENHA);
            return conn;
        }catch(SQLException ex){
            throw new RuntimeException("ERRO DE CONEXÃO");
        }
    }
    public static void closeConnection(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
        
        closeConnection(conn);
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(conn, stmt);
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void main(String[] args) throws Exception {
//        Connection c = getConnection();
//        if(c!=null){
//            System.out.println("PIKA MANE");
//        }else{
//            System.out.println("deu ruim");
//        }
//    }
}
