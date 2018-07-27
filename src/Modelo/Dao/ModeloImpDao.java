/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.ModeloImpressoraBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author phelype
 */
public class ModeloImpDao {
    
    public List<ModeloImpressoraBeans> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ModeloImpressoraBeans> ImpreB = new ArrayList<>();
        
        
        try {
            stmt = con.prepareStatement("select * from ModeloImp ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ModeloImpressoraBeans model = new ModeloImpressoraBeans();
                
                model.setIdModelo(rs.getInt("idModelo"));
                model.setNomeModelo(rs.getString("nomeModelo"));
                ImpreB.add(model);
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERRO " +ex.getMessage());
        }
        finally{
            ConnectionFactory.CloseConection(con, stmt, rs);
        }
        return ImpreB;

    } 
}
