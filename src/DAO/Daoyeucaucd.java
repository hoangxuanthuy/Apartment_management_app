package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Database.OracleJDBCconnection;
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


public class Daoyeucaucd {
    public static Daoyeucaucd getInstance() {
        return new Daoyeucaucd();
}
    public void guiyeucau (Modelyeucaucd cd) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();
            
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_YEUCAUCUDAN(?,?,?,?,?)}");
            
            callableStatement.setString(1, cd.getMAYC());
            callableStatement.setString(2, cd.getLoaiYC());
           
            callableStatement.setString(3, cd.getNoiDungYC());
            callableStatement.setString(4, cd.getTrangThaiYC());
            callableStatement.setString(5, cd.getMACD());
            
            callableStatement.executeUpdate();
                // Close resources
            callableStatement.close();
            c.close();
}
    public void update(Modelyeucaucd cd) throws SQLException, ParseException {
       
       try( Connection c = OracleJDBCconnection.getJDBCconnection();
        CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_YEUCAUCUDAN(?,?,?,?,?)}")){
         callableStatement.setString(1, cd.getMAYC());
            callableStatement.setString(2, cd.getLoaiYC());
            callableStatement.setString(3, cd.getNoiDungYC());
            callableStatement.setString(4, cd.getTrangThaiYC());
            callableStatement.setString(5, cd.getMACD());
            
            callableStatement.executeUpdate();
//            callableStatement.close();
          //  c.close();
          
}
    }
   
//    public static void main(String[] args) {
//        // Create a test instance of Modelyeucaucd with example data
//        Modelyeucaucd testYeuCau = new Modelyeucaucd(
//            "YC001",      // Example MAYC
//            "Yeu cau sua chua", // Example LoaiYC
//            "Loi nuoc trong nha", // Example NoiDungYC
//            "Đã xử lý",       // Example TrangThaiYC
//            "CD001"       // Example MACD
//        );
//
//        // Get an instance of Daoyeucaucd
//        Daoyeucaucd dao = Daoyeucaucd.getInstance();
//
//        // Try updating the request in the database
//        try {
//            dao.update(testYeuCau);
//            System.out.println("Update successful");
//        } catch (SQLException | ParseException e) {
//            e.printStackTrace();
//            System.out.println("Update failed: " + e.getMessage());
//        }
//    }

    
    

     public ArrayList<Modelyeucaucd> selectAll() {
        ArrayList<Modelyeucaucd> ketQua = new ArrayList<Modelyeucaucd>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM YEUCAUCUDAN";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Mayc = rs.getString("MAYC");
                String LoaiYC= rs.getString("LoaiYC");
                String NoiDungYC = rs.getString("NoiDungYC");
                String TrangThaiYC = rs.getString("TrangThaiYC");
         
                String Macd= rs.getString("MACD");
             
                Modelyeucaucd yc = new Modelyeucaucd(Mayc, LoaiYC ,NoiDungYC, TrangThaiYC,Macd );
                ketQua.add(yc);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
     
    public int delete(Modelyeucaucd s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM YEUCAUCUDAN WHERE MAYC=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getMAYC());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
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
               String  MAYC = rs.getString("MAYC");
                String LoaiYC= rs.getString("LoaiYC");
                String NoiDungYC = rs.getString("NoiDungYC");
                String TrangThaiYC = rs.getString("TrangThaiYC");
                String MACD = rs.getString("MACD");
            
                
                ketQua = new Modelyeucaucd(MAYC,LoaiYC,NoiDungYC,TrangThaiYC,MACD);
               
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<Modelyeucaucd> selectByMacd(String macd) {
    ArrayList<Modelyeucaucd> ketQua = new ArrayList<>();
    try {
        Connection con = OracleJDBCconnection.getJDBCconnection();
        String sql = "SELECT * FROM YEUCAUCUDAN WHERE MACD=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, macd);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String MAYC = rs.getString("MAYC");
            String LoaiYC = rs.getString("LoaiYC");
            String NoiDungYC = rs.getString("NoiDungYC");
            String TrangThaiYC = rs.getString("TrangThaiYC");
            String MACD = rs.getString("MACD");

            Modelyeucaucd yeucaucd = new Modelyeucaucd(MAYC, LoaiYC, NoiDungYC, TrangThaiYC, MACD);
            ketQua.add(yeucaucd);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}
}
    
   
