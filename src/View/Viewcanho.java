/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
//import controller.TimSanPham;
//import dao.NhaCungCapDAO;
import DAO.Daocanho;
import DAO.Daocthd;
import DAO.Daocudan;
import DAO.Daohoadon;
import DAO.Daohopdong;
import DAO.Daotaikhoan;
import DAO.Daoxe;
import DAO.Daoyeucaucd;
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
import MODEL.Modelcanho;
import MODEL.Modelcudan;
import MODEL.Modelhoadon;
import MODEL.Modelhopdong;
import MODEL.Modeltaikhoan;
import controler.Timcanho;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author HP
 */
public class Viewcanho extends javax.swing.JFrame {
    String ma ="";
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");

     /**
     * Creates new form NewJFrame
     */
    public Viewcanho() {
       
        initComponents();
        jTableCanho.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
       loadDataToTable();
        //filltable();
        
        //changeTextFind();
    }
    
    public Viewcanho(String ma) {
       
        initComponents();
        jTableCanho.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
               this.ma = ma ;
       loadDataToTable1();
        //filltable();
        
        //changeTextFind();
    }
    
     public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã căn hộ", "Diện Tích", "LoạiCH", "Số Phòng Ngủ", "Số Phòng Tắm", "Tầng", "Giá Thuê", "Phí DV","Giá Xe","SL xe"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableCanho.setModel(tblModel);
        
        jTableCanho.setRowHeight(25);
        jTableCanho.setFont(new Font("Arial", Font.PLAIN, 12));

        // Alternating row colors
        jTableCanho.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        
        
        jTableCanho.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTableCanho.getColumnModel().getColumn(1).setPreferredWidth(20);
        jTableCanho.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTableCanho.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableCanho.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableCanho.getColumnModel().getColumn(5).setPreferredWidth(20);        
        jTableCanho.getColumnModel().getColumn(6).setPreferredWidth(20);
        jTableCanho.getColumnModel().getColumn(7).setPreferredWidth(20);
        jTableCanho.getColumnModel().getColumn(8).setPreferredWidth(20);
        jTableCanho.getColumnModel().getColumn(9).setPreferredWidth(20);
    
       
        
    }

     public void changeTextFind() {
        txttracuu.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (txttracuu.getText().length() == 0) {
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
    public ArrayList<Modelcanho> searchFn(String luaChon, String content) {
        ArrayList<MODEL.Modelcanho> result = new ArrayList<>();
        Timcanho timch = new Timcanho();
        switch (luaChon) {
            case "MACH":
                result = timch.searchMACH(content);
                break;
            case "LoaiCH":
                result = timch.searchLoaiCH(content);
                break;
            
        }
        return result;
    }
    public MODEL.Modelcanho getDetail() {
        MODEL.Modelcanho a = Daocanho.getInstance().selectById(getCANHOSelect().getMACH());
        return a;
    }
    public MODEL.Modelcanho getCANHOSelect() {
        int i_row = jTableCanho.getSelectedRow();
        MODEL.Modelcanho ch = Daocanho.getInstance().selectAll().get(i_row);
        return ch;
    }
     public void loadDataToTable() {
    try {
        Daocanho chdao = new Daocanho();
        ArrayList<MODEL.Modelcanho> arms = chdao.selectAll();
        tblModel.setRowCount(0);
        for (MODEL.Modelcanho i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMACH(), i.getDienTich(),i.getLoaiCH(),i.getSoPhongNgu(),i.getSoPhongTam(),i.getTang(),formatter.format(i.getGiaThue()) + "đ",formatter.format(i.getPHIDV()) + "đ",
                formatter.format(i.getGIAXE()) + "đ",i.getSLXE()
                  
            });
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     
     public void loadDataToTable1() {
    try {
        Daocanho chdao = new Daocanho();
        ArrayList<MODEL.Modelcanho> arms = chdao.selectCHByMANV(ma);
        tblModel.setRowCount(0);
        for (MODEL.Modelcanho i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMACH(), i.getDienTich(),i.getLoaiCH(),i.getSoPhongNgu(),i.getSoPhongTam(),i.getTang(),formatter.format(i.getGiaThue()) + "đ",formatter.format(i.getPHIDV()) + "đ",
                formatter.format(i.getGIAXE()) + "đ",i.getSLXE()
                  
            });
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
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
        btnxoach = new javax.swing.JButton();
        btnsuach = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCanho = new javax.swing.JTable();
        labQLCH = new javax.swing.JLabel();
        txttracuu = new javax.swing.JTextField();
        jButtontrangchu = new javax.swing.JButton();
        jComboluachon = new javax.swing.JComboBox<>();
        btnsetchiso = new javax.swing.JButton();
        btnsuach1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setForeground(new java.awt.Color(196, 233, 245));

        btnxoach.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnxoach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btnxoach.setText("Xóa chủ căn hộ");
        btnxoach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoachActionPerformed(evt);
            }
        });

        btnsuach.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsuach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-30 (1).png"))); // NOI18N
        btnsuach.setText("Sửa");
        btnsuach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuachActionPerformed(evt);
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

        jTableCanho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Căn Hộ", "Diện Tích", "Loại Căn Hộ", "Số Phòng Ngủ", "Số Phòng Tắm", "Tầng", "Giá Thuê", "Phí Dịch Vụ", "Giá Xe", "Số Lượng Xe"
            }
        ));
        jTableCanho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCanhoMouseClicked(evt);
            }
        });
        jTableCanho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCanhoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCanho);
        if (jTableCanho.getColumnModel().getColumnCount() > 0) {
            jTableCanho.getColumnModel().getColumn(4).setMinWidth(50);
        }

        labQLCH.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labQLCH.setForeground(new java.awt.Color(255, 255, 255));
        labQLCH.setText("QUẢN LÝ CĂN HỘ");

        txttracuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuuActionPerformed(evt);
            }
        });

        jButtontrangchu.setBackground(new java.awt.Color(55, 139, 167));
        jButtontrangchu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtontrangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-48.png"))); // NOI18N
        jButtontrangchu.setBorder(null);
        jButtontrangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontrangchuActionPerformed(evt);
            }
        });

        jComboluachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MACH", "LoaiCH", " ", " ", " " }));
        jComboluachon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboluachonActionPerformed(evt);
            }
        });

        btnsetchiso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsetchiso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-item (2).png"))); // NOI18N
        btnsetchiso.setText("Cập nhật số điện/nước");
        btnsetchiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsetchisoActionPerformed(evt);
            }
        });

        btnsuach1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsuach1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-eye-30.png"))); // NOI18N
        btnsuach1.setText("Xem");
        btnsuach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuach1ActionPerformed(evt);
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
                .addGap(26, 26, 26)
                .addComponent(txttracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btntracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtontrangchu)
                        .addGap(332, 332, 332)
                        .addComponent(labQLCH))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnsetchiso)
                        .addGap(65, 65, 65)
                        .addComponent(btnsuach)
                        .addGap(78, 78, 78)
                        .addComponent(btnsuach1)
                        .addGap(67, 67, 67)
                        .addComponent(btnxoach)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labQLCH)
                    .addComponent(jButtontrangchu))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntracuu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboluachon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuach)
                    .addComponent(btnxoach)
                    .addComponent(btnsetchiso)
                    .addComponent(btnsuach1))
                .addContainerGap(40, Short.MAX_VALUE))
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

    private void txttracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuuActionPerformed
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuu.getText();
        ArrayList<MODEL.Modelcanho> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuuActionPerformed

    private void jButtontrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchuActionPerformed
        if(ma.equals("")) {
            ViewMenubql viewbql= new ViewMenubql();
        viewbql.show();
        dispose();}  
        else {
            ViewMenunhanvien viewnv= new ViewMenunhanvien(ma);
            viewnv.show();
            dispose();
        }
    }//GEN-LAST:event_jButtontrangchuActionPerformed

    private void btnsuachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuachActionPerformed
        if (ma.equals("")) {
            if (jTableCanho.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ cần sửa");
    } else {
        Viewsuacanho frame = new Viewsuacanho(this.getCANHOSelect());
        frame.setVisible(true);
        dispose();
    }
        }else {
             if (jTableCanho.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ cần sửa");
    } else {
        Viewsuacanho frame = new Viewsuacanho(this.getCANHOSelect(),ma);
        frame.setVisible(true);
        dispose();
    }
        }
    }//GEN-LAST:event_btnsuachActionPerformed

    private void jTableCanhoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCanhoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCanhoKeyReleased

    private void jTableCanhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCanhoMouseClicked
                        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCanhoMouseClicked
 public void loadDataToTableSearch(ArrayList<MODEL.Modelcanho> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modelcanho i : result) {
                tblModel.addRow(new Object[]{
                    i.getMACH(), i.getDienTich(),i.getLoaiCH(),i.getSoPhongNgu(),i.getSoPhongTam(),i.getTang(),formatter.format(i.getGiaThue()) + "đ",formatter.format(i.getPHIDV()) + "đ",
                formatter.format(i.getGIAXE()) + "đ",i.getSLXE()
                });
            }
        } catch (Exception e) {  
        }
    }

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
          
           if(ma.equals("")) {
               loadDataToTable();
           } else {
               loadDataToTable1();
           }
    }//GEN-LAST:event_btntracuuActionPerformed

    private void jComboluachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboluachonActionPerformed
        // TODO add your handling code here:
         String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuu.getText();
        ArrayList<MODEL.Modelcanho> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboluachonActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked

                   // TODO add your handling code here:
        String luaChon = jComboluachon.getSelectedItem().toString();
        String content = txttracuu.getText();
        ArrayList<MODEL.Modelcanho> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked
    public  MODEL.Modelcanho getCanHoSelect() {
        int i_row = jTableCanho.getSelectedRow();
        MODEL.Modelcanho sp =Daocanho.getInstance().selectAll().get(i_row);
        return sp;
    }
    private void btnxoachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoachActionPerformed
        if (ma.equals("")) {
        if (jTableCanho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá căn hộ", "Xác nhận xoá căn hộ", JOptionPane.YES_NO_OPTION);
            
            if (output == JOptionPane.YES_OPTION) {
    int selectedRow = jTableCanho.getSelectedRow();
    String maCH = jTableCanho.getValueAt(selectedRow, 0).toString();
    
    Daocanho daoch = new Daocanho();
                try {
                    daoch.delete1(maCH);
                } catch (SQLException ex) {
                    Logger.getLogger(Viewcanho.class.getName()).log(Level.SEVERE, null, ex);
                }
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadDataToTable();
  

}
        }
        }
        else 
        {
         if (jTableCanho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá căn hộ", "Xác nhận xoá căn hộ", JOptionPane.YES_NO_OPTION);
            
            if (output == JOptionPane.YES_OPTION) {
    int selectedRow = jTableCanho.getSelectedRow();
    String maCH = jTableCanho.getValueAt(selectedRow, 0).toString();
    
       Daocanho daoch = new Daocanho();
                try {
                    daoch.delete1(maCH);
                } catch (SQLException ex) {
                    Logger.getLogger(Viewcanho.class.getName()).log(Level.SEVERE, null, ex);
                }
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        loadDataToTable1();
  

}
        }
        }
    }//GEN-LAST:event_btnxoachActionPerformed

    private void btnsetchisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsetchisoActionPerformed
        if (ma.equals("")) {
            if (jTableCanho.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ cần cập nhật điện nước");
            } else {
                Viewdiennuoc frame = new Viewdiennuoc(this.getCANHOSelect());
                frame.setVisible(true);
                dispose();
            }
        }else {
            if (jTableCanho.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ cần cập nhật điện nước");
            } else {
                Viewdiennuoc frame = new Viewdiennuoc(this.getCANHOSelect(), ma);
                frame.setVisible(true);
                dispose();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsetchisoActionPerformed

    private void btnsuach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuach1ActionPerformed
      if(ma.equals("")) {
        if (jTableCanho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ cần xem");
        } else {
          int selectedRow = jTableCanho.getSelectedRow();
           String mach = jTableCanho.getValueAt(selectedRow, 0).toString();
            Viewctch frame = new Viewctch(mach);
            frame.setVisible(true);
            dispose();
        }  
    
    } else {
        if (jTableCanho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn căn hộ cần xem");
        } else {
          int selectedRow = jTableCanho.getSelectedRow();
           String mach = jTableCanho.getValueAt(selectedRow, 0).toString();
            Viewctch frame = new Viewctch(mach, ma);
            frame.setVisible(true);dispose();
        }  
   
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnsuach1ActionPerformed

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
            java.util.logging.Logger.getLogger(Viewcanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewcanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewcanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewcanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewcanho().setVisible(true);
            }
        });
    
  
    }
    
    
    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsetchiso;
    private javax.swing.JButton btnsuach;
    private javax.swing.JButton btnsuach1;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton btnxoach;
    private javax.swing.JButton jButtontrangchu;
    private javax.swing.JComboBox<String> jComboluachon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCanho;
    private javax.swing.JLabel labQLCH;
    private javax.swing.JTextField txttracuu;
    // End of variables declaration//GEN-END:variables
}
