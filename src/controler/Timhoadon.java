/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import DAO.Daohoadon;
import MODEL.Modelhoadon;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timhoadon {
     public static Timhoadon getInstance() {
        return new Timhoadon();
    }


public ArrayList<Modelhoadon> searchMAHD(String text) {
        ArrayList<Modelhoadon> result = new ArrayList<>();
        ArrayList<Modelhoadon> arms = Daohoadon.getInstance().selectAll();
        for (var hdon : arms) {
            if (hdon.getMAHD().toLowerCase().contains(text.toLowerCase())) {
                result.add(hdon);
            }
        }
        return result;
    }

 
}
