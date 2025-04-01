/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.ArrayList;
import java.util.List;

public class ModelChart {
    private String MACH;
  
    private double trigia;

    public ModelChart(String MACH, double trigia) {
        this.MACH= MACH;
        
        this.trigia = trigia;
    }

    public String getMACH() {
        return MACH;
    }


    public double getTrigia() {
        return trigia;
    }

    public void setMACH(String MACH) {
        this.MACH = MACH;
    }

    public void setTrigia(double trigia) {
        this.trigia = trigia;
    }

   
}
