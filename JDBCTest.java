package com.balafoutas.test;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCXYDataset;

import com.balafoutas.util.MysqlHandler;

public class JDBCTest {

    public static void display() {
        JFrame f = new JFrame("Gamaw kai dernw");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDBCXYDataset jds = createDataset();
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Ratings", "Date", "Rating", jds, true, true, false);
        f.add(new ChartPanel(chart));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
     
    }

    private static JDBCXYDataset createDataset() {
        try {
            Connection conn = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());
         
            JDBCXYDataset jds = new JDBCXYDataset(conn);
            jds.executeQuery("SELECT date,rating FROM services WHERE employeeid=");
            return jds;
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JDBCTest().display();
            }
        });
    }
}