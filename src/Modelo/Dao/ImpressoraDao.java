/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.ImpressoraBeans;
import Modelo.Beans.MarcaImpressoraBeans;
import Modelo.Beans.ModeloImpressoraBeans;
import Modelo.Beans.TecnicoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ImpressoraDao {

    public void Create(ImpressoraBeans imp) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into (numPat, numSut, serialImp, dataEnvio, obsDef, tecnicoId, OS, marcaId,modeloId, dataCompraImp, dataEntrada,dataFechamento, dataSaida,laudoTec) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, imp.getNumPat());
            stmt.setInt(2, imp.getNumSut());
            stmt.setInt(3, imp.getSerialImp());
            stmt.setString(4, imp.getDataEnvio());
            stmt.setString(5, imp.getObsDefeito());
            stmt.setInt(6, imp.getTecnico().getIdTec());
            stmt.setInt(7, imp.getOs());
            stmt.setString(8, imp.getDataCompra());
            stmt.setInt(9, imp.getMarcaImp().getIdMarca());
            stmt.setInt(10, imp.getModeloImp().getIdModelo());
            stmt.setString(11, imp.getDataEntrada());
            stmt.setString(12, imp.getDataFechamento());
            stmt.setString(13, imp.getDataSaida());
            stmt.setString(14, imp.getLaudoTecnico());
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
            stmt = con.prepareStatement("select idImp, numPat, numSut, serialImp, dataEnvio, obsDef, nomeTec, os, marca, nomeModelo from Impressoras inner join Tecnicos on tecnicoId = idTec inner join MarcaImp on marcaId = idMarca inner join ModeloImp on modeloId = idModelo");
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
                tec.setNomeTec(rs.getString("nomeTec"));
                imp.setTecnico(tec);
                //imp.setTecnico((TecnicoBeans) rs.getArray("nomeTec"));
                //imp.setOs(rs.getInt("OS"));
                
                MarcaImpressoraBeans impMarca = new MarcaImpressoraBeans();
                impMarca.setNomeMarca(rs.getString("marca"));
                imp.setIdImp(0);
                imp.setMarcaImp(impMarca);
                
                ModeloImpressoraBeans impModel = new ModeloImpressoraBeans();
                impModel.setNomeModelo(rs.getString("nomeModelo"));
                impModel.setIdModelo(rs.getInt("idModelo"));
                imp.setModeloImp(impModel);
                
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
