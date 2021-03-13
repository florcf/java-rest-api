/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.java.rest.api.dao;

import es.cifpcm.java.rest.api.model.Tienda;
import java.util.List;

/**
 *
 * @author Florencia Del Castillo Fleitas
 */
public interface TiendaDao {
    public Tienda getTienda(int num);
    public List<Tienda> getTiendas();
    public int addTienda(Tienda tienda);
}
