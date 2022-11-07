/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chivu
 */
public class Server implements Runnable{
    private ServerSocket socket;

    
    Server(int puerto){
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
            do{
            sc = socket.accept();
            clientMsg = new DataInputStream(sc.getInputStream()).readUTF();
            System.out.println(clientMsg);
            new DataOutputStream(sc.getOutputStream()).writeUTF("datos tabla");
            }
            while(!clientMsg.equals("close"));
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
