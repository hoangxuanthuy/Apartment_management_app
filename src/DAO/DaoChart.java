/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.OracleJDBCconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import MODEL.ModelChart;

public class DaoChart {
  public List<ModelChart> getDataByMonthYear(String monthYear) {
        List<ModelChart> dataList = new ArrayList<>();
        String query = "SELECT MACH, SUM(TRIGIA) AS TOTAL_TRIGIA " +
                       "FROM HOADON " +
                       "WHERE TO_CHAR(NGAYHD, 'MM/YYYY') = ? " +
                       "AND TINHTRANG = 'Da thanh toan' "+
                       "GROUP BY MACH";

        try (Connection connection = OracleJDBCconnection.getJDBCconnection();
             PreparedStatement statement = connection.prepareStatement(query)){
             statement.setString(1, monthYear);
             ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maCH = resultSet.getString("MACH");
                double totalTrigia = resultSet.getDouble("TOTAL_TRIGIA");
                dataList.add(new ModelChart(maCH, totalTrigia));
            }
}  catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
public List<String> getAllMonthYears() {
        List<String> monthYearList = new ArrayList<>();
        String query = "SELECT DISTINCT TO_CHAR(NGAYHD, 'MM/YYYY') AS MONTH_YEAR FROM HOADON ORDER BY MONTH_YEAR";

        try (Connection connection = OracleJDBCconnection.getJDBCconnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                monthYearList.add(resultSet.getString("MONTH_YEAR"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monthYearList;
    }

   

    public List<String> getAllMaCH() {
       List<String> maCHList = new ArrayList<>();
        String query = "SELECT DISTINCT MACH FROM HOADON ORDER BY MACH";

        try (Connection connection = OracleJDBCconnection.getJDBCconnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                maCHList.add(resultSet.getString("MACH"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maCHList;
    }
}