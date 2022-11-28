package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Endereco;
import Entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    
    public static ArrayList<Funcionario> lerListaFuncionario(String tipo){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM vw_Funcionario WHERE tipo = ?");
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Endereco e = new Endereco();
                Funcionario f = new Funcionario();
                
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
                f.setMatricula(rs.getInt("matricula"));
                f.setExp(rs.getString("especializa"));
                f.setDocumento(rs.getInt("documento"));
                
                funcionarios.add(f);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public static int lerIdFunc(Funcionario f){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        int id = -1;
        
        try{
            stmt = conn.prepareStatement("SELECT id FROM "
                    + "tbFuncionario WHERE matricula = ?");
            stmt.setInt(1, f.getMatricula());
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
    
    public static Funcionario retornarCadastro(int idUser){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Endereco e = new Endereco();
        Funcionario f = new Funcionario();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM "
                    + "vw_funcionario WHERE id = ?");
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
            f.setMatricula(rs.getInt("matricula"));
            f.setExp(rs.getString("especializa"));
            f.setDocumento(rs.getInt("documento"));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return f;
    }
}
