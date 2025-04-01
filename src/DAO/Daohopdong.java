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
import MODEL.Modelhopdong;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author Thinkbook 16
 */
public class Daohopdong {
     public static Daohopdong getInstance() {
        return new Daohopdong();
}

public void addhopdong (Modelhopdong hd) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_HOPDONG(?,?,?,?,?,?,?)}");
            
            callableStatement.setString(1, hd.getMAHOPDONG());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(hd.getNGAYBD());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            callableStatement.setDate(2, sqlDate);
            callableStatement.setString(3, hd.getTHOIHAN());
            callableStatement.setString(4, hd.getLOAIHD());
            callableStatement.setDouble(5, hd.getGIA());
            callableStatement.setString(6, hd.getMACD());
            callableStatement.setString(7, hd.getMABQL());
            
            callableStatement.executeUpdate();
                // Close resources
            callableStatement.close();
            c.close();
}
    public void update(Modelhopdong s) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_HOPDONG(?,?,?,?,?,?,?)}")){
            
             callableStatement.setString(1, s.getMAHOPDONG());    
            // Chuyển đổi ngày sinh từ chuỗi định dạng dd/MM/yyyy sang java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(s.getNGAYBD());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            callableStatement.setDate(2, sqlDate);
            callableStatement.setString(3, s.getTHOIHAN());
            callableStatement.setString(4, s.getLOAIHD());
            callableStatement.setDouble(5, s.getGIA());
            callableStatement.setString(6, s.getMACD());
            callableStatement.setString(7, s.getMABQL());
            
            callableStatement.executeUpdate();
             callableStatement.close();
            c.close();
          
}
    }
    
    

    
    public void delete(Modelhopdong s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM HOPDONG WHERE MAHOPDONG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getMAHOPDONG());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       
    }

    //Override
    public ArrayList<Modelhopdong> selectAll() {
        ArrayList<Modelhopdong> ketQua = new ArrayList<Modelhopdong>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM HOPDONG";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MAHOPDONG = rs.getString("MAHOPDONG");
                String NgayBD= rs.getString("NGAYBD");
                String ThoiHan = rs.getString("THOIHAN");
                String Loaihd = rs.getString("LOAIHD");
                Double Gia = rs.getDouble("GIA");
                String MACD = rs.getString("MACD");
                String MABQL = rs.getString("MABQL");
                            
                Modelhopdong hd = new Modelhopdong(MAHOPDONG, NgayBD ,ThoiHan, Loaihd, Gia, MACD, MABQL);
                ketQua.add(hd);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
    public Modelhopdong selectById(String s) {
        Modelhopdong ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM HOPDONG WHERE MAHOPDONG=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MAHOPDONG = rs.getString("MAHOPDONG");
                String NgayBD= rs.getString("NGAYBD");
                String ThoiHan = rs.getString("THOIHAN");
                String Loaihd = rs.getString("LOAIHD");
                Double Gia = rs.getDouble("GIA");
                String MACD = rs.getString("MACD");
                String MABQL = rs.getString("MABQL");
                            
                ketQua = new Modelhopdong(MAHOPDONG, NgayBD ,ThoiHan, Loaihd, Gia, MACD, MABQL);
                
                         
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
public Modelhopdong selectBymacd(String macd) {
    Modelhopdong ketQua = null;
    try {
        Connection con = OracleJDBCconnection.getJDBCconnection();
        String sql = "SELECT * FROM HOPDONG WHERE MACD=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, macd);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String MAHOPDONG = rs.getString("MAHOPDONG");
            String NgayBD = rs.getString("NGAYBD");
            String ThoiHan = rs.getString("THOIHAN");
            String Loaihd = rs.getString("LOAIHD");
            Double Gia = rs.getDouble("GIA");
            String MACD = rs.getString("MACD");
            String MABQL = rs.getString("MABQL");

            ketQua = new Modelhopdong(MAHOPDONG, NgayBD, ThoiHan, Loaihd, Gia, MACD, MABQL);
        }
        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}}