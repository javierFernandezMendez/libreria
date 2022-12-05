/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author chivu
 */
public class ServerConnection {
    private Socket sc;
    private static DataOutputStream out;
    private static DataInputStream in;
    
    public ServerConnection(int port) throws IOException {
        sc = new Socket("127.0.0.1", port);
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
    
    public void close() throws IOException{
        out.writeUTF("close");
        sc.close();
    }
    
}
