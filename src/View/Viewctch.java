/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.Daocanho;
import MODEL.Modelcanho;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thinkbook 16
 */
public class Viewctch extends javax.swing.JFrame {
String ma = "" ; 
    String manv ="" ;
    public Viewctch() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public static String formatNumber(double number) {
        // Định dạng số sao cho không có các số 0 ở đầu nhưng tối đa 10 chữ số
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(0); // Không có phần thập phân
        decimalFormat.setMaximumIntegerDigits(10); // Tối đa 10 chữ số

        return decimalFormat.format(number);
    }
    
    public Viewctch(String ma) {
        initComponents();
        setLocationRelativeTo(null);
        this.ma = ma;
        Daocanho dch = new Daocanho();
        Modelcanho ch = new Modelcanho();
    try {
        ch = dch.getXEMCTCHByMACH(ma);
    } catch (SQLException ex) {
        Logger.getLogger(Viewctch.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        txtMach.setText(ch.getMACH().trim());
        txtDientich.setText(formatNumber(ch.getDienTich()) + " ");
        txtLoaich.setText(ch.getLoaiCH().trim());
        txtSpn.setText(formatNumber(ch.getSoPhongNgu()) + " ");
        txtSpt.setText(formatNumber(ch.getSoPhongTam()) + " ");
        txtTang.setText(formatNumber(ch.getTang()) + " ");
        txtGiathue.setText(formatNumber(ch.getGiaThue()) + " ");
        txtPhidv.setText(formatNumber(ch.getPHIDV()) + " ");
        txtGiaxe.setText(formatNumber(ch.getGIAXE()) + " ");
        txtSlxe.setText(ch.getSLXE() + " ");
        txtMacd.setText(ch.getMACD().trim());
        txtManv.setText(ch.getMANV().trim());
        txtMahd.setText(ch.getMAHOPDONG().trim());
    }

    
     public Viewctch(String ma , String manv) {
        initComponents();
        setLocationRelativeTo(null);
        this.ma = ma;
        this.manv = manv;
         Daocanho dch = new Daocanho();
        Modelcanho ch = new Modelcanho();
    try {
        ch = dch.getXEMCTCHByMACH(ma);
    } catch (SQLException ex) {
        Logger.getLogger(Viewctch.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        txtMach.setText(ch.getMACH().trim());
        txtDientich.setText(formatNumber(ch.getDienTich()) + " ");
        txtLoaich.setText(ch.getLoaiCH().trim());
        txtSpn.setText(formatNumber(ch.getSoPhongNgu()) + " ");
        txtSpt.setText(formatNumber(ch.getSoPhongTam()) + " ");
        txtTang.setText(formatNumber(ch.getTang()) + " ");
        txtGiathue.setText(formatNumber(ch.getGiaThue()) + " ");
        txtPhidv.setText(formatNumber(ch.getPHIDV()) + " ");
        txtGiaxe.setText(formatNumber(ch.getGIAXE()) + " ");
        txtSlxe.setText(ch.getSLXE() + " ");
        txtMacd.setText(ch.getMACD().trim());
        txtManv.setText(ch.getMANV().trim());
        txtMahd.setText(ch.getMAHOPDONG().trim());
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMach = new javax.swing.JLabel();
        jLabelDtich = new javax.swing.JLabel();
        jLabelLoaich = new javax.swing.JLabel();
        jLabelSpn = new javax.swing.JLabel();
        jLabelSpt = new javax.swing.JLabel();
        jLabelGiathue = new javax.swing.JLabel();
        jLabelTang = new javax.swing.JLabel();
        txtMach = new javax.swing.JTextField();
        txtDientich = new javax.swing.JTextField();
        txtLoaich = new javax.swing.JTextField();
        txtSpt = new javax.swing.JTextField();
        txtTang = new javax.swing.JTextField();
        txtGiathue = new javax.swing.JTextField();
        btnQuaylai = new javax.swing.JButton();
        txtSpn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelPhidv = new javax.swing.JLabel();
        jLabelGiaxe = new javax.swing.JLabel();
        jLabelSlxe = new javax.swing.JLabel();
        jLabelMacd = new javax.swing.JLabel();
        jLabelManv = new javax.swing.JLabel();
        jLabelMahd = new javax.swing.JLabel();
        txtPhidv = new javax.swing.JTextField();
        txtGiaxe = new javax.swing.JTextField();
        txtSlxe = new javax.swing.JTextField();
        txtMacd = new javax.swing.JTextField();
        txtManv = new javax.swing.JTextField();
        txtMahd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelMach.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMach.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMach.setText("Mã Căn Hộ");

        jLabelDtich.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelDtich.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDtich.setText("Diện Tích");

        jLabelLoaich.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelLoaich.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoaich.setText("Loại Căn Hộ");

        jLabelSpn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelSpn.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSpn.setText("Số Phòng Ngủ");

        jLabelSpt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelSpt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSpt.setText("Số Phòng Tắm");

        jLabelGiathue.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelGiathue.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGiathue.setText("Giá Thuê");

        jLabelTang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTang.setText("Tầng");

        txtMach.setEditable(false);
        txtMach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMachActionPerformed(evt);
            }
        });

        txtDientich.setEditable(false);
        txtDientich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDientichActionPerformed(evt);
            }
        });

        txtLoaich.setEditable(false);

        txtSpt.setEditable(false);

        txtTang.setEditable(false);

        txtGiathue.setEditable(false);

        btnQuaylai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-left-50.png"))); // NOI18N
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        txtSpn.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-40.png"))); // NOI18N
        jLabel1.setText("Chi tiết căn hộ");

        jLabelPhidv.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPhidv.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPhidv.setText("Phí Dịch Vụ");

        jLabelGiaxe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelGiaxe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGiaxe.setText("Giá Xe");

        jLabelSlxe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelSlxe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSlxe.setText("Số Lượng Xe");

        jLabelMacd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMacd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMacd.setText("Mã Cư Dân");

        jLabelManv.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelManv.setForeground(new java.awt.Color(255, 255, 255));
        jLabelManv.setText("Mã Nhân Viên");

        jLabelMahd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMahd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMahd.setText("Mã Hợp Đồng");

        txtPhidv.setEditable(false);

        txtGiaxe.setEditable(false);

        txtSlxe.setEditable(false);

        txtMacd.setEditable(false);

        txtManv.setEditable(false);

        txtMahd.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSpn, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jLabelSpt, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jLabelGiathue)
                            .addComponent(jLabelTang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDtich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLoaich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPhidv)
                            .addComponent(jLabelGiaxe)
                            .addComponent(jLabelSlxe)
                            .addComponent(jLabelMacd)
                            .addComponent(jLabelManv)
                            .addComponent(jLabelMahd))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLoaich, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtMach, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtDientich, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtSpt, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtTang, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtGiathue, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtSpn)
                            .addComponent(txtPhidv, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtGiaxe, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtSlxe, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtMacd, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtManv, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtMahd, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnQuaylai)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuaylai)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMach)
                    .addComponent(txtMach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDtich)
                    .addComponent(txtDientich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLoaich)
                    .addComponent(txtLoaich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpn)
                    .addComponent(txtSpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpt)
                    .addComponent(txtSpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTang)
                    .addComponent(txtTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGiathue)
                    .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhidv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPhidv))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGiaxe))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSlxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSlxe))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMacd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMacd))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelManv))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMahd))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMachActionPerformed

    private void txtDientichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDientichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDientichActionPerformed

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        if(ma.equals("")) {
            Viewcanho viewch = new Viewcanho();
            viewch.show();
            dispose();
        } else {
            Viewcanho viewch=new Viewcanho(manv);
            viewch.show();
            dispose();
        }
    }//GEN-LAST:event_btnQuaylaiActionPerformed

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
            java.util.logging.Logger.getLogger(Viewctch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewctch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewctch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewctch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewctch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDtich;
    private javax.swing.JLabel jLabelGiathue;
    private javax.swing.JLabel jLabelGiaxe;
    private javax.swing.JLabel jLabelLoaich;
    private javax.swing.JLabel jLabelMacd;
    private javax.swing.JLabel jLabelMach;
    private javax.swing.JLabel jLabelMahd;
    private javax.swing.JLabel jLabelManv;
    private javax.swing.JLabel jLabelPhidv;
    private javax.swing.JLabel jLabelSlxe;
    private javax.swing.JLabel jLabelSpn;
    private javax.swing.JLabel jLabelSpt;
    private javax.swing.JLabel jLabelTang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDientich;
    private javax.swing.JTextField txtGiathue;
    private javax.swing.JTextField txtGiaxe;
    private javax.swing.JTextField txtLoaich;
    private javax.swing.JTextField txtMacd;
    private javax.swing.JTextField txtMach;
    private javax.swing.JTextField txtMahd;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtPhidv;
    private javax.swing.JTextField txtSlxe;
    private javax.swing.JTextField txtSpn;
    private javax.swing.JTextField txtSpt;
    private javax.swing.JTextField txtTang;
    // End of variables declaration//GEN-END:variables
}
