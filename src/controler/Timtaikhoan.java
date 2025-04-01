/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import DAO.Daotaikhoan;
import MODEL.Modeltaikhoan;
import java.util.ArrayList;

/**
 *
 * @author Thinkbook 16
 */
public class Timtaikhoan {
    public static Timtaikhoan getInstance() {
        return new Timtaikhoan();
    }


public ArrayList<Modeltaikhoan> searchUsername(String text) {
        ArrayList<Modeltaikhoan> result = new ArrayList<>();
        ArrayList<Modeltaikhoan> arms = Daotaikhoan.getInstance().selectAll();
        for (var tk : arms) {
            if (tk.getUsername().toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }

 public ArrayList<Modeltaikhoan> searchRole(String text) {
        ArrayList<Modeltaikhoan> result = new ArrayList<>();
        ArrayList<Modeltaikhoan> arms = Daotaikhoan.getInstance().selectAll();
        for (var tk : arms) {
            if (tk.getRole().toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
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
