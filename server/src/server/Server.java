/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.sql.Statement;
import java.sql.Connection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chivu
 */
public class Server implements Runnable{
    private ServerSocket socket;
    private Connection connection;
    
    Server(int puerto, Connection connection){
        this.connection = connection;
        try {
            socket = new ServerSocket(puerto);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            Socket sc;
            String clientMsg;
            Statement st;
            do{
            sc = socket.accept();
            clientMsg = new DataInputStream(sc.getInputStream()).readUTF();
            System.out.println(clientMsg);
            st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(clientMsg);
            String data = "";
            while(rs.next()){
                data = data + String.valueOf(rs.getInt("id")) + "," + rs.getString("name") + ";";
            }
            new DataOutputStream(sc.getOutputStream()).writeUTF(data);
            }
            while(!clientMsg.equals("close"));
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
