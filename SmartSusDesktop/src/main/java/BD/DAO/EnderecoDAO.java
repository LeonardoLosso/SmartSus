package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class EnderecoDAO {
    public void salvarCep(Endereco e){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("INSERT INTO tbendereco(logradouro,"
                    + "complemento, bairro, numero, uf, cep) VALUES "
                    + "(?,?,?,?,?,?)");
            
            stmt.setString(1, e.getEndereco());
            stmt.setString(2, e.getComplemento());
            stmt.setString(3, e.getBairro());
            stmt.setInt(4, e.getNumero());
            stmt.setString(5, e.getUF());
            stmt.setString(6, e.getCep());
            
            stmt.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
        lerIdEndereco(e);
    }
     
    private void lerIdEndereco(Endereco e){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        try{
            stmt = conn.prepareStatement("SELECT id FROM "
                    + "tbEndereco WHERE cep = ? AND numero = ?");
            stmt.setString(1, e.getCep());
            stmt.setInt(2, e.getNumero());
            rs=stmt.executeQuery();
            
            rs.next();
            e.setId(rs.getInt("id"));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
}
