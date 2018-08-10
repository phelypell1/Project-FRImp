
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.StatusEnvioBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StatusEnvioDao {
    
    public List<StatusEnvioBeans> ReadStatus(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<StatusEnvioBeans>ListStatus = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("select * from Sts_imp");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               
                StatusEnvioBeans status = new StatusEnvioBeans();
                
                status.setIdStsEnvio(rs.getInt("idSts"));
                status.setNomeStsEnvio(rs.getString("nomeSts"));
                ListStatus.add(status);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro preencher ArrayList");
        }
        return ListStatus;
    }
}
