
package co.edu.sena.sser.controlador;

import co.edu.sena.sser.modelo.OrdenR;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class COrdenR {
    
    public void registrarOrdenR(OrdenR o){
        try {
            Statement st= Conexion.getConect().createStatement();
            st.execute("insert into ordenr (estado, tipo_servicio, observacion, cliente, equipo, empleado) values('"+o.getEstado()+"','"+o.getTipo_servicio()+"','"+o.getObservacion()+"','"+o.getCliente()+"','"+o.getEquipo()+"','"+o.getEmpleado()+"')");
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el equipo");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String idTecnico(String idTec){
            char caracteres[] = idTec.toCharArray();
            String digitos[] = new String[3];
            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i<3; i++){
                digitos[i] = String.valueOf(caracteres[i]);
            }
            
            for (int j=0 ;j<3; j++){
                sb =sb.append(digitos[j]);
            }
            String str =sb.toString();
            return str;
            }
    
    
    public ResultSet ConsultarOrdenR(){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from ordenR");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public ResultSet ConsultarEquipoPorID(int codigo){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from ordenr where idOrdenr='"+codigo+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public void ModificarOrdenR(OrdenR o){
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("update ordenr set estado='"+o.getEstado()+"', tipo_servicio='"+o.getTipo_servicio()+"', observacion='"+o.getObservacion()+"', cliente='"+o.getCliente()+"', equipo='"+o.getEquipo()+"', empleado='"+o.getEmpleado()+"' where idOrdenR='"+o.getIdOrdenR()+"'");
            JOptionPane.showMessageDialog(null, "Actualizado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo actualizar");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void EliminarOrdenR(int codigo){
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("delete from ordenr where idOrdenr='"+codigo+"'");
            JOptionPane.showMessageDialog(null, "Eliminado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Eliminado");
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void pintarTabla(JTable tabla, ResultSet rs){
        
        DefaultTableModel modelo =new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("FECHA");
        modelo.addColumn("ESTADO");
        modelo.addColumn("TIPO_SERVICIO");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("EQUIPO");
        modelo.addColumn("EMPLEADO");
        modelo.addColumn("OBSERVACIONES");
        
        
        try {
            while( rs.next()){
                       
                String fila []={rs.getString("idOrdenR"),rs.getString("fecha_hora"),rs.getString("estado"),rs.getString("tipo_servicio"),rs.getString("cliente"),rs.getString("equipo"),rs.getString("empleado"),rs.getString("observacion")};
                modelo.addRow(fila);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
