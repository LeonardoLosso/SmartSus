/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD.DAO;

import BD.Connection.ConnectionFactory;
import Entidades.Estoque;
import Entidades.Remedio;
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
public class EstoqueDAO {
    public static ArrayList<Estoque> pesquisarVacina(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Estoque> vacinas = new ArrayList<Estoque>();
        
        try{
            stmt = conn.prepareStatement("SELECT unidade, finalidade, SUM(quantidade) as quantidade "
                    + "FROM vw_Estoque_vacina GROUP BY finalidade, unidade ORDER BY unidade");
            rs = stmt.executeQuery();

            while(rs.next()){
                Estoque e = new Estoque();
                Vacina v = new Vacina();
                
                v.setFinalidade(rs.getString("finalidade"));
                
                e.setItem(v);
                e.setQuantidade(rs.getInt("quantidade"));
                e.setUnidade(rs.getString("unidade"));
                
                vacinas.add(e);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return vacinas;
    }
    
    // terminar select e essa tela 
    public static ArrayList<Estoque> pesquisarRemedio(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Estoque> vacinas = new ArrayList<Estoque>();
        
        try{
            stmt = conn.prepareStatement("SELECT nome, substancia, finalidade, dosagem, SUM(quantidade) as quantidade "
                    + "FROM vw_estoque_remedio GROUP BY nome, substancia, finalidade ORDER BY nome");
            rs = stmt.executeQuery();

            while(rs.next()){
                Estoque e = new Estoque();
                Remedio r = new Remedio();
                
                r.setFinalidade(rs.getString("finalidade"));
                r.setDosagem(rs.getInt("dosagem"));
                r.setSubstancia(rs.getString("substancia"));
                e.setItem(r);
                e.setQuantidade(rs.getInt("quantidade"));
                e.setUnidade(rs.getString("nome"));
                
                vacinas.add(e);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return vacinas;
    }
}
