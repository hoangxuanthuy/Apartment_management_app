/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author hoangxuanthuy
 */
public class Modeltaikhoan {
    private String username; // VARCHAR2(10)
    private String password; // VARCHAR2(6)
    private String role; // VARCHAR2(10)
    private String email;

    public Modeltaikhoan(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }
  
    
    public Modeltaikhoan() {
        this.username = "";
        this.password = "";
        this.role = "";
        this.email = "";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Modeltaikhoan{" + "username=" + username + ", password=" + password + ", role=" + role + ", email=" + email + '}';
    }

    
    
}
