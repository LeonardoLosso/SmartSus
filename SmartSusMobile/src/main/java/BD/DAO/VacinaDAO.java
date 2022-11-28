package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Vacina;
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
public class VacinaDAO {
    public static ArrayList<Vacina> lerListaVacina(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
        
        try{
            stmt = conn.prepareStatement("SELECT DISTINCT finalidade FROM tbvacina");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Vacina v = new Vacina();
                
                v.setFinalidade(rs.getString("finalidade"));
                
                vacinas.add(v);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return vacinas;
    }
}
