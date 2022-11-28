package BD.DAO;

import BD.Connection.ConnectionFactory;
import DadosGlobaisTemporarios.Logado;
import Entidades.Agenda;
import Entidades.Funcionario;
import Entidades.Paciente;
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
    
    public static ArrayList<Agenda> lerAgendaDoutor(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Agenda> agendas = new ArrayList<Agenda>();
        
        try{
            stmt = conn.prepareStatement("SELECT *, date_format(dia, '%d/%m/%Y') as data "
                    + "FROM vw_agenda WHERE id_doctor = ? "
                    + "AND dia > now() AND status_consulta = 'A'");
            
            stmt.setInt(1, Logado.getFuncionario().getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Agenda a = new Agenda();
                Paciente p = new Paciente();
                UnidadeUbs u = new UnidadeUbs();
                
                p.setId(rs.getInt("id_doctor"));
                p.setNome(rs.getString("nome_paciente"));
                
                u.setId(rs.getInt("id_unidade"));
                u.setNome(rs.getString("nome_unidade"));
                
                a.setPaciente(p);
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
            
//            stmt.setInt(1, Logado.getPaciente().getId());
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
