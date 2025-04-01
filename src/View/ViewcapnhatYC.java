

package View;

import DAO.Daoyeucaucd;
import MODEL.Modelyeucaucd;
import View.ViewYeucau;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewcapnhatYC extends javax.swing.JFrame {
        private ViewYeucau owner;
    public ViewcapnhatYC() {
        super();
        initComponents();
        setLocationRelativeTo(null);
    }
   
   
   public ViewcapnhatYC(ViewYeucau parent) {
        super();  // gọi constructor của JFrame
        initComponents();
        setLocationRelativeTo(null);
        this.owner = parent;
        Modelyeucaucd yc = this.owner.getDetail();
        
        txtMayc.setText(yc.getMAYC().trim());
        txtLoai.setText(yc.getLoaiYC().trim());
       
        txtNoidung.setText(yc.getNoiDungYC() + " ");
        CBTrangthai.setSelectedItem(yc.getTrangThaiYC().trim());
        txtMacd.setText(yc.getMACD().trim());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMayc = new javax.swing.JLabel();
        jLabelLoaiyc = new javax.swing.JLabel();
        jLabelTrangthai = new javax.swing.JLabel();
        jLabelNoidung = new javax.swing.JLabel();
        CBTrangthai = new javax.swing.JComboBox<>();
        txtMayc = new javax.swing.JTextField();
        jLabelMacd = new javax.swing.JLabel();
        txtMacd = new javax.swing.JTextField();
        btncapnhat = new javax.swing.JButton();
        btnQuaylai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoidung = new javax.swing.JTextArea();
        txtLoai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));

        jLabelMayc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMayc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMayc.setText("Mã Yêu Cầu");

        jLabelLoaiyc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelLoaiyc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoaiyc.setText("Loại Yêu Cầu");

        jLabelTrangthai.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTrangthai.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTrangthai.setText("Trạng Thái YC");

        jLabelNoidung.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNoidung.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNoidung.setText("Nội Dung Yêu Cầu");

        CBTrangthai.setEditable(true);
        CBTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chua xu ly", "Da xu ly" }));
        CBTrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTrangthaiActionPerformed(evt);
            }
        });

        txtMayc.setEditable(false);
        txtMayc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaycActionPerformed(evt);
            }
        });

        jLabelMacd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMacd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMacd.setText("Mã Cư Dân");

        txtMacd.setEditable(false);
        txtMacd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMacdActionPerformed(evt);
            }
        });

        btncapnhat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btncapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-item (2).png"))); // NOI18N
        btncapnhat.setText("Cập nhật");
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        btnQuaylai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-left-50.png"))); // NOI18N
        btnQuaylai.setBorder(null);
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        txtNoidung.setEditable(false);
        txtNoidung.setColumns(20);
        txtNoidung.setRows(5);
        jScrollPane1.setViewportView(txtNoidung);

        txtLoai.setEditable(false);
        txtLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncapnhat)
                .addGap(167, 167, 167))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelMayc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelMacd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelLoaiyc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNoidung, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBTrangthai, 0, 188, Short.MAX_VALUE)
                            .addComponent(txtMacd, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtMayc)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtLoai)))
                    .addComponent(btnQuaylai))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMayc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMayc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLoaiyc, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtLoai))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CBTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMacd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMacd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btncapnhat)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaycActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaycActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaycActionPerformed

    private void CBTrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTrangthaiActionPerformed

    private void txtMacdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMacdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMacdActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
         Daoyeucaucd yc = new Daoyeucaucd();
        Modelyeucaucd s = new Modelyeucaucd();
         s.setMAYC(txtMayc.getText());
         s.setLoaiYC(txtLoai.getText());
        s.setNoiDungYC(txtNoidung.getText());
        String selectedValue = (String) CBTrangthai.getSelectedItem();
       if ("Da xu ly".equals(selectedValue)) {
            s.setTrangThaiYC("Đã xử lý");
        } else {
            s.setTrangThaiYC("Chưa xử lý");
       }
        s.setMACD(txtMacd.getText());
        try {
            yc.update(s);
        } catch (SQLException ex) {
            Logger.getLogger(ViewcapnhatYC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewcapnhatYC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new ViewYeucau().setVisible(true);
        this.dispose();
                                                

    }//GEN-LAST:event_btncapnhatActionPerformed

    private void txtLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiActionPerformed

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        ViewYeucau viewyc=new ViewYeucau();
        viewyc.show();
        dispose();
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
            java.util.logging.Logger.getLogger(ViewcapnhatYC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewcapnhatYC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewcapnhatYC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewcapnhatYC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewcapnhatYC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTrangthai;
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JButton btncapnhat;
    private javax.swing.JLabel jLabelLoaiyc;
    private javax.swing.JLabel jLabelMacd;
    private javax.swing.JLabel jLabelMayc;
    private javax.swing.JLabel jLabelNoidung;
    private javax.swing.JLabel jLabelTrangthai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtMacd;
    private javax.swing.JTextField txtMayc;
    private javax.swing.JTextArea txtNoidung;
    // End of variables declaration//GEN-END:variables
}
