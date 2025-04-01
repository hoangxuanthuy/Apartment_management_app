/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import MODEL.Modeltaikhoan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Thinkbook 16
 */
public class ViewMenubql extends javax.swing.JFrame {

   
    public ViewMenubql() {
        initComponents();
        this.setLocationRelativeTo(null);
         addHoverEffect(jButtoncudan);
         addHoverEffect(jbutoncanho);
         addHoverEffect(jButtonhopdong);
         addHoverEffect(jButtonxe);
         addHoverEffect(jButtonhoadon);
         addHoverEffect(jButtonnhanvien);
         addHoverEffect(jButtontaikhoan);
         addHoverEffect(jButtondangxuat);
         addHoverEffect(jButtonyeucau);
         addHoverEffect(jButtonthongke);
    }

    ViewMenubql(Modeltaikhoan acc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    private void addHoverEffect(JButton jbutoncanho ) {
        // Customize JButton
        
        jbutoncanho.setBackground(new Color(255, 255, 255));
        jbutoncanho.setForeground(Color.BLACK);
        jbutoncanho.setFocusPainted(false);
        // jbutoncanho.setBorder(new RoundedBorder(20));
        jbutoncanho.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        jbutoncanho.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jbutoncanho.setBackground(new Color(67, 100, 200));
            }

            public void mouseExited(MouseEvent evt) {
                jbutoncanho.setBackground(new Color(255, 255, 255));
            }
        });
    }
    private void addHoverEffectdx(JButton jbutoncanho ) {
        // Customize JButton
        
        jbutoncanho.setBackground(new Color(255, 255, 255));
        jbutoncanho.setForeground(Color.BLACK);
        jbutoncanho.setFocusPainted(false);
        // jbutoncanho.setBorder(new RoundedBorder(20));
        jbutoncanho.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        jbutoncanho.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jbutoncanho.setBackground(new Color(67, 100, 200));
            }

            public void mouseExited(MouseEvent evt) {
                jbutoncanho.setBackground(new Color(255, 255, 255));
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMenu = new javax.swing.JPanel();
        jbutoncanho = new javax.swing.JButton();
        jButtoncudan = new javax.swing.JButton();
        jButtonhopdong = new javax.swing.JButton();
        jButtonhoadon = new javax.swing.JButton();
        jButtonyeucau = new javax.swing.JButton();
        jButtonxe = new javax.swing.JButton();
        jButtonnhanvien = new javax.swing.JButton();
        jButtontaikhoan = new javax.swing.JButton();
        jButtonthongke = new javax.swing.JButton();
        jButtondangxuat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenu.setBackground(new java.awt.Color(55, 139, 167));

        jbutoncanho.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbutoncanho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-room-30.png"))); // NOI18N
        jbutoncanho.setText("CĂN HỘ");
        jbutoncanho.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbutoncanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutoncanhoActionPerformed(evt);
            }
        });

        jButtoncudan.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtoncudan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-people-30.png"))); // NOI18N
        jButtoncudan.setText("CƯ DÂN");
        jButtoncudan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtoncudan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncudanActionPerformed(evt);
            }
        });

        jButtonhopdong.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonhopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-contract-30.png"))); // NOI18N
        jButtonhopdong.setText("HỢP ĐỒNG");
        jButtonhopdong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhopdongActionPerformed(evt);
            }
        });

        jButtonhoadon.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-40.png"))); // NOI18N
        jButtonhoadon.setText("HÓA ĐƠN");
        jButtonhoadon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhoadonActionPerformed(evt);
            }
        });

        jButtonyeucau.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonyeucau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ticket-30.png"))); // NOI18N
        jButtonyeucau.setText("YÊU CẦU CƯ DÂN");
        jButtonyeucau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonyeucau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonyeucauActionPerformed(evt);
            }
        });

        jButtonxe.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonxe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-vehicle-30.png"))); // NOI18N
        jButtonxe.setText("XE");
        jButtonxe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonxeActionPerformed(evt);
            }
        });

        jButtonnhanvien.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonnhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-qlnhanvien-account-30.png"))); // NOI18N
        jButtonnhanvien.setText("NHÂN VIÊN");
        jButtonnhanvien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonnhanvienActionPerformed(evt);
            }
        });

        jButtontaikhoan.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtontaikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-taikhoan-30.png"))); // NOI18N
        jButtontaikhoan.setText("TÀI KHOẢN");
        jButtontaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtontaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontaikhoanActionPerformed(evt);
            }
        });

        jButtonthongke.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chart-30.png"))); // NOI18N
        jButtonthongke.setText("THỐNG KÊ");
        jButtonthongke.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonthongkeActionPerformed(evt);
            }
        });

        jButtondangxuat.setBackground(new java.awt.Color(153, 204, 255));
        jButtondangxuat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtondangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-login-rounded-30.png"))); // NOI18N
        jButtondangxuat.setText("Đăng xuất");
        jButtondangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondangxuatActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Dowload\\2.jpg")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-administrator-male-94.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-waving-hand-emoji-25.png"))); // NOI18N
        jLabel1.setText("Xin chào, người quản lý");
        jLabel1.setAutoscrolls(true);
        jLabel1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonthongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtontaikhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonyeucau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(jButtonnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbutoncanho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jButtoncudan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnMenuLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(jLabel3))
                        .addGroup(jpnMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonhoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonxe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtondangxuat))
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jbutoncanho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtoncudan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonxe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonyeucau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtontaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtondangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoncudanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncudanActionPerformed
        Viewcudan viewcd=new Viewcudan();
            viewcd.show();
            dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_jButtoncudanActionPerformed

    private void jbutoncanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutoncanhoActionPerformed
            Viewcanho viewch=new Viewcanho();
            viewch.show();
            dispose(); 
    }//GEN-LAST:event_jbutoncanhoActionPerformed

    private void jButtonhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhopdongActionPerformed
         Viewhopdong viewhd=new Viewhopdong();
            viewhd.show();
            dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonhopdongActionPerformed

    private void jButtonxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonxeActionPerformed
       Viewxe xe=new Viewxe();
            xe.show();
            dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonxeActionPerformed

    private void jButtonhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhoadonActionPerformed
        Viewhoadon viewhdon=new Viewhoadon();
            viewhdon.show();
            dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonhoadonActionPerformed

    private void jButtonnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonnhanvienActionPerformed
       Viewnhanvien viewnv=new Viewnhanvien();
            viewnv.show();
            dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonnhanvienActionPerformed

    private void jButtontaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontaikhoanActionPerformed
        Viewtaikhoan viewtk=new Viewtaikhoan();
            viewtk.show();
            dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButtontaikhoanActionPerformed

    private void jButtondangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondangxuatActionPerformed
       Viewdangnhap dangnhap=new Viewdangnhap();
            dangnhap.show();
            dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButtondangxuatActionPerformed

    private void jButtonyeucauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonyeucauActionPerformed
        ViewYeucau view=new ViewYeucau();
        view.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonyeucauActionPerformed

    private void jButtonthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonthongkeActionPerformed
        ViewChart view=new ViewChart("Thống kê Trị giá Hóa đơn theo Mã căn hộ");
        view.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonthongkeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenubql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenubql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenubql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenubql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenubql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncudan;
    private javax.swing.JButton jButtondangxuat;
    private javax.swing.JButton jButtonhoadon;
    private javax.swing.JButton jButtonhopdong;
    private javax.swing.JButton jButtonnhanvien;
    private javax.swing.JButton jButtontaikhoan;
    private javax.swing.JButton jButtonthongke;
    private javax.swing.JButton jButtonxe;
    private javax.swing.JButton jButtonyeucau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbutoncanho;
    private javax.swing.JPanel jpnMenu;
    // End of variables declaration//GEN-END:variables

    void setCurrentAcc(Modeltaikhoan acc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
