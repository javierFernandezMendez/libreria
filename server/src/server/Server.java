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
public class Server{
    private ServerSocket serverSocket;
    private Connection connection;
    private Socket socket;
    private String clientMsg = "";
    
    Server(Connection connection, ServerSocket serverSocket){
        this.connection = connection;
        this.serverSocket = serverSocket;
        recieveClients();
    }

    private void recieveClients(){
        try {
            do{
                socket = serverSocket.accept();
                clientMsg = new DataInputStream(socket.getInputStream()).readUTF();
                ServerThread thread = new ServerThread(connection, socket, clientMsg);
                thread.run();
            }
            while(!clientMsg.equals("quit"));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
