/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import DAO.Daonhanvien;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableColumn;
import MODEL.Modelnhanvien;
import controler.Timnhanvien;

/**
 *
 * @author Thinkbook 16
 */
public class Viewnhanvien extends javax.swing.JFrame {

     private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
    public Viewnhanvien() {
        initComponents();
         jTableNhanvien.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
       loadDataToTable();
        }
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã Nhân Viên", "Họ Tên", "Số Điện Thoại", "Email", "Mã Ban Quản Lý"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableNhanvien.setModel(tblModel);
        jTableNhanvien.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableNhanvien.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableNhanvien.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableNhanvien.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableNhanvien.getColumnModel().getColumn(4).setPreferredWidth(30);
        
 
    }
      public void changeTextFind() {
        txttracuunv.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (txttracuunv.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /* do nothing */

            }
        });
    }
    public ArrayList<Modelnhanvien> searchFn(String luaChon, String content) {
        ArrayList<MODEL.Modelnhanvien> result = new ArrayList<>();
        Timnhanvien timnv = new Timnhanvien();
        switch (luaChon) {
            case "MANV":
                result = timnv.searchMANV(content);
                break;
            case "HOTEN":
                result = timnv.searchHOTEN(content);
                break;
            
        }
        return result;
    }
    public MODEL.Modelnhanvien getDetail() {
        MODEL.Modelnhanvien a = Daonhanvien.getInstance().selectById(getNHANVIENSelect().getMANV());
        return a;
    }
    public MODEL.Modelnhanvien getNHANVIENSelect() {
        int i_row = jTableNhanvien.getSelectedRow();
        MODEL.Modelnhanvien nv = Daonhanvien.getInstance().selectAll().get(i_row);
        return nv;
    }
     public void loadDataToTable() {
    try {
        Daonhanvien nvdao = new Daonhanvien();
        ArrayList<MODEL.Modelnhanvien> arms = nvdao.selectAll();
        tblModel.setRowCount(0);
        for (MODEL.Modelnhanvien i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMANV(), i.getHOTEN(),i.getSDT(),i.getEmail(),i.getMABQL()              
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     public void loadDataToTableSearch(ArrayList<MODEL.Modelnhanvien> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modelnhanvien i : result) {
                tblModel.addRow(new Object[]{
                     i.getMANV(), i.getHOTEN(),i.getSDT(),i.getEmail(),i.getMABQL()    
                }
                );
            }
        } catch (Exception e) {  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnthemnv = new javax.swing.JButton();
        btnxoanv = new javax.swing.JButton();
        btnsuanv = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNhanvien = new javax.swing.JTable();
        labQLNV = new javax.swing.JLabel();
        txttracuunv = new javax.swing.JTextField();
        jButtontrangchu = new javax.swing.JButton();
        jComboluachon = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(196, 233, 245));

        btnthemnv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnthemnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-male-user-30.png"))); // NOI18N
        btnthemnv.setText("Thêm");
        btnthemnv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthemnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemnvActionPerformed(evt);
            }
        });

        btnxoanv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnxoanv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btnxoanv.setText("Xóa");
        btnxoanv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxoanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoanvActionPerformed(evt);
            }
        });

        btnsuanv.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsuanv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-item (2).png"))); // NOI18N
        btnsuanv.setText("Sửa");
        btnsuanv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsuanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanvActionPerformed(evt);
            }
        });

        btntracuu.setBackground(new java.awt.Color(55, 139, 167));
        btntracuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-36.png"))); // NOI18N
        btntracuu.setBorder(null);
        btntracuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntracuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntracuuMouseClicked(evt);
            }
        });
        btntracuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntracuuActionPerformed(evt);
            }
        });

        jTableNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên", "Số Điện Thoại", "Email", "Mã Ban Quản Lý"
            }
        ));
        jTableNhanvien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNhanvienMouseClicked(evt);
            }
        });
        jTableNhanvien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableNhanvienKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNhanvien);

        labQLNV.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labQLNV.setForeground(new java.awt.Color(255, 255, 255));
        labQLNV.setText("QUẢN LÝ NHÂN VIÊN");
        labQLNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txttracuunv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttracuunv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuunvActionPerformed(evt);
            }
        });

        jButtontrangchu.setBackground(new java.awt.Color(55, 139, 167));
        jButtontrangchu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtontrangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-48.png"))); // NOI18N
        jButtontrangchu.setBorder(null);
        jButtontrangchu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtontrangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontrangchuActionPerformed(evt);
            }
        });

        jComboluachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MANV", "HOTEN", " ", " ", " " }));
        jComboluachon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboluachon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboluachonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttracuunv, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btntracuu)
                .addGap(251, 251, 251))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(btnthemnv)
                        .addGap(78, 78, 78)
                        .addComponent(btnsuanv)
                        .addGap(68, 68, 68)
                        .addComponent(btnxoanv))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtontrangchu)
                        .addGap(303, 303, 303)
                        .addComponent(labQLNV)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labQLNV)
                    .addComponent(jButtontrangchu))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntracuu)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttracuunv, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuanv)
                    .addComponent(btnthemnv)
                    .addComponent(btnxoanv))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemnvActionPerformed
        Viewthemnhanvien viewnv=new Viewthemnhanvien();
        viewnv.show();
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btnthemnvActionPerformed

    private void btnxoanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoanvActionPerformed
        if (jTableNhanvien.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá nhân viên", "Xác nhận xoá nhân viên", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                Daonhanvien.getInstance().delete(getNHANVIENSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                loadDataToTable();
            }
        }
    }//GEN-LAST:event_btnxoanvActionPerformed

    private void btnsuanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanvActionPerformed
        if (jTableNhanvien.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa");
        } else {
            Viewsuanhanvien frame = new Viewsuanhanvien(this);
            frame.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnsuanvActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked

        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuunv.getText();
        ArrayList<MODEL.Modelnhanvien> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
        jComboluachon.setSelectedIndex(0);
        loadDataToTable();
    }//GEN-LAST:event_btntracuuActionPerformed

    private void jTableNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNhanvienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableNhanvienMouseClicked

    private void jTableNhanvienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableNhanvienKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableNhanvienKeyReleased

    private void txttracuunvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuunvActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuunv.getText();
        ArrayList<MODEL.Modelnhanvien> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuunvActionPerformed

    private void jButtontrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchuActionPerformed
        ViewMenubql viewbql= new ViewMenubql();
        viewbql.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtontrangchuActionPerformed

    private void jComboluachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboluachonActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuunv.getText();
        ArrayList<MODEL.Modelnhanvien> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboluachonActionPerformed

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
            java.util.logging.Logger.getLogger(Viewnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewnhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsuanv;
    private javax.swing.JButton btnthemnv;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton btnxoanv;
    private javax.swing.JButton jButtontrangchu;
    private javax.swing.JComboBox<String> jComboluachon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNhanvien;
    private javax.swing.JLabel labQLNV;
    private javax.swing.JTextField txttracuunv;
    // End of variables declaration//GEN-END:variables
}
