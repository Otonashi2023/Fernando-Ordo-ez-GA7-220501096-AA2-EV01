
package co.edu.sena.sser;


import co.edu.sena.sser.controlador.Conexion;
import co.edu.sena.sser.vista.ManejadorPantallas;


public class SSER {

    public static void main(String[] args) {
        
        Conexion.conectar();
        ManejadorPantallas.abrirPantallaCliente();
        ManejadorPantallas.abrirPantallaEquipo();
        ManejadorPantallas.abrirPantallaOrdenR();
        
    }
}
