/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofincurso.clases;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author DAW
 */
public class ConectBD {
    
    private Connection c = null;
    private String query = null;
    private ResultSet rs;
    private final String url="jdbc:mysql://localhost/limpieza";
    private final String usrName = "JavierC";
    private final String pwd= "Arcoiris";
    private final String Driver="com.mysql.jdbc.Driver";

    public Connection ConectBD() {
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
