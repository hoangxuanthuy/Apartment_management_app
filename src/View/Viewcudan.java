/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.Daocanho;
import DAO.Daocthd;
import DAO.Daocudan;
import DAO.Daohoadon;
import DAO.Daohopdong;
import DAO.Daotaikhoan;
import DAO.Daoxe;
import DAO.Daoyeucaucd;
import Database.OracleJDBCconnection;
import MODEL.Modelcanho;
import MODEL.Modelcthd;
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
import MODEL.Modelcudan;
import MODEL.Modelhoadon;
import MODEL.Modelhopdong;
import MODEL.Modeltaikhoan;
import MODEL.Modelxe;
import MODEL.Modelyeucaucd;
import controler.Timcudan;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;

public class Viewcudan extends javax.swing.JFrame {
    
    String ma ="";
        
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
    public Viewcudan() {
        initComponents();
         jTableCudan.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
       loadDataToTable();
    }
    
    public Viewcudan(String ma) {
        initComponents();
         jTableCudan.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
               this.ma = ma;
       loadDataToTable1();
    }
    

    
     public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã Cư Dân", "Họ Tên", "Ngày Sinh", "Giới Tính", "CCCD", "Số Điện Thoại", "Email", "Loại Cư Dân"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableCudan.setModel(tblModel);
        
        jTableCudan.setRowHeight(25);
        jTableCudan.setFont(new Font("Arial", Font.PLAIN, 12));

        // Alternating row colors
        jTableCudan.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        
        
        
        
        
        
        jTableCudan.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableCudan.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableCudan.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableCudan.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTableCudan.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTableCudan.getColumnModel().getColumn(5).setPreferredWidth(30);        
        jTableCudan.getColumnModel().getColumn(6).setPreferredWidth(95);
        jTableCudan.getColumnModel().getColumn(7).setPreferredWidth(15);
   
       
        
    }
      public void changeTextFind() {
        txttracuucd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (txttracuucd.getText().length() == 0) {
                    if (ma.equals("")) {
                    loadDataToTable();
                } else {
                    loadDataToTable1();
                }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /* do nothing */

            }
        });
    }
    public ArrayList<Modelcudan> searchFn(String luaChon, String content) {
        ArrayList<MODEL.Modelcudan> result = new ArrayList<>();
        Timcudan timcd = new Timcudan();
        switch (luaChon) {
            case "MACD":
                result = timcd.searchMACD(content);
                break;
            case "HoTen":
                result = timcd.searchHoTen(content);
                break;
            
        }
        return result;
    }
    public MODEL.Modelcudan getDetail() {
        MODEL.Modelcudan a = Daocudan.getInstance().selectById(getCUDANSelect().getMACD());
        return a;
    }
    public MODEL.Modelcudan getCUDANSelect() {
        int i_row = jTableCudan.getSelectedRow();
        MODEL.Modelcudan cd = Daocudan.getInstance().selectAll().get(i_row);
        return cd;
    }
     public void loadDataToTable() {
          Connection con = OracleJDBCconnection.getJDBCconnection();
        try {
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        } catch (SQLException ex) {
            Logger.getLogger(Viewcudan.class.getName()).log(Level.SEVERE, null, ex);
        }
    try {
        Daocudan cddao = new Daocudan();
        ArrayList<MODEL.Modelcudan> arms = cddao.selectAll();
        tblModel.setRowCount(0);
        for (MODEL.Modelcudan i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMACD(), i.getHoten(),i.getNgsinh(),i.getGioitinh(),i.getCccd(),i.getSdt(),i.getEmail(),i.getLoaicd()              
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     
     
        public void loadDataToTable1() {
    try {
        Daocudan cddao = new Daocudan();
        ArrayList<MODEL.Modelcudan> arms = cddao.selectCDByMANV(ma);
        tblModel.setRowCount(0);
        for (MODEL.Modelcudan i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMACD(), i.getHoten(),i.getNgsinh(),i.getGioitinh(),i.getCccd(),i.getSdt(),i.getEmail(),i.getLoaicd()              
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
        
        
     public void loadDataToTableSearch(ArrayList<MODEL.Modelcudan> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modelcudan i : result) {
                tblModel.addRow(new Object[]{
                    i.getMACD(), i.getHoten(),i.getNgsinh(),i.getGioitinh(),i.getCccd(),i.getSdt(),i.getEmail(),i.getLoaicd()     
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
        btnthemcd = new javax.swing.JButton();
        btnxoacd = new javax.swing.JButton();
        btnsuacd = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCudan = new javax.swing.JTable();
        labQLCD = new javax.swing.JLabel();
        txttracuucd = new javax.swing.JTextField();
        jButtontrangchu = new javax.swing.JButton();
        jComboluachon = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(196, 233, 245));

        btnthemcd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnthemcd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-male-user-30.png"))); // NOI18N
        btnthemcd.setText("Thêm");
        btnthemcd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthemcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemcdActionPerformed(evt);
            }
        });

        btnxoacd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnxoacd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btnxoacd.setText("Xóa");
        btnxoacd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxoacd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoacdActionPerformed(evt);
            }
        });

        btnsuacd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsuacd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-30 (1).png"))); // NOI18N
        btnsuacd.setText("Sửa");
        btnsuacd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsuacd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuacdActionPerformed(evt);
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

        jTableCudan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Cư Dân", "Họ Tên", "Ngày Sinh", "Giới Tính", "CCCD", "Số Điện Thoại", "Email", "Loại Cư Dân"
            }
        ));
        jTableCudan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCudan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCudanMouseClicked(evt);
            }
        });
        jTableCudan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCudanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCudan);

        labQLCD.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labQLCD.setForeground(new java.awt.Color(255, 255, 255));
        labQLCD.setText("QUẢN LÝ CƯ DÂN");

        txttracuucd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttracuucd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuucdActionPerformed(evt);
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

        jComboluachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MACD", "HoTen", " ", " ", " " }));
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
                .addComponent(txttracuucd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnthemcd)
                        .addGap(35, 35, 35)
                        .addComponent(btnsuacd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnxoacd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtontrangchu)
                        .addGap(297, 297, 297)
                        .addComponent(labQLCD)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labQLCD))
                    .addComponent(jButtontrangchu))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntracuu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttracuucd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuacd)
                    .addComponent(btnthemcd)
                    .addComponent(btnxoacd))
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

    private void btnthemcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemcdActionPerformed
        if (ma.equals("")) {
            Viewthemcudan viewcd=new Viewthemcudan();
            viewcd.show();
            dispose(); 
        } else {
            Viewthemcudan viewcd=new Viewthemcudan(ma);
            viewcd.show();
            dispose(); 
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnthemcdActionPerformed

    private void btnxoacdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoacdActionPerformed
        if (ma.equals("")) {
        if (jTableCudan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cư dân muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá cư dân", "Xác nhận xoá cư dân", JOptionPane.YES_NO_OPTION);
            
            if (output == JOptionPane.YES_OPTION) {
    int selectedRow = jTableCudan.getSelectedRow();
    String macd = jTableCudan.getValueAt(selectedRow, 0).toString();

    Daocudan cddao = new Daocudan();
                try {
                    cddao.delete(macd);
                    // Cuối cùng xóa cư dân
                } catch (SQLException ex) {
                    Logger.getLogger(Viewcudan.class.getName()).log(Level.SEVERE, null, ex);
                }
      

        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadDataToTable();
    

}
        }
        }
        else 
        {
            if (jTableCudan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cư dân muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá cư dân", "Xác nhận xoá cư dân", JOptionPane.YES_NO_OPTION);
            
            if (output == JOptionPane.YES_OPTION) {
    int selectedRow = jTableCudan.getSelectedRow();
    String macd = jTableCudan.getValueAt(selectedRow, 0).toString();

     Daocudan cddao = new Daocudan();
                try {
                    cddao.delete(macd);
                    
                    // Cuối cùng xóa cư dân
                } catch (SQLException ex) {
                    Logger.getLogger(Viewcudan.class.getName()).log(Level.SEVERE, null, ex);
                }
        

        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadDataToTable1();
    

}
        }
        }
        
    }//GEN-LAST:event_btnxoacdActionPerformed

    private void btnsuacdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuacdActionPerformed
        if (ma.equals("")){ 
            if (jTableCudan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cư dân cần sửa thông tin");
        } else {
            Viewsuacudan frame = new Viewsuacudan(this.getCUDANSelect());
            frame.setVisible(true);
            dispose();
        }
        } else {
           if (jTableCudan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cư dân cần sửa thông tin");
        } else {
            Viewsuacudan frame = new Viewsuacudan(this.getCUDANSelect() , ma);
            frame.setVisible(true);
            dispose(); 
        }}
    }//GEN-LAST:event_btnsuacdActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuucd.getText();
        ArrayList<MODEL.Modelcudan> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
       
        if (ma.equals("")) {
                    loadDataToTable();
                } else {
                    loadDataToTable1();
                }
    }//GEN-LAST:event_btntracuuActionPerformed

    private void jTableCudanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCudanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCudanMouseClicked

    private void jTableCudanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCudanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCudanKeyReleased

    private void txttracuucdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuucdActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuucd.getText();
        ArrayList<MODEL.Modelcudan> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuucdActionPerformed

    private void jButtontrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchuActionPerformed
        if (ma.equals("")) {
            ViewMenubql viewbql= new ViewMenubql();
            viewbql.show();
            dispose(); 
        } else {
            ViewMenunhanvien viewnv= new ViewMenunhanvien(ma);
            viewnv.show();
            dispose(); 
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButtontrangchuActionPerformed

    private void jComboluachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboluachonActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuucd.getText();
        ArrayList<MODEL.Modelcudan> result = searchFn(luaChon, content);
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
            java.util.logging.Logger.getLogger(Viewcudan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewcudan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewcudan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewcudan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewcudan().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsuacd;
    private javax.swing.JButton btnthemcd;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton btnxoacd;
    private javax.swing.JButton jButtontrangchu;
    private javax.swing.JComboBox<String> jComboluachon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCudan;
    private javax.swing.JLabel labQLCD;
    private javax.swing.JTextField txttracuucd;
    // End of variables declaration//GEN-END:variables
}
