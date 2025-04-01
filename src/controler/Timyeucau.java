/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;


import DAO.Daoyeucaucd;
import MODEL.Modelcudan;
import MODEL.Modelyeucaucd;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Timyeucau {
     public static Timyeucau getInstance() {
        return new Timyeucau();
}
     public ArrayList<Modelyeucaucd> searchMAYC(String text) {
        ArrayList<Modelyeucaucd> result = new ArrayList<>();
        ArrayList<Modelyeucaucd> arms = Daoyeucaucd.getInstance().selectAll();
        for (var yc : arms) {
            if (yc.getMAYC().toLowerCase().contains(text.toLowerCase())) {
                result.add(yc);
            }
        }
        return result;
    }

 public ArrayList<Modelyeucaucd> searchMACD(String text) {
        ArrayList<Modelyeucaucd> result = new ArrayList<>();
        ArrayList<Modelyeucaucd> arms = Daoyeucaucd.getInstance().selectAll();
        for (var yc : arms) {
            if (yc.getMACD().toLowerCase().contains(text.toLowerCase())) {
                result.add(yc);
            }
        }
        return result;
    }
}
