/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.ImpressoraBeans;
import Modelo.Beans.TecnicoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ImpressoraDao {

    public void Create(ImpressoraBeans imp) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Impressoras(numPat, numSut, serialImp, dataEnvio, obsDef, tecnicoid, OS) values(?,?,?,?,?,?,?)");
            stmt.setInt(1, imp.getNumPat());
            stmt.setInt(2, imp.getNumSut());
            stmt.setInt(3, imp.getSerialImp());
            stmt.setString(4, imp.getDataEnvio());
            stmt.setString(5, imp.getObsDefeito());
            stmt.setInt(6, imp.getTecnico().getIdTec());
            stmt.setInt(7, imp.getOs());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar !" + ex.getMessage());
        } finally {
            ConnectionFactory.CloseConection(con, stmt);
        }
    }

    public List<ImpressoraBeans> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ImpressoraBeans> imps = new ArrayList<>();
        
        
        try {
            //stmt = con.prepareStatement("select * from Impressoras ");
            stmt = con.prepareStatement("select idImp, numPat, numSut, serialImp, dataEnvio, obsDef, nomeTec, os from Impressoras inner join Tecnicos on tecnicoId = idTec");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ImpressoraBeans imp = new ImpressoraBeans();
                
                imp.setIdImp(rs.getInt("idImp"));
                imp.setNumPat(rs.getInt("numPat"));
                imp.setNumSut(rs.getInt("numSut"));
                imp.setSerialImp(rs.getInt("serialImp"));
                imp.setDataEnvio(rs.getString("dataEnvio"));
                imp.setObsDefeito(rs.getString("obsDef"));
                
                TecnicoBeans tec = new TecnicoBeans();
                //tec.setIdTec(rs.getInt("idTec"));
                tec.setNomeTec(rs.getString("nomeTec"));
                imp.setTecnico(tec);
                //imp.setTecnico((TecnicoBeans) rs.getArray("nomeTec"));
                imp.setOs(rs.getInt("OS"));
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
    public void Update(ImpressoraBeans imp) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update Impressoras set numPat =?, numSut =?, serialImp=?, dataEnvio=?, obsDef=?, tecnicoid=?, OS=? where idImp = ?");
            stmt.setInt(1, imp.getNumPat());
            stmt.setInt(2, imp.getNumSut());
            stmt.setInt(3, imp.getSerialImp());
            stmt.setString(4, imp.getDataEnvio());
            stmt.setString(5, imp.getObsDefeito());
            stmt.setInt(6, imp.getTecnico().getIdTec());
            stmt.setInt(7, imp.getOs());
            stmt.setInt(8,imp.getIdImp());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atulizado com sucesso !");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar !" + ex.getMessage());
        } finally {
            ConnectionFactory.CloseConection(con, stmt);
        }
    }
}
