/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package client.screens;

import client.ServerConnection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chivu
 */
public class Collections extends javax.swing.JDialog {

    private ServerConnection sc;

    /**
     * Creates new form Collections
     */
    public Collections(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sc = new ServerConnection(10);
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        loadData();
    }

    private void loadData() {
        String data = sc.query("select * from collection;");
        if (data != null) {
            for (int i = 0; i < data.split(";").length; i++) {
                tableModel.setRowCount(tableModel.getRowCount() + 1);
                tableModel.setValueAt(data.split(";")[i].split(",")[0], tableModel.getRowCount() - 1, 0);
                tableModel.setValueAt(data.split(";")[i].split(",")[1], tableModel.getRowCount() - 1, 1);

            }
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

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel tableModel = new DefaultTableModel();
}
