/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectofincurso;

import proyectofincurso.clases.ConectBD;

import proyectofincurso.clases.UsuarioConectado;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author DAW
 */
public class Inicio extends javax.swing.JFrame {
    
    
    
    public Inicio() {
        setLocation(800,400);
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CEtxt = new javax.swing.JTextField();
        Contrtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Reg = new javax.swing.JButton();
        IniciarS = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabel2.setText("Bienvenido a OrgAralia");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel5.setText("Correo Electronico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel6.setText("Contraseña");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel7.setText("INICIO DE SESION");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        CEtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEtxtActionPerformed(evt);
            }
        });
        getContentPane().add(CEtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 150, -1));
        getContentPane().add(Contrtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, -1));

        jLabel8.setText("¿Aun no tienes una cuenta? ¡Registrate!");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        Reg.setText("Registrarse");
        Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegActionPerformed(evt);
            }
        });
        getContentPane().add(Reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        IniciarS.setText("Iniciar sesión");
        IniciarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSActionPerformed(evt);
            }
        });
        getContentPane().add(IniciarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegActionPerformed
        dispose();
        Registro reg= new Registro();
        reg.setVisible(true);       
    }//GEN-LAST:event_RegActionPerformed

    private void IniciarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSActionPerformed
        ConectBD bd=new ConectBD();
        String CE,Contr;
        CE=CEtxt.getText();
        Contr=Contrtxt.getText();
        try{
            //juan.perez@mail.com
            //PassJuan01
            //carlos.gomez@mail.com
            //Pass1234
            Connection c =DriverManager.getConnection("jdbc:mysql://localhost/limpieza", "JavierC","Arcoiris");
            
            Statement s1 = c.createStatement();
            Statement s2 = c.createStatement();
            Statement s3 = c.createStatement();
            
            ResultSet t = s1.executeQuery("SELECT id_trabajador FROM trabajadores \nWHERE correo ='"+CE+"' AND contraseña ='"+Contr+"';");
            ResultSet cl= s2.executeQuery("SELECT id_cliente FROM clientes \nWHERE correo ='"+CE+"' AND contraseña ='"+Contr+"';");
            ResultSet comp= s3.executeQuery("SELECT id_compañia FROM compañias \nWHERE correo ='"+CE+"' AND contraseña ='"+Contr+"';");
            
            if(t.next()){
                dispose();
                Trabajador tr= new Trabajador();
                tr.setVisible(true);
                System.out.println("trabajador");
                UsuarioConectado.idU=t.getInt(1);
            }
            else
                if(cl.next()){
                dispose();
                Cliente tr= new Cliente();
                tr.setVisible(true);
                System.out.println("cliente");
                UsuarioConectado.idU=cl.getInt(1);
            }
                else
                    if(comp.next()){
                        dispose();
                        Compañia cm= new Compañia();
                        cm.setVisible(true);
                        System.out.println("compañia");
                        UsuarioConectado.idU=comp.getInt(1);
                    }
            else
                if((CE.trim().length()==0)||(Contr.trim().length()==0)){
                JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
                CEtxt.setText("");
                Contrtxt.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    CEtxt.setText("");
                    Contrtxt.setText("");
            }   
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la BD");
        }
        
    }//GEN-LAST:event_IniciarSActionPerformed

    private void CEtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEtxtActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEtxt;
    private javax.swing.JTextField Contrtxt;
    private javax.swing.JButton IniciarS;
    private javax.swing.JButton Reg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
