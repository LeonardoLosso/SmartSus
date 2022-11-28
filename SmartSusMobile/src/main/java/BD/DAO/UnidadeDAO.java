package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Endereco;
import Entidades.UnidadeUbs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UnidadeDAO {
    public static ArrayList<UnidadeUbs> lerListaUnidadeUbs(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<UnidadeUbs> unidades = new ArrayList<UnidadeUbs>();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM tbunidade");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Endereco e = new Endereco();
                UnidadeUbs u = new UnidadeUbs();
                
                e.setId(rs.getInt("id_endereco"));
                u.setEndereco(e);
                
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                
                unidades.add(u);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return unidades;
    }
    
    public UnidadeUbs getUnidade(int id){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UnidadeUbs u = new UnidadeUbs();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM tbunidade WHERE id = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            rs.next();
            Endereco e = new Endereco();

            e.setId(rs.getInt("id_endereco"));
            u.setEndereco(e);

            u.setId(id);
            u.setNome(rs.getString("nome"));
                
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return u;
    }
}
