/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import MODEL.Modelnhanvien;
import MODEL.Modeltaikhoan;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Thinkbook 16
 */
public class ViewMenunhanvien extends javax.swing.JFrame {

     Modelnhanvien nv = new Modelnhanvien();
    
    public ViewMenunhanvien() {
        initComponents();
        this.setLocationRelativeTo(null);
        addHoverEffect(jbutoncanho);
        addHoverEffect(jButtoncudan);
        addHoverEffect(jButtonhoadon);
        addHoverEffectdx(jButton9);
        
    }

    ViewMenunhanvien(String MANV) {
        initComponents();
        this.setLocationRelativeTo(null);
        nv.setMANV(MANV);
        
    }

    private void addHoverEffectdx(JButton jbutoncanho ) {
        // Customize JButton
        
        jbutoncanho.setBackground(new Color(55, 139, 167));
        jbutoncanho.setForeground(Color.WHITE);
        jbutoncanho.setFocusPainted(false);
        // jbutoncanho.setBorder(new RoundedBorder(20));
        jbutoncanho.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        jbutoncanho.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jbutoncanho.setBackground(new Color(67, 100, 200));
            }

            public void mouseExited(MouseEvent evt) {
                jbutoncanho.setBackground(new Color(55, 139, 167));
            }
        });
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMenu = new javax.swing.JPanel();
        jbutoncanho = new javax.swing.JButton();
        jButtoncudan = new javax.swing.JButton();
        jButtonhoadon = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(196, 233, 245));

        jpnMenu.setBackground(new java.awt.Color(55, 139, 167));

        jbutoncanho.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbutoncanho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-room-30.png"))); // NOI18N
        jbutoncanho.setText("CĂN HỘ");
        jbutoncanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutoncanhoActionPerformed(evt);
            }
        });

        jButtoncudan.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtoncudan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-people-30.png"))); // NOI18N
        jButtoncudan.setText("CƯ DÂN");
        jButtoncudan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncudanActionPerformed(evt);
            }
        });

        jButtonhoadon.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-40.png"))); // NOI18N
        jButtonhoadon.setText("HÓA ĐƠN");
        jButtonhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhoadonActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(153, 204, 255));
        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-login-rounded-30.png"))); // NOI18N
        jButton9.setText("Đăng xuất");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Dowload\\2.jpg")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-nhanvienmale-80.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-waving-hand-emoji-25.png"))); // NOI18N
        jLabel3.setText("Xin chào, nhân viên");

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnMenuLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnMenuLayout.createSequentialGroup()
                                .addComponent(jButtoncudan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbutoncanho, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                                        .addComponent(jButton9)
                                        .addGap(61, 61, 61))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(48, 48, 48)))))))
                .addComponent(jLabel2)
                .addGap(0, 0, 0))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jbutoncanho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtoncudan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutoncanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutoncanhoActionPerformed
        Viewcanho nvien = new Viewcanho(nv.getMANV());
        nvien.show();
        dispose();    
    }//GEN-LAST:event_jbutoncanhoActionPerformed

    private void jButtoncudanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncudanActionPerformed
        Viewcudan viewcd = new Viewcudan(nv.getMANV());
        viewcd.show();
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButtoncudanActionPerformed

    private void jButtonhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhoadonActionPerformed
        Viewhoadon viewhd = new Viewhoadon(nv.getMANV()) ;
        viewhd.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonhoadonActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Viewdangnhap viewdn = new Viewdangnhap();
        viewdn.show();
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed
    
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
            java.util.logging.Logger.getLogger(ViewMenunhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenunhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenunhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenunhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenunhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtoncudan;
    private javax.swing.JButton jButtonhoadon;
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
