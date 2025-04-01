/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DAO.Daocanho;
import DAO.Daocthd;
import DAO.Daohoadon;
import MODEL.Modelcanho;
import MODEL.Modelcthd;
import MODEL.Modelhoadon;
import MODEL.Modeldienke;
import MODEL.Modeldonghonuoc;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;




public class Xuathoadon {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public Xuathoadon() {
        try {
            fontData = new Font(BaseFont.createFont("Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Xuathoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writePhieuXuat(String mahd) {
        String url = "";
        try {
            fd.setTitle("In hoá đơn căn hộ");
            fd.setLocationRelativeTo(null);
            url = getFile(mahd);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN HOÁ ĐƠN CĂN HỘ");

            Modelhoadon hd = Daohoadon.getInstance().selectById(mahd);
            Modelcanho ch = Daocanho.getInstance().selectByInvoiceId(mahd);
            Modeldienke dk = new Modeldienke();
            try {
                dk = Daocanho.getInstance().getDKByMACH(ch.getMACH());
            } catch (SQLException ex) {
                Logger.getLogger(Xuathoadon.class.getName()).log(Level.SEVERE, null, ex);
            }
            Modeldonghonuoc dhn = new Modeldonghonuoc();
            try {
                dhn = Daocanho.getInstance().getDHNByMACH(ch.getMACH());
            } catch (SQLException ex) {
                Logger.getLogger(Xuathoadon.class.getName()).log(Level.SEVERE, null, ex);
            }
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = new Date();
            try {
                date = sdf.parse(hd.getNGAYHD());
            } catch (ParseException ex) {
                Logger.getLogger(Xuathoadon.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            Paragraph p1 = new Paragraph(new Phrase("Mã hoá đơn: " + mahd, fontData));
            Paragraph p2 = new Paragraph(new Phrase("Thời gian tạo: " + sqlDate, fontData));
            Paragraph p3 = new Paragraph(new Phrase("Mã căn hộ: " + ch.getMACH(), fontData));
            Paragraph p4 = new Paragraph(new Phrase("Mã cư dân: " + ch.getMACD(), fontData));
            Paragraph p5 = new Paragraph (new Phrase("Tình trạng: " +hd.getTINHTRANG(), fontData));

            
            p1.setIndentationLeft(40);
            p2.setIndentationLeft(40);
            p3.setIndentationLeft(40);
            p4.setIndentationLeft(40);
            p5.setIndentationLeft(40);
            document.add(p1);
            document.add(p2);
            document.add(p3);
            document.add(p4);
            document.add(p5);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(4);
            pdfTable.setWidths(new float[]{ 30f, 15f, 15f, 15f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Tên loại phí", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Thành tiền", fontHeader)));

            for (int i = 0; i < 4; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            pdfTable.addCell(new PdfPCell(new Phrase("Giá Thuê Chung Cư", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getGiaThue()) + "đ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase("1", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getGiaThue()) + "đ", fontData)));

            pdfTable.addCell(new PdfPCell(new Phrase("Giá Xe", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getGIAXE()) + "đ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getSLXE()), fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getGIAXE()*ch.getSLXE()) + "đ", fontData)));

            pdfTable.addCell(new PdfPCell(new Phrase("Giá Dịch Vụ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getPHIDV()) + "đ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase("1", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ch.getPHIDV()) + "đ", fontData)));

            pdfTable.addCell(new PdfPCell(new Phrase("Tiền Điện", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(dk.getGIADIEN()) + "đ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(dk.getCSS()-dk.getCST()), fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(dk.getGIADIEN()*(dk.getCSS()-dk.getCST())) + "đ", fontData)));

            pdfTable.addCell(new PdfPCell(new Phrase("Tiền Nước", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(dhn.getGIANUOC()) + "đ", fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(dhn.getCSS()-dhn.getCST()), fontData)));
            pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(dhn.getGIANUOC()*(dhn.getCSS()-dhn.getCST())) + "đ", fontData)));
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(hd.getTRIGIA()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }
}
