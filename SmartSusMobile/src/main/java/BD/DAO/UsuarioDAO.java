package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class UsuarioDAO {
    public static void salvarUsuario(Usuario u){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("INSERT INTO tbUser"
                    + "(id_cadastro, login, senha, email)"
                    + "VALUES(?,?,?,?)");
            stmt.setInt(1, u.getPessoa().getId());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getEmail());
            
            stmt.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    public static ArrayList<Usuario> lerListaUsuario(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM tbuser");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                
                u.setLogin(rs.getString("login"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getInt("id"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return usuarios;
    }
    public static boolean FazerLogin(String login, String senha){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        boolean tmp=false;
        try{
            stmt = conn.prepareStatement("SELECT * FROM "
                    + "tbUser WHERE login = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs=stmt.executeQuery();
            
            tmp=rs.next();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return tmp;
    }
    public static boolean confereLogin(String login){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        boolean tmp=false;
        try{
            stmt = conn.prepareStatement("SELECT * FROM "
                    + "tbUser WHERE login = ?");
            stmt.setString(1, login);
            rs=stmt.executeQuery();
            
            tmp=rs.next(); 
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return tmp;
    }
    public static int lerIdUser(String login){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        int id = -1;
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM "
                    + "tbuser WHERE login = ?");
            stmt.setString(1, login);
            rs=stmt.executeQuery();
            rs.next();
            id=rs.getInt("id_cadastro");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return id;
    }
}
