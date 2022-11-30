/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chivu
 */
public class ServerThread implements Runnable {

    private Connection connection;
    private Socket socket;
    private String clientMsg;

    public ServerThread(Connection connection, Socket socket, String clientMsg) {
        this.connection = connection;
        this.socket = socket;
        this.clientMsg = clientMsg;
    }

    @Override
    public void run() {
        Statement st;
        try {
            st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(clientMsg);
            String data = "";
            while (rs.next()) {
                data = data + String.valueOf(rs.getInt("id")) + "," + rs.getString("name") + ";";
            }
            new DataOutputStream(socket.getOutputStream()).writeUTF(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
