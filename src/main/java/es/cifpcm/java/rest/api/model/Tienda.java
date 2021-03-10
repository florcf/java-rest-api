/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.java.rest.api.model;

/**
 *
 * @author Florencia Del Castillo Fleitas
 */
public class Tienda {
    private int idTienda;
    private String nombreTienda;
    private String direccion;
    private String localidad;
    private String telefono;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombreTienda, String direccion, String localidad, String telefono) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Tienda{" + "idTienda=" + idTienda + ", nombreTienda=" + nombreTienda + ", direccion=" + direccion + ", localidad=" + localidad + ", telefono=" + telefono + '}';
    }
    
}
