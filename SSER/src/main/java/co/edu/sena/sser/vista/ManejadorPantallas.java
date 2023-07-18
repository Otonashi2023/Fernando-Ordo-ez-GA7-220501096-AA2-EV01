
package co.edu.sena.sser.vista;

/**
 *
 * @author Otonashi
 */
public class ManejadorPantallas {
    
    private static VCliente pantallaCliente;
    private static VEquipo pantallaEquipo;
    private static VOrdenR pantallaOrdenR;
    
    public static void abrirPantallaCliente(){
        
        pantallaCliente = new VCliente();
        pantallaCliente.setVisible(true);
        pantallaCliente.setLocation(3,10);
    }
    
    public static void cerrarPantallaCLiente(){
        
        pantallaCliente.setVisible(false);
        pantallaCliente=null;
    }
    
    public static void abrirPantallaEquipo(){
        
        pantallaEquipo = new VEquipo();
        pantallaEquipo.setVisible(true);
        pantallaEquipo.setLocation(3,390);
    }
    
    public static void cerrarPantallaEquipo(){
        
        pantallaEquipo.setVisible(false);
        pantallaEquipo=null;
    }
    
    public static void abrirPantallaOrdenR(){
        
        pantallaOrdenR = new VOrdenR();
        pantallaOrdenR.setVisible(true);
        pantallaOrdenR.setLocation(360,150);
    }
}
