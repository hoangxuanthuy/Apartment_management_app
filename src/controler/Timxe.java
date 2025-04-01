/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import DAO.Daoxe;
import MODEL.Modelxe;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timxe {
    public static Timxe getInstance() {
        return new Timxe();
    }


public ArrayList<Modelxe> searchMAXE(String text) {
        ArrayList<Modelxe> result = new ArrayList<>();
        ArrayList<Modelxe> arms = Daoxe.getInstance().selectAll();
        for (var xe : arms) {
            if (xe.getMaXe().toLowerCase().contains(text.toLowerCase())) {
                result.add(xe);
            }
        }
        return result;
    }

 public ArrayList<Modelxe> searchBSX(String text) {
        ArrayList<Modelxe> result = new ArrayList<>();
        ArrayList<Modelxe> arms = Daoxe.getInstance().selectAll();
        for (var xe : arms) {
            if (xe.getBienSoXe().toLowerCase().contains(text.toLowerCase())) {
                result.add(xe);
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
