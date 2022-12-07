/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package client.screens;

import client.ServerConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author chivu
 */
public class ModifyComic extends javax.swing.JDialog {

    private java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("client/i18n/LabelsBundle");
    private ServerConnection sc;
    private java.awt.Frame parent;
    
    /**
     * Creates new form ModifyCollection
     */
    public ModifyComic(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        try {
            sc = new ServerConnection(10);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), bundle.getString("error"), 0);
            this.dispose();
        }
        fillComicsCombo();
        fillCollectionLabels();
    }

    private void fillComicsCombo() {
        comboComicsModel.removeAllElements();
        String data = sc.query("select * from comic;");
        if (data != "") {
            for (int i = 0; i < data.split(";").length; i++) {
                comboComicsModel.addElement(data.split(";")[i].substring(0, data.split(";")[i].length() - 1));
            }
        } else {
            JOptionPane.showMessageDialog(parent, bundle.getString("sin_comics_error"));
            this.dispose();
        }
    }
    
    private void fillCollectionLabels(){
        String selected = (String) comboComicsModel.getSelectedItem();
        txtfID.setText(selected.split(",")[0]);
        txtfTitle.setText(selected.split(",")[1]);
        txtfAutor.setText(selected.split(",")[2]);
        txtfBuyDate.setText(selected.split(",")[3]);
        if(selected.split(",")[4].equals("hard")){
            cmbCover.setSelectedItem("hard");
        }
        else{
            cmbCover.setSelectedItem("soft");
        }
        if(selected.split(",")[5].equals("broken")){
            cmbCondition.setSelectedItem("broken");
        }
        else if(selected.split(",")[5].equals("marked")){
            cmbCondition.setSelectedItem("marked");
        }
        else if(selected.split(",")[5].equals("good condition")){
            cmbCondition.setSelectedItem("good condition");
        }
        else {
            cmbCondition.setSelectedItem("new");
        }
        txtfCollection.setText(selected.split(",")[6]);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfID = new javax.swing.JTextField();
        txtfTitle = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtfAutor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfBuyDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCover = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbCondition = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtfCollection = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar colección");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Cómic");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jComboBox1.setModel(comboComicsModel);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jComboBox1, gridBagConstraints);

        jLabel2.setText("Datos a modificar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel3, gridBagConstraints);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("client/i18n/LabelsBundle"); // NOI18N
        jLabel4.setText(bundle.getString("nombre")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(txtfID, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(txtfTitle, gridBagConstraints);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        getContentPane().add(jButton1, gridBagConstraints);

        jLabel5.setText("Autor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtfAutor, gridBagConstraints);

        jLabel6.setText(bundle.getString("fecha_compra")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtfBuyDate, gridBagConstraints);

        jLabel7.setText(bundle.getString("tapa")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel7, gridBagConstraints);

        cmbCover.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hard", "soft" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(cmbCover, gridBagConstraints);

        jLabel8.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel8, gridBagConstraints);

        cmbCondition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "broken", "marked", "good condition", "new" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(cmbCondition, gridBagConstraints);

        jLabel9.setText("ID colección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtfCollection, gridBagConstraints);

        setSize(new java.awt.Dimension(756, 385));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(comboComicsModel.getSize()>0)
            fillCollectionLabels();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query = "update comic set id=";
        query = query + txtfID.getText() + ",title='" + txtfTitle.getText() + "', author='"+txtfAutor.getText()
                + "', buy_date='" + txtfBuyDate.getText() + "', cover='" + cmbCover.getSelectedItem().toString() 
                + "', health='" + cmbCondition.getSelectedItem().toString() + "', id_collection=" + txtfCollection.getText() 
                + " where id=" + ((String) comboComicsModel.getSelectedItem()).split(",")[0] + ";";
        String result = sc.update(query);
        if(result.equals("updated")){
            JOptionPane.showMessageDialog(parent, "Colección actualizada con éxito");
            fillComicsCombo();
        }
        else if(result.equals("not deleted cause of foreing key")){
            JOptionPane.showMessageDialog(parent, bundle.getString("error_actualizado_foreing_key"));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifyComic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyComic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyComic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyComic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyComic dialog = new ModifyComic(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCondition;
    private javax.swing.JComboBox<String> cmbCover;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtfAutor;
    private javax.swing.JTextField txtfBuyDate;
    private javax.swing.JTextField txtfCollection;
    private javax.swing.JTextField txtfID;
    private javax.swing.JTextField txtfTitle;
    // End of variables declaration//GEN-END:variables
    private DefaultComboBoxModel comboComicsModel = new DefaultComboBoxModel();
}
