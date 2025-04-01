/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import DAO.Daohopdong;
import MODEL.Modelhopdong;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timhopdong {
     public static Timhopdong getInstance() {
        return new Timhopdong();
    }


public ArrayList<Modelhopdong> searchMAHOPDONG(String text) {
        ArrayList<Modelhopdong> result = new ArrayList<>();
        ArrayList<Modelhopdong> arms = Daohopdong.getInstance().selectAll();
        for (var hd : arms) {
            if (hd.getMAHOPDONG().toLowerCase().contains(text.toLowerCase())) {
                result.add(hd);
            }
        }
        return result;
    }

 public ArrayList<Modelhopdong> searchLOAIHD(String text) {
        ArrayList<Modelhopdong> result = new ArrayList<>();
        ArrayList<Modelhopdong> arms = Daohopdong.getInstance().selectAll();
        for (var hd : arms) {
            if (hd.getLOAIHD().toLowerCase().contains(text.toLowerCase())) {
                result.add(hd);
            }
        }
        return result;
}
}
