
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.TecnicoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TecnicosDao {
    
    
   public List<TecnicoBeans> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<TecnicoBeans> tecs = new ArrayList<>();
        
        
        try {
            stmt = con.prepareStatement("select * from Tecnicos ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                TecnicoBeans tec = new TecnicoBeans();
                
                tec.setIdTec(rs.getInt("idTec"));
                tec.setNomeTec(rs.getString("nomeTec"));
                tecs.add(tec);
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERRO " +ex.getMessage());
        }
        finally{
            ConnectionFactory.CloseConection(con, stmt, rs);
        }
        return tecs;

    } 
}
