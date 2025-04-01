/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import DAO.Daotaikhoan;
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
import MODEL.Modeltaikhoan;
import controler.Timtaikhoan;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Thinkbook 16
 */
public class Viewtaikhoan extends javax.swing.JFrame {

     private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
    public Viewtaikhoan() {
        initComponents();
         jTableTaikhoan.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
       loadDataToTable();
        }
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Username", "Password", "Role", "Email"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableTaikhoan.setModel(tblModel);
        
         jTableTaikhoan.setRowHeight(25);
        jTableTaikhoan.setFont(new Font("Arial", Font.PLAIN, 12));

        // Alternating row colors
        jTableTaikhoan.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(new Color(0, 120, 215)); // Màu nền cho hàng được chọn (thay đổi nếu cần)
                    c.setForeground(Color.WHITE); // Màu chữ cho hàng được chọn (thay đổi nếu cần)
                } else {
                    c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                    c.setForeground(Color.BLACK); // Màu chữ cho hàng không được chọn
                }
                return c;
            }
        });
        jTableTaikhoan.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableTaikhoan.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableTaikhoan.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableTaikhoan.getColumnModel().getColumn(3).setPreferredWidth(30);
     
       
   
       
        
    }
      public void changeTextFind() {
        txttracuutk.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (txttracuutk.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /* do nothing */

            }
        });
    }
    public ArrayList<Modeltaikhoan> searchFn(String luaChon, String content) {
        ArrayList<MODEL.Modeltaikhoan> result = new ArrayList<>();
        Timtaikhoan timtk = new Timtaikhoan();
        switch (luaChon) {
            case "Username":
                result = timtk.searchUsername(content);
                break;
            case "Role":
                result = timtk.searchRole(content);
                break;
            
        }
        return result;
    }
    public MODEL.Modeltaikhoan getDetail() {
        MODEL.Modeltaikhoan a = Daotaikhoan.getInstance().selectById(getTAIKHOANSelect().getUsername());
        return a;
    }
    public MODEL.Modeltaikhoan getTAIKHOANSelect() {
        int i_row = jTableTaikhoan.getSelectedRow();
        MODEL.Modeltaikhoan tk = Daotaikhoan.getInstance().selectAll().get(i_row);
        return tk;
    }
     public void loadDataToTable() {
    try {
        Daotaikhoan tkdao = new Daotaikhoan();
        ArrayList<MODEL.Modeltaikhoan> arms = tkdao.selectAll();
        tblModel.setRowCount(0);
        for (MODEL.Modeltaikhoan i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getUsername(), i.getPassword(),i.getRole(),i.getEmail()            
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     public void loadDataToTableSearch(ArrayList<MODEL.Modeltaikhoan> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modeltaikhoan i : result) {
                tblModel.addRow(new Object[]{
                          i.getUsername(), i.getPassword(),i.getRole(),i.getEmail() 
                }
                );
            }
        } catch (Exception e) {  
        }
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
        btnthemtk = new javax.swing.JButton();
        btnxoatk = new javax.swing.JButton();
        btnsuatk = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTaikhoan = new javax.swing.JTable();
        labQLTK = new javax.swing.JLabel();
        txttracuutk = new javax.swing.JTextField();
        jButtontrangchu = new javax.swing.JButton();
        jComboluachon = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(196, 233, 245));

        btnthemtk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnthemtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-user-32.png"))); // NOI18N
        btnthemtk.setText("Thêm");
        btnthemtk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthemtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemtkActionPerformed(evt);
            }
        });

        btnxoatk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnxoatk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btnxoatk.setText("Xóa");
        btnxoatk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxoatk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatkActionPerformed(evt);
            }
        });

        btnsuatk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsuatk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-item (2).png"))); // NOI18N
        btnsuatk.setText("Sửa");
        btnsuatk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsuatk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuatkActionPerformed(evt);
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

        jTableTaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Role", "Email"
            }
        ));
        jTableTaikhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableTaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTaikhoanMouseClicked(evt);
            }
        });
        jTableTaikhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTaikhoanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTaikhoan);

        labQLTK.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labQLTK.setForeground(new java.awt.Color(255, 255, 255));
        labQLTK.setText("QUẢN LÝ TÀI KHOẢN");

        txttracuutk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttracuutk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuutkActionPerformed(evt);
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

        jComboluachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Username", "Role", " " }));
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
                .addComponent(txttracuutk, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntracuu)
                .addGap(259, 259, 259))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnthemtk)
                        .addGap(50, 50, 50)
                        .addComponent(btnsuatk)
                        .addGap(50, 50, 50)
                        .addComponent(btnxoatk))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtontrangchu)
                        .addGap(291, 291, 291)
                        .addComponent(labQLTK)))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtontrangchu)
                    .addComponent(labQLTK))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntracuu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttracuutk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuatk)
                    .addComponent(btnthemtk)
                    .addComponent(btnxoatk))
                .addGap(34, 34, 34))
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

    private void btnthemtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemtkActionPerformed
        Viewthemtaikhoan viewtk=new Viewthemtaikhoan();
        viewtk.show();
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btnthemtkActionPerformed

    private void btnxoatkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatkActionPerformed
        if (jTableTaikhoan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá tài khoản", "Xác nhận xoá tài khoản", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                Daotaikhoan.getInstance().delete(getTAIKHOANSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                loadDataToTable();
            }
        }
    }//GEN-LAST:event_btnxoatkActionPerformed

    private void btnsuatkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuatkActionPerformed
        if (jTableTaikhoan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần sửa");
        } else {
            Viewsuataikhoan frame = new Viewsuataikhoan(this);
            frame.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnsuatkActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked

        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuutk.getText();
        ArrayList<MODEL.Modeltaikhoan> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
       
        loadDataToTable();
    }//GEN-LAST:event_btntracuuActionPerformed

    private void jTableTaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaikhoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableTaikhoanMouseClicked

    private void jTableTaikhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTaikhoanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableTaikhoanKeyReleased

    private void txttracuutkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuutkActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuutk.getText();
        ArrayList<MODEL.Modeltaikhoan> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuutkActionPerformed

    private void jButtontrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchuActionPerformed
        ViewMenubql viewbql= new ViewMenubql();
        viewbql.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtontrangchuActionPerformed

    private void jComboluachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboluachonActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuutk.getText();
        ArrayList<MODEL.Modeltaikhoan> result = searchFn(luaChon, content);
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
            java.util.logging.Logger.getLogger(Viewtaikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewtaikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewtaikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewtaikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewtaikhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsuatk;
    private javax.swing.JButton btnthemtk;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton btnxoatk;
    private javax.swing.JButton jButtontrangchu;
    private javax.swing.JComboBox<String> jComboluachon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTaikhoan;
    private javax.swing.JLabel labQLTK;
    private javax.swing.JTextField txttracuutk;
    // End of variables declaration//GEN-END:variables
}
