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
public class Modelnhanvien {
   private String MANV;
   private String HOTEN;
   private String SDT;
   private  String Email;
   private  String MABQL;
    public Modelnhanvien(String MANV, String HOTEN, String SDT, String Email, String MABQL) {
        this.MANV = MANV;
        this.SDT = SDT;
        this.HOTEN = HOTEN;
        this.Email = Email;
        this.MABQL = MABQL;
    }
    
    public Modelnhanvien() {
        this.MANV = "";
        this.SDT = "";
        this.HOTEN = "";
        this.Email = "";
        this.MABQL = "";
    }
   

    public String getMANV() {
        return MANV;
    }

    public String getSDT() {
        return SDT;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public String getEmail() {
        return Email;
    }

    public String getMABQL() {
        return MABQL;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setMABQL(String MABQL) {
        this.MABQL = MABQL;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "MANV=" + MANV + ", HOTEN=" + HOTEN + ",  SDT=" + SDT + ", Email=" + Email + ", MABQL=" + MABQL + '}';
    }
    
}
