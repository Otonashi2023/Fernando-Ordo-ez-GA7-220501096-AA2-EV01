
package co.edu.sena.sser.controlador;

import co.edu.sena.sser.modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Otonashi
 */
public class CCliente {
    
    public void registrarPersona(Cliente p){
        try {
            Statement st= Conexion.getConect().createStatement();
            st.execute("insert into cliente values('"+p.getIdCliente()+"','"+p.getNombres()+"','"+p.getApellidos()+"','"+p.getCedula()+"','"+p.getTelefono()+"','"+p.getDireccion()+"','"+p.getCorreo()+"')");
            JOptionPane.showMessageDialog(null, " Equipo Registrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el equipo");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet ConsultarCliente(){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from cliente");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public ResultSet ConsultarClientePorID(int codigo){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from cliente where idCliente='"+codigo+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
        
    }
    
    public void ModificarCliente(Cliente p){
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("update cliente set nombres='"+p.getNombres()+"', apellidos='"+p.getApellidos()+"', cedula='"+p.getCedula()+"', telefono='"+p.getTelefono()+"', direccion='"+p.getDireccion()+"', correo='"+p.getCorreo()+"' where idCliente='"+p.getIdCliente()+"'");
            JOptionPane.showMessageDialog(null, "Actualizado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo actualizar");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void EliminarCliente(int codigo ){
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("delete from cliente where idCliente ='"+codigo+"'");
            JOptionPane.showMessageDialog(null, "Eliminado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Eliminado");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void pintarTabla(JTable tabla, ResultSet rs){
        
        DefaultTableModel modelo =new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CEDULA");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("CORREO");
        
        try {
            while( rs.next()){
                       
                String fila []={rs.getString("idCliente"),rs.getString("nombres"),rs.getString("apellidos"),rs.getString("cedula"),rs.getString("telefono"),rs.getString("direccion"),rs.getString("correo")};
                modelo.addRow(fila);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
