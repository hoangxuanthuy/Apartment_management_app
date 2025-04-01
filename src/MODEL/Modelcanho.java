/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author hoangxuanthuy
 */
public class Modelcanho {
    private String MACH; // VARCHAR2(6) PRIMARY KEY
    private double DienTich; // NUMBER
    private String LoaiCH; // VARCHAR2(60)
    private int SoPhongNgu; // INT
    private int SoPhongTam; // INT
    private int Tang; // INT
    private double GiaThue; // NUMBER
    private double PHIDV; // NUMBER
    private double GIAXE; // NUMBER
    private int SLXE; // NUMBER
    private String MACD; // VARCHAR2(6)
    private String MANV; // VARCHAR2(6)
    private String MAHOPDONG; // VARCHAR2(15)

    public Modelcanho(String MACH, double DienTich, String LoaiCH, int SoPhongNgu, int SoPhongTam, int Tang, double GiaThue, double PHIDV, double GIAXE, int SLXE, String MACD, String MANV, String MAHOPDONG) {
        this.MACH = MACH;
        this.DienTich = DienTich;
        this.LoaiCH = LoaiCH;
        this.SoPhongNgu = SoPhongNgu;
        this.SoPhongTam = SoPhongTam;
        this.Tang = Tang;
        this.GiaThue = GiaThue;
        this.PHIDV = PHIDV;
        this.GIAXE = GIAXE;
        this.SLXE = SLXE;
        this.MACD = MACD;
        this.MANV = MANV;
        this.MAHOPDONG = MAHOPDONG;
    }

//   
    public Modelcanho() {
        this.MACH = "";
        this.DienTich = 0;
        this.LoaiCH = "";
        this.SoPhongNgu = 0;
        this.SoPhongTam = 0;
        this.Tang = 0;
        this.GiaThue = 0;
        this.PHIDV = 0;
        this.GIAXE = 0;
        this.SLXE = 0;
        this.MACD = "";
        this.MANV = "";
        this.MAHOPDONG = "";
    }

    public String getMACH() {
        return MACH;
    }

    public double getDienTich() {
        return DienTich;
    }

    public String getLoaiCH() {
        return LoaiCH;
    }

    public int getSoPhongNgu() {
        return SoPhongNgu;
    }

    public int getSoPhongTam() {
        return SoPhongTam;
    }

    public int getTang() {
        return Tang;
    }

    public double getGiaThue() {
        return GiaThue;
    }

    public double getPHIDV() {
        return PHIDV;
    }

    public double getGIAXE() {
        return GIAXE;
    }

    public int getSLXE() {
        return SLXE;
    }

    public String getMACD() {
        return MACD;
    }

    public String getMANV() {
        return MANV;
    }

    public String getMAHOPDONG() {
        return MAHOPDONG;
    }

    public void setMACH(String MACH) {
        this.MACH = MACH;
    }

    public void setDienTich(double DienTich) {
        this.DienTich = DienTich;
    }

    public void setLoaiCH(String LoaiCH) {
        this.LoaiCH = LoaiCH;
    }

    public void setSoPhongNgu(int SoPhongNgu) {
        this.SoPhongNgu = SoPhongNgu;
    }

    public void setSoPhongTam(int SoPhongTam) {
        this.SoPhongTam = SoPhongTam;
    }

    public void setTang(int Tang) {
        this.Tang = Tang;
    }

    public void setGiaThue(double GiaThue) {
        this.GiaThue = GiaThue;
    }

    public void setPHIDV(double PHIDV) {
        this.PHIDV = PHIDV;
    }

    public void setGIAXE(double GIAXE) {
        this.GIAXE = GIAXE;
    }

    public void setSLXE(int SLXE) {
        this.SLXE = SLXE;
    }

    public void setMACD(String MACD) {
        this.MACD = MACD;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public void setMAHOPDONG(String MAHOPDONG) {
        this.MAHOPDONG = MAHOPDONG;
    }

    @Override
    public String toString() {
        return "canho{" + "MACH=" + MACH + ", DienTich=" + DienTich + ", LoaiCH=" + LoaiCH + ", SoPhongNgu=" + SoPhongNgu + ", SoPhongTam=" + SoPhongTam + ", Tang=" + Tang + ", GiaThue=" + GiaThue + ", PHIDV=" + PHIDV + ", GIAXE=" + GIAXE + ", SLXE=" + SLXE + ", MACD=" + MACD + ", MANV=" + MANV + ", MAHOPDONG=" + MAHOPDONG + '}';
    }
    
}
