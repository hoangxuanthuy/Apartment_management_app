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
public class Modelhopdong {
    private String MAHOPDONG; // VARCHAR2(15) PRIMARY KEY
    private String NGAYBD; // DATE
    private String THOIHAN; // VARCHAR2(20)
    private String LOAIHD; // VARCHAR2(40)
    private double GIA; // NUMBER
    private String MACD; // VARCHAR2(6)
    private String MABQL; // VARCHAR2(6)

    public Modelhopdong(String MAHOPDONG, String NGAYBD, String THOIHAN, String LOAIHD, double GIA, String MACD, String MABQL) {
        this.MAHOPDONG = MAHOPDONG;
        this.NGAYBD = NGAYBD;
        this.THOIHAN = THOIHAN;
        this.LOAIHD = LOAIHD;
        this.GIA = GIA;
        this.MACD = MACD;
        this.MABQL = MABQL;
    }
    
    public Modelhopdong (){
        this.MAHOPDONG = "";
        this.NGAYBD = "";
        this.THOIHAN = "";
        this.LOAIHD = "";
        this.GIA = 0;
        this.MACD = "";
        this.MABQL = "";
    }

    public String getMAHOPDONG() {
        return MAHOPDONG;
    }

    public String getNGAYBD() {
        if (NGAYBD == null) {
            return null;
        }
        try {
            // Định dạng đầu vào (thay đổi nếu định dạng của bạn khác)
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Chuyển đổi từ chuỗi định dạng đầu vào sang đối tượng Date
            Date date = inputFormat.parse(NGAYBD);

            // Chuyển đổi từ đối tượng Date sang chuỗi định dạng đầu ra
            return outputFormat.format(date);
        } catch (ParseException es) {
            return NGAYBD; // Hoặc bạn có thể trả về một giá trị mặc định hoặc chuỗi thông báo lỗi
        }
    }

    public String getTHOIHAN() {
        return THOIHAN;
    }

    public String getLOAIHD() {
        return LOAIHD;
    }

    public double getGIA() {
        return GIA;
    }

    public String getMACD() {
        return MACD;
    }

    public String getMABQL() {
        return MABQL;
    }

    public void setMAHOPDONG(String MAHOPDONG) {
        this.MAHOPDONG = MAHOPDONG;
    }

    public void setNGAYBD(String NGAYBD) {
        this.NGAYBD = NGAYBD;
    }

    public void setTHOIHAN(String THOIHAN) {
        this.THOIHAN = THOIHAN;
    }

    public void setLOAIHD(String LOAIHD) {
        this.LOAIHD = LOAIHD;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public void setMACD(String MACD) {
        this.MACD = MACD;
    }

    public void setMABQL(String MABQL) {
        this.MABQL = MABQL;
    }

    @Override
    public String toString() {
        return "hopdong{" + "MAHOPDONG=" + MAHOPDONG + ", NGAYBD=" + NGAYBD + ", THOIHAN=" + THOIHAN + ", LOAIHD=" + LOAIHD + ", GIA=" + GIA + ", MACD=" + MACD + ", MABQL=" + MABQL + '}';
    }
    
    
}
