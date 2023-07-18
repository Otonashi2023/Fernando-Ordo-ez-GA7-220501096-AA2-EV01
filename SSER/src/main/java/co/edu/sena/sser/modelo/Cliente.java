
package co.edu.sena.sser.modelo;

import java.math.BigInteger;


public class Cliente {
    
    private int idCliente;
    private String nombres;
    private String apellidos;
    private BigInteger cedula;
    private BigInteger telefono;
    private String direccion;
    private String correo;

    public Cliente(int idCliente, String nombres, String apellidos, BigInteger cedula, BigInteger telefono, String direccion, String correo) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + '}';
    }
    
        
}