 
package View;

import MODEL.ModelChart;
import DAO.DaoChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.chart.ui.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewChart extends javax.swing.JFrame {
    private JComboBox<String> comboBox;
    private DaoChart daoChart;
    private ChartPanel chartPanel;
  
    public ViewChart(String title) {
         
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        daoChart = new DaoChart();
        
        comboBox = new JComboBox<>();
        List<String> monthYears = daoChart.getAllMonthYears();
        for (String monthYear : monthYears) {
            comboBox.addItem(monthYear);
        }
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart();
            }
        });
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton btnQuayLai = new JButton("Trang chủ");
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });
        backPanel.add(btnQuayLai);
        backPanel.setBackground(new Color(55, 139, 167));
        add(backPanel, BorderLayout.WEST);
         
        
        JPanel newpanel = new JPanel();
         newpanel.setBackground(new Color(55, 139, 167));
        newpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton btnDoanhThu = new JButton("Thống Kê Doanh Thu");
        
        newpanel.add(btnDoanhThu);

        add(newpanel, BorderLayout.EAST);
        
        
        
        
        
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(55, 139, 167));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Chọn tháng/năm:"));
        topPanel.add(comboBox);
        add(topPanel, BorderLayout.NORTH);

       
        btnDoanhThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDoanhThuView();
            }
        });
        

        chartPanel = new ChartPanel(null);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        add(chartPanel, BorderLayout.CENTER);

        updateChart();
        pack();
        setLocationRelativeTo(null);
    }

    private void updateChart() {
        String selectedMonthYear = (String) comboBox.getSelectedItem();
        List<ModelChart> data = daoChart.getDataByMonthYear(selectedMonthYear);
        DefaultCategoryDataset dataset = createDataset(data);
        JFreeChart chart = createChart(dataset);
        chartPanel.setChart(chart);
    }

    private DefaultCategoryDataset createDataset(List<ModelChart> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (ModelChart model : data) {
            dataset.addValue(model.getTrigia(), "Trigia", model.getMACH());
        }
        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ Trị giá Hóa đơn theo Mã căn hộ",
                "Mã căn hộ",
                "Trị giá",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(79, 129, 189)); // Màu xanh dương
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);

        return chart;
    }
        
    private void openDoanhThuView() {
        // Mở View doanh thu
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               Viewdoanhthu viewdoanhthu = new Viewdoanhthu("Thống kê Doanh thu theo năm");
                viewdoanhthu.pack();
                UIUtils.centerFrameOnScreen(viewdoanhthu);
                viewdoanhthu.setVisible(true);
            }
        });

        // Đóng ViewChart hiện tại
        dispose();
    }
    private void goBack() {
        // Quay lại màn hình trước
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Tạo instance của JFrame muốn quay lại, ở đây là Viewdoanhthu
                ViewMenubql viewdoanhthu = new ViewMenubql();
                viewdoanhthu.setVisible(true);
            }
        });

        // Đóng ViewChart hiện tại
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewChart viewChart = new ViewChart("Thống kê Trị giá Hóa đơn theo Mã căn hộ");
                viewChart.pack();
                UIUtils.centerFrameOnScreen(viewChart);
                viewChart.setVisible(true);
            }
        });
    }
}





/*

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(196, 233, 245));
        jPanel1.setForeground(new java.awt.Color(196, 233, 245));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
*/