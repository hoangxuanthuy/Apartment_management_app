/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.Daocthd;
import DAO.Daohoadon;
import MODEL.Modelcthd;
import MODEL.Modelcanho;
import MODEL.Modeldienke;
import MODEL.Modeldonghonuoc;
import MODEL.Modelhoadon;
import static View.Viewcthd.formatNumber;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinkbook 16
 */
public class Viewthemhoadon extends javax.swing.JFrame {
    String ma="";
    /**
     * Creates new form Viewthemhoadon
     */
    Modelhoadon hoadon = new Modelhoadon();
    Modelcthd cthd = new Modelcthd();
    
    public Viewthemhoadon() {
        initComponents();
        this.setLocationRelativeTo(null);
//        txtMahd.setText(createId());
    }
    
   
    
    public static String formatNumber(double number) {
        // Định dạng số sao cho không có các số 0 ở đầu nhưng tối đa 10 chữ số
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(0); // Không có phần thập phân
        decimalFormat.setMaximumIntegerDigits(10); // Tối đa 10 chữ số

        return decimalFormat.format(number);
    }
    
    public String createId() {
    ArrayList<Modelhoadon> hdAll = Daohoadon.getInstance().selectAll();
    int maxId = 0;
    for (Modelhoadon hd : hdAll) {
        String MAHD = hd.getMAHD();
        if (MAHD.startsWith("HD")) {
            try {
                int id = Integer.parseInt(MAHD.replaceAll("[^\\d]", ""));
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e) {
            }
        }
    }
    return  (String.format("HD%03d", maxId + 1));
}

    Viewthemhoadon(String maCanHo) {
        initComponents();
        setLocationRelativeTo(null);
        txtMahd.setText(createId());
        String mahdon = txtMahd.getText().trim();
        Daohoadon dhd = new Daohoadon();
        Modelhoadon hdon = new Modelhoadon(maCanHo,mahdon);
        Modeldienke dk = new Modeldienke();
        Modeldonghonuoc dhn = new Modeldonghonuoc();
        Modelcanho ch = new Modelcanho();
        Modelcthd ct = new Modelcthd();
        try {
            ct = dhd.getCTHDByMAHD(hdon.getMAHD() , maCanHo);
           } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ch = dhd.getCHByMACH(maCanHo);
 
        } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            dk = dhd.getDKByMACH(maCanHo);
        } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            dhn =dhd.getDHNByMACH(maCanHo);
        } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date currentDate = new Date();

// Định dạng ngày thành chuỗi
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(currentDate);

// Đặt giá trị vào JTextField
        txtNgayhd.setText(formattedDate);
        hdon.setNGAYHD(formattedDate);
        txtMach.setText(ch.getMACH().trim());
        txtGiathue.setText(formatNumber(ch.getGiaThue())+ " ");
        txtSlxe.setText(formatNumber(ch.getSLXE())+ " ");
        txtGiaxe.setText(formatNumber(ch.getGIAXE())+ " ");
        txtTongtienxe.setText(formatNumber((ch.getSLXE()*ch.getGIAXE()))+ " ");
        txtPhidv.setText(formatNumber(ch.getPHIDV())+ " ");
        txtSldien.setText(formatNumber((dk.getCSS()- dk.getCST()))+ " ");
        txtGiadien.setText(formatNumber(dk.getGIADIEN())+ " ");
        txtTiendien.setText(formatNumber((dk.getGIADIEN() * (dk.getCSS()- dk.getCST()))) + " ");
        ct.setTIENDIEN((dk.getGIADIEN() * (dk.getCSS()- dk.getCST())));
        txtSlnuoc.setText(formatNumber((dhn.getCSS()- dhn.getCST()))+ " ");
        txtGianuoc.setText(formatNumber(dhn.getGIANUOC())+ " ");
        txtTiennuoc.setText(formatNumber((dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST()))) + " ");
        ct.setTIENNUOC((dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST())));
        txtTongtien.setText(formatNumber((ch.getGiaThue()+ (ch.getSLXE()*ch.getGIAXE()) + ch.getPHIDV()+ (dk.getGIADIEN() * (dk.getCSS()- dk.getCST()))+ (dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST()))))+ " ");
        hdon.setTRIGIA((ch.getGiaThue()+ (ch.getSLXE()*ch.getGIAXE()) + ch.getPHIDV()+ (dk.getGIADIEN() * (dk.getCSS()- dk.getCST()))+ (dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST()))));
        this.hoadon = hdon;
        this.cthd = ct;
    }
    
    Viewthemhoadon(String maCanHo , String ma) {
        initComponents();
        setLocationRelativeTo(null);
        this.ma = ma ;
        txtMahd.setText(createId());
        String mahdon = txtMahd.getText().trim();
        Daohoadon dhd = new Daohoadon();
        Modelhoadon hdon = new Modelhoadon(maCanHo,mahdon);
        Modeldienke dk = new Modeldienke();
        Modeldonghonuoc dhn = new Modeldonghonuoc();
        Modelcanho ch = new Modelcanho();
        Modelcthd ct = new Modelcthd();
        try {
            ct = dhd.getCTHDByMAHD(hdon.getMAHD() , maCanHo);
           } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ch = dhd.getCHByMACH(maCanHo);
 
        } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            dk = dhd.getDKByMACH(maCanHo);
        } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            dhn =dhd.getDHNByMACH(maCanHo);
        } catch (SQLException ex) {
            Logger.getLogger(Viewthemhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date currentDate = new Date();

// Định dạng ngày thành chuỗi
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(currentDate);

// Đặt giá trị vào JTextField
        txtNgayhd.setText(formattedDate);
        hdon.setNGAYHD(formattedDate);
        txtMach.setText(ch.getMACH().trim());
        txtGiathue.setText(formatNumber(ch.getGiaThue())+ " ");
        txtSlxe.setText(formatNumber(ch.getSLXE())+ " ");
        txtGiaxe.setText(formatNumber(ch.getGIAXE())+ " ");
        txtTongtienxe.setText(formatNumber((ch.getSLXE()*ch.getGIAXE()))+ " ");
        txtPhidv.setText(formatNumber(ch.getPHIDV())+ " ");
        txtSldien.setText(formatNumber((dk.getCSS()- dk.getCST()))+ " ");
        txtGiadien.setText(formatNumber(dk.getGIADIEN())+ " ");
        txtTiendien.setText(formatNumber((dk.getGIADIEN() * (dk.getCSS()- dk.getCST()))) + " ");
        ct.setTIENDIEN((dk.getGIADIEN() * (dk.getCSS()- dk.getCST())));
        txtSlnuoc.setText(formatNumber((dhn.getCSS()- dhn.getCST()))+ " ");
        txtGianuoc.setText(formatNumber(dhn.getGIANUOC())+ " ");
        txtTiennuoc.setText(formatNumber((dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST()))) + " ");
        ct.setTIENNUOC((dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST())));
        txtTongtien.setText(formatNumber((ch.getGiaThue()+ (ch.getSLXE()*ch.getGIAXE()) + ch.getPHIDV()+ (dk.getGIADIEN() * (dk.getCSS()- dk.getCST()))+ (dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST()))))+ " ");
        hdon.setTRIGIA((ch.getGiaThue()+ (ch.getSLXE()*ch.getGIAXE()) + ch.getPHIDV()+ (dk.getGIADIEN() * (dk.getCSS()- dk.getCST()))+ (dhn.getGIANUOC() * (dhn.getCSS()- dhn.getCST()))));
        this.hoadon = hdon;
        this.cthd = ct;
    }
           
            
            
             
//        txtGiathue.setText(formatNumber(ct.getGIATHUE()) + " ");
//        txtPhixe.setText(formatNumber(ct.getPHIXE()) + " ");
//        txtPhidv.setText(formatNumber(ct.getPHIDV()) + " ");
//        txtTiendien.setText(formatNumber(ct.getTIENDIEN()) + " ");
//        txtTiennuoc.setText(formatNumber(ct.getTIENNUOC()) + " ");
//        txtTongtien.setText(formatNumber(hd.getTRIGIA()) + " ");
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMahoadon = new javax.swing.JLabel();
        jLabelNgayhd = new javax.swing.JLabel();
        jLabelMach = new javax.swing.JLabel();
        txtMahd = new javax.swing.JTextField();
        txtNgayhd = new javax.swing.JTextField();
        txtMach = new javax.swing.JTextField();
        btnThemhd = new javax.swing.JButton();
        btnQuaylai = new javax.swing.JButton();
        jLabelGiathue = new javax.swing.JLabel();
        jLabelSlxe = new javax.swing.JLabel();
        jLabelGiaxe = new javax.swing.JLabel();
        jLabelPhixe = new javax.swing.JLabel();
        jLabelPhidv = new javax.swing.JLabel();
        jLabelSl = new javax.swing.JLabel();
        jLabelGiatien = new javax.swing.JLabel();
        jLabelDien = new javax.swing.JLabel();
        jLabelNuoc = new javax.swing.JLabel();
        jLabelTongtien = new javax.swing.JLabel();
        txtSldien = new javax.swing.JTextField();
        txtGiadien = new javax.swing.JTextField();
        txtSlnuoc = new javax.swing.JTextField();
        txtGianuoc = new javax.swing.JTextField();
        jLabelThanhtien = new javax.swing.JLabel();
        txtTiendien = new javax.swing.JTextField();
        txtTiennuoc = new javax.swing.JTextField();
        txtGiathue = new javax.swing.JTextField();
        txtSlxe = new javax.swing.JTextField();
        txtGiaxe = new javax.swing.JTextField();
        txtTongtienxe = new javax.swing.JTextField();
        txtPhidv = new javax.swing.JTextField();
        txtTongtien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 139, 167));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelMahoadon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMahoadon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMahoadon.setText("Mã Hóa Đơn");

        jLabelNgayhd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNgayhd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNgayhd.setText("Ngày Hóa Đơn");

        jLabelMach.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelMach.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMach.setText("Mã Căn Hộ");

        txtMahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMahdActionPerformed(evt);
            }
        });

        txtNgayhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayhdActionPerformed(evt);
            }
        });

        btnThemhd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnThemhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-properties-30.png"))); // NOI18N
        btnThemhd.setText("Thêm");
        btnThemhd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemhd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemhdMouseClicked(evt);
            }
        });
        btnThemhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemhdActionPerformed(evt);
            }
        });

        btnQuaylai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-left-50.png"))); // NOI18N
        btnQuaylai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        jLabelGiathue.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelGiathue.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGiathue.setText("Giá Thuê");

        jLabelSlxe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelSlxe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSlxe.setText("Số Lượng Xe");

        jLabelGiaxe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelGiaxe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGiaxe.setText("Giá Xe");

        jLabelPhixe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPhixe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPhixe.setText("Tổng Tiền Xe");

        jLabelPhidv.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPhidv.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPhidv.setText("Phí Dịch Vụ");

        jLabelSl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelSl.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSl.setText("Số Lượng");

        jLabelGiatien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelGiatien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGiatien.setText("Giá Tiền");

        jLabelDien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelDien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDien.setText("Điện");

        jLabelNuoc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNuoc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNuoc.setText("Nước");

        jLabelTongtien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTongtien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTongtien.setText("Tổng Tiền");

        jLabelThanhtien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelThanhtien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThanhtien.setText("Thành Tiền");

        txtGiathue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiathueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNgayhd, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(jLabelMahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelGiathue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelSlxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelGiaxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPhixe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPhidv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelDien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSl, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSldien, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSlnuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtGiadien, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                    .addComponent(txtGianuoc)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabelGiatien)))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTiennuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                            .addComponent(txtTiendien, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabelThanhtien))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMahd)
                                            .addComponent(txtNgayhd)
                                            .addComponent(txtMach)
                                            .addComponent(txtGiathue)
                                            .addComponent(txtSlxe)
                                            .addComponent(txtGiaxe)
                                            .addComponent(txtTongtienxe)
                                            .addComponent(txtPhidv, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))))
                            .addComponent(jLabelTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemhd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnQuaylai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnQuaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMahoadon)
                    .addComponent(txtMahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNgayhd)
                    .addComponent(txtNgayhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMach)
                    .addComponent(txtMach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGiathue)
                    .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSlxe)
                    .addComponent(txtSlxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGiaxe)
                    .addComponent(txtGiaxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPhixe)
                    .addComponent(txtTongtienxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPhidv)
                    .addComponent(txtPhidv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSl)
                    .addComponent(jLabelGiatien)
                    .addComponent(jLabelThanhtien))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDien)
                    .addComponent(txtSldien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiadien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiendien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNuoc)
                    .addComponent(txtSlnuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGianuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiennuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTongtien)
                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThemhd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
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

    private void txtMahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMahdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMahdActionPerformed

    private void txtNgayhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayhdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayhdActionPerformed

    private void btnThemhdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemhdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemhdMouseClicked

    private void btnThemhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemhdActionPerformed
         try {
          Daohoadon themhd= new Daohoadon();
          Daocthd themcthd = new Daocthd();
          themhd.addhoadon(this.hoadon);
          themcthd.addcthd(this.cthd);

            // Optionally display a success message or update UI
            JOptionPane.showMessageDialog(null, "Hóa đơn đã được thêm thành công!");

            // Optionally clear input fields or update UI
            if(ma.equals("")) {
                Viewhoadon viewhdon= new Viewhoadon();
                viewhdon.show();
                dispose();
            } else {
                Viewhoadon viewhdon= new Viewhoadon(ma);
                viewhdon.show();
                dispose();
            }

            // Update UI to reflect changes
            // You may need to refresh the table or list displaying the data

        } catch (Exception ex) {
            // Handle any errors or exceptions (e.g., display error message)
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm Hóa đơn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemhdActionPerformed

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        if(ma.equals("")) {
            Viewhoadon viewhdon=new Viewhoadon();
            viewhdon.show();
            dispose();
        } else {
            Viewhoadon viewhdon=new Viewhoadon(ma);
            viewhdon.show();
            dispose();
        }
    }//GEN-LAST:event_btnQuaylaiActionPerformed

    private void txtGiathueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiathueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiathueActionPerformed

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
            java.util.logging.Logger.getLogger(Viewthemhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewthemhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewthemhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewthemhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewthemhoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JButton btnThemhd;
    private javax.swing.JLabel jLabelDien;
    private javax.swing.JLabel jLabelGiathue;
    private javax.swing.JLabel jLabelGiatien;
    private javax.swing.JLabel jLabelGiaxe;
    private javax.swing.JLabel jLabelMach;
    private javax.swing.JLabel jLabelMahoadon;
    private javax.swing.JLabel jLabelNgayhd;
    private javax.swing.JLabel jLabelNuoc;
    private javax.swing.JLabel jLabelPhidv;
    private javax.swing.JLabel jLabelPhixe;
    private javax.swing.JLabel jLabelSl;
    private javax.swing.JLabel jLabelSlxe;
    private javax.swing.JLabel jLabelThanhtien;
    private javax.swing.JLabel jLabelTongtien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtGiadien;
    private javax.swing.JTextField txtGianuoc;
    private javax.swing.JTextField txtGiathue;
    private javax.swing.JTextField txtGiaxe;
    private javax.swing.JTextField txtMach;
    private javax.swing.JTextField txtMahd;
    private javax.swing.JTextField txtNgayhd;
    private javax.swing.JTextField txtPhidv;
    private javax.swing.JTextField txtSldien;
    private javax.swing.JTextField txtSlnuoc;
    private javax.swing.JTextField txtSlxe;
    private javax.swing.JTextField txtTiendien;
    private javax.swing.JTextField txtTiennuoc;
    private javax.swing.JTextField txtTongtien;
    private javax.swing.JTextField txtTongtienxe;
    // End of variables declaration//GEN-END:variables
}
