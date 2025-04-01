package View;

import MODEL.Modeldoanhthu;
import DAO.Daodoanhthu;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;

import org.jfree.chart.ui.UIUtils;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Viewdoanhthu extends JFrame {
   
    private JComboBox<String> yearComboBox;
    private Daodoanhthu daoChart;
    private ChartPanel chartPanel;
  
    public Viewdoanhthu(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
         this.setLocationRelativeTo(null);
        daoChart = new Daodoanhthu();

        yearComboBox = new JComboBox<>();
        List<String> years = daoChart.getAllYears();
        for (String year : years) {
            yearComboBox.addItem(year);
        }
        yearComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart();
            }
        });
        JPanel backPanel = new JPanel();
        backPanel.setBackground(new Color(55, 139, 167));
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton btnQuayLai = new JButton("Quay lại");
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });
        backPanel.add(btnQuayLai);

        add(backPanel, BorderLayout.WEST);
        
        
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(55, 139, 167));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Chọn năm:"));
        topPanel.add(yearComboBox);
        add(topPanel, BorderLayout.NORTH);

        chartPanel = new ChartPanel(null);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        add(chartPanel, BorderLayout.CENTER);

        updateChart();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void updateChart() {
        String selectedYear = (String) yearComboBox.getSelectedItem();
        List<Modeldoanhthu> data = daoChart.getDataByYear(selectedYear);
        DefaultPieDataset dataset = createDataset(data);
        JFreeChart chart = createChart(dataset);
        chartPanel.setChart(chart);
    }

    private DefaultPieDataset createDataset(List<Modeldoanhthu> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Modeldoanhthu model : data) {
            dataset.setValue(model.getTinhTrang(), model.getTrigia());
        }
        return dataset;
    }
       private void goBack() {
        // Quay lại màn hình trước
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Tạo instance của JFrame muốn quay lại, ở đây là Viewdoanhthu
                ViewChart viewchart = new ViewChart("Thống kê Trị giá Hóa đơn theo Mã căn hộ");
                viewchart.setVisible(true);
            }
        });

        // Đóng ViewChart hiện tại
        dispose();
    }
    private JFreeChart createChart(DefaultPieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ Doanh thu theo năm",
                dataset,
                true, true, false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Da thanh toan", new Color(153, 153, 255)); // Màu tím nhạt
        plot.setSectionPaint("Chua thanh toan", new Color(255, 255, 102)); // Màu đỏ

        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlinePaint(null);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 15));
        plot.setNoDataMessage("No data available");

        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {1} VNĐ")); // Format nhãn

        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Viewdoanhthu viewdoanhthu = new Viewdoanhthu("Thống kê Doanh thu theo năm");
                viewdoanhthu.pack();
                UIUtils.centerFrameOnScreen(viewdoanhthu);
                viewdoanhthu.setVisible(true);
            }
        });
    }
}

/*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
} */
