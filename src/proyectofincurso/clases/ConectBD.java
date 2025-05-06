/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofincurso.clases;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author DAW
 */
public class ConectBD {
    
    private static Connection c = null;
    private static final String url="jdbc:mysql://localhost/limpieza";
    private static final String usrName = "JavierC";
    private static final String pwd= "Arcoiris";
    private static final String Driver="com.mysql.jdbc.Driver";

    public static Connection Conexion() {
        try{
            Class.forName(Driver);
            c = DriverManager.getConnection(url, usrName, pwd);      
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la BD");
        } 
        catch (ClassNotFoundException ex) {            
            JOptionPane.showMessageDialog(null, "error al encontrar Drivers");
        }
        return c;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
