/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.OracleJDBCconnection;
import MODEL.Modelcthd;
import MODEL.Modelhoadon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Daocthd {
    public static Daocthd getInstance() {
        return new Daocthd();
    }
    
     public void addcthd (Modelcthd ct) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection(); 
        
        CallableStatement callableStatement = c.prepareCall("{CALL INSERT_CTHD(?,?,?,?,?,?)}");
        callableStatement.setString(1, ct.getMAHD());
        callableStatement.setDouble(2, ct.getGIATHUE());
        callableStatement.setDouble(3, ct.getPHIXE());
        callableStatement.setDouble(4, ct.getPHIDV());
        callableStatement.setDouble(5, ct.getTIENDIEN());
        callableStatement.setDouble(6, ct.getTIENNUOC());

        
        callableStatement.executeUpdate();
        callableStatement.close();
        c.close();
}
     
     public int delete(Modelhoadon s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM CTHD WHERE MAHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getMAHD());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
     
       public ArrayList<Modelcthd> selectAll() {
        ArrayList<Modelcthd> ketQua = new ArrayList<Modelcthd>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM CTHD";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MAHD");
                Double giathue= rs.getDouble("GIATHUE");
                Double phixe = rs.getDouble("PHIXE");
                Double phidv = rs.getDouble("PHIDV");
                Double tiendien = rs.getDouble("TIENDIEN");
                Double tiennuoc = rs.getDouble("TIENNUOC");
             
                Modelcthd cthd = new Modelcthd(mahd, giathue ,phixe,phidv, tiendien, tiennuoc);
                ketQua.add(cthd);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
}
