/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package senati.presentacion;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import senati.datos.Conexion;
import senati.datos.Funciones;
import senati.entidades.Empleados;
import java.sql.*;
/**
 *
 * @author USER
 */
public class Formulario extends javax.swing.JFrame {
    
    Conexion conn = new Conexion();
    Funciones fun = new Funciones();
    Empleados ent = new Empleados();
    ArrayList listado = new ArrayList();
    
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String codigo, cargo, nombre, apellido, telefono;
    float sueldo, dscTotal, dscAFP, dscONP, grati, total;


    public Formulario() {
        initComponents();
        listarEmpleados();
    }
    
    void agregar(){
    
    
        
          
            String query = "  INSERT into empleado VALUES('"+codigo+"','"+cargo+"','"+nombre+"', '"+apellido+"','"+telefono+
                    "',"+sueldo+","+dscTotal+","+grati+","+total+") ";
            
            try{        
                Statement st = conn.conectar().createStatement();      
                st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, nombre + " agregado correctamente");
                              
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, nombre + " Error al agregar");
    }
        
    }
    
    void actualizar(){
    

          
            String query = "UPDATE empleado SET cargo='"+cargo+"', nombre='"+nombre+
                    "',apellido= '"+apellido+"', telefono = '"+telefono+"' , sueldo= "+sueldo+", descuento = "+dscTotal+", gratificacion = "
                    +grati+ " WHERE codigo ='"+codigo+"'";
            
            try{        
                Statement st = conn.conectar().createStatement();      
                st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, nombre + " actualizado correctamente");
                
                /*limpiar();*/                
                          
            }
            catch(Exception e){} 
    }
    
    void eliminar(){
        
        codigo = txtCodigo.getText();
        
        
        if(codigo.equals("")){
            
            JOptionPane.showMessageDialog(null, "Ingrese ID para eliminar");
            txtCodigo.requestFocus();
        }
        else{
          
            String query = " DELETE FROM empleado WHERE codigo = '"+codigo+"'";
            
            try{        
                Statement st = conn.conectar().createStatement();      
                st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, codigo + " eliminado correctamente");
                
                /*limpiar();*/
                
                          
            }
            catch(Exception e){} 
        }
    }
    
    void listarEmpleados(){
        
        fun.ListarEmpleados();
        
    
        try{
            
            
            listado = fun.ListarEmpleados();
            DefaultTableModel table = new DefaultTableModel();
            table.setColumnCount(0);
            table.addColumn("CODIGO");
            table.addColumn("CARGO");
            table.addColumn("NOMBRES");
            table.addColumn("APELLIDOS");
            table.addColumn("TELEFONO");
            table.addColumn("SUELDO");
            table.addColumn("DESCUENTO");
            table.addColumn("GRATI");
            table.addColumn("TOTAL");
            table.setRowCount(listado.size());
            
            for(int i = 0; i < listado.size(); i++){
                
                
                
                Empleados objEmp = (Empleados)listado.get(i);
                table.setValueAt(objEmp.getCodigo(), i ,0);
                table.setValueAt(objEmp.getCargo(), i ,1);
                table.setValueAt(objEmp.getNombres(), i ,2);
                table.setValueAt(objEmp.getApellido(), i ,3);
                table.setValueAt(objEmp.getTelefono(), i ,4);
                table.setValueAt(objEmp.getSueldo(), i ,5);
                table.setValueAt(objEmp.getDescuento(), i ,6);
                table.setValueAt(objEmp.getGratificacion(), i ,7);
                table.setValueAt(objEmp.getTotal(), i ,8);
            }
            
            jTable1.setModel(table);
            
        }catch(Exception e){
        
        }
    }
    
    
    void calcularDsc(){
        
        if(cbAFP.isSelected()){
            dscAFP = sueldo * 12 / 100;
            //JOptionPane.showMessageDialog(null,"marco afp");
            
        }
        if(cbONP.isSelected()){
            
            dscONP = sueldo * 8 / 100;
           
        }
        dscTotal = dscONP + dscAFP;
    }
    
    void calcularTotal(){
        
        total = sueldo + grati - dscTotal;
    }
    
    void calcularGrati(){
        
        if(cboCargo.getSelectedIndex()==0){
            
             JOptionPane.showMessageDialog(null,"Seleccione una categoria");
        }
             
        else if(cboCargo.getSelectedIndex()==1){
            cargo= "Administrador";
            grati = sueldo * 70 / 100;
        }
        else if(cboCargo.getSelectedIndex()==2){
            grati = sueldo * 60 / 100;
            cargo= "Contador";
        }   
        else if(cboCargo.getSelectedIndex()==3){
           grati = sueldo * 50 / 100;
           cargo= "Secretaria";
        }
    }
    
    void capturarCampos(){
    
        codigo = txtCodigo.getText();
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        telefono = txtTel.getText();
        sueldo = Float.parseFloat( txtSueldo.getText());
        calcularDsc();
        calcularGrati();
        calcularTotal();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        cboCargo = new javax.swing.JComboBox<>();
        cbAFP = new javax.swing.JCheckBox();
        cbONP = new javax.swing.JCheckBox();
        btnGrabar = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo");

        jLabel2.setText("Cargos");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Telefono");

        jLabel6.setText("Sueldo");

        jLabel7.setText("Descuentos");

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione un cargo", "Administrador", "Contador", "Secretaria" }));

        cbAFP.setText("AFP 12%");

        cbONP.setText("ONP 8%");

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)))
                                .addGap(167, 167, 167)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(222, 222, 222)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbAFP)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbONP))
                                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 232, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbAFP)
                            .addComponent(cbONP)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTel.setText("");
        txtSueldo.setText("");
        cboCargo.setSelectedIndex(0);
        cbAFP.setSelected(false);
        cbONP.setSelected(false);
        txtCodigo.requestFocus();
        
        
        
        
        
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        
        capturarCampos();
        agregar();
        listarEmpleados();

    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        capturarCampos();
        actualizar();
        listarEmpleados();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        eliminar();
        listarEmpleados();

    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbAFP;
    private javax.swing.JCheckBox cbONP;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
