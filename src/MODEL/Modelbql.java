/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author hoangxuanthuy
 */
public class Modelbql {
   private String MABQL;
   private String TENBQL;
   private int toa;

    public Modelbql(String MABQL, String TENBQL, int toa) {
        this.MABQL = MABQL;
        this.TENBQL = TENBQL;
        this.toa = toa;
    }

    public String getMABQL() {
        return MABQL;
    }

    public String getTENBQL() {
        return TENBQL;
    }

    public int getToa() {
        return toa;
    }

    public void setMABQL(String MABQL) {
        this.MABQL = MABQL;
    }

    public void setTENBQL(String TENBQL) {
        this.TENBQL = TENBQL;
    }

    public void setToa(int toa) {
        this.toa = toa;
    }

    @Override
    public String toString() {
        return "banquanly{" + "MABQL=" + MABQL + ", TENBQL=" + TENBQL + ", toa=" + toa + '}';
    }


}
