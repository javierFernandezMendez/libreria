/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package client.screens;

import client.ServerConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chivu
 */
public class ShowComicsByCollection extends javax.swing.JDialog {
    private java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("client/i18n/LabelsBundle");
    private ServerConnection sc;
    private java.awt.Frame parent;
    
    /**
     * Creates new form Collections
     */
    public ShowComicsByCollection(java.awt.Frame parent, boolean modal, String name) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        try {
            sc = new ServerConnection(10);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), bundle.getString("error"), 0);
            this.dispose();
        }
        tableModel.addColumn("ID");
        tableModel.addColumn("Título");
        tableModel.addColumn("Autor");
        tableModel.addColumn(bundle.getString("fecha_compra"));
        tableModel.addColumn(bundle.getString("tapa"));
        tableModel.addColumn("Estado");
        tableModel.addColumn("ID colección");
        loadData(name);
    }

    private void loadData(String name) {
        String data = sc.query("select * from comic as c left join collection as co on c.id_collection = co.id " 
                + "where co.name='" + name + "';");
        if (!data.equals("")) {
            for (int i = 0; i < data.split(";").length; i++) {
                tableModel.setRowCount(tableModel.getRowCount() + 1);
                tableModel.setValueAt(data.split(";")[i].split(",")[0], tableModel.getRowCount() - 1, 0);
                tableModel.setValueAt(data.split(";")[i].split(",")[1], tableModel.getRowCount() - 1, 1);
                tableModel.setValueAt(data.split(";")[i].split(",")[2], tableModel.getRowCount() - 1, 2);
                tableModel.setValueAt(data.split(";")[i].split(",")[3], tableModel.getRowCount() - 1, 3);
                tableModel.setValueAt(data.split(";")[i].split(",")[4], tableModel.getRowCount() - 1, 4);
                tableModel.setValueAt(data.split(";")[i].split(",")[5], tableModel.getRowCount() - 1, 5);
                tableModel.setValueAt(data.split(";")[i].split(",")[6], tableModel.getRowCount() - 1, 6);
                
            }
        }
        else{
           JOptionPane.showMessageDialog(this, bundle.getString("sin_resultados"));
           this.dispose();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("client/i18n/LabelsBundle"); // NOI18N
        setTitle(bundle.getString("show_comics")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);

        setSize(new java.awt.Dimension(716, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sc.close();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel tableModel = new DefaultTableModel();
}