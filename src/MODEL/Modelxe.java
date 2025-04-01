/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author hoangxuanthuy
 */
public class Modelxe {
    private String maXe;
    private String bienSoXe;
    private String loaiXe;
    private String maCD;

    public Modelxe(String maXe, String bienSoXe, String loaiXe, String maCD) {
        this.maXe = maXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.maCD = maCD;
    }
    public Modelxe () {
        this.maXe ="";
        this.bienSoXe = "";
        this.loaiXe = "";
        this.maCD = "";
        
    }
    public String getMaXe() {
        return maXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    @Override
    public String toString() {
        return "Xe{" + "maXe=" + maXe + ", bienSoXe=" + bienSoXe + ", loaiXe=" + loaiXe + ", maCD=" + maCD + '}';
    }
    
}

