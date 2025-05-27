/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectofincurso;

import java.awt.Dimension;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofincurso.clases.ConectBD;
import proyectofincurso.clases.UsuarioConectado;

/**
 *
 * @author DAW
 */
public class Compania extends javax.swing.JFrame {
    
    DefaultTableModel modS=new DefaultTableModel();
    DefaultTableModel modC=new DefaultTableModel();
    DefaultTableModel modT=new DefaultTableModel();
    DefaultTableModel modTR=new DefaultTableModel();
    private static String ids;
    /**
     * Creates new form Compania
     */
    public Compania() {
        initComponents();
        PS.setVisible(false);
        PCT.setVisible(false);
        try{
            String id,E,C,Cli,FI,HI,FF,HF,TE;
            int idn;
            Connection c = ConectBD.Conexion();        
            int idU=UsuarioConectado.idU;
            
            //tabla
            String titulosS[]={"Servicio","Compañia","Cliente","Establecimiento","Fecha de inicio","Hora de inicio","Fecha de terminado","Hora de terminado","Terminado"};
            String titulosC[]={"id","DNI","nombre","1º apellido","2º apellido","correo","contraseña","telefono"};
            String titulosT[]={"id","DNI","nombre","1º apellido","2º apellido","correo","contraseña","telefono"};
            String titulosTR[]={"id","nombre"};
            modS.setColumnIdentifiers(titulosS);
            modC.setColumnIdentifiers(titulosC);
            modT.setColumnIdentifiers(titulosT);
            modTR.setColumnIdentifiers(titulosTR);
            TServ.setModel(modS);
            TTrab.setModel(modT);
            TCli.setModel(modC);
            TRTR.setModel(modTR);
            
            String sql="SELECT * FROM Servicios;";                
            Statement s= c.createStatement();
            ResultSet a= s.executeQuery(sql);          
            while (a.next()){
                idn=a.getInt(1);
                id=Integer.toString(idn);
                C=a.getString(2);
                Cli=a.getString(3);
                E=a.getString(4);
                FI=a.getString(5);
                HI=a.getString(6);
                if(a.getString(5)!=null){
                    FF=a.getString(7);
                    HF=a.getString(8);
                }
                else{
                    FF="----------------";
                    HF="---:---:---";
                }
                TE=a.getString(9);
                if("1".equals(TE))
                    TE="SI";
                else
                    TE="NO";
                
                String row[]={id,C,Cli,E,FI,HI,FF,HF,TE};
                modS.addRow(row);
            }
            
            String DNI,nom,A1,A2,CE,Con,Tel;
            sql="SELECT * FROM clientes;";                
            a= s.executeQuery(sql);
            while (a.next()){
                idn=a.getInt(1);
                id=Integer.toString(idn);
                DNI=a.getString(2);
                nom=a.getString(3);
                A1=a.getString(4);
                A2=a.getString(5);
                CE=a.getString(6);
                Con=a.getString(7);
                Tel=a.getString(8);
                
                String row[]={id,DNI,nom,A1,A2,CE,Con,Tel};
                modC.addRow(row);
            }
            
            sql="SELECT * FROM trabajadores;";                
            a= s.executeQuery(sql); 
            while (a.next()){
                idn=a.getInt(1);
                id=Integer.toString(idn);
                DNI=a.getString(2);
                nom=a.getString(3);
                A1=a.getString(4);
                A2=a.getString(5);
                CE=a.getString(6);
                Con=a.getString(7);
                Tel=a.getString(8);
                
                String row[]={id,DNI,nom,A1,A2,CE,Con,Tel};
                modT.addRow(row);
            }
            
            sql="SELECT * FROM trabajos;";                
            a= s.executeQuery(sql);
            while (a.next()){
                idn=a.getInt(1);
                id=Integer.toString(idn);
                nom=a.getString(2);
                
                String row[]={id,nom};
                modTR.addRow(row);
            }
            
            Estab.addItem("<Seleccionar>");
            sql="SELECT id_establecimiento from establecimientos";
            s= c.createStatement();
            a= s.executeQuery(sql);
            
            while (a.next()){
                Estab.addItem(""+a.getString(1)+"");
            }
        }
        catch(SQLException ex){
            
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

        PS = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FFtctxt = new javax.swing.JTextField();
        FItxt = new javax.swing.JTextField();
        HItxt = new javax.swing.JTextField();
        FNItxt = new javax.swing.JTextField();
        chTerminado = new javax.swing.JCheckBox();
        Estab = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        PCT = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nomtxt = new javax.swing.JTextField();
        Ap1txt = new javax.swing.JTextField();
        Ap2txt = new javax.swing.JTextField();
        DNItxt = new javax.swing.JTextField();
        Teltxt = new javax.swing.JTextField();
        CEtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Contxt = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TServ = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TCli = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTrab = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TRTR = new javax.swing.JTable();
        btnEditar = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        btnAsigServ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Aplicar");
        PS.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel9.setText("Fecha de Inicio");
        PS.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel10.setText("Hora de Inicio");
        PS.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel11.setText("Fecha de  finalizacion");
        PS.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel12.setText("Fecha de finalizacion");
        PS.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        PS.add(FFtctxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 100, -1));
        PS.add(FItxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, -1));

        HItxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HItxtActionPerformed(evt);
            }
        });
        PS.add(HItxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 100, -1));
        PS.add(FNItxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, -1));

        chTerminado.setText("Terminado");
        PS.add(chTerminado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        PS.add(Estab, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 130, -1));

        jLabel7.setText("Establecimiento");
        PS.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        getContentPane().add(PS, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 410, 170));

        PCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        PCT.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("1º Apellido");
        PCT.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("DNI");
        PCT.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setText("Telefono");
        PCT.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel5.setText("Correo Electronico");
        PCT.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel6.setText("Contraseña");
        PCT.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));
        PCT.add(Nomtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 120, -1));
        PCT.add(Ap1txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 120, -1));
        PCT.add(Ap2txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, -1));

        DNItxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNItxtActionPerformed(evt);
            }
        });
        PCT.add(DNItxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 120, -1));
        PCT.add(Teltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 120, -1));
        PCT.add(CEtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 120, -1));

        jLabel8.setText("2º Apellido ");
        PCT.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jButton1.setText("Aplicar");
        PCT.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        PCT.add(Contxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 120, -1));

        getContentPane().add(PCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 490, 170));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 100, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TServ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TServ);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 300));

        jTabbedPane1.addTab("Servicios", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TCli);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 270));

        jTabbedPane1.addTab("Clientes", jPanel1);

        TTrab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TTrab);

        jTabbedPane1.addTab("Trabajadores", jScrollPane1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TRTR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(TRTR);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 210));

        jTabbedPane1.addTab("tab4", jPanel3);

        jLayeredPane1.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 660, 300);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 670, 300));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 100, 30));

        jButton2.setText("Cerrar sesion");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 30));

        btnAsigServ.setText("Asignar Servicio");
        btnAsigServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsigServActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsigServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int selec=jTabbedPane1.getSelectedIndex();
    String DNI,nom,A1,A2,CE,Con,Tel;
    String id,E,C,Cli,FI,HI,FF,HF,TE;
    int idn;
    if(selec==0){
        int rc=TServ.getRowCount(),i=0;
            while(i<rc){
                if(TServ.isRowSelected(i)){
                    ids=(String) modS.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este servicio?", "confirmación", 0);
                    if(op==0){
                        try{
                            Connection c=ConectBD.Conexion();
                            Statement s= c.createStatement();
                            s.executeUpdate("DELETE FROM servicios WHERE id_servicio="+ids);
                            
                            ResultSet a= s.executeQuery("SELECT * FROM Servicios;");
                            while (a.next()){
                                idn=a.getInt(1);
                                id=Integer.toString(idn);
                                C=a.getString(2);
                                Cli=a.getString(3);
                                E=a.getString(4);
                                FI=a.getString(5);
                                HI=a.getString(6);
                                if(a.getString(5)!=null){
                                    FF=a.getString(7);
                                    HF=a.getString(8);
                                }
                                else{
                                    FF="----------------";
                                    HF="---:---:---";
                                }
                                TE=a.getString(9);
                                if("1".equals(TE))
                                    TE="SI";
                                else
                                    TE="NO";

                                String row[]={id,C,Cli,E,FI,HI,FF,HF,TE};
                                modS.addRow(row);
                            }
                        
                        }
                        catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, "error en la BD");
                        }
                    }
                }
                i++;
            }
    }
    else
    if(selec==1){
        int rc=TServ.getRowCount(),i=0;
            while(i<rc){
                if(TCli.isRowSelected(i)){
                    ids=(String) modS.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este cliente?", "confirmación", 0);
                    if(op==0){
                        try{
                            Connection c=ConectBD.Conexion();
                            Statement s= c.createStatement();
                            s.executeUpdate("DELETE FROM clientes WHERE id_cliente="+ids);
                            
                            ResultSet a= s.executeQuery("SELECT * FROM clientes;");
                            while (a.next()){
                                idn=a.getInt(1);
                                id=Integer.toString(idn);
                                DNI=a.getString(2);
                                nom=a.getString(3);
                                A1=a.getString(4);
                                A2=a.getString(5);
                                CE=a.getString(6);
                                Con=a.getString(7);
                                Tel=a.getString(8);

                                String row[]={id,DNI,nom,A1,A2,CE,Con,Tel};
                                modC.addRow(row);
                            }
                        }
                        catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, "error en la BD");
                        }
                    }
                }
                i++;
            }
    }
    else
    if(selec==2){
        int rc=TServ.getRowCount(),i=0;
            while(i<rc){
                if(TTrab.isRowSelected(i)){
                    ids=(String) modS.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este trabajador?", "confirmación", 0);
                    if(op==0){
                        try{
                            Connection c=ConectBD.Conexion();
                            Statement s= c.createStatement();
                            s.executeUpdate("DELETE FROM trabajadores WHERE id_trabajador="+ids);
                            
                            ResultSet a= s.executeQuery("SELECT * FROM trabajadores;");
                            while (a.next()){
                                idn=a.getInt(1);
                                id=Integer.toString(idn);
                                DNI=a.getString(2);
                                nom=a.getString(3);
                                A1=a.getString(4);
                                A2=a.getString(5);
                                CE=a.getString(6);
                                Con=a.getString(7);
                                Tel=a.getString(8);

                                String row[]={id,DNI,nom,A1,A2,CE,Con,Tel};
                                modC.addRow(row);
                            }
                        }
                        catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, "error en la BD");
                        }
                    }
                }
                i++;
            }
    }
    else
        if(selec==3){
            int rc=TServ.getRowCount(),i=0;
            while(i<rc){
                if(TTrab.isRowSelected(i)){
                    ids=(String) modS.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este trabajo?", "confirmación", 0);
                    if(op==0){
                        try{
                            Connection c=ConectBD.Conexion();
                            Statement s= c.createStatement();
                            s.executeUpdate("DELETE FROM trabajadores WHERE id_trabajo="+ids);
                            
                            ResultSet a= s.executeQuery("SELECT * FROM trabajos;");
                            while (a.next()){
                                idn=a.getInt(1);
                                id=Integer.toString(idn);
                                nom=a.getString(2);

                                String row[]={id,nom};
                                modTR.addRow(row);
                            }
                        }
                        catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, "error en la BD");
                        }
                    }
                }
                i++;
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void DNItxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNItxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DNItxtActionPerformed

    private void HItxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HItxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HItxtActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selec=jTabbedPane1.getSelectedIndex();
        System.out.println(selec);
        PS.setVisible(false);
        PCT.setVisible(false);
        if(selec==0&&btnEditar.isSelected()){//servicio
            int i=0;
            PS.setVisible(true);
            int rc=TServ.getRowCount();
            while(i<rc){
                
                i++;
            } 
        }
        else
        if(selec==1&&btnEditar.isSelected()){//cliente 
            PCT.setVisible(true);
            int i=0;
            int rc=TServ.getRowCount();
            
            while(i<rc){
                
                i++;
            } 
        }
        else
        if(selec==2&&btnEditar.isSelected()){//trabajador
            PCT.setVisible(true);
            int i=0;
            int rc=TTrab.getRowCount();
            
            while(i<rc){
                if(TServ.isRowSelected(i)){
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro?", "confirmación", 0);
                    if(op==0){
                        ids=(String) modS.getValueAt(i, 0);
                    }
                    else{
                        break;
                    }
                }
                i++;
            } 
        }
        else
        if(selec==3&&btnEditar.isSelected()){//trabajos
            PCT.setVisible(true);
            int i=0;
            int rc=TTrab.getRowCount();
            
            while(i<rc){
                if(TServ.isRowSelected(i)){
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro?", "confirmación", 0);
                    if(op==0){
                        ids=(String) modS.getValueAt(i, 0);
                    }
                    else{
                        break;
                    }
                }
                i++;
            } 
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAsigServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsigServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsigServActionPerformed

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
            java.util.logging.Logger.getLogger(Compania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compania().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ap1txt;
    private javax.swing.JTextField Ap2txt;
    private javax.swing.JTextField CEtxt;
    private javax.swing.JTextField Contxt;
    private javax.swing.JTextField DNItxt;
    private javax.swing.JComboBox<String> Estab;
    private javax.swing.JTextField FFtctxt;
    private javax.swing.JTextField FItxt;
    private javax.swing.JTextField FNItxt;
    private javax.swing.JTextField HItxt;
    private javax.swing.JTextField Nomtxt;
    private javax.swing.JPanel PCT;
    private javax.swing.JPanel PS;
    private javax.swing.JTable TCli;
    private javax.swing.JTable TRTR;
    private javax.swing.JTable TServ;
    private javax.swing.JTable TTrab;
    private javax.swing.JTextField Teltxt;
    private javax.swing.JButton btnAsigServ;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBox chTerminado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
