
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.ImpressoraBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RelatorioDao {
    
    
    
    public List<ImpressoraBeans> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ImpressoraBeans> imps = new ArrayList<>();
        
        
        try {
            //stmt = con.prepareStatement("select * from Impressoras ");
            stmt = con.prepareStatement("select idImp, OS,numPat, dataEnvio, dataEntrada, dataFechamento, dataSaida, obsDef, laudoTec  from Impressoras");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ImpressoraBeans imp = new ImpressoraBeans();
                
                imp.setIdImp(rs.getInt("idImp"));
                imp.setOs(rs.getString("OS"));
                imp.setNumPat(rs.getInt("numPat"));
                imp.setDataEnvio(rs.getString("dataEnvio"));
                imp.setDataEntrada(rs.getString("dataEntrada"));
                imp.setDataFechamento(rs.getString("dataFechamento"));
                imp.setDataSaida(rs.getString("dataSaida"));
                imp.setObsDefeito(rs.getString("obsDef"));
                imp.setLaudoTecnico(rs.getString("laudoTec"));
                
                imps.add(imp);
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERRO " +ex.getMessage());
        }
        finally{
            ConnectionFactory.CloseConection(con, stmt, rs);
        }
        return imps;

    }
    public List<ImpressoraBeans> ReadBuscaOS(String busca) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ImpressoraBeans> imps = new ArrayList<>();
        
        
        try {
            
            stmt = con.prepareStatement("select * from Impressoras where OS like ?");
            stmt.setString(1, "%"+busca+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ImpressoraBeans imp = new ImpressoraBeans();
                
                imp.setIdImp(rs.getInt("idImp"));
                imp.setOs(rs.getString("OS"));
                imp.setNumPat(rs.getInt("numPat"));
                imp.setDataEnvio(rs.getString("dataEnvio"));
                imp.setDataEntrada(rs.getString("dataEntrada"));
                imp.setDataFechamento(rs.getString("dataFechamento"));
                imp.setDataSaida(rs.getString("dataSaida"));
                imp.setObsDefeito(rs.getString("obsDef"));
                imp.setLaudoTecnico(rs.getString("laudoTec"));
                
                imps.add(imp);
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro no RelatorioDao Método ReadBuscaOS\n " +ex.getMessage());
        }
        finally{
            ConnectionFactory.CloseConection(con, stmt, rs);
        }
        return imps;

    }
    
}
