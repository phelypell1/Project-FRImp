package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/BancoDadosFr";
    private static final String USER = "root";
    private static final String PASS = "Fw38q1V7sN";
    public ResultSet rs;
    public PreparedStatement stmt;

    public void executaSql(String sql){
        ConnectionFactory.getConnection();
        try {
           stmt = (PreparedStatement) getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           rs = stmt.executeQuery(sql);     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar! " +e);
        }
    } 
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar: " + ex);
        }
    }

    public static void CloseConection(Connection con) {
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO " +ex.getMessage());
        }
    }
    
    public static void CloseConection(Connection con,PreparedStatement stmt) {
        CloseConection(con);
        
        try {
            
            if(stmt != null){
            
             stmt.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO " +ex.getMessage());
        }
    }
    public static void CloseConection(Connection con,PreparedStatement stmt, ResultSet rs) {
        CloseConection(con, stmt);
        
        try {
            
            if(rs != null){
            
             rs.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO " +ex.getMessage());
        }
    }
    

}
