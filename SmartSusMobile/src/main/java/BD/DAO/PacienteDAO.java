package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Endereco;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class PacienteDAO {
    public static void salvarPaciente(Paciente p){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try{
            stmt = conn.prepareStatement("INSERT INTO tbCadastro (nome, cpf_cnpj,"
                    + " telefone, tipo, id_endereco) VALUES(?,?,?,?,?)");
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getTipo()+"");
            stmt.setInt(5, p.getEndereco().getId());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR: "+ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    public static int lerIdPessoa(Paciente p){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        int id = -1;
        
        try{
            stmt = conn.prepareStatement("SELECT id FROM "
                    + "tbCadastro WHERE cpf_cnpj = ?");
            stmt.setString(1, p.getCpf());
            rs=stmt.executeQuery();
            rs.next();
            id=rs.getInt("id");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return id;
    }
    
    public static boolean lerCpfPessoa(String cpf){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        boolean tmp=false;
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM "
                    + "tbCadastro WHERE cpf_cnpj = ?");
            stmt.setString(1, cpf);
            rs=stmt.executeQuery();
            tmp=rs.next();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return tmp;
    }
    
    public static Paciente retornarCadastro(int idUser){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Endereco e = new Endereco();
        Paciente f = new Paciente();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM "
                    + "vw_Paciente WHERE id = ?");
            stmt.setInt(1, idUser);
            rs=stmt.executeQuery();
            rs.next();

            e.setId(rs.getInt("id_endereco"));
            e.setEndereco(rs.getString("logradouro"));
            e.setComplemento(rs.getString("complemento"));
            e.setBairro(rs.getString("bairro"));
            e.setNumero(rs.getInt("numero"));
            e.setUF(rs.getString("uf"));
            e.setCep(rs.getString("cep"));

            f.setEndereco(e);
            f.setNome(rs.getString("nome"));
            f.setId(rs.getInt("id"));
            f.setCpf(rs.getString("cpf_cnpj"));
            f.setTelefone(rs.getString("telefone"));
            f.setTipo(rs.getString("tipo"));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return f;
    }
}
