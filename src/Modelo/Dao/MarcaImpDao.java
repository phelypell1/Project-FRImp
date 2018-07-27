/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.MarcaImpressoraBeans;
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
public class MarcaImpDao {
    public List<MarcaImpressoraBeans> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<MarcaImpressoraBeans> ImpreB = new ArrayList<>();
        
        
        try {
            stmt = con.prepareStatement("select * from MarcaImp ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                MarcaImpressoraBeans model = new MarcaImpressoraBeans();
                
                model.setIdMarca(rs.getInt("idMarca"));
                model.setNomeMarca(rs.getString("marca"));
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
