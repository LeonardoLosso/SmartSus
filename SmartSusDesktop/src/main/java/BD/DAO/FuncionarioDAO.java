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
    
    public void salvarCadastro(Funcionario f) {
        salvarFuncionario(f);
        int id_func = lerIdFunc(f);
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try{
            stmt = conn.prepareStatement("INSERT INTO tbCadastro (nome, cpf_cnpj,"
                    + " telefone, tipo, id_func, id_endereco) VALUES(?,?,?,?,?,?)");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getTipo()+"");
            stmt.setInt(5, id_func);
            stmt.setInt(6, f.getEndereco().getId());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR: "+ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    private void salvarFuncionario(Funcionario f){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("INSERT INTO tbFuncionario"
                    + "(matricula, especializa, documento) VALUES (?,?,?)");
            
            stmt.setInt(1, f.getMatricula());
            stmt.setString(2, f.getExp());
            stmt.setInt(3, f.getDocumento());
            
            stmt.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    private int lerIdFunc(Funcionario f){
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
    
    public boolean confereMatricula(int m){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        boolean tmp=false;
        try{
            stmt = conn.prepareStatement("SELECT matricula FROM "
                    + "tbFuncionario WHERE matricula = ?");
            stmt.setInt(1, m);
            rs=stmt.executeQuery();
            tmp=rs.next();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return tmp;
    }
    
    public ArrayList<Funcionario> lerListaFuncionario(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM vw_Funcionario");
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
    public Funcionario retornarCadastro(int idUser){
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
