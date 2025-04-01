/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import DAO.Daocanho;
import DAO.Daocthd;
import DAO.Daohoadon;
import DAO.Daohopdong;
import DAO.Daotaikhoan;
import DAO.Daoxe;
import DAO.Daoyeucaucd;
import MODEL.Modelcanho;
import MODEL.Modelhoadon;
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
import MODEL.Modelhopdong;
import MODEL.Modeltaikhoan;
import controler.Timhopdong;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Thinkbook 16
 */
public class Viewhopdong extends javax.swing.JFrame {
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
    public Viewhopdong() {
        initComponents();
         jTableHopdong.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
       loadDataToTable();
        }
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã Hợp Đồng", "Ngày Bắt Đầu", "Thời Hạn", "Loại Hợp Đồng", "Giá", "Mã Cư Dân", "Mã Ban Quản Lý"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableHopdong.setModel(tblModel);
         jTableHopdong.setRowHeight(25);
        jTableHopdong.setFont(new Font("Arial", Font.PLAIN, 12));

        // Alternating row colors
        jTableHopdong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        jTableHopdong.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableHopdong.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableHopdong.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableHopdong.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableHopdong.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTableHopdong.getColumnModel().getColumn(5).setPreferredWidth(30);        
        jTableHopdong.getColumnModel().getColumn(6).setPreferredWidth(30);
       
   
       
        
    }
      public void changeTextFind() {
        txttracuuhopdong.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (txttracuuhopdong.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /* do nothing */

            }
        });
    }
    public ArrayList<Modelhopdong> searchFn(String luaChon, String content) {
        ArrayList<MODEL.Modelhopdong> result = new ArrayList<>();
        Timhopdong timhd = new Timhopdong();
        switch (luaChon) {
            case "MAHOPDONG":
                result = timhd.searchMAHOPDONG(content);
                break;
            case "LOAIHD":
                result = timhd.searchLOAIHD(content);
                break;
            
        }
        return result;
    }
    public MODEL.Modelhopdong getDetail() {
        MODEL.Modelhopdong a = Daohopdong.getInstance().selectById(getHOPDONGSelect().getMAHOPDONG());
        return a;
    }
    public MODEL.Modelhopdong getHOPDONGSelect() {
        int i_row = jTableHopdong.getSelectedRow();
        MODEL.Modelhopdong hd = Daohopdong.getInstance().selectAll().get(i_row);
        return hd;
    }
     public void loadDataToTable() {
    try {
        Daohopdong hddao = new Daohopdong();
        ArrayList<MODEL.Modelhopdong> arms = hddao.selectAll();
        tblModel.setRowCount(0);
        for (MODEL.Modelhopdong i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMAHOPDONG(), i.getNGAYBD(),i.getTHOIHAN(),i.getLOAIHD(),i.getGIA(),i.getMACD(),i.getMABQL()              
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     public void loadDataToTableSearch(ArrayList<MODEL.Modelhopdong> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modelhopdong i : result) {
                tblModel.addRow(new Object[]{
                    i.getMAHOPDONG(), i.getNGAYBD(),i.getTHOIHAN(),i.getLOAIHD(),i.getGIA(),i.getMACD(),i.getMABQL()    
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
        btnthemhopdong = new javax.swing.JButton();
        btnxoahopdong = new javax.swing.JButton();
        btnsuahopdong = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHopdong = new javax.swing.JTable();
        labQLHD = new javax.swing.JLabel();
        txttracuuhopdong = new javax.swing.JTextField();
        jButtontrangchu = new javax.swing.JButton();
        jComboluachon = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(196, 233, 245));

        btnthemhopdong.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnthemhopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-agreement-new-30.png"))); // NOI18N
        btnthemhopdong.setText("Thêm");
        btnthemhopdong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthemhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhopdongActionPerformed(evt);
            }
        });

        btnxoahopdong.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnxoahopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btnxoahopdong.setText("Xóa");
        btnxoahopdong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxoahopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoahopdongActionPerformed(evt);
            }
        });

        btnsuahopdong.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsuahopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-item (2).png"))); // NOI18N
        btnsuahopdong.setText("Sửa");
        btnsuahopdong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsuahopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuahopdongActionPerformed(evt);
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

        jTableHopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hợp Đồng", "Ngày Bắt Đầu", "Thời Hạn", "Loại Hợp Đồng", "Giá", "Mã Cư Dân", "Mã Ban Quản Lý"
            }
        ));
        jTableHopdong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableHopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHopdongMouseClicked(evt);
            }
        });
        jTableHopdong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableHopdongKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHopdong);

        labQLHD.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labQLHD.setForeground(new java.awt.Color(255, 255, 255));
        labQLHD.setText("QUẢN LÝ HỢP ĐỒNG");

        txttracuuhopdong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttracuuhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuuhopdongActionPerformed(evt);
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

        jComboluachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAHOPDONG", "LOAIHD", " ", " ", " " }));
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(btnthemhopdong)
                        .addGap(60, 60, 60)
                        .addComponent(btnsuahopdong)
                        .addGap(60, 60, 60)
                        .addComponent(btnxoahopdong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtontrangchu)
                        .addGap(301, 301, 301)
                        .addComponent(labQLHD))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txttracuuhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btntracuu)))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labQLHD)
                    .addComponent(jButtontrangchu))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntracuu)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttracuuhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuahopdong)
                    .addComponent(btnthemhopdong)
                    .addComponent(btnxoahopdong))
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

    private void btnthemhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhopdongActionPerformed
        Viewthemhopdong viewhd=new Viewthemhopdong();
        viewhd.show();
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btnthemhopdongActionPerformed

    private void btnxoahopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoahopdongActionPerformed
          
        if (jTableHopdong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá căn hộ", "Xác nhận xoá căn hộ", JOptionPane.YES_NO_OPTION);
            
            if (output == JOptionPane.YES_OPTION) {
    int selectedRow = jTableHopdong.getSelectedRow();
    String maHD = jTableHopdong.getValueAt(selectedRow, 0).toString();
    Daohopdong hdongdao=new Daohopdong();
    Modelhopdong hdong= hdongdao.selectById(maHD);
    String macd=hdong.getMACD();
    Daocanho chdao = new Daocanho();
    Modelcanho ch=chdao.selectByMacd(macd);
    Daohoadon hddao = new Daohoadon();
    Daocthd ctdao = new Daocthd();
    Daoxe xedao = new Daoxe();
    Daoyeucaucd ycdao= new Daoyeucaucd();
    
    
    
        ArrayList<MODEL.Modelyeucaucd> armsyc = ycdao.selectByMacd(macd);
        if (armsyc != null){
        for (MODEL.Modelyeucaucd yc : armsyc) {
            ycdao.delete(yc);
        }
        }
       

     

        
            // Xóa hóa đơn và chi tiết hóa đơn
            Modelhoadon hdon=new Modelhoadon();
                try {
                    hdon = hddao.getHoaDonByMACH(ch.getMACH());
                } catch (SQLException ex) {
                    Logger.getLogger(Viewcanho.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (hdon != null) {
                ctdao.delete(hdon);
                hddao.delete(hdon);
            }
          
            String tam=ch.getMAHOPDONG();
            int slxe=ch.getSLXE();
            // Xóa căn hộ
            chdao.delete(ch);
            hdongdao.delete(hdong);
            // Xóa hợp đồng nếu tồn tại
            
        
                // Lấy danh sách xe theo MACD và xóa
       ArrayList<MODEL.Modelxe> armsxe = xedao.selectXeByMACD(macd);
        if (armsxe != null) {// Số lượng xe của căn hộ
            for (int i = 0; i < slxe; i++) {
                MODEL.Modelxe xe = armsxe.get(i); // Lấy xe ở vị trí i
                xedao.delete(xe); // Xóa xe
    }
        }
//        Modelcudan cd=Daocudan.getInstance().getCudanByMACD(macd);
//        // Cuối cùng xóa cư dân
//        Daocudan.getInstance().delete(cd);

        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadDataToTable();
  

}
        }
        
    }//GEN-LAST:event_btnxoahopdongActionPerformed

    private void btnsuahopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuahopdongActionPerformed
        if (jTableHopdong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hợp đồng cần sửa");
        } else {
            Viewsuahopdong frame = new Viewsuahopdong(this);
            frame.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnsuahopdongActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked

        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuuhopdong.getText();
        ArrayList<MODEL.Modelhopdong> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
        jComboluachon.setSelectedIndex(0);
        loadDataToTable();
    }//GEN-LAST:event_btntracuuActionPerformed

    private void jTableHopdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHopdongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableHopdongMouseClicked

    private void jTableHopdongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableHopdongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableHopdongKeyReleased

    private void txttracuuhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuuhopdongActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuuhopdong.getText();
        ArrayList<MODEL.Modelhopdong> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuuhopdongActionPerformed

    private void jButtontrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchuActionPerformed
        ViewMenubql viewbql= new ViewMenubql();
        viewbql.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtontrangchuActionPerformed

    private void jComboluachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboluachonActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuuhopdong.getText();
        ArrayList<MODEL.Modelhopdong> result = searchFn(luaChon, content);
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
            java.util.logging.Logger.getLogger(Viewhopdong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewhopdong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewhopdong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewhopdong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewhopdong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsuahopdong;
    private javax.swing.JButton btnthemhopdong;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton btnxoahopdong;
    private javax.swing.JButton jButtontrangchu;
    private javax.swing.JComboBox<String> jComboluachon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHopdong;
    private javax.swing.JLabel labQLHD;
    private javax.swing.JTextField txttracuuhopdong;
    // End of variables declaration//GEN-END:variables
}
