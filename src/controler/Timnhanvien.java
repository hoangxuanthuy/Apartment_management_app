/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import DAO.Daonhanvien;
import MODEL.Modelnhanvien;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timnhanvien {
     public static Timnhanvien getInstance() {
        return new Timnhanvien();
    }


public ArrayList<Modelnhanvien> searchMANV(String text) {
        ArrayList<Modelnhanvien> result = new ArrayList<>();
        ArrayList<Modelnhanvien> arms = Daonhanvien.getInstance().selectAll();
        for (var nv : arms) {
            if (nv.getMANV().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

 public ArrayList<Modelnhanvien> searchHOTEN(String text) {
        ArrayList<Modelnhanvien> result = new ArrayList<>();
        ArrayList<Modelnhanvien> arms = Daonhanvien.getInstance().selectAll();
        for (var nv : arms) {
            if (nv.getHOTEN().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
}
}
    
    
