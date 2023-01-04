/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senati.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Conexion {
    
     private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conn = null;
    
    
    public Connection conectar(){
        
        try{
            
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL, USER, PASS);
       System.out.println("Conexion exitosa");
            
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error al conectar" + e.getMessage());
        }
        
        return conn;
    }
    
    public void desconectar(){
        
        try{
            
            conn.close();
            System.out.println("Desconexion exitosa");
            
        }catch(Exception e){
   
        }
    }
}
