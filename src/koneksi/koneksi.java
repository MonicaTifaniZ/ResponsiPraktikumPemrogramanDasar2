/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class koneksi {

    private static Connection konekin;

    public static Connection getConnection() { //getConnection nama var
        if (konekin == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                konekin = DriverManager.getConnection("jdbc:mysql://localhost:3306/responsiprakpd2", "root", ""); // jdbc blabla = alamatnya , 3306 = defaultnya , root = user login db, "" = password default
            } catch (SQLException sqlex) {
                JOptionPane.showMessageDialog(null, sqlex.getMessage());
            }
        }
        return konekin;
    }
}
