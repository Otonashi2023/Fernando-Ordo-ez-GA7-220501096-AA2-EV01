
package co.edu.sena.sser.modelo;

import java.math.BigInteger;


public class Equipo {
    
    private int idEquipo;
    private String tipo;
    private String marca;
    private String modelo;
    private BigInteger serial;

    public Equipo(int idEquipo, String tipo, String marca, String modelo, BigInteger serial) {
        this.idEquipo = idEquipo;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigInteger getSerial() {
        return serial;
    }

    public void setSerial(BigInteger serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", serial=" + serial + '}';
    }

    
    
}
