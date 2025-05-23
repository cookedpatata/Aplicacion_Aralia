/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectofincurso;

import proyectofincurso.clases.ConectBD;
import java.sql.*;
import javax.swing.*;
import proyectofincurso.clases.UsuarioConectado;
/**
 *
 * @author Usuario
 */
public class Añadir_Establecimiento extends javax.swing.JFrame {

    /**
     * Creates new form Añadir_Establecimiento
     */
    public Añadir_Establecimiento() {
        initComponents();
        setLocation(950, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Estabtxt = new javax.swing.JTextField();
        Añadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Añadir Establecimiento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        Estabtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstabtxtActionPerformed(evt);
            }
        });
        getContentPane().add(Estabtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, -1));

        Añadir.setText("Añadir");
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });
        getContentPane().add(Añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        try{
        int idU=UsuarioConectado.idU, f;
        String Estab=Estabtxt.getText();
        Connection c= ConectBD.Conexion();
        Statement s= c.createStatement();
        
        ResultSet e= s.executeQuery("SELECT direccion FROM establecimientos WHERE id_cliente="+idU+" AND direccion LIKE '"+Estab+"';");
        if (e.next())
            JOptionPane.showMessageDialog(null, "Ya posee dicho establecimiento");
        else{
            int conf=JOptionPane.showConfirmDialog(null,"¿Está seguro de los datos intoducidos?", "confirmación", 0);
            if(conf==0){
                s.executeUpdate("INSERT INTO establecimientos (id_cliente, direccion) VALUES ("+idU+", '"+Estab+"');");    
            }
            else{
            }            
        }
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Error en la BD");
        }
    }//GEN-LAST:event_AñadirActionPerformed

    private void EstabtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstabtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstabtxtActionPerformed

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
            java.util.logging.Logger.getLogger(Añadir_Establecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Añadir_Establecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Añadir_Establecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Añadir_Establecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Añadir_Establecimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JTextField Estabtxt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
