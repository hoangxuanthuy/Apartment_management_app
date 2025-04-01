/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.Daoyeucaucd;

import MODEL.Modelyeucaucd;
import View.ViewcapnhatYC;
import controler.Timyeucau;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewYeucau extends javax.swing.JFrame {
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    /**
     * Creates new form ViewYeucau
     */
    public ViewYeucau() {
        initComponents();
         jTableYeucau.setDefaultEditor(Object.class, null);
    initTable();
    this.setLocationRelativeTo(null);
    loadDataToTable();
    }
     public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã Yêu Cầu", "Loại Yêu Cầu", "Nội Dung ", "Trạng Thái","Mã CD"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableYeucau.setModel(tblModel);
        
        jTableYeucau.setRowHeight(25);
        jTableYeucau.setFont(new Font("Arial", Font.PLAIN, 12));

        // Alternating row colors
        jTableYeucau.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        
        
        
        
        jTableYeucau.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableYeucau.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTableYeucau.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableYeucau.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTableYeucau.getColumnModel().getColumn(4).setPreferredWidth(30);
         
    }
      public void changeTextFind() {
        txttracuuyccd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (txttracuuyccd.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /* do nothing */

            }
        });
    }
public ArrayList<Modelyeucaucd> searchFn(String luaChon, String content) {
        ArrayList<MODEL.Modelyeucaucd> result = new ArrayList<>();
        Timyeucau timyc = new Timyeucau();
        switch (luaChon) {
            case "MAYC":
                result = timyc.searchMAYC(content);
                break;
            case "MACD":
                result = timyc.searchMACD(content);
                break;
            
        }
        return result;
    }
    
   
     public void loadDataToTable() {
    try {
        Daoyeucaucd daoyc = new Daoyeucaucd();
        ArrayList<MODEL.Modelyeucaucd> arms = daoyc.selectAll();
        tblModel.setRowCount(0);
        for (MODEL.Modelyeucaucd i : arms ) {
            tblModel.addRow(new Object[]{
             i.getMAYC(), i.getLoaiYC(),i.getNoiDungYC() ,i.getTrangThaiYC(),i.getMACD()           
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
      public MODEL.Modelyeucaucd getDetail() {
        MODEL.Modelyeucaucd a = Daoyeucaucd.getInstance().selectById(getYEUCAUCUDANSelect().getMAYC());
        return a;
    }
    public MODEL.Modelyeucaucd getYEUCAUCUDANSelect() {
        int i_row = jTableYeucau.getSelectedRow();
        MODEL.Modelyeucaucd yeucau = Daoyeucaucd.getInstance().selectAll().get(i_row);
        return yeucau;
    }
     public void loadDataToTableSearch(ArrayList<MODEL.Modelyeucaucd> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modelyeucaucd i : result) {
                tblModel.addRow(new Object[]{
                  i.getMAYC(), i.getLoaiYC(),i.getNoiDungYC() ,i.getTrangThaiYC(),i.getMACD()  
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableYeucau = new javax.swing.JTable();
        BtnXoa = new javax.swing.JButton();
        BtnCapnhat = new javax.swing.JButton();
        jButtontrangchu1 = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        txttracuuyccd = new javax.swing.JTextField();
        CbLoai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(196, 233, 243));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Yêu Cầu Cư Dân");

        jTableYeucau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableYeucau);

        BtnXoa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BtnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        BtnXoa.setText("Xóa");
        BtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnXoaActionPerformed(evt);
            }
        });

        BtnCapnhat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BtnCapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-30 (1).png"))); // NOI18N
        BtnCapnhat.setText("Cập nhật");
        BtnCapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCapnhatActionPerformed(evt);
            }
        });

        jButtontrangchu1.setBackground(new java.awt.Color(55, 139, 167));
        jButtontrangchu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtontrangchu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-48.png"))); // NOI18N
        jButtontrangchu1.setBorder(null);
        jButtontrangchu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontrangchu1ActionPerformed(evt);
            }
        });

        btntracuu.setBackground(new java.awt.Color(55, 139, 167));
        btntracuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-36.png"))); // NOI18N
        btntracuu.setBorder(null);
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

        txttracuuyccd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuuyccdActionPerformed(evt);
            }
        });

        CbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAYC", "MACD", " " }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-support-94.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(BtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(BtnCapnhat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(CbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttracuuyccd, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtontrangchu1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btntracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(jLabel2))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtontrangchu1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btntracuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CbLoai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttracuuyccd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCapnhat)
                    .addComponent(BtnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnXoaActionPerformed
      if (jTableYeucau.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn yêu cầu muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá yêu cầu", "Xác nhận xoá yêu cầu", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
            
                Daoyeucaucd.getInstance().delete(getYEUCAUCUDANSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                loadDataToTable();
            }
        }
               
    }//GEN-LAST:event_BtnXoaActionPerformed

    private void BtnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCapnhatActionPerformed
         if (jTableYeucau.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn yêu cầu cần cập nhật");
        } else {
            ViewcapnhatYC frame = new ViewcapnhatYC(this);
            frame.setVisible(true);
            dispose();
        }
                   
    }//GEN-LAST:event_BtnCapnhatActionPerformed

    private void jButtontrangchu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchu1ActionPerformed
        ViewMenubql view=new ViewMenubql();
        view.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtontrangchu1ActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked

         String luaChon = CbLoai.getSelectedItem().toString();
        String content = txttracuuyccd.getText();
        ArrayList<MODEL.Modelyeucaucd> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
                String luaChon = CbLoai.getSelectedItem().toString();
        String content = txttracuuyccd.getText();
        ArrayList<MODEL.Modelyeucaucd> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuActionPerformed

    private void txttracuuyccdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuuyccdActionPerformed
        // TODO add your handling code here:
          String luaChon = CbLoai.getSelectedItem().toString();
        String content = txttracuuyccd.getText();
        ArrayList<MODEL.Modelyeucaucd> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuuyccdActionPerformed

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
            java.util.logging.Logger.getLogger(ViewYeucau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewYeucau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewYeucau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewYeucau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewYeucau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCapnhat;
    private javax.swing.JButton BtnXoa;
    private javax.swing.JComboBox<String> CbLoai;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton jButtontrangchu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableYeucau;
    private javax.swing.JTextField txttracuuyccd;
    // End of variables declaration//GEN-END:variables
}
