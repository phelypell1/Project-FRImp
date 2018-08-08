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
import Modelo.Beans.StatusBeans;
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
            stmt = con.prepareStatement("insert into Impressoras(numPat, numSut, serialImp, dataEnvio, obsDef, tecnicoId, OS, marcaId,modeloId, dataCompraImp, dataEntrada,dataFechamento, dataSaida,laudoTec) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, imp.getNumPat());
            stmt.setInt(2, imp.getNumSut());
            stmt.setString(3, imp.getSerialImp());
            stmt.setString(4, imp.getDataEnvio());
            stmt.setString(5, imp.getObsDefeito());
            stmt.setInt(6, imp.getTecnico().getIdTec());
            stmt.setString(7, imp.getOs());
            stmt.setInt(8, imp.getMarcaImp().getIdMarca());
            stmt.setInt(9, imp.getModeloImp().getIdModelo());
            stmt.setString(10, imp.getDataCompra());
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
            stmt = con.prepareStatement("select idImp, numPat, numSut, serialImp, dataEnvio, obsDef, nomeTec, os, marca, nomeModelo, nomeSts from Impressoras inner join Tecnicos on tecnicoId = idTec \n" +
"inner join MarcaImp on marcaId = idMarca \n" +
"inner join ModeloImp on modeloId = idModelo\n" +
"inner join Sts_imp on   idStatus = idSts");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ImpressoraBeans imp = new ImpressoraBeans();
                
                imp.setIdImp(rs.getInt("idImp"));
                imp.setNumPat(rs.getInt("numPat"));
                imp.setNumSut(rs.getInt("numSut"));
                imp.setSerialImp(rs.getString("serialImp"));
                imp.setDataEnvio(rs.getString("dataEnvio"));
                imp.setObsDefeito(rs.getString("obsDef"));
                
                TecnicoBeans tec = new TecnicoBeans();
                tec.setNomeTec(rs.getString("nomeTec"));
                imp.setTecnico(tec);
                //imp.setTecnico((TecnicoBeans) rs.getArray("nomeTec"));
                //imp.setOs(rs.getInt("OS"));
                //Serve para pegar o id e converter em String e trazer o nome da chave estrangeira
                MarcaImpressoraBeans impMarca = new MarcaImpressoraBeans();
                impMarca.setNomeMarca(rs.getString("marca"));
                imp.setMarcaImp(impMarca);
                //Serve para pegar o id e salvar na chave estrangeira
                ModeloImpressoraBeans impModel = new ModeloImpressoraBeans();
                impModel.setNomeModelo(rs.getString("nomeModelo"));
                imp.setModeloImp(impModel);
                
                //
                StatusBeans status = new StatusBeans();
                status.setNomeSts(rs.getString("nomeSts"));
                imp.setStatusEnvio(status);
                
                
                
                
                
                
                
                
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
            stmt = con.prepareStatement("update Impressoras set numPat =?, numSut =?, serialImp=?, dataEnvio=?, obsDef=?, tecnicoid=?, OS=?, marcaid=?, modeloId=?, dataCompraImp=?, dataEntrada=?, dataFechamento =?, dataSaida =?, laudoTec=? where idImp = ?");
            stmt.setInt(1, imp.getNumPat());
            stmt.setInt(2, imp.getNumSut());
            stmt.setString(3, imp.getSerialImp());
            stmt.setString(4, imp.getDataEnvio());
            stmt.setString(5, imp.getObsDefeito());
            stmt.setInt(6, imp.getTecnico().getIdTec());
            stmt.setString(7, imp.getOs());
            stmt.setInt(8, imp.getMarcaImp().getIdMarca());
            stmt.setInt(9, imp.getModeloImp().getIdModelo());
            stmt.setString(10, imp.getDataCompra());
            stmt.setString(11, imp.getDataEntrada());
            stmt.setString(12, imp.getDataFechamento());
            stmt.setString(13, imp.getDataSaida());
            stmt.setString(14, imp.getLaudoTecnico());
            stmt.setInt(15,imp.getIdImp());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atulizado com sucesso !");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar !" + ex.getMessage());
        } finally {
            ConnectionFactory.CloseConection(con, stmt);
        }
    }
}
