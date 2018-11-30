/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class koneksi {
    private static Connection konek;
    public static Connection getConnection(){
        if(konek == null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                konek = DriverManager.getConnection("");
                
            } catch (SQLException ex){
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null , ex);
            }
        }
        return konek;
    }
    
}
