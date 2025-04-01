/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Thinkbook 16
 */
public class Modeldonghonuoc {
    private String MACH;
    private double CST;
    private double CSS;
    private double GIANUOC;

    public Modeldonghonuoc(String MACH, double CST, double CSS, double GIANUOC) {
        this.MACH = MACH;
        this.CST = CST;
        this.CSS = CSS;
        this.GIANUOC = GIANUOC;
    }

    public Modeldonghonuoc() {
        this.MACH = "";
        this.CST = 0;
        this.CSS = 0;
        this.GIANUOC = 0;
    }

    public String getMACH() {
        return MACH;
    }

    public double getCST() {
        return CST;
    }

    public double getCSS() {
        return CSS;
    }

    public double getGIANUOC() {
        return GIANUOC;
    }

    public void setMACH(String MACH) {
        this.MACH = MACH;
    }

    public void setCST(double CST) {
        this.CST = CST;
    }

    public void setCSS(double CSS) {
        this.CSS = CSS;
    }

    public void setGIANUOC(double GIANUOC) {
        this.GIANUOC = GIANUOC;
    }

    @Override
    public String toString() {
        return "Modeldonghonuoc{" + "MACH=" + MACH + ", CST=" + CST + ", CSS=" + CSS + ", GIANUOC=" + GIANUOC + '}';
    }
    
    
}


