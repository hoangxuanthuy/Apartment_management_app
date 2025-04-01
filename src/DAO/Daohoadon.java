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
import MODEL.Modelcanho;
import MODEL.Modelcthd;
import MODEL.Modeldienke;
import MODEL.Modeldonghonuoc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.Modelhoadon;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import oracle.jdbc.OracleTypes;


public class Daohoadon {
    public static Daohoadon getInstance() {
        return new Daohoadon();
    }
    public void addhoadon (Modelhoadon hd) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection(); 
        
        CallableStatement callableStatement = c.prepareCall("{CALL INSERT_HOADON(?,?,?,?,?)}");
        callableStatement.setString(1, hd.getMAHD());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = sdf.parse(hd.getNGAYHD());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        callableStatement.setDate(2, sqlDate);
        callableStatement.setDouble(3, hd.getTRIGIA());
        callableStatement.setString(4, hd.getTINHTRANG());
        callableStatement.setString(5, hd.getMACH());
        
        callableStatement.executeUpdate();
        callableStatement.close();
        c.close();
}
  
    public void updateTinhTrangHoadon(String mahd) throws SQLException {
    Connection c = OracleJDBCconnection.getJDBCconnection();
    
    CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_TINHTRANG_HOADON(?, ?)}");
    callableStatement.setString(1, mahd);
    callableStatement.setString(2, "Da thanh toan");
    
    callableStatement.executeUpdate();
    callableStatement.close();
    c.close();
}
    
    
    public int delete(Modelhoadon s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
         //   con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            String sql = "DELETE FROM HOADON WHERE MAHD=?";
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

    //Override
    public ArrayList<Modelhoadon> selectAll() {
        ArrayList<Modelhoadon> ketQua = new ArrayList<Modelhoadon>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM HOADON";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MAHD");
                String ngayhd= rs.getString("NGAYHD");
                Double trigia = rs.getDouble("TRIGIA");
                String tinhtrang = rs.getString("TINHTRANG");
                String mach = rs.getString("MACH");
               
             
                Modelhoadon hd = new Modelhoadon(mahd, ngayhd ,trigia,tinhtrang, mach);
                ketQua.add(hd);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Modelhoadon> selectHDByMANV(String manv) throws SQLException {
    ArrayList<Modelhoadon> list = new ArrayList<>();
    Connection con = OracleJDBCconnection.getJDBCconnection();
    String sql = "SELECT hd.*, ch.DienTich, ch.LoaiCH, ch.SoPhongNgu, ch.SoPhongTam, ch.Tang, ch.GiaThue, ch.PHIDV, ch.GIAXE, ch.SLXE " +
                 "FROM HOADON hd " +
                 "INNER JOIN CANHO ch ON hd.MACH = ch.MACH " +
                 "WHERE ch.MANV = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, manv);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
        String mahd = rs.getString("MAHD");
        String ngayhd = rs.getString("NGAYHD");
        double trigia = rs.getDouble("TRIGIA");
        String tinhtrang = rs.getString("TINHTRANG");
        String mach = rs.getString("MACH");
 
        Modelhoadon hd = new Modelhoadon(mahd, ngayhd, trigia, tinhtrang, mach);
        list.add(hd);
    }
    rs.close();
    pst.close();
    con.close();
    return list;
}
    
    public Modelhoadon selectById(String s) {
        Modelhoadon ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM HOADON WHERE MAHD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               String mahd = rs.getString("MAHD");
                String ngayhd= rs.getString("NGAYHD");
                Double trigia = rs.getDouble("TRIGIA");
                String tinhtrang = rs.getString("TINHTRANG");
                String mach = rs.getString("MACH");
                
               ketQua = new Modelhoadon(mahd, ngayhd ,trigia,tinhtrang, mach);
               
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    public Modelcthd getCTHDByMAHD(String mahd , String maCanHo) throws SQLException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
        Modelcthd cthd = null;

        String query = "SELECT MACH, GiaThue, PHIDV, GIAXE , SLXE FROM CANHO WHERE MACH = ?";

        PreparedStatement preparedStatement = c.prepareStatement(query);
        preparedStatement.setString(1, maCanHo);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            cthd = new Modelcthd();
            cthd.setMAHD(mahd);
            cthd.setGIATHUE(resultSet.getDouble("GiaThue"));
            double tienxe = resultSet.getDouble("GIAXE") * resultSet.getInt("SLXE");
            cthd.setPHIXE(tienxe);
            cthd.setPHIDV(resultSet.getDouble("PHIDV"));
            cthd.setTIENDIEN(0);
            cthd.setTIENNUOC(0);
        }

            resultSet.close();
            preparedStatement.close();
            c.close();

        return cthd;
    }
    
    public Modelhoadon getHoaDonByMACH(String mach) throws SQLException {
    Modelhoadon hoadon = null;
    Connection con = OracleJDBCconnection.getJDBCconnection();
    
    String sql = "SELECT * FROM HOADON WHERE MACH = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, mach);
    
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        String mahd = rs.getString("MAHD");
        String ngayhd = rs.getString("NGAYHD");
        double trigia = rs.getDouble("TRIGIA");
        String tinhtrang = rs.getString("TINHTRANG");
        
        hoadon = new Modelhoadon();
        hoadon.setMAHD(mahd);
        hoadon.setNGAYHD(ngayhd);
        hoadon.setTRIGIA(trigia);
        hoadon.setTINHTRANG(tinhtrang);
        hoadon.setMACH(mach);
    }
    
    rs.close();
    pst.close();
    con.close();
    
    return hoadon;
}
    public Modelhoadon getHoaDonByMACD(String macd) throws SQLException {
        Modelhoadon hoadon = null;
        Connection con = OracleJDBCconnection.getJDBCconnection();
        
        String sql = "SELECT * FROM HOADON WHERE MACH IN (SELECT MACH FROM CANHO WHERE MACD = ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, macd);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String mahd = rs.getString("MAHD");
            String ngayhd = rs.getString("NGAYHD");
            double trigia = rs.getDouble("TRIGIA");
            String tinhtrang = rs.getString("TINHTRANG");
            String mach = rs.getString("MACH");
            
            hoadon = new Modelhoadon();
            hoadon.setMAHD(mahd);
            hoadon.setNGAYHD(ngayhd);
            hoadon.setTRIGIA(trigia);
            hoadon.setTINHTRANG(tinhtrang);
            hoadon.setMACH(mach);
        }
        
        rs.close();
        pst.close();
        con.close();
        
        return hoadon;
    }
    
   public Modelcthd getXEMCTHDByMAHD(String mahd) throws SQLException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
        Modelcthd cthd = null;
        
        CallableStatement callableStatement = c.prepareCall("{CALL XEMCTHD(?, ?)}");
        callableStatement.setString(1, mahd);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        
        // Execute the stored procedure
        callableStatement.execute();
        
        // Retrieve the cursor
        ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
        
        if (resultSet.next()) {
            cthd = new Modelcthd();
            cthd.setMAHD(resultSet.getString("MAHD"));
            cthd.setGIATHUE(resultSet.getDouble("GIATHUE"));
            cthd.setPHIXE(resultSet.getDouble("PHIXE"));
            cthd.setPHIDV(resultSet.getDouble("PHIDV"));
            cthd.setTIENDIEN(resultSet.getDouble("TIENDIEN"));
            cthd.setTIENNUOC(resultSet.getDouble("TIENNUOC"));
        }
        
        resultSet.close();
        callableStatement.close();
        c.close();

        return cthd;
    }
  
    
     public Modelcanho getCHByMACH(String mach) throws SQLException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
        Modelcanho ch = null;

        String query = "SELECT MACH, GiaThue, PHIDV, GIAXE , SLXE FROM CANHO WHERE MACH = ?";

        PreparedStatement preparedStatement = c.prepareStatement(query);
        preparedStatement.setString(1, mach);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            ch = new Modelcanho();
            ch.setMACH(resultSet.getString("MACH"));
            
            ch.setGiaThue(resultSet.getDouble("GiaThue"));
            
            ch.setPHIDV(resultSet.getDouble("PHIDV"));
            
            ch.setGIAXE(resultSet.getDouble("GIAXE"));
            ch.setSLXE(resultSet.getInt("SLXE"));

        }

        resultSet.close();
        preparedStatement.close();
        c.close();

        return ch;
    }
     
     public Modeldienke getDKByMACH(String mach) throws SQLException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
        Modeldienke dk = null;

        String query = "SELECT MACH, CHISOTRUOC, CHISOSAU, GIADIEN  FROM DIENKE WHERE MACH = ?";

        PreparedStatement preparedStatement = c.prepareStatement(query);
        preparedStatement.setString(1, mach);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            dk = new Modeldienke();
            dk.setMACH(resultSet.getString("MACH"));
            dk.setCST(resultSet.getInt("CHISOTRUOC"));
            dk.setCSS(resultSet.getInt("CHISOSAU"));
            dk.setGIADIEN(resultSet.getDouble("GIADIEN"));

        }
        resultSet.close();
        preparedStatement.close();
        c.close();

        return dk;
    }
     
     public Modeldonghonuoc getDHNByMACH(String mach) throws SQLException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
        Modeldonghonuoc dhn = null;

        String query = "SELECT MACH, CHISOTRUOC, CHISOSAU, GIANUOC  FROM DONGHONUOC WHERE MACH = ?";

        PreparedStatement preparedStatement = c.prepareStatement(query);
        preparedStatement.setString(1, mach);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            dhn = new Modeldonghonuoc();
            dhn.setMACH(resultSet.getString("MACH"));
            dhn.setCST(resultSet.getInt("CHISOTRUOC"));
            dhn.setCSS(resultSet.getInt("CHISOSAU"));
            dhn.setGIANUOC(resultSet.getDouble("GIANUOC"));

        }
        resultSet.close();
        preparedStatement.close();
        c.close();

        return dhn;
    }
     
     public ArrayList<Modelhoadon> selectInvoicesByMACD(String macd) throws SQLException {
    ArrayList<Modelhoadon> list = new ArrayList<>();
    Connection con = OracleJDBCconnection.getJDBCconnection();
    String sql = "SELECT HOADON.MAHD, HOADON.NGAYHD, HOADON.TRIGIA, HOADON.TINHTRANG, HOADON.MACH " +
                 "FROM HOADON " +
                 "JOIN CANHO ON HOADON.MACH = CANHO.MACH " +
                 "WHERE CANHO.MACD = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, macd);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
        String mahd = rs.getString("MAHD");
        String ngayhd = rs.getString("NGAYHD");
        double trigia = rs.getDouble("TRIGIA");
        String tinhtrang = rs.getString("TINHTRANG");
        String mach = rs.getString("MACH");
        Modelhoadon hd = new Modelhoadon(mahd, ngayhd, trigia, tinhtrang, mach);
        list.add(hd);
    }
    rs.close();
    pst.close();
    con.close();
    return list;
}
    
 
}
