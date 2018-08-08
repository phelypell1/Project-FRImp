/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Connection.ConnectionFactory;
import Modelo.Beans.StatusBeans;
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
public class StatusDao {

    public class MarcaImpDao {

        public List<StatusBeans> Read() {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            List<StatusBeans> statusB = new ArrayList<>();

            try {
                stmt = con.prepareStatement("select * from Sts_imp ");
                rs = stmt.executeQuery();

                while (rs.next()) {

                    StatusBeans model = new StatusBeans();

                    model.setIdSts(rs.getInt("idSts"));
                    model.setNomeSts(rs.getString("nomeSts"));
                    statusB.add(model);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO " + ex.getMessage());
            } finally {
                ConnectionFactory.CloseConection(con, stmt, rs);
            }
            return statusB;

        }
    }
}
