/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import DAO.Daocthd;
import DAO.Daohoadon;
import MODEL.Modelhoadon;
import controler.Timhoadon;
import controler.Xuathoadon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Viewhoadon extends javax.swing.JFrame {
    
    String ma="";

   private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
public static String formatNumber(double number) {
        // Định dạng số sao cho không có các số 0 ở đầu nhưng tối đa 10 chữ số
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(0); // Không có phần thập phân
        decimalFormat.setMaximumIntegerDigits(10); // Tối đa 10 chữ số

        return decimalFormat.format(number);
    }
    
    public Viewhoadon() {
        initComponents();
         jTableHoadon.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
       loadDataToTable();
        }
    
     public Viewhoadon(String ma) {
        initComponents();
         jTableHoadon.setDefaultEditor(Object.class, null);
              initTable();
               this.setLocationRelativeTo(null);
               this.ma = ma;
       loadDataToTable1();
        }
     
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã Hóa Đơn", "Ngày Hóa Đơn", "Trị Giá","Tình Trạng", "Mã Căn Hộ"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTableHoadon.setModel(tblModel);
        
        
         jTableHoadon.setRowHeight(25);
        jTableHoadon.setFont(new Font("Arial", Font.PLAIN, 12));

        // Alternating row colors
        jTableHoadon.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        jTableHoadon.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableHoadon.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTableHoadon.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableHoadon.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableHoadon.getColumnModel().getColumn(4).setPreferredWidth(30);

         
    }
      public void changeTextFind() {
        txttracuuhd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if(ma.equals("")) {
                    if (txttracuuhd.getText().length() == 0) {
                   
                        loadDataToTable();
                    
                        
                    }
                } else {
                    if (txttracuuhd.getText().length() == 0) {
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
    public ArrayList<Modelhoadon> searchFn( String content) {
        ArrayList<MODEL.Modelhoadon> result = new ArrayList<>();
        Timhoadon timhdon = new Timhoadon();
        result = timhdon.searchMAHD(content);
            
            
        
        return result;
    }
    
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    
    public MODEL.Modelhoadon getDetail() {
        MODEL.Modelhoadon a = Daohoadon.getInstance().selectById(getHOADONSelect().getMAHD());
        return a;
    }
    public MODEL.Modelhoadon getHOADONSelect() {
        int i_row = jTableHoadon.getSelectedRow();
        MODEL.Modelhoadon hoadon = Daohoadon.getInstance().selectAll().get(i_row);
        return hoadon;
    }
    public void loadDataToTable() {
        try {
            Daohoadon daohd = new Daohoadon();
            ArrayList<MODEL.Modelhoadon> arms = daohd.selectAll();
            tblModel.setRowCount(0);
            for (MODEL.Modelhoadon i : arms ) {
                tblModel.addRow(new Object[]{
                    i.getMAHD(), i.getNGAYHD(),formatNumber(i.getTRIGIA()), i.getTINHTRANG() ,i.getMACH()            
            }
            );
        }
        } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     
     public void loadDataToTable1() {
    try {
        Daohoadon daohd = new Daohoadon();
        ArrayList<MODEL.Modelhoadon> arms = daohd.selectHDByMANV(ma);
        tblModel.setRowCount(0);
        for (MODEL.Modelhoadon i : arms ) {
            tblModel.addRow(new Object[]{
                    i.getMAHD(), i.getNGAYHD(),formatNumber(i.getTRIGIA()), i.getTINHTRANG() ,i.getMACH()            
            }
            );
        }
    } catch (Exception e) {
        System.err.println(e.toString());
        
    }
}
     
     public void loadDataToTableSearch(ArrayList<MODEL.Modelhoadon> result) {
        try {
            tblModel.setRowCount(0);
            for (MODEL.Modelhoadon i : result) {
                tblModel.addRow(new Object[]{
                    i.getMAHD(), i.getNGAYHD(),formatNumber(i.getTRIGIA()), i.getTINHTRANG() ,i.getMACH()            
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

        jPanel2 = new javax.swing.JPanel();
        btnthemhd = new javax.swing.JButton();
        btnxoahd = new javax.swing.JButton();
        btntracuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHoadon = new javax.swing.JTable();
        labQLHD = new javax.swing.JLabel();
        txttracuuhd = new javax.swing.JTextField();
        jButtontrangchu = new javax.swing.JButton();
        jTextmahdtim = new javax.swing.JTextField();
        jButtonxemcthd = new javax.swing.JButton();
        btnXuathd = new javax.swing.JButton();
        btnCapnhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(55, 139, 167));
        jPanel2.setForeground(new java.awt.Color(196, 233, 245));

        btnthemhd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnthemhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-properties-30.png"))); // NOI18N
        btnthemhd.setText("Thêm");
        btnthemhd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthemhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhdActionPerformed(evt);
            }
        });

        btnxoahd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnxoahd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btnxoahd.setText("Xóa");
        btnxoahd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxoahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoahdActionPerformed(evt);
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

        jTableHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Hóa Đơn", "Trị Giá", "Tình Trạng", "Mã Căn Hộ"
            }
        ));
        jTableHoadon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableHoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHoadonMouseClicked(evt);
            }
        });
        jTableHoadon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableHoadonKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHoadon);

        labQLHD.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labQLHD.setForeground(new java.awt.Color(255, 255, 255));
        labQLHD.setText("QUẢN LÝ HOÁ ĐƠN");

        txttracuuhd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttracuuhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttracuuhdActionPerformed(evt);
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

        jTextmahdtim.setEditable(false);
        jTextmahdtim.setText("MAHD");
        jTextmahdtim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextmahdtim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextmahdtimActionPerformed(evt);
            }
        });

        jButtonxemcthd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonxemcthd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-eye-30.png"))); // NOI18N
        jButtonxemcthd.setText("Chi tiết hoá đơn");
        jButtonxemcthd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonxemcthd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonxemcthdActionPerformed(evt);
            }
        });

        btnXuathd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnXuathd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-export-30.png"))); // NOI18N
        btnXuathd.setText("Xuất hóa đơn");
        btnXuathd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuathd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuathdActionPerformed(evt);
            }
        });

        btnCapnhat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-item (2).png"))); // NOI18N
        btnCapnhat.setText("Cập nhật");
        btnCapnhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jTextmahdtim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txttracuuhd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtontrangchu)
                        .addGap(279, 279, 279)
                        .addComponent(labQLHD)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButtonxemcthd)
                        .addGap(55, 55, 55)
                        .addComponent(btnthemhd)
                        .addGap(61, 61, 61)
                        .addComponent(btnCapnhat)
                        .addGap(68, 68, 68)
                        .addComponent(btnxoahd)
                        .addGap(58, 58, 58)
                        .addComponent(btnXuathd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labQLHD)
                    .addComponent(jButtontrangchu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntracuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttracuuhd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextmahdtim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemhd)
                    .addComponent(btnxoahd)
                    .addComponent(jButtonxemcthd)
                    .addComponent(btnXuathd)
                    .addComponent(btnCapnhat))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhdActionPerformed
        if(ma.equals("")) {
            Viewnhapch viewmach=new Viewnhapch();
            viewmach.show();
            dispose();
        } else {
            Viewnhapch viewmach=new Viewnhapch(ma);
            viewmach.show();
            dispose();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnthemhdActionPerformed

    private void btnxoahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoahdActionPerformed
    if(ma.equals("")){    
    if (jTableHoadon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá hóa đơn", "Xác nhận xoá hóa đơn", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                Daocthd.getInstance().delete(getHOADONSelect());
                Daohoadon.getInstance().delete(getHOADONSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                
                    loadDataToTable();
          
                 
                
            }
        }
    }
    else 
    {
        if (jTableHoadon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá hóa đơn", "Xác nhận xoá hóa đơn", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                Daocthd.getInstance().delete(getHOADONSelect());
                Daohoadon.getInstance().delete(getHOADONSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                
                    loadDataToTable1();
          
                 
                
            }
        }
    }
    }//GEN-LAST:event_btnxoahdActionPerformed

    private void btntracuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntracuuMouseClicked

        // TODO add your handling code here:
       
        String content = txttracuuhd.getText();
        ArrayList<MODEL.Modelhoadon> result = searchFn(content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_btntracuuMouseClicked

    private void btntracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuActionPerformed
     
        if(ma.equals("")) {
            loadDataToTable();
        } else {
            loadDataToTable1();
        }
    }//GEN-LAST:event_btntracuuActionPerformed

    private void jTableHoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHoadonMouseClicked
                // TODO add your handling code here:
    }//GEN-LAST:event_jTableHoadonMouseClicked

    private void jTableHoadonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableHoadonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableHoadonKeyReleased

    private void txttracuuhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttracuuhdActionPerformed
        // TODO add your handling code here:
       
        String content = txttracuuhd.getText();
        ArrayList<MODEL.Modelhoadon> result = searchFn( content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txttracuuhdActionPerformed

    private void jButtontrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontrangchuActionPerformed
        if(ma.equals("")){
            ViewMenubql viewbql= new ViewMenubql();
            viewbql.show();
            dispose();
        } else {
            ViewMenunhanvien viewnv= new ViewMenunhanvien(ma);
            viewnv.show();
            dispose();
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButtontrangchuActionPerformed

    private void jTextmahdtimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextmahdtimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextmahdtimActionPerformed

    private void jButtonxemcthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonxemcthdActionPerformed
    if(ma.equals("")) {
        if (jTableHoadon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xem");
        } else {
          int selectedRow = jTableHoadon.getSelectedRow();
           String mahd = jTableHoadon.getValueAt(selectedRow, 0).toString();
            Viewcthd frame = new Viewcthd(mahd);
            frame.setVisible(true);
            dispose();
        }  
    
    } else {
        if (jTableHoadon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xem");
        } else {
          int selectedRow = jTableHoadon.getSelectedRow();
           String mahd = jTableHoadon.getValueAt(selectedRow, 0).toString();
            Viewcthd frame = new Viewcthd(mahd, ma);
            frame.setVisible(true);dispose();
        }  
   
    }// TODO add your handling code here:
    }//GEN-LAST:event_jButtonxemcthdActionPerformed

    private void btnXuathdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuathdActionPerformed
        Xuathoadon xuat = new Xuathoadon();
        xuat.writePhieuXuat(this.getDetail().getMAHD());
    }//GEN-LAST:event_btnXuathdActionPerformed

    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        if (ma.equals("")) { 
        if (jTableHoadon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần cập nhật tình trạng");
        } else {
             Modelhoadon hd = this.getDetail();
             if (hd.getTINHTRANG().equals("Da thanh toan")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn chưa thanh toán");

             } else {
             Daohoadon dao=new Daohoadon();
             
                 try {
                     dao.updateTinhTrangHoadon(hd.getMAHD());
                 } catch (SQLException ex) {
                     Logger.getLogger(Viewhoadon.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
            
                Viewhoadon frame = new Viewhoadon();
            frame.setVisible(true);
            dispose();
             
                
            
        }
         }
        }
        else 
        {
                if (jTableHoadon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần cập nhật tình trạng");
        } else {
             Modelhoadon hd = this.getDetail();
             if (hd.getTINHTRANG().equals("Da thanh toan")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn chưa thanh toán");

             } else {
             Daohoadon dao=new Daohoadon();
             
                 try {
                     dao.updateTinhTrangHoadon(hd.getMAHD());
                 } catch (SQLException ex) {
                     Logger.getLogger(Viewhoadon.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
            
                Viewhoadon frame = new Viewhoadon();
            frame.setVisible(true);
            dispose();
             
                
            
        }
                }
             Viewhoadon frame = new Viewhoadon(ma);
            frame.setVisible(true);
            dispose();   
                }
    }//GEN-LAST:event_btnCapnhatActionPerformed

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
            java.util.logging.Logger.getLogger(Viewhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewhoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnXuathd;
    private javax.swing.JButton btnthemhd;
    private javax.swing.JButton btntracuu;
    private javax.swing.JButton btnxoahd;
    private javax.swing.JButton jButtontrangchu;
    private javax.swing.JButton jButtonxemcthd;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHoadon;
    private javax.swing.JTextField jTextmahdtim;
    private javax.swing.JLabel labQLHD;
    private javax.swing.JTextField txttracuuhd;
    // End of variables declaration//GEN-END:variables
}
