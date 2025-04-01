/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Database.OracleJDBCconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.Modelyeucaucd;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Thinkbook 16
 */
public class Daoguiyc {
    public static Daoguiyc getInstance() {
        return new Daoguiyc();
}
    public void addyeucau (Modelyeucaucd yc) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_YEUCAUCUDAN(?,?,?,?,?)}");
            
            callableStatement.setString(1, yc.getMAYC());
            callableStatement.setString(2, yc.getLoaiYC());
            callableStatement.setString(3, yc.getNoiDungYC());
            callableStatement.setString(4, yc.getTrangThaiYC());
            callableStatement.setString(5, yc.getMACD());
            callableStatement.executeUpdate();
                // Close resources
            callableStatement.close();
            c.close();
}

    
    public int delete(Modelyeucaucd yc) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM YEUCAUCUDAN WHERE MAYC=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, yc.getMAYC());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    //Override
    public ArrayList<Modelyeucaucd> selectAll() {
        ArrayList<Modelyeucaucd> ketQua = new ArrayList<Modelyeucaucd>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM YEUCAUCUDAN";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mayc = rs.getString("MAYC");
                String loaiyc= rs.getString("LoaiYC");
                String noidungyc = rs.getString("NoiDungYC");
                String trangthaiyc = rs.getString("TrangThaiYC");
                String macd = rs.getString("MACD");
                            
                Modelyeucaucd yc = new Modelyeucaucd( mayc, loaiyc ,noidungyc, trangthaiyc, macd);
                ketQua.add(yc);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Modelyeucaucd> selectByMACD(String macd) throws SQLException {
        ArrayList<Modelyeucaucd> list = new ArrayList<>();
        Connection con = OracleJDBCconnection.getJDBCconnection();
        String sql = "SELECT * FROM YEUCAUCUDAN WHERE MACD = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, macd);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String mayc = rs.getString("MAYC");
            String loaiYC = rs.getString("LoaiYC");
            String noiDungYC = rs.getString("NoiDungYC");
            String trangThaiYC = rs.getString("TrangThaiYC");
            Modelyeucaucd yc = new Modelyeucaucd(mayc, loaiYC, noiDungYC, trangThaiYC, macd);
            list.add(yc);
        }
        rs.close();
        pst.close();
        con.close();
        return list;
    }
    
    public Modelyeucaucd selectById(String s) {
        Modelyeucaucd ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM YEUCAUCUDAN WHERE MAYC=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mayc = rs.getString("MAYC");
                String loaiyc= rs.getString("LoaiYC");
                String noidungyc = rs.getString("NoiDungYC");
                String trangthaiyc = rs.getString("TrangThaiYC");
                String macd = rs.getString("MACD");
                
                ketQua =  new Modelyeucaucd( mayc, loaiyc ,noidungyc, trangthaiyc, macd);
               
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}

