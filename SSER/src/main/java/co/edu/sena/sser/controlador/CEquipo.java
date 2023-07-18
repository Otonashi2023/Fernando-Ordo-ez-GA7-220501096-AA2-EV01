
package co.edu.sena.sser.controlador;

import co.edu.sena.sser.modelo.Equipo;
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
public class CEquipo {
    public void registrarEquipo(Equipo e){
        try {
            Statement st= Conexion.getConect().createStatement();
            st.execute("insert into equipo values('"+e.getIdEquipo()+"','"+e.getTipo()+"','"+e.getMarca()+"','"+e.getModelo()+"','"+e.getSerial()+"')");
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el equipo");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet ConsultarEquipo(){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from equipo");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public ResultSet ConsultarEquipoPorID(int codigo){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from equipo where idEquipo='"+codigo+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public void ModificarEquipo(Equipo e){
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("update equipo set tipo='"+e.getTipo()+"', marca='"+e.getMarca()+"', modelo='"+e.getModelo()+"', numero_serial='"+e.getSerial()+"' where idEquipo='"+e.getIdEquipo()+"'");
            JOptionPane.showMessageDialog(null, "Actualizado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo actualizar");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void EliminarEquipo(int codigo){
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("delete from Equipo where idEquipo='"+codigo+"'");
            JOptionPane.showMessageDialog(null, "Eliminado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Eliminado");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void pintarTabla(JTable tabla, ResultSet rs){
        
        DefaultTableModel modelo =new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("TIPO");
        modelo.addColumn("MARCA");
        modelo.addColumn("MODELO");
        modelo.addColumn("# SERIAL");
        
        try {
            while( rs.next()){
                       
                String fila []={rs.getString("idEquipo"),rs.getString("tipo"),rs.getString("marca"),rs.getString("modelo"),rs.getString("numero_serial")};
                modelo.addRow(fila);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
