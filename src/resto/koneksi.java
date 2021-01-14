/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class koneksi 
{
    Connection koneksi;
    public String url = "oracle.jdbc.OracleDriver";
    public String database = "jdbc:oracle:thin:@localhost:1521:XE";
    
    public String username = "uaspbd";
    public String password = "uas";
    public Connection getConnection(){
        try {
            Class.forName(url);
            koneksi = DriverManager.getConnection(database, username, password);
            System.out.println("Berhasil");
            //JOptionPane.showMessageDialog(null, "Koneksi ke database Berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database GAGAl", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return koneksi;
    }
}
