package BD.DAO;

import BD.Connection.ConnectionFactory;
import DadosGlobaisTemporarios.Logado;
import Entidades.Agenda;
import Entidades.Funcionario;
import Entidades.UnidadeUbs;
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
public class AgendaDAO {
    public static ArrayList<Agenda> lerAgenda(String data, int idFunc){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Agenda> agendas = new ArrayList<Agenda>();
        
        try{
            stmt = conn.prepareStatement("SELECT * FROM tbAgenda "
                    + "WHERE date_format(dia, '%d/%m/%Y') = ? AND id_funcionario = ? "
                    + "AND status_consulta = 'A' ORDER BY Horario asc");
            stmt.setString(1, data);
            stmt.setInt(2, idFunc);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Agenda a = new Agenda();
                
                a.setData(rs.getString("dia"));
                a.setHora(rs.getTime("horario"));
                
                agendas.add(a);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return agendas;
    }
    
    public static void salvarConsulta(int idFunc, int idPaciente, int idUbs, String dia, String horario, String motivo){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("INSERT INTO tbAgenda (id_funcionario, id_cadastro, id_unidade, dia, "
                    + "Horario, Motivo_consulta) VALUES (?,?,?,str_to_date(?, '%d/%m/%Y'),?,?)");
            stmt.setInt(1, idFunc);
            stmt.setInt(2, idPaciente);
            stmt.setInt(3, idUbs);
            stmt.setString(4, dia);
            stmt.setString(5, horario);
            stmt.setString(6, motivo);
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Consulta Agendada com sucesso!!");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    public static ArrayList<Agenda> lerAgendaPaciente(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Agenda> agendas = new ArrayList<Agenda>();
        
        try{
            stmt = conn.prepareStatement("SELECT *, date_format(dia, '%d/%m/%Y') as data "
                    + "FROM vw_agenda WHERE id_paciente = ? "
                    + "AND dia > now() AND status_consulta = 'A'");
            
            stmt.setInt(1, Logado.getPaciente().getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Agenda a = new Agenda();
                Funcionario f = new Funcionario();
                UnidadeUbs u = new UnidadeUbs();
                
                f.setId(rs.getInt("id_doctor"));
                f.setNome(rs.getString("nome_doutor"));
                
                u.setId(rs.getInt("id_unidade"));
                u.setNome(rs.getString("nome_unidade"));
                
                a.setFuncionario(f);
                a.setUnidade(u);
                a.setData(rs.getString("data"));
                a.setHora(rs.getTime("horario"));
                
                agendas.add(a);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return agendas;
    }
    
    public static int buscarIdConsulta(String data, String horario, String medico){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id=-1;
        
        try{
            stmt = conn.prepareStatement("SELECT * "
                    + "FROM vw_agenda WHERE id_paciente = ? "
                    + "AND date_format(dia, '%d/%m/%Y') = ? "
                    + "AND horario = ? "
                    + "AND nome_doutor = ? "
                    + "AND status_consulta = 'A'");
            
            stmt.setInt(1, Logado.getPaciente().getId());
            stmt.setString(2, data);
            stmt.setString(3, horario);
            stmt.setString(4, medico);
            
            rs = stmt.executeQuery();
            rs.next();
            
            id = rs.getInt("id");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex + " busca ID");
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return id;
    }
    
    public static void cancelarConsulta(int id){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("UPDATE tbAgenda SET status_consulta = 'C' WHERE id = ?");
            stmt.setInt(1, id);
            stmt.execute();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex + " DELETA");
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
}
