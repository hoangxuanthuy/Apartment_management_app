/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Thinkbook 16
 */
public class Modeldienke {
    private String MACH;
    private double CST;
    private double CSS;
    private double GIADIEN;

    public Modeldienke(String MACH, double CST, double CSS, double GIADIEN) {
        this.MACH = MACH;
        this.CST = CST;
        this.CSS = CSS;
        this.GIADIEN = GIADIEN;
    }

    public Modeldienke() {
        this.MACH = "";
        this.CST = 0;
        this.CSS = 0;
        this.GIADIEN = 0;
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

    public double getGIADIEN() {
        return GIADIEN;
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

    public void setGIADIEN(double GIADIEN) {
        this.GIADIEN = GIADIEN;
    }

    @Override
    public String toString() {
        return "Modeldienke{" + "MACH=" + MACH + ", CST=" + CST + ", CSS=" + CSS + ", GIADIEN=" + GIADIEN + '}';
    }
    
    
    
    
}
