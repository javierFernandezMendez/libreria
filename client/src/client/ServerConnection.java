/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author chivu
 */
public class ServerConnection {
    private Socket sc;
    private static DataOutputStream out;
    private static DataInputStream in;
    
    public ServerConnection(int port) throws IOException {
        sc = new Socket("192.168.8.128", port);
        out = new DataOutputStream(sc.getOutputStream());
        in = new DataInputStream(sc.getInputStream());
        
    }
    
    public String query(String data){
        try {
            out.writeUTF(data);
            return in.readUTF();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public boolean insert(String data){
        try {
            out.writeUTF(data);
            return true;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    public String delete(String data){
        try {
            out.writeUTF(data);
            return in.readUTF();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public String update(String data){
        try {
            out.writeUTF(data);
            return in.readUTF();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public Object informe(String num){
        try {
            out.writeUTF("informe"+num);
            return new ObjectInputStream(sc.getInputStream()).readObject();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public void close(){
        try {
            out.writeUTF("close");
            sc.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
