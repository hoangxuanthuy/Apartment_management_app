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
import MODEL.Modeltaikhoan;
import java.sql.CallableStatement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Daotaikhoan {
    public static Daotaikhoan getInstance() {
        return new Daotaikhoan();
    }

    public void addtaikhoan (Modeltaikhoan tk) throws SQLException, ParseException {
        Connection c = OracleJDBCconnection.getJDBCconnection();           
            CallableStatement callableStatement = c.prepareCall("{CALL INSERT_TAIKHOAN(?,?,?,?)}");         
            callableStatement.setString(1, tk.getUsername());
            callableStatement.setString(2, tk.getPassword());
            callableStatement.setString(3, tk.getRole());
            callableStatement.setString(4, tk.getEmail());          
            callableStatement.executeUpdate();          
            callableStatement.close();
            c.close();
}
    public void update(Modeltaikhoan s) throws SQLException, ParseException {     
        try (
            Connection c = OracleJDBCconnection.getJDBCconnection();
                CallableStatement callableStatement = c.prepareCall("{CALL UPDATE_TAIKHOAN(?,?,?,?)}")){  
                callableStatement.setString(1, s.getUsername());    
                callableStatement.setString(2, s.getPassword());
                callableStatement.setString(3, s.getRole());
                callableStatement.setString(4, s.getEmail());           
                callableStatement.executeUpdate();
                callableStatement.close();
                c.close();       
        }
    }
    
    public int delete(Modeltaikhoan s) {
        int ketQua = 0;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "DELETE FROM TAIKHOAN WHERE Username=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getUsername());
            ketQua = pst.executeUpdate();
            OracleJDBCconnection.closeConnection(con);
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    //Override
    public ArrayList<Modeltaikhoan> selectAll() {
        ArrayList<Modeltaikhoan> ketQua = new ArrayList<Modeltaikhoan>();
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM TAIKHOAN";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String user = rs.getString("Username");
                String pass= rs.getString("Password");
                String role = rs.getString("Role");
                String email = rs.getString("Email");
           
                            
                Modeltaikhoan tk = new Modeltaikhoan(user, pass ,role, email);
                ketQua.add(tk);
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
    public Modeltaikhoan selectById(String s) {
        Modeltaikhoan ketQua = null;
        try {
            Connection con = OracleJDBCconnection.getJDBCconnection();
            String sql = "SELECT * FROM TAIKHOAN WHERE Username=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               String user = rs.getString("Username");
                String pass= rs.getString("Password");
                String role = rs.getString("Role");
                String email = rs.getString("Email");
                            
                ketQua = new Modeltaikhoan(user, pass ,role, email);
                
                         
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public Modeltaikhoan getTaikhoanByEmail(String email) throws SQLException {
    Connection c = OracleJDBCconnection.getJDBCconnection();
    Modeltaikhoan taikhoan = null;
    String query = "SELECT USERNAME, PASSWORD, ROLE, EMAIL FROM TAIKHOAN WHERE EMAIL = ?";
    PreparedStatement preparedStatement = c.prepareStatement(query);
    preparedStatement.setString(1, email);
    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        taikhoan = new Modeltaikhoan();
        taikhoan.setUsername(resultSet.getString("USERNAME"));
        taikhoan.setPassword(resultSet.getString("PASSWORD"));
        taikhoan.setRole(resultSet.getString("ROLE"));
        taikhoan.setEmail(resultSet.getString("EMAIL"));
    }
    resultSet.close();
    preparedStatement.close();
    // Không đóng kết nối ở đây

    return taikhoan;
    }
}