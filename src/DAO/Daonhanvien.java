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
import MODEL.Modelnhanvien;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author Thinkbook 16
 */
public class Daonhanvien {
     public static Daonhanvien getInstance() {
        return new Daonhanvien();
}
     public void addnhanvien (Modelnhanvien nv) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_NHANVIEN(?,?,?,?,?)}");
            
            callableStatement.setString(1, nv.getMANV());
            callableStatement.setString(2, nv.getHOTEN());
            callableStatement.setString(3, nv.getSDT());
            callableStatement.setString(4, nv.getEmail());
            callableStatement.setString(5, nv.getMABQL());
                      
            callableStatement.executeUpdate();
                // Close resources
            callableStatement.close();
            c.close();
}
    public void update(Modelnhanvien nv) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_NHANVIEN(?,?,?,?,?)}")){
            
            callableStatement.setString(1, nv.getMANV());
            callableStatement.setString(2, nv.getHOTEN());
            callableStatement.setString(3, nv.getSDT());
            callableStatement.setString(4, nv.getEmail());
            callableStatement.setString(5, nv.getMABQL());
            
            callableStatement.executeUpdate();
             callableStatement.close();
            c.close();
          
}
    }
    
    

    
    public int delete(Modelnhanvien nv) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM NHANVIEN WHERE MANV=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nv.getMANV());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    //Override
    public ArrayList<Modelnhanvien> selectAll() {
        ArrayList<Modelnhanvien> ketQua = new ArrayList<Modelnhanvien>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM NHANVIEN";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String manv = rs.getString("MANV");
                String hoten= rs.getString("HOTEN");
                String sdt = rs.getString("SDT");
                String email = rs.getString("Email");                
                String mabql = rs.getString("MABQL");
                            
                Modelnhanvien nv = new Modelnhanvien(manv, hoten ,sdt, email, mabql);
                ketQua.add(nv);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
    public Modelnhanvien selectById(String s) {
        Modelnhanvien ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM NHANVIEN WHERE MANV=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String manv = rs.getString("MANV");
                String hoten= rs.getString("HOTEN");
                String sdt = rs.getString("SDT");
                String email = rs.getString("Email");                
                String mabql = rs.getString("MABQL");
                            
                ketQua = new Modelnhanvien(manv, hoten ,sdt, email, mabql);
                
                         
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }}
