
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
import MODEL.Modelyeucaucd;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import oracle.jdbc.OracleTypes;

    public class Daocanho {
        public static Daocanho getInstance() {
            return new Daocanho();
        }
        
        public void addcanho (Modelcanho ch) throws SQLException, ParseException {
            Connection c = OracleJDBCconnection.getJDBCconnection(); 
            c.setAutoCommit(false);
            c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_CANHO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");         
            callableStatement.setString(1, ch.getMACH());
            callableStatement.setDouble(2, ch.getDienTich());
            callableStatement.setString(3, ch.getLoaiCH());
            callableStatement.setInt(4, ch.getSoPhongNgu());
            callableStatement.setInt(5, ch.getSoPhongTam());
            callableStatement.setInt(6, ch.getTang());
            callableStatement.setDouble(7, ch.getGiaThue());
            callableStatement.setDouble(8, ch.getPHIDV());
            callableStatement.setDouble(9, ch.getGIAXE());
            callableStatement.setInt(10, ch.getSLXE());
            callableStatement.setString(11, ch.getMACD());
            callableStatement.setString(12, ch.getMANV());
            callableStatement.setString(13, ch.getMAHOPDONG());  
            callableStatement.executeUpdate();
            callableStatement.close();
            c.close();
        }
        
        public void update(Modelcanho s) throws SQLException, ParseException {
            Connection c = OracleJDBCconnection.getJDBCconnection();
            c.setAutoCommit(false);
            if (s.getMACD().equals("null")&& s.getMAHOPDONG().equals("null")&&s.getMANV().equals("null"))
            {
                try( 
                        
                CallableStatement callableStatement = c.prepareCall("{CALL UPDATE1_CANHO(?,?,?,?,?,?,?,?,?,?)}")){
                callableStatement.setString(1, s.getMACH());
                callableStatement.setDouble(2, s.getDienTich());
                callableStatement.setString(3, s.getLoaiCH());
                callableStatement.setInt(4, s.getSoPhongNgu());
                callableStatement.setInt(5, s.getSoPhongTam());
                callableStatement.setInt(6, s.getTang());
                callableStatement.setDouble(7, s.getGiaThue());
                callableStatement.setDouble(8, s.getPHIDV());
                callableStatement.setDouble(9, s.getGIAXE());
                callableStatement.setInt(10, s.getSLXE());
                callableStatement.executeUpdate();
            }
}
            else
            {
            try( 
                
                CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_CANHO(?,?,?,?,?,?,?,?,?,?,?,?,?)}")){
                callableStatement.setString(1, s.getMACH());
                callableStatement.setDouble(2, s.getDienTich());
                callableStatement.setString(3, s.getLoaiCH());
                callableStatement.setInt(4, s.getSoPhongNgu());
                callableStatement.setInt(5, s.getSoPhongTam());
                callableStatement.setInt(6, s.getTang());
                callableStatement.setDouble(7, s.getGiaThue());
                callableStatement.setDouble(8, s.getPHIDV());
                callableStatement.setDouble(9, s.getGIAXE());
                callableStatement.setInt(10, s.getSLXE());
                callableStatement.setString(11, s.getMACD());
                callableStatement.setString(12, s.getMANV());
                callableStatement.setString(13, s.getMAHOPDONG()); 
                callableStatement.executeUpdate();
            }
            }
    //Override
  
        }
     
     
     
     public void updatedien(Modeldienke d) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_DIENKE(?,?,?,?)}")){
            callableStatement.setString(1, d.getMACH());
            callableStatement.setDouble(2, d.getCST());
            callableStatement.setDouble(3, d.getCSS());
            callableStatement.setDouble(4, d.getGIADIEN());
           
            callableStatement.executeUpdate();          
}

    //Override
     }
     
     public void updatenuoc(Modeldonghonuoc n) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_DONGHONUOC(?,?,?,?)}")){
            callableStatement.setString(1, n.getMACH());
            callableStatement.setDouble(2, n.getCST());
            callableStatement.setDouble(3, n.getCSS());
            callableStatement.setDouble(4, n.getGIANUOC());
            
            callableStatement.executeUpdate();
//            callableStatement.close();
          //  c.close();
          
}

    //Override
     }
    
    
   
    
    public int delete(Modelcanho s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "UPDATE CANHO SET MACD=NULL,MANV=NULL,MAHOPDONG=NULL,SLXE=0 WHERE MACH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getMACH());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public void delete1(String mach) throws SQLException {

    try (Connection c = OracleJDBCconnection.getJDBCconnection();
         CallableStatement callableStatement = c.prepareCall("{CALL XOACANHO(?)}")) {

        // Truyền mã cư dân vào procedure
        callableStatement.setString(1, mach);

        // Thực thi procedure
        callableStatement.executeUpdate();
    }
}

    //Override
    public ArrayList<Modelcanho> selectAll() {
        ArrayList<Modelcanho> ketQua = new ArrayList<Modelcanho>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
             con.setAutoCommit(false);
            String sql = "SELECT * FROM CANHO";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 String mach = rs.getString("MACH");
                double dientich= rs.getDouble("DienTich");
                String loaich = rs.getString("LoaiCH");
                int sophngu = rs.getInt("SoPhongNgu");
                int sophtam = rs.getInt("SoPhongTam");
                int tang = rs.getInt("Tang");
                double giathue = rs.getDouble("GiaThue");
                double phidv = rs.getDouble("PHIDV");
                double giaxe = rs.getDouble("GIAXE");
                int slxe = rs.getInt("SLXE");
                String macd= rs.getString("MACD");
                String manv= rs.getString("MANV");
                String mahopdong= rs.getString("MAHOPDONG");
             
                Modelcanho ch = new Modelcanho(mach, dientich ,loaich, sophngu, sophtam, tang, giathue, phidv, giaxe, slxe, macd, manv, mahopdong);
                ketQua.add(ch);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
    public Modelcanho selectById(String s) {
        Modelcanho ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM CANHO WHERE MACH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 String mach = rs.getString("MACH");
                double dientich= rs.getDouble("DienTich");
                String loaich = rs.getString("LoaiCH");
                int sophngu = rs.getInt("SoPhongNgu");
                int sophtam = rs.getInt("SoPhongTam");
                int tang = rs.getInt("Tang");
                double giathue = rs.getDouble("GiaThue");
                double phidv = rs.getDouble("PHIDV");
                double giaxe = rs.getDouble("GIAXE");
                int slxe = rs.getInt("SLXE");
                String macd= rs.getString("MACD");
                String manv= rs.getString("MANV");
                String mahopdong= rs.getString("MAHOPDONG");
                
                ketQua = new Modelcanho(mach, dientich ,loaich, sophngu, sophtam, tang, giathue, phidv, giaxe, slxe, macd, manv, mahopdong);
               
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public Modelcanho selectByMacd(String macd) {
    Modelcanho ketQua = null;
    try {
        Connection con = OracleJDBCconnection.getJDBCconnection();
        String sql = "SELECT * FROM CANHO WHERE MACD=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, macd);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String mach = rs.getString("MACH");
            double dientich = rs.getDouble("DienTich");
            String loaich = rs.getString("LoaiCH");
            int sophngu = rs.getInt("SoPhongNgu");
            int sophtam = rs.getInt("SoPhongTam");
            int tang = rs.getInt("Tang");
            double giathue = rs.getDouble("GiaThue");
            double phidv = rs.getDouble("PHIDV");
            double giaxe = rs.getDouble("GIAXE");
            int slxe = rs.getInt("SLXE");
            String manv = rs.getString("MANV");
            String mahopdong = rs.getString("MAHOPDONG");

            ketQua = new Modelcanho(mach, dientich, loaich, sophngu, sophtam, tang, giathue, phidv, giaxe, slxe, macd, manv, mahopdong);
        }
        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}
    
   public Modelcanho getXEMCTCHByMACH(String mach) throws SQLException {
    Connection c = OracleJDBCconnection.getJDBCconnection();
    c.setAutoCommit(false);
    Modelcanho ch = null;

    CallableStatement callableStatement = c.prepareCall("{CALL XEMCTCH(?,?)}");
    callableStatement.setString(1, mach);
    callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

    // Execute the stored procedure
    callableStatement.execute();

    // Retrieve the cursor
    ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

    if (resultSet.next()) {
        ch = new Modelcanho();
        ch.setMACH(resultSet.getString("MACH"));
        ch.setDienTich(resultSet.getDouble("DienTich"));
        ch.setLoaiCH(resultSet.getString("LoaiCH"));
        ch.setSoPhongNgu(resultSet.getInt("SoPhongNgu"));
        ch.setSoPhongTam(resultSet.getInt("SoPhongTam"));
        ch.setTang(resultSet.getInt("Tang"));
        ch.setGiaThue(resultSet.getDouble("GiaThue"));
        ch.setPHIDV(resultSet.getDouble("PHIDV"));
        ch.setGIAXE(resultSet.getDouble("GIAXE"));
        ch.setSLXE(resultSet.getInt("SLXE"));
        ch.setMACD(resultSet.getString("MACD"));
        ch.setMANV(resultSet.getString("MANV"));
        ch.setMAHOPDONG(resultSet.getString("MAHOPDONG"));
    }

    resultSet.close();
    callableStatement.close();
    c.close();

    return ch;
}

    
    
    public Modelcanho selectByInvoiceId(String invoiceId) {
        Modelcanho ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT c.* FROM CANHO c JOIN HOADON h ON c.MACH = h.MACH WHERE h.MAHD = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, invoiceId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String mach = rs.getString("MACH");
                double dientich = rs.getDouble("DienTich");
                String loaich = rs.getString("LoaiCH");
                int sophngu = rs.getInt("SoPhongNgu");
                int sophtam = rs.getInt("SoPhongTam");
                int tang = rs.getInt("Tang");
                double giathue = rs.getDouble("GiaThue");
                double phidv = rs.getDouble("PHIDV");
                double giaxe = rs.getDouble("GIAXE");
                int slxe = rs.getInt("SLXE");
                String macd = rs.getString("MACD");
                String manv = rs.getString("MANV");
                String mahopdong = rs.getString("MAHOPDONG");

                ketQua = new Modelcanho(mach, dientich, loaich, sophngu, sophtam, tang, giathue, phidv, giaxe, slxe, macd, manv, mahopdong);
            }
            
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Modelcanho> selectCHByMANV(String manv) throws SQLException {
        ArrayList<Modelcanho> list = new ArrayList<>();
        Connection con = OracleJDBCconnection.getJDBCconnection();
        String sql = "SELECT * FROM CANHO WHERE MANV = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, manv);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String mach = rs.getString("MACH");
                double dientich = rs.getDouble("DienTich");
                String loaich = rs.getString("LoaiCH");
                int sophngu = rs.getInt("SoPhongNgu");
                int sophtam = rs.getInt("SoPhongTam");
                int tang = rs.getInt("Tang");
                double giathue = rs.getDouble("GiaThue");
                double phidv = rs.getDouble("PHIDV");
                double giaxe = rs.getDouble("GIAXE");
                int slxe = rs.getInt("SLXE");
                String macd = rs.getString("MACD");
                String manvien = rs.getString("MANV");
                String mahopdong = rs.getString("MAHOPDONG");
                
            Modelcanho ch = new Modelcanho(mach, dientich, loaich, sophngu, sophtam,tang, giathue, phidv, giaxe, slxe ,macd ,manvien , mahopdong);
            list.add(ch);
        }
        rs.close();
        pst.close();
        con.close();
        return list;
    }
    public ArrayList<Modelcanho> selectCHByMACD(String macd) throws SQLException {
    ArrayList<Modelcanho> list = new ArrayList<>();
    Connection con = OracleJDBCconnection.getJDBCconnection();
    String sql = "SELECT * FROM CANHO WHERE MACD = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, macd);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
        String mach = rs.getString("MACH");
        double dientich = rs.getDouble("DienTich");
        String loaich = rs.getString("LoaiCH");
        int sophngu = rs.getInt("SoPhongNgu");
        int sophtam = rs.getInt("SoPhongTam");
        int tang = rs.getInt("Tang");
        double giathue = rs.getDouble("GiaThue");
        double phidv = rs.getDouble("PHIDV");
        double giaxe = rs.getDouble("GIAXE");
        int slxe = rs.getInt("SLXE");
        String manvien = rs.getString("MANV");
        String mahopdong = rs.getString("MAHOPDONG");
        
        Modelcanho ch = new Modelcanho(mach, dientich, loaich, sophngu, sophtam, tang, giathue, phidv, giaxe, slxe, macd, manvien, mahopdong);
        list.add(ch);
    }
    rs.close();
    pst.close();
    con.close();
    return list;
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
    
    public Modeldienke getDKByMACH(String maCanHo) throws SQLException {
    Connection c = OracleJDBCconnection.getJDBCconnection();
    Modeldienke dk = null;

    String query = "SELECT MACH, CHISOTRUOC, CHISOSAU, GIADIEN FROM DIENKE WHERE MACH = ?";

    PreparedStatement preparedStatement = c.prepareStatement(query);
    preparedStatement.setString(1, maCanHo);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        dk = new Modeldienke();
        dk.setMACH(maCanHo);
        dk.setCST(resultSet.getInt("CHISOTRUOC"));
        dk.setCSS(resultSet.getInt("CHISOSAU"));
        dk.setGIADIEN(resultSet.getInt("GIADIEN")); // Ensure this gets value from database
    }

    resultSet.close();
    preparedStatement.close();
    c.close();

    return dk;
}

public Modeldonghonuoc getDHNByMACH(String maCanHo) throws SQLException {
    Connection c = OracleJDBCconnection.getJDBCconnection();
    Modeldonghonuoc dhn = null;

    String query = "SELECT MACH, CHISOTRUOC, CHISOSAU, GIANUOC FROM DONGHONUOC WHERE MACH = ?";

    PreparedStatement preparedStatement = c.prepareStatement(query);
    preparedStatement.setString(1, maCanHo);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        dhn = new Modeldonghonuoc();
        dhn.setMACH(maCanHo);
        dhn.setCST(resultSet.getInt("CHISOTRUOC"));
        dhn.setCSS(resultSet.getInt("CHISOSAU"));
        dhn.setGIANUOC(resultSet.getInt("GIANUOC")); // Ensure this gets value from database
    }

    resultSet.close();
    preparedStatement.close();
    c.close();

    return dhn;
}
       }