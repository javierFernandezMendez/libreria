/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataInputStream;
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

    public ServerThread(Connection connection, Socket socket) {
        this.connection = connection;
        this.socket = socket;
    }

    @Override
    public void run() {
        Statement st;
        try {
            do {
                clientMsg = new DataInputStream(socket.getInputStream()).readUTF();
                st = this.connection.createStatement();
                if (clientMsg.startsWith("select")) {
                    ResultSet rs = st.executeQuery(clientMsg);
                    String data = "";
                    while (rs.next()) {
                        try {
                            int cont = 1;
                            while (true) {
                                data = data + String.valueOf(rs.getString(cont)) + ",";
                                cont++;
                            }
                        } catch (Exception e) {
                            data = data + ";";
                        }
                    }
                    new DataOutputStream(socket.getOutputStream()).writeUTF(data);
                    
                } else if (clientMsg.startsWith("insert")) {
                    st.executeUpdate(clientMsg);
                } else if (clientMsg.startsWith("delete")) {
                    st.executeUpdate(clientMsg);
                    new DataOutputStream(socket.getOutputStream()).writeUTF("deleted");
                } else if (clientMsg.startsWith("update")) {
                    st.executeUpdate(clientMsg);
                    new DataOutputStream(socket.getOutputStream()).writeUTF("updated");
                }
            } 
            while (!clientMsg.equals("close"));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + ex.getErrorCode());
            if(ex.getErrorCode() == 1451){
                try {
                    new DataOutputStream(socket.getOutputStream()).writeUTF("not deleted cause of foreing key");
                } catch (IOException ex1) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
