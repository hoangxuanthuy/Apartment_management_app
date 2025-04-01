/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import DAO.Daocudan;
import MODEL.Modelcudan;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timcudan {
    public static Timcanho getInstance() {
        return new Timcanho();
    }


public ArrayList<Modelcudan> searchMACD(String text) {
        ArrayList<Modelcudan> result = new ArrayList<>();
        ArrayList<Modelcudan> arms = Daocudan.getInstance().selectAll();
        for (var cd : arms) {
            if (cd.getMACD().toLowerCase().contains(text.toLowerCase())) {
                result.add(cd);
            }
        }
        return result;
    }

 public ArrayList<Modelcudan> searchHoTen(String text) {
        ArrayList<Modelcudan> result = new ArrayList<>();
        ArrayList<Modelcudan> arms = Daocudan.getInstance().selectAll();
        for (var cd : arms) {
            if (cd.getHoten().toLowerCase().contains(text.toLowerCase())) {
                result.add(cd);
            }
        }
        return result;
    }

    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author Thinkbook 16
 */
