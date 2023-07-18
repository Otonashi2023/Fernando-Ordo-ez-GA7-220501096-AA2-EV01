
package co.edu.sena.sser.modelo;



public class OrdenR {
    private int idOrdenR;
    private String estado;
    private String tipo_servicio;
    private String observacion;
    private int cliente;
    private int equipo;
    private int empleado;

    public OrdenR(int idOrdenR, String estado, String tipo_servicio, String observacion, int cliente, int equipo, int empleado) {
        this.idOrdenR = idOrdenR;
        this.estado = estado;
        this.tipo_servicio = tipo_servicio;
        this.observacion = observacion;
        this.cliente = cliente;
        this.equipo = equipo;
        this.empleado = empleado;
    }
    
    

    public OrdenR( String estado, String tipo_servicio, String observacion, int cliente, int equipo, int empleado) {
        //this.idOrdenR = idOrdenR;
        this.estado = estado;
        this.tipo_servicio = tipo_servicio;
        this.observacion = observacion;
        this.cliente = cliente;
        this.equipo = equipo;
        this.empleado = empleado;
    }

    public OrdenR(int idOrdenR) {
        this.idOrdenR = idOrdenR;
    }
    

    public int getIdOrdenR() {
        return idOrdenR;
    }

    public void setIdOrdenR(int idOrdenR) {
        this.idOrdenR = idOrdenR;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "OrdenR{" + "idOrdenR=" + idOrdenR + ", estado=" + estado + ", tipo_servicio=" + tipo_servicio + ", observacion=" + observacion + ", cliente=" + cliente + ", equipo=" + equipo + ", empleado=" + empleado + '}';
    }
    
    
    
}
