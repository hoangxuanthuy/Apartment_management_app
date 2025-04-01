/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Modelcudan {
    private String MACD;
    private String hoten;
    private String ngsinh;
    private String gioitinh;
    private String cccd;
    private String sdt;
    private String email;
    private String loaicd;
    
public Modelcudan(String MACD, String hoten, String ngsinh, String gioitinh, String cccd, String sdt, String email, String loaicd) {
    this.MACD = MACD;
    this.hoten = hoten;
    this.ngsinh = ngsinh;
    this.gioitinh = gioitinh;
    this.cccd = cccd;
    this.sdt = sdt;
    this.email = email;
    this.loaicd = loaicd;
    }

//    public Modelcudan() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

public Modelcudan() {
    this.MACD = "";
    this.hoten = "";
    this.ngsinh = "";
    this.gioitinh = "";
    this.cccd = "";
    this.sdt = "";
    this.email = "";
    this.loaicd = "";

    }



public String getMACD() {
    return MACD;
    }

public String getHoten() {
    return hoten;
    }

    
public String getNgsinh() {
    if (ngsinh == null) {
            return null;
        }
        try {
            // Định dạng đầu vào (thay đổi nếu định dạng của bạn khác)
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Chuyển đổi từ chuỗi định dạng đầu vào sang đối tượng Date
            Date date = inputFormat.parse(ngsinh);

            // Chuyển đổi từ đối tượng Date sang chuỗi định dạng đầu ra
            return outputFormat.format(date);
        } catch (ParseException es) {
            return ngsinh; // Hoặc bạn có thể trả về một giá trị mặc định hoặc chuỗi thông báo lỗi
        }
    }
    
public String getGioitinh() {
    return gioitinh;
    }


public String getCccd() {
    return cccd;
    }

public String getSdt() {
    return sdt;
    }

public String getEmail() {
    return email;
    }

public String getLoaicd() {
    return loaicd;
    }

public void setMACD(String MACD) {
    this.MACD = MACD;
    }

public void setHoten(String hoten) {
    this.hoten = hoten;
    }

public void setNgsinh(String ngsinh) {
    this.ngsinh = ngsinh;
    }
    
public void setGioitinh(String gioitinh) {
    this.gioitinh = gioitinh;
    }

public void setCccd(String cccd) {
    this.cccd = cccd;
    }

public void setSdt(String sdt) {
    this.sdt = sdt;
    }

public void setEmail(String email) {
    this.email = email;
    }

public void setLoaicd(String loaicd) {
    this.loaicd = loaicd;
    }

    @Override
public String toString() {
    return "cudan{" + "MACD=" + MACD + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", ngsinh=" + ngsinh + ", cccd=" + cccd + ", sdt=" + sdt + ", email=" + email + ", loaicd=" + loaicd + '}';
    }
}
