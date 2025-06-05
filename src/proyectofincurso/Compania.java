/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectofincurso;

import java.awt.Dimension;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyectofincurso.clases.ConectBD;
import proyectofincurso.clases.UsuarioConectado;

/**
 *
 * @author DAW
 */
public class Compania extends javax.swing.JFrame {
    public static boolean C9(String a){
        if(a.length()==9)
            return true;
        else
            return false;
    }
    
    public static boolean CE(String a){
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_-]{2,}@[a-zA-Z0-9_-]{2,}.[a-zA-Z]{2,4}(.[a-zA-Z]{2,4})?$");
        Matcher mat = pat.matcher(a);
        return mat.find();
    }
    
    public static boolean Contr(String a){
        Pattern pat= Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{7,}$");
        Matcher mat= pat.matcher(a);
        return mat.find();   
    }
    
    public static boolean DNI(String a){
        Pattern pat= Pattern.compile("[0-9]{8}[A-Z]");
        Matcher mat= pat.matcher(a);
        return mat.find();
    }
    public static boolean CERep(String CE) throws SQLException{
        Connection c = ConectBD.Conexion();
        Statement s = c.createStatement();
        ResultSet cc =s.executeQuery("SELECT correo FROM clientes;");
        Statement s1 = c.createStatement();
        ResultSet ct =s1.executeQuery("SELECT correo FROM trabajadores;");
        while (cc.next()){
            if(CE.equals(cc.getString(1)))
                return true;                    
        }
        while (ct.next()){
            if(CE.equals(ct.getString(1)))
                return true;
        }
        return false;
    }
    
    DefaultTableModel modS=new DefaultTableModel();
    DefaultTableModel modC=new DefaultTableModel();
    DefaultTableModel modT=new DefaultTableModel();
    DefaultTableModel modTR=new DefaultTableModel();
    
    private Connection c = ConectBD.Conexion(); 
    
    private String ids,id,E,C,Cli,FI,HI,FF,HF,TE,A1,A2,Con;
    
    private String DNI,nom,ap1,ap2,CEo,contr,Tel;
    private String DNIp,nomp,ap1p,ap2p,CEp,contrp,Telp;
    private int idn,idU=UsuarioConectado.idU;
    /**
     * Creates new form Compania
     */
    public Compania() {
        initComponents();
        setLocation(800,400);
        PS.setVisible(false);
        PCT.setVisible(false);
        try{
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
            
            sql="SELECT * FROM clientes;";                
            a= s.executeQuery(sql);
            while (a.next()){
                idn=a.getInt(1);
                id=Integer.toString(idn);
                DNI=a.getString(2);
                nom=a.getString(3);
                A1=a.getString(4);
                A2=a.getString(5);
                CEo=a.getString(6);
                Con=a.getString(7);
                Tel=a.getString(8);
                
                String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
                modC.addRow(row);
            }
            
            sql="SELECT * FROM trabajadores;";                
            a= s.executeQuery(sql); 
            while (a.next()){
                idn=a.getInt(1);
                id=Integer.toString(idn);
                DNI=a.getString(2);
                nom=a.getString(4);
                A1=a.getString(5);
                A2=a.getString(6);
                CEo=a.getString(7);
                Con=a.getString(8);
                Tel=a.getString(9);
                
                String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
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

        jTextField1 = new javax.swing.JTextField();
        PS = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chTerminado = new javax.swing.JCheckBox();
        Estab = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnAplicServ = new javax.swing.JButton();
        Dia = new javax.swing.JComboBox<>();
        Mes = new javax.swing.JComboBox<>();
        Año = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Dia1 = new javax.swing.JComboBox<>();
        Mes1 = new javax.swing.JComboBox<>();
        Año1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Hora1 = new javax.swing.JComboBox<>();
        Hora = new javax.swing.JComboBox<>();
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
        btnAplicUsuario = new javax.swing.JButton();
        Contxt = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        btnAsigServ = new javax.swing.JButton();
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
        jLabel13 = new javax.swing.JLabel();
        Trabtxt = new javax.swing.JTextField();
        AñadTrab = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PS.setBackground(new java.awt.Color(204, 204, 204));
        PS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Fecha de Inicio");
        PS.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel10.setText("Hora de Inicio");
        PS.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel11.setText("Fecha de  finalizacion");
        PS.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel12.setText("Fecha de finalizacion");
        PS.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        chTerminado.setText("Terminado");
        PS.add(chTerminado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        PS.add(Estab, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 130, -1));

        jLabel7.setText("Establecimiento");
        PS.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        btnAplicServ.setText("Aplicar");
        btnAplicServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicServActionPerformed(evt);
            }
        });
        PS.add(btnAplicServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, 30));

        Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Dia>", "01  ", "02  ", "03  ", "04  ", "05  ", "06  ", "07  ", "08  ", "09  ", "10  ", "11  ", "12  ", "13  ", "14  ", "15  ", "16  ", "17  ", "18  ", "19  ", "20  ", "21  ", "22  ", "23  ", "24  ", "25  ", "26  ", "27  ", "28  ", "29  ", "30  ", "31" }));
        Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiaActionPerformed(evt);
            }
        });
        PS.add(Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Mes>", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesActionPerformed(evt);
            }
        });
        PS.add(Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Año>", "2025  ", "2026  ", "2027  ", "2028  ", "2029  ", "2030  ", "2031  ", "2032  ", "2033  ", "2034  ", "2035  ", "2036  ", "2037  ", "2038  ", "2039  ", "2040  ", "2041  ", "2042  ", "2043  ", "2044  ", "2045  ", "2046  ", "2047  ", "2048  ", "2049  ", "2050" }));
        PS.add(Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("de");
        PS.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("de");
        PS.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        Dia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Dia>", "01  ", "02  ", "03  ", "04  ", "05  ", "06  ", "07  ", "08  ", "09  ", "10  ", "11  ", "12  ", "13  ", "14  ", "15  ", "16  ", "17  ", "18  ", "19  ", "20  ", "21  ", "22  ", "23  ", "24  ", "25  ", "26  ", "27  ", "28  ", "29  ", "30  ", "31" }));
        Dia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dia1ActionPerformed(evt);
            }
        });
        PS.add(Dia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        Mes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Mes>", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Mes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mes1ActionPerformed(evt);
            }
        });
        PS.add(Mes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        Año1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Año>", "2025  ", "2026  ", "2027  ", "2028  ", "2029  ", "2030  ", "2031  ", "2032  ", "2033  ", "2034  ", "2035  ", "2036  ", "2037  ", "2038  ", "2039  ", "2040  ", "2041  ", "2042  ", "2043  ", "2044  ", "2045  ", "2046  ", "2047  ", "2048  ", "2049  ", "2050" }));
        PS.add(Año1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("de");
        PS.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("de");
        PS.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        Hora1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<hora>", "00:00  ", "00:30  ", "01:00  ", "01:30  ", "02:00  ", "02:30  ", "03:00  ", "03:30  ", "04:00  ", "04:30  ", "05:00  ", "05:30  ", "06:00  ", "06:30  ", "07:00  ", "07:30  ", "08:00  ", "08:30  ", "09:00  ", "09:30  ", "10:00  ", "10:30  ", "11:00  ", "11:30  ", "12:00  ", "12:30  ", "13:00  ", "13:30  ", "14:00  ", "14:30  ", "15:00  ", "15:30  ", "16:00  ", "16:30  ", "17:00  ", "17:30  ", "18:00  ", "18:30  ", "19:00  ", "19:30  ", "20:00  ", "20:30  ", "21:00  ", "21:30  ", "22:00  ", "22:30  ", "23:00  ", "23:30  ", "24:00" }));
        PS.add(Hora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        Hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<hora>", "00:00  ", "00:30  ", "01:00  ", "01:30  ", "02:00  ", "02:30  ", "03:00  ", "03:30  ", "04:00  ", "04:30  ", "05:00  ", "05:30  ", "06:00  ", "06:30  ", "07:00  ", "07:30  ", "08:00  ", "08:30  ", "09:00  ", "09:30  ", "10:00  ", "10:30  ", "11:00  ", "11:30  ", "12:00  ", "12:30  ", "13:00  ", "13:30  ", "14:00  ", "14:30  ", "15:00  ", "15:30  ", "16:00  ", "16:30  ", "17:00  ", "17:30  ", "18:00  ", "18:30  ", "19:00  ", "19:30  ", "20:00  ", "20:30  ", "21:00  ", "21:30  ", "22:00  ", "22:30  ", "23:00  ", "23:30  ", "24:00" }));
        PS.add(Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        getContentPane().add(PS, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 580, 200));

        PCT.setBackground(new java.awt.Color(204, 204, 204));
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

        btnAplicUsuario.setText("Aplicar");
        btnAplicUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicUsuarioActionPerformed(evt);
            }
        });
        PCT.add(btnAplicUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        PCT.add(Contxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 120, -1));

        getContentPane().add(PCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 500, 170));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 30));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 100, 30));

        jButton2.setText("Cerrar sesion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 30));

        btnAsigServ.setText("Asignar Servicio");
        btnAsigServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsigServActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsigServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 120, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setEnabled(false);

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
        TServ.setFocusable(false);
        jScrollPane2.setViewportView(TServ);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 320));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 320));

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

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
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

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 320, 270));

        jLabel13.setText("¿Desea añadir un nuevo trabajo?");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));
        jPanel3.add(Trabtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 170, -1));

        AñadTrab.setText("Añadir");
        AñadTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadTrabActionPerformed(evt);
            }
        });
        jPanel3.add(AñadTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jTabbedPane1.addTab("Trabajos", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 830, 350));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int selec=jTabbedPane1.getSelectedIndex();
    if(selec==0){ //servicios
        int rc=TServ.getRowCount(),i=0;
            while(i<rc){
                if(TServ.isRowSelected(i)){
                    ids=(String) modS.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este servicio?", "confirmación", 0);
                    if(op==0){
                        try{
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
    if(selec==1){ //clientes
        int rc=TCli.getRowCount(),i=0;
            while(i<rc){
                if(TCli.isRowSelected(i)){
                    ids=(String) modC.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este cliente?", "confirmación", 0);
                    if(op==0){
                        try{
                            modC.setRowCount(0);
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
                                CEo=a.getString(6);
                                Con=a.getString(7);
                                Tel=a.getString(8);

                                String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
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
    if(selec==2){ //trabajador
        int rc=TTrab.getRowCount(),i=0;
            while(i<rc){
                if(TTrab.isRowSelected(i)){
                    ids=(String) modT.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este trabajador?", "confirmación", 0);
                    if(op==0){
                        try{
                            modT.setRowCount(0);
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
                                CEo=a.getString(6);
                                Con=a.getString(7);
                                Tel=a.getString(8);

                                String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
                                modT.addRow(row);
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
        if(selec==3){ //trabajo
            int rc=TRTR.getRowCount(),i=0;
            while(i<rc){
                if(TRTR.isRowSelected(i)){
                    ids=(String) modTR.getValueAt(i, 0);
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de eliminar este trabajo?", "confirmación", 0);
                    if(op==0){
                        try{
                            modTR.setRowCount(0);
                            Statement s= c.createStatement();
                            s.executeUpdate("DELETE FROM trabajos WHERE id_trabajo="+ids);
                            
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selec=jTabbedPane1.getSelectedIndex();
        PS.setVisible(false);
        PCT.setVisible(false);
        
        
        if(selec==0&&btnEditar.isSelected()){//servicio
            int i=0;      
            int rc=TServ.getRowCount();
            while(i<rc){
                if(TServ.isRowSelected(i)){
                    PS.setVisible(true);
                    ids=(String) modS.getValueAt(i, 0);
                    
                    try{
                        Statement s= c.createStatement();
                    }
                    catch(SQLException ex){
                        
                    }
                }
                i++;
            } 
        }
        else
        if(selec==1&&btnEditar.isSelected()){//cliente        
            int i=0;
            int rc=TCli.getRowCount();           
            while(i<rc){
                if(TCli.isRowSelected(i)){
                    PCT.setVisible(true);
                    ids=(String) modC.getValueAt(i, 0);
                    
                    DNI=(String) modC.getValueAt(i, 1);
                    DNItxt.setText(DNI);
                    nom=(String) modC.getValueAt(i, 2);
                    Nomtxt.setText(nom);
                    ap1=(String) modC.getValueAt(i, 3);
                    Ap1txt.setText(ap1);
                    ap2=(String) modC.getValueAt(i, 4);
                    Ap2txt.setText(ap2);
                    CEo=(String) modC.getValueAt(i, 5);
                    CEtxt.setText(CEo);
                    contr=(String) modC.getValueAt(i, 6);
                    Contxt.setText(contr);
                    Tel=(String) modC.getValueAt(i, 7);
                    Teltxt.setText(Tel); 
                }
                i++;
            } 
        }
        else
        if(selec==2&&btnEditar.isSelected()){//trabajador          
            int i=0;
            int rc=TTrab.getRowCount();  
            while(i<rc){
                if(TTrab.isRowSelected(i)){
                    PCT.setVisible(true);
                    ids=(String) modT.getValueAt(i, 0);
                    System.out.println(ids);
                    DNI=(String) modT.getValueAt(i, 1);
                    DNItxt.setText(DNI);
                    nom=(String) modT.getValueAt(i, 2);
                    Nomtxt.setText(nom);
                    ap1=(String) modT.getValueAt(i, 3);
                    Ap1txt.setText(ap1);
                    ap2=(String) modT.getValueAt(i, 4);
                    Ap2txt.setText(ap2);
                    CEo=(String) modT.getValueAt(i, 5);
                    CEtxt.setText(CEo);
                    contr=(String) modT.getValueAt(i, 6);
                    Contxt.setText(contr);
                    Tel=(String) modT.getValueAt(i, 7);
                    Teltxt.setText(Tel);
                }
                i++;
            } 
        }
        else
        if(selec==3&&btnEditar.isSelected()){//trabajos
            int i=0;
            int rc=TRTR.getRowCount();
            
            while(i<rc){
                if(TRTR.isRowSelected(i)){
                    ids=(String) modTR.getValueAt(i, 0);
                    String NomTrab=(String) modTR.getValueAt(i, 1);
                    nom=JOptionPane.showInputDialog("Nombre", NomTrab.trim());
                        if(nom.trim().length()==0){
                            JOptionPane.showMessageDialog(null, "porfavor introduzca el campo");
                        }
                        else{
                            int op=JOptionPane.showConfirmDialog(null,"¿Está seguro?", "confirmación", 0);
                            if(op==0){
                                try{
                                    Statement s= c.createStatement();
                                    s.executeUpdate("UPDATE trabajos SET nombre='"+nom.trim()+"' WHERE id_trabajo="+ids);        
                                }
                                catch(SQLException ex){
                                    JOptionPane.showMessageDialog(null, "Error en la BD");
                                }
                            }
                        }
                }
                i++;
            } 
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAplicUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicUsuarioActionPerformed
        try{
            System.out.println(ids);
            DNIp=DNItxt.getText();
            nomp=Nomtxt.getText();
            ap1p=Ap1txt.getText();
            ap2p=Ap2txt.getText();
            contrp=Contxt.getText();
            Telp=Teltxt.getText();
            CEp=CEtxt.getText();

            if((ap1p.trim().length()==0)||(DNIp.trim().length()==0)||(Telp.trim().length()==0)||(CEo.trim().length()==0)||(contrp.trim().length()==0)){
                    JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos necesarios");
                }                       
                else{
                    if((C9(Telp)==false))
                        JOptionPane.showMessageDialog(null, "Telfono no valido");  
                    else
                    if((DNI(DNIp)==false))
                        JOptionPane.showMessageDialog(null, "DNI no valido");
                    else
                    if(CE(CEo)==false)
                        JOptionPane.showMessageDialog(null, "Correo electronico no valido");
                    else
                    if(Contr(contrp)==false)
                        JOptionPane.showMessageDialog(null, "Formato de contraseña no valido, prueba a utilizar mayusculas y numeros");
                    else
                    if(CERep(CEp)==true&&(!CEo.equals(CEp))){
                        JOptionPane.showMessageDialog(null, "Usuario Ya existente");
                    }
                    else{
                        int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de los datos intoducidos?", "confirmación", 0);
                        if(op==0){
                            int selec=jTabbedPane1.getSelectedIndex();
                            System.out.println(selec);
                            Statement s= c.createStatement();
                            if(selec==1){
                                if(ap2p==null){
                                    String sql="UPDATE clientes SET\n"
                                        + "DNI='"+DNIp+"',\n"
                                        + "nombre='"+nomp+"',\n"
                                        + "apellido1='"+ap1p+"',\n"
                                        + "apellido2=NULL,\n"
                                        + "correo='"+CEp+"',\n"
                                        + "contraseña='"+contrp+"',\n"
                                        + "telefono="+Telp+"\n"
                                        + "WHERE id_cliente="+ids;
                                    s.executeUpdate(sql);
                                    
                                    sql="SELECT * FROM clientes;";                
                                    ResultSet a= s.executeQuery(sql);
                                    while (a.next()){
                                        idn=a.getInt(1);
                                        id=Integer.toString(idn);
                                        DNI=a.getString(2);
                                        nom=a.getString(3);
                                        A1=a.getString(4);
                                        A2=a.getString(5);
                                        CEo=a.getString(6);
                                        Con=a.getString(7);
                                        Tel=a.getString(8);

                                        String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
                                        modC.addRow(row);
                                    }
                                }
                                else{
                                    String sql="UPDATE clientes SET\n"
                                        + "DNI='"+DNIp+"',\n"
                                        + "nombre='"+nomp+"',\n"
                                        + "apellido1='"+ap1p+"',\n"
                                        + "apellido2='"+ap2p+"',\n"
                                        + "correo='"+CEp+"',\n"
                                        + "contraseña='"+contrp+"',\n"
                                        + "telefono="+Telp+"\n"
                                        + "WHERE id_cliente="+ids;
                                    s.executeUpdate(sql);
                                    
                                    sql="SELECT * FROM clientes;";                
                                    ResultSet a= s.executeQuery(sql);
                                    while (a.next()){
                                        idn=a.getInt(1);
                                        id=Integer.toString(idn);
                                        DNI=a.getString(2);
                                        nom=a.getString(3);
                                        A1=a.getString(4);
                                        A2=a.getString(5);
                                        CEo=a.getString(6);
                                        Con=a.getString(7);
                                        Tel=a.getString(8);

                                        String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
                                        modC.addRow(row);
                                    }
                                } 
                            }
                            else
                                if(selec==2){
                                    if(ap2p==null){
                                        String sql="UPDATE trabajadores SET\n"
                                            + "DNI='"+DNIp+"',\n"
                                            + "nombre='"+nomp+"',\n"
                                            + "apellido1='"+ap1p+"',\n"
                                            + "apellido2=NULL,\n"
                                            + "correo='"+CEp+"',\n"
                                            + "contraseña='"+contrp+"',\n"
                                            + "telefono="+Telp+"\n"
                                            + "WHERE id_trabajador="+ids;
                                        s.executeUpdate(sql);  
                                        
                                        sql="SELECT * FROM trabajadores;";                
                                        ResultSet a= s.executeQuery(sql); 
                                        while (a.next()){
                                            idn=a.getInt(1);
                                            id=Integer.toString(idn);
                                            DNI=a.getString(2);
                                            nom=a.getString(4);
                                            A1=a.getString(5);
                                            A2=a.getString(6);
                                            CEo=a.getString(7);
                                            Con=a.getString(8);
                                            Tel=a.getString(9);

                                            String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
                                            modT.addRow(row);
                                        }
                                    }
                                    else{
                                        String sql="UPDATE trabajadores SET\n"
                                            + "DNI='"+DNIp+"',\n"
                                            + "nombre='"+nomp+"',\n"
                                            + "apellido1='"+ap1p+"',\n"
                                            + "apellido2='"+ap2p+"',\n"
                                            + "correo='"+CEp+"',\n"
                                            + "contraseña='"+contrp+"',\n"
                                            + "telefono="+Telp+"\n"
                                            + "WHERE id_trabajador="+ids;
                                        s.executeUpdate(sql);
                                        
                                        sql="SELECT * FROM trabajadores;";                
                                        ResultSet a= s.executeQuery(sql); 
                                        while (a.next()){
                                            idn=a.getInt(1);
                                            id=Integer.toString(idn);
                                            DNI=a.getString(2);
                                            nom=a.getString(4);
                                            A1=a.getString(5);
                                            A2=a.getString(6);
                                            CEo=a.getString(7);
                                            Con=a.getString(8);
                                            Tel=a.getString(9);

                                            String row[]={id,DNI,nom,A1,A2,CEo,Con,Tel};
                                            modT.addRow(row);
                                        }
                                    } 
                                }
                        }
                    }
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la BD");
        }
        
    }//GEN-LAST:event_btnAplicUsuarioActionPerformed

    private void btnAplicServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicServActionPerformed
        int iD1,iM1,iA1,iH1,iD2,iM2,iA2,iH2;
        String D1,M1,A1,D2,M2,A2;
        int nD1,nM1,nA1,nD2,nM2,nA2;
        
        iD1=Dia.getSelectedIndex();
        iM1=Mes.getSelectedIndex();
        iA1=Año.getSelectedIndex();
        iH1=Hora.getSelectedIndex();
        iD2=Dia1.getSelectedIndex();
        iM2=Mes1.getSelectedIndex();
        iA2=Año1.getSelectedIndex();
        iH2=Hora1.getSelectedIndex();
        
        if(iD1==0||iM1==0||iA1==0||iH1==0){
            JOptionPane.showMessageDialog(null, "Es necesario una fecha y hora de inicio");
        }  
        else{
            if(!chTerminado.isSelected()&&(iD2!=0||iM2!=0||iA2!=0||iH2!=0)){
                JOptionPane.showMessageDialog(null, "si tiene fecha de finalizacion tiene que estar terminado el servicio");
            }     
            else
                if(chTerminado.isSelected()&&(iD2!=0&&iM2!=0&&iA2!=0&&iH2!=0)){
                D1=Dia.getItemAt(iD1).trim();
                nD1=Integer.parseInt(D1);
                D2=Dia1.getItemAt(iD2).trim();
                nD2=Integer.parseInt(D2);
                M1=Mes.getItemAt(iM1).trim();
                nM1=Integer.parseInt(M1);
                M2=Mes1.getItemAt(iM2).trim();
                nM2=Integer.parseInt(M2);
                A1=Año.getItemAt(iA1).trim();
                nA1=Integer.parseInt(A1);
                A2=Año1.getItemAt(iA2).trim();
                nA2=Integer.parseInt(A2);

                if(nM1>nM2&&nA1==nA2){
                    JOptionPane.showMessageDialog(null, "Porfavor escoja un mes valido");
                }
                else
                    if(nM1==nM2&&nD1>nD2&&nA1==nA2){
                        JOptionPane.showMessageDialog(null, "Porfavor escoja un dia valida");
                    }
                else{
                    int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de los datos intoducidos?", "confirmación", 0);
                    if(op==0){
                        try{
                            Statement s= c.createStatement();
                             
                            String Finicio="'"+A1+"-"+M1+"-"+D1+"'";
                            String Hinicio="'"+Hora.getItemAt(iH1).trim()+":00'";
                            String Hfin="'"+Hora1.getItemAt(iH2).trim()+":00'";
                            String Ffin="'"+A2+"-"+M2+"-"+D2+"'";
                            String sql="UPDATE servicios SET\n"
                                    + "fecha_inicio="+Finicio+",\n"
                                    + "hora_inicio="+Hinicio+",\n"
                                    + "fecha_fin="+Ffin+",\n"
                                    + "hora_fin="+Hfin+",\n"
                                    + "terminado=TRUE";
                            int iEstab=Estab.getSelectedIndex();
                            if(iEstab!=0){
                                String Est=Estab.getItemAt(iEstab);
                                sql=sql+",\nid_establecimiento="+Est;
                            }
                            sql=sql+"\nWHERE id_servicio="+ids;
                            System.out.println(sql);
                            s.executeUpdate(sql);
                        }
                        catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Erroe en la BD");
                        }
                    }
                }
            }
            else{
                int op=JOptionPane.showConfirmDialog(null,"¿Está seguro de los datos intoducidos?", "confirmación", 0);
                if(op==0){
                    try{
                        D1=Dia.getItemAt(iD1).trim();
                        nD1=Integer.parseInt(D1);
                        M1=Mes.getItemAt(iM1).trim();
                        nM1=Integer.parseInt(M1);
                        A1=Año.getItemAt(iA1).trim();
                        nA1=Integer.parseInt(A1);
                        
                        Statement s= c.createStatement();
                             
                            String Finicio="'"+A1+"-"+M1+"-"+D1+"'";
                            String Hinicio="'"+Hora.getItemAt(iH1).trim()+":00'";
                            String sql="UPDATE servicios SET\n"
                                    + "fecha_inicio="+Finicio+",\n"
                                    + "hora_inicio="+Hinicio+",\n"
                                    + "fecha_fin=NULL,\n"
                                    + "hora_fin=NULL,\n"
                                    + "terminado=FALSE";
                            int iEstab=Estab.getSelectedIndex();
                            if(iEstab!=0){
                                String Est=Estab.getItemAt(iEstab);
                                sql=sql+",\n"
                                        + "id_establecimiento="+Est;
                            }
                            sql=sql+"\nWHERE id_servicio="+ids;
                            System.out.println(sql);                           
                            s.executeUpdate(sql);
                    }
                    catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Erroe en la BD");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAplicServActionPerformed

    private void btnAsigServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsigServActionPerformed
        int i=0;
        int rc=TTrab.getRowCount();
        while(i<rc){
            if(TTrab.isRowSelected(i)){
                ids=(String) modT.getValueAt(i, 0);
                int op=JOptionPane.showConfirmDialog(null,"¿Está seguro?", "confirmación", 0);
                if(op==0){
                    int id=Integer.parseInt(ids);
                    UsuarioConectado.idU=id; //guardamos el id del trabajador
                    dispose();
                    Asignar_Servicio a=new Asignar_Servicio();
                    a.setVisible(true);
                }
            }
            i++;
        } 
    }//GEN-LAST:event_btnAsigServActionPerformed

    private void AñadTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadTrabActionPerformed
        String Trab=Trabtxt.getText();
        System.out.println(Trab);
        if(Trab.trim().length()==0&&Trab.trim().length()<2){
            JOptionPane.showMessageDialog(null, "rellene el campo");
        }
        else{
            int op=JOptionPane.showConfirmDialog(null,"¿Está seguro?", "confirmación", 0);
            if(op==0){
                try{
                    Statement s= c.createStatement();
                    s.executeUpdate("INSERT INTO trabajos (nombre) VALUES ('"+Trab+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error en la BD");
                }
            }
        }
    }//GEN-LAST:event_AñadTrabActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        Inicio i=new Inicio();
        i.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiaActionPerformed

    private void MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MesActionPerformed

    private void Dia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Dia1ActionPerformed

    private void Mes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mes1ActionPerformed

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
    private javax.swing.JButton AñadTrab;
    private javax.swing.JComboBox<String> Año;
    private javax.swing.JComboBox<String> Año1;
    private javax.swing.JTextField CEtxt;
    private javax.swing.JTextField Contxt;
    private javax.swing.JTextField DNItxt;
    private javax.swing.JComboBox<String> Dia;
    private javax.swing.JComboBox<String> Dia1;
    private javax.swing.JComboBox<String> Estab;
    private javax.swing.JComboBox<String> Hora;
    private javax.swing.JComboBox<String> Hora1;
    private javax.swing.JComboBox<String> Mes;
    private javax.swing.JComboBox<String> Mes1;
    private javax.swing.JTextField Nomtxt;
    private javax.swing.JPanel PCT;
    private javax.swing.JPanel PS;
    private javax.swing.JTable TCli;
    private javax.swing.JTable TRTR;
    private javax.swing.JTable TServ;
    private javax.swing.JTable TTrab;
    private javax.swing.JTextField Teltxt;
    private javax.swing.JTextField Trabtxt;
    private javax.swing.JButton btnAplicServ;
    private javax.swing.JButton btnAplicUsuario;
    private javax.swing.JButton btnAsigServ;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBox chTerminado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
