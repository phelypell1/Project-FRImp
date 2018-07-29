
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.ImpressoraBeans;
import Modelo.Beans.RelatorioBeans;
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
    public RelatorioBeans BuscaOS(RelatorioBeans rel){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con.prepareStatement("select * from Impressoras where OS like%'"+rel.getBusca()+"%'");
            RelatorioBeans imp = new RelatorioBeans();
                
                imp.setIdImp(rs.getInt("idImp"));
                imp.setNumPat(rs.getInt("numPat"));
                imp.setDataEnvio(rs.getString("dataEnvio"));
                imp.setDataEntrada(rs.getString("dataEntrada"));
                imp.setDataFechamento(rs.getString("dataFechamento"));
                imp.setDataSaida(rs.getString("dataSaida"));
                imp.setDefeito(rs.getString("obsDef"));
                imp.setLautoTec(rs.getString("laudoTec"));
                
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro: " +ex);
        }
        finally{
            ConnectionFactory.CloseConection(con, stmt, rs);
        }
        return rel;
    }
}
