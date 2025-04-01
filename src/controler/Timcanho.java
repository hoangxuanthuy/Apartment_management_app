/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import DAO.Daocanho;
import MODEL.Modelcanho;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timcanho {
     public static Timcanho getInstance() {
        return new Timcanho();
    }


public ArrayList<Modelcanho> searchMACH(String text) {
        ArrayList<Modelcanho> result = new ArrayList<>();
        ArrayList<Modelcanho> arms = Daocanho.getInstance().selectAll();
        for (var ch : arms) {
            if (ch.getMACH().toLowerCase().contains(text.toLowerCase())) {
                result.add(ch);
            }
        }
        return result;
    }

 public ArrayList<Modelcanho> searchLoaiCH(String text) {
        ArrayList<Modelcanho> result = new ArrayList<>();
        ArrayList<Modelcanho> arms = Daocanho.getInstance().selectAll();
        for (var ch : arms) {
            if (ch.getLoaiCH().toLowerCase().contains(text.toLowerCase())) {
                result.add(ch);
            }
        }
        return result;
    }

    
}