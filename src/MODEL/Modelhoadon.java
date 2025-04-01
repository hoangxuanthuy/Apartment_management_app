/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author hoangxuanthuy
 */
public class Modelhoadon {
    private String MAHD; // VARCHAR2(6) PRIMARY KEY
    private  String NGAYHD; // DATE
    private double TRIGIA;
    private String TINHTRANG;
    private String MACH; // VARCHAR2(6)

    public Modelhoadon(String MAHD, String NGAYHD, double TRIGIA,String TINHTRANG, String MACH) {
        this.MAHD = MAHD;
        this.NGAYHD = NGAYHD;
        this.TRIGIA = TRIGIA;
        this.TINHTRANG = TINHTRANG;
        this.MACH = MACH;
    }
    
    public Modelhoadon(String macanho , String mahdon) {
        this.MAHD = mahdon;
        this.NGAYHD = "";
        this.TRIGIA = 0;
        this.TINHTRANG ="Chua thanh toan";
        this.MACH = macanho;
        
    }
    
    public Modelhoadon() {
        this.MAHD = "";
        this.NGAYHD = "";
        this.TRIGIA = 0;
        this.TINHTRANG ="Chua thanh toan";
        this.MACH = "";
    }

    public String getMAHD() {
        return MAHD;
    }

    public String getNGAYHD() {
       if (NGAYHD == null) {
            return null;
        }
        try {
            // Định dạng đầu vào (thay đổi nếu định dạng của bạn khác)
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Chuyển đổi từ chuỗi định dạng đầu vào sang đối tượng Date
            Date date = inputFormat.parse(NGAYHD);

            // Chuyển đổi từ đối tượng Date sang chuỗi định dạng đầu ra
            return outputFormat.format(date);
        } catch (ParseException es) {
            return NGAYHD; // Hoặc bạn có thể trả về một giá trị mặc định hoặc chuỗi thông báo lỗi
        }
    }

    public double getTRIGIA() {
        return TRIGIA;
    }
 
    public String getTINHTRANG() {
        return TINHTRANG;
    }
    
    public String getMACH() {
        return MACH;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public void setNGAYHD(String NGAYHD) {
        this.NGAYHD = NGAYHD;
    }

    public void setTRIGIA(double TRIGIA) {
        this.TRIGIA = TRIGIA;
    }
    
    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG; 
    } 

    public void setMACH(String MACH) {
        this.MACH = MACH;
    }

    @Override
    public String toString() {
        return "Modelhoadon{" + "MAHD=" + MAHD + ", NGAYHD=" + NGAYHD + ", TRIGIA=" + TRIGIA + ", TINHTRANG=" + TINHTRANG + ", MACH=" + MACH + '}';
    }

    
    
}
