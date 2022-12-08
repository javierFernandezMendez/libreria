/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperReport;

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
                } else if (clientMsg.startsWith("informe1")) {
                    try {
                        InputStream isBlanda = this.getClass().getResourceAsStream("/images/tapa_blanda.jpg");
                        Image blanda = ImageIO.read(isBlanda);

                        InputStream isDura = this.getClass().getResourceAsStream("/images/tapa_dura.jpg");
                        Image dura = ImageIO.read(isDura);

                        HashMap parametros = new HashMap();
                        parametros.put("DURA", dura);
                        parametros.put("BLANDA", blanda);

                        String informe = "/reports/primer_informe.jrxml";

                        JasperReport jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream(informe));
                        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, connection);

                        if (jp.getPages().size() == 0) {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(null);
                        } else {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(jp);
                        }

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } catch (JRException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (clientMsg.startsWith("informe2")) {
                    try {
                        String informe = "/reports/segundo_informe.jrxml";

                        JasperReport jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream(informe));
                        JasperPrint jp = JasperFillManager.fillReport(jr, null, connection);

                        if (jp.getPages().size() == 0) {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(null);
                        } else {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(jp);
                        }

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } catch (JRException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (clientMsg.startsWith("informe3")) {
                    try {
                        String collectionName = clientMsg.split(",")[1];
                                
                        HashMap parametros = new HashMap();
                        parametros.put("COLECCION", collectionName);

                        String informe = "/reports/tercer_informe.jrxml";

                        JasperReport jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream(informe));
                        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, connection);

                        if (jp.getPages().size() == 0) {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(null);
                        } else {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(jp);
                        }

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } catch (JRException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (clientMsg.startsWith("informe4")) {
                    try {
                        String healthName = clientMsg.split(",")[1];
                                
                        HashMap parametros = new HashMap();
                        parametros.put("ESTADO", healthName);

                        String informe = "/reports/cuarto_informe.jrxml";

                        JasperReport jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream(informe));
                        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, connection);

                        if (jp.getPages().size() == 0) {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(null);
                        } else {
                            new ObjectOutputStream(socket.getOutputStream()).writeObject(jp);
                        }

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } catch (JRException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } while (!clientMsg.equals("close"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + ex.getErrorCode());
            if (ex.getErrorCode() == 1451) {
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
