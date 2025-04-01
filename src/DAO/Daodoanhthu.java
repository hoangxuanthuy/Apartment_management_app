/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Database.OracleJDBCconnection;

import MODEL.Modeldoanhthu;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Daodoanhthu {


    public List<Modeldoanhthu> getDataByYear(String year) {
        List<Modeldoanhthu> dataList = new ArrayList<>();
        String query = "SELECT TINHTRANG, SUM(TRIGIA) AS DOANH_THU " +
                       "FROM HOADON " +
                       "WHERE TO_CHAR(NGAYHD, 'YYYY') = ? " +
                       "GROUP BY TINHTRANG";

         try (Connection connection = OracleJDBCconnection.getJDBCconnection();
             PreparedStatement statement = connection.prepareStatement(query)){
             statement.setString(1, year);
             ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String tinhTrang = resultSet.getString("TINHTRANG");
                double totalTrigia = resultSet.getDouble("DOANH_THU");
                dataList.add(new Modeldoanhthu(tinhTrang, totalTrigia));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public List<String> getAllYears() {
        List<String> yearList = new ArrayList<>();
        String query = "SELECT DISTINCT TO_CHAR(NGAYHD, 'YYYY') AS YEAR FROM HOADON ORDER BY YEAR";

        try (Connection connection = OracleJDBCconnection.getJDBCconnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                yearList.add(resultSet.getString("YEAR"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yearList;
    }
}
