/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.screens;

import java.net.URL;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

/**
 *
 * @author chivu
 */
public class MainFrame extends javax.swing.JFrame {
    final Locale glLocale = new Locale("gl","ES");
    final Locale esLocale = new Locale("es","ES");
    public static HelpSet HELPSET;
    public static HelpBroker BROKER;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        try {
            initComponents();
            
            URL url = this.getClass().getResource("/help/ayuda.hs");
            HELPSET = new HelpSet(null, url);
            BROKER = HELPSET.createHelpBroker();
            BROKER.enableHelpOnButton(menuHelp, "index", HELPSET);
            
        } catch (HelpSetException ex) {
            System.out.println(ex.getMessage());
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuES = new javax.swing.JMenuItem();
        menuGAL = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("client/i18n/LabelsBundle"); // NOI18N
        setTitle(bundle.getString("main_frame")); // NOI18N
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText(bundle.getString("colecciones")); // NOI18N
        jButton1.setLabel(bundle.getString("colecciones")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText(bundle.getString("comics")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        jMenu1.setText("Informes");

        jMenuItem1.setText("Pantalla informes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenu3.setText("Idioma");

        menuES.setText("Castellano");
        menuES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuESActionPerformed(evt);
            }
        });
        jMenu3.add(menuES);

        menuGAL.setText("Gallego");
        menuGAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGALActionPerformed(evt);
            }
        });
        jMenu3.add(menuGAL);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        jMenu4.setText(bundle.getString("ayuda")); // NOI18N

        menuHelp.setText(bundle.getString("ayuda")); // NOI18N
        jMenu4.add(menuHelp);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(416, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuCollections(this, false).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MenuComics(this, false).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuGALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGALActionPerformed
        Locale.setDefault(glLocale);
        this.dispose();
        new MainFrame().setVisible(true);
    }//GEN-LAST:event_menuGALActionPerformed

    private void menuESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuESActionPerformed
        Locale.setDefault(esLocale);
        this.dispose();
        new MainFrame().setVisible(true);
    }//GEN-LAST:event_menuESActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Reports(this, false).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuES;
    private javax.swing.JMenuItem menuGAL;
    private javax.swing.JMenuItem menuHelp;
    // End of variables declaration//GEN-END:variables
}
