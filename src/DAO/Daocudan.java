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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.Modelcudan;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Daocudan {
    public static Daocudan getInstance() {
        return new Daocudan();
    }

   

    public void addcudan (Modelcudan cd) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_CUDAN(?,?,?,?,?,?,?,?)}");
            
            callableStatement.setString(1, cd.getMACD());
            callableStatement.setString(2, cd.getHoten());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(cd.getNgsinh());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            callableStatement.setDate(3, sqlDate);
            callableStatement.setString(4, cd.getGioitinh());
            callableStatement.setString(5, cd.getCccd());
            callableStatement.setString(6, cd.getSdt());
            callableStatement.setString(7, cd.getEmail());
            callableStatement.setString(8, cd.getLoaicd());
            
            callableStatement.executeUpdate();
                // Close resources
            callableStatement.close();
            c.close();
}
//    
//    
//    public void addcudan(Modelcudan cd) throws SQLException, ParseException {
//    Connection c = OracleJDBCconnection.getJDBCconnection();
//    try {
//        // Thiết lập mức độ cô lập của giao dịch là SERIALIZABLE
//        c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//
//        // Bắt đầu giao dịch
//        c.setAutoCommit(false);
//
//        CallableStatement callableStatement = c.prepareCall("{CALL INSERT_CUDAN(?,?,?,?,?,?,?,?)}");
//
//        callableStatement.setString(1, cd.getMACD());
//        callableStatement.setString(2, cd.getHoten());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date date = sdf.parse(cd.getNgsinh());
//        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//        callableStatement.setDate(3, sqlDate);
//        callableStatement.setString(4, cd.getGioitinh());
//        callableStatement.setString(5, cd.getCccd());
//        callableStatement.setString(6, cd.getSdt());
//        callableStatement.setString(7, cd.getEmail());
//        callableStatement.setString(8, cd.getLoaicd());
//
//        callableStatement.executeUpdate();
//
//        // Commit giao dịch
//        c.commit();
//
//        // Đóng tài nguyên
//        callableStatement.close();
//    } catch (SQLException | ParseException e) {
//        // Rollback giao dịch nếu có lỗi xảy ra
//        if (c != null) {
//            try {
//                c.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        e.printStackTrace();
//    } finally {
//        // Đóng kết nối
//        if (c != null) {
//            try {
//                c.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//    
//    
    public Modelcudan getCudanByMACD(String MACD) throws SQLException {
    Connection c = OracleJDBCconnection.getJDBCconnection();
    Modelcudan cd = null;

    String sql = "SELECT MACD, HOTEN, NGSINH, GIOITINH, CCCD, SDT, EMAIL, LOAICD FROM CUDAN WHERE MACD = ?";
    PreparedStatement preparedStatement = c.prepareStatement(sql);
    preparedStatement.setString(1, MACD);
    ResultSet rs = preparedStatement.executeQuery();

    if (rs.next()) {
        cd = new Modelcudan();
        cd.setMACD(rs.getString("MACD"));
        cd.setHoten(rs.getString("HOTEN"));
        cd.setNgsinh(rs.getDate("NGSINH").toString()); // assuming the Modelcudan has a String ngsinh field, otherwise, convert accordingly
        cd.setGioitinh(rs.getString("GIOITINH"));
        cd.setCccd(rs.getString("CCCD"));
        cd.setSdt(rs.getString("SDT"));
        cd.setEmail(rs.getString("EMAIL"));
        cd.setLoaicd(rs.getString("LOAICD"));
    }

    // Close resources
    rs.close();
    preparedStatement.close();
    c.close();

    return cd;
}
    
    public void update(Modelcudan s) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_CUDAN(?,?,?,?,?,?,?,?)}")){
            callableStatement.setString(1, s.getMACD());
            callableStatement.setString(2, s.getHoten());    
         // Chuyển đổi ngày sinh từ chuỗi định dạng dd/MM/yyyy sang java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(s.getNgsinh());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            callableStatement.setDate(3, sqlDate);
            callableStatement.setString(4, s.getGioitinh());
            callableStatement.setString(5, s.getCccd());
            callableStatement.setString(6, s.getSdt());
            callableStatement.setString(7, s.getEmail());
            callableStatement.setString(8, s.getLoaicd());
            
            callableStatement.executeUpdate();
//            callableStatement.close();
          //  c.close();
          
}
    }
     
    
    public void delete(String macd) throws SQLException {

    try (Connection c = OracleJDBCconnection.getJDBCconnection();
         CallableStatement callableStatement = c.prepareCall("{CALL XOACUDAN(?)}")) {

        // Truyền mã cư dân vào procedure
        callableStatement.setString(1, macd);

        // Thực thi procedure
        callableStatement.executeUpdate();
    }
}
    
    

        
    

    //Override
    public ArrayList<Modelcudan> selectAll() {
        ArrayList<Modelcudan> ketQua = new ArrayList<Modelcudan>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
           
           // con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
             String sql = "SELECT * FROM CUDAN";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MACD = rs.getString("MACD");
                String Hoten= rs.getString("HoTen");
                String Ngaysinh = rs.getString("NGSINH");
                String Gioitinh = rs.getString("GIOITINH");
                String Cccd = rs.getString("CCCD");
                String Sdt = rs.getString("SDT");
                String Email = rs.getString("Email");
                String Loaicd= rs.getString("LoaiCD");
             
                Modelcudan cd = new Modelcudan(MACD, Hoten ,Ngaysinh, Gioitinh, Cccd, Sdt, Email, Loaicd);
                ketQua.add(cd);
      
            }
        
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
          
        return ketQua;
        
    }
    
    
    public Modelcudan selectById(String s) {
        Modelcudan ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM CUDAN WHERE MACD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               String MACD = rs.getString("MACD");
                String Hoten= rs.getString("HoTen");
                String Ngaysinh = rs.getString("NGSINH");
                String Gioitinh = rs.getString("GIOITINH");
                String Cccd = rs.getString("CCCD");
                String Sdt = rs.getString("SDT");
                String Email = rs.getString("Email");
                String Loaicd= rs.getString("LoaiCD");
                
                ketQua = new Modelcudan(MACD, Hoten ,Ngaysinh, Gioitinh, Cccd, Sdt, Email, Loaicd);
               
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Modelcudan> selectCDByMANV(String manv) throws SQLException {
        ArrayList<Modelcudan> list = new ArrayList<>();
        Connection con = OracleJDBCconnection.getJDBCconnection();
        
        String sql = "SELECT c.MACD, c.HoTen, c.NGSINH, c.GIOITINH, c.CCCD, c.SDT, c.Email, c.LoaiCD " +
                     "FROM CUDAN c " +
                     "INNER JOIN CANHO ch ON c.MACD = ch.MACD " +
                     "INNER JOIN HOPDONG h ON ch.MAHOPDONG = h.MAHOPDONG " +
                     "WHERE ch.MANV = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, manv);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String macd = rs.getString("MACD");
            String hoten = rs.getString("HoTen");
            String ngsinh = rs.getString("NGSINH");
            String gioitinh = rs.getString("GIOITINH");
            String cccd = rs.getString("CCCD");
            String sdt = rs.getString("SDT");
            String email = rs.getString("Email");
            String loaicd = rs.getString("LoaiCD");

            Modelcudan cd = new Modelcudan(macd, hoten, ngsinh, gioitinh, cccd, sdt, email, loaicd);
            list.add(cd);
        }
        rs.close();
        pst.close();
        con.close();
        return list;
    }





}