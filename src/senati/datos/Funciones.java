/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senati.datos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import senati.entidades.Empleados;

/**
 *
 * @author USER
 */
public class Funciones {
    
    public ArrayList ListarEmpleados(){
        
        Conexion conn = new Conexion();
        ArrayList lista = new ArrayList();
         
        
        try{
            Statement sql = conn.conectar().createStatement();
            String query = "SELECT * FROM empleado";
            ResultSet res = sql.executeQuery(query);
            
            while(res.next()){
            
                Empleados objEmpleado = new Empleados();
                
                objEmpleado.setCodigo(res.getString(1));
                objEmpleado.setCargo(res.getString(2));
                objEmpleado.setNombres(res.getString(3));
                objEmpleado.setApellido(res.getString(4));
                objEmpleado.setTelefono(res.getString(5));
                objEmpleado.setSueldo(res.getFloat(6));
                objEmpleado.setDescuento(res.getFloat(7));
                objEmpleado.setGratificacion(res.getFloat(8));
                objEmpleado.setTotal(res.getFloat(9));
                lista.add(objEmpleado);   
            }    
            
        }catch(SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        return lista;
    }
    
    
}
