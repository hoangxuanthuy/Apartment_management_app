/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.security.SecureRandom;

/**
 *
 * @author Thinkbook 16
 */
public class Daorandom {
    static final String az = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
    static SecureRandom rd = new SecureRandom();
    
    public String SoNgauNhienString(int n) {
        StringBuilder str = new StringBuilder(n);
        for (int i=0;i < n; i++) {
            str.append(az.charAt(rd.nextInt(az.length())));
        }
        return str.toString();
    }
}
