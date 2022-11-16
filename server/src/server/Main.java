/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chivu
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
            Server server = new Server(10, connection);
            server.run();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
