/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.java.rest.api.services;

import es.cifpcm.java.rest.api.dao.TiendaDao;
import es.cifpcm.java.rest.api.dao.TiendaDaoImpl;
import es.cifpcm.java.rest.api.model.Tienda;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
/**
 *
 * @author Florencia Del Castillo Fleitas
 */
@Path("tiendas")
public class TiendaRest {

    private final TiendaDao tiendaDao = new TiendaDaoImpl();

    public TiendaRest() {
    }
    
    // Al usar la dependencia jersey-media-json-jackson, no es necesario convertitr objetos.

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getTienda(@PathParam("id") int id) {
        Tienda tienda = this.tiendaDao.getTienda(id);
        if (tienda != null) {
            return Response.status(200).entity(tienda).build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("La tienda no existe.").build();
        }
    }

    @GET
    @Produces("application/json")
    public Response getTiendas() {
        List<Tienda> tiendas = this.tiendaDao.getTiendas();
        if (tiendas.size() > 0) {
            return Response.status(200).entity(tiendas).build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("Error. No se ha podido obtener la lista de tiendas.").build();
        }
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void addTienda(Tienda tiendaRequest) {
        this.tiendaDao.addTienda(tiendaRequest);             
    }
}
