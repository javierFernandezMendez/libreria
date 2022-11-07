/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;

/**
 *
 * @author chivu
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ServerConnection sc = new ServerConnection(10);
         System.out.println(sc.query("soy cliente"));
    }
    
  
}
