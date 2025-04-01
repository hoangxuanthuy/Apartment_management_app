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
import MODEL.Modelxe;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Daoxe {
    public static Daoxe getInstance() {
        return new Daoxe();
}
    public void addxe (Modelxe xe) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_XE(?,?,?,?)}");
            
            callableStatement.setString(1, xe.getMaXe());
            callableStatement.setString(2, xe.getBienSoXe());
       
            callableStatement.setString(3, xe.getLoaiXe());
            callableStatement.setString(4, xe.getMaCD());
            
            
            callableStatement.executeUpdate();
                // Close resources
            callableStatement.close();
            c.close();
}
    public void update(Modelxe s) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_XE(?,?,?,?)}")){
            callableStatement.setString(1, s.getMaXe());
            callableStatement.setString(2, s.getBienSoXe());
       
            callableStatement.setString(3, s.getLoaiXe());
            callableStatement.setString(4, s.getMaCD());
            
            callableStatement.executeUpdate();
//            callableStatement.close();
          //  c.close();
          
}
    }
    
    

    
    public int delete(Modelxe s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM XE WHERE MAXE=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getMaXe());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    //Override
    public ArrayList<Modelxe> selectAll() {
        ArrayList<Modelxe> ketQua = new ArrayList<Modelxe>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM XE";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MAXE = rs.getString("MAXE");
                String BIENSOXE= rs.getString("BIENSOXE");
                String LOAIXE = rs.getString("LOAIXE");
                String MACD = rs.getString("MACD");
             
                Modelxe xe = new Modelxe(MAXE,BIENSOXE,LOAIXE,MACD);
                ketQua.add(xe);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<Modelxe> selectXeByMACD(String macd) {
    ArrayList<Modelxe> ketQua = new ArrayList<Modelxe>();
    try {
        Connection con = OracleJDBCconnection.getJDBCconnection();
        String sql = "SELECT * FROM XE WHERE MACD = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, macd);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String MAXE = rs.getString("MAXE");
            String BIENSOXE = rs.getString("BIENSOXE");
            String LOAIXE = rs.getString("LOAIXE");

            Modelxe xe = new Modelxe(MAXE, BIENSOXE, LOAIXE, macd);
            ketQua.add(xe);
        }
        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}
    
    
    public Modelxe selectById(String s) {
        Modelxe ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM XE WHERE MAXE=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MAXE = rs.getString("MAXE");
                String BIENSOXE= rs.getString("BIENSOXE");
                String LOAIXE = rs.getString("LOAIXE");
                String MACD = rs.getString("MACD");
             
                ketQua = new Modelxe(MAXE,BIENSOXE,LOAIXE,MACD);
               
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }}
//     public static void main(String[] args){
//         Modelcudan cd = new Modelcudan("CD015", "Nguyen Thi Kieu Trinh", "20/05/2018",  "Nu", "053301201758", "0914240468", "kieutrinh@gmail.com", "Thue");
//         Daocudan mcd = new Daocudan();
//        try {
//            mcd.update(cd);
//        } catch (SQLException ex) {
//            Logger.getLogger(Daocudan.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(Daocudan.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     }
//}
