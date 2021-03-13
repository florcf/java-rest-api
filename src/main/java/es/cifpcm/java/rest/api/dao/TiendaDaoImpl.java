/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.java.rest.api.dao;

import es.cifpcm.java.rest.api.model.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Florencia Del Castillo Fleitas
 */
public class TiendaDaoImpl implements TiendaDao {

    private Tienda tienda;

    private DaoFactory daoFactory;
    private final Logger logger = LoggerFactory.getLogger(DaoFactory.class);

    public TiendaDaoImpl() {
        this.daoFactory = DaoFactory.createInstance();
    }

    @Override
    public Tienda getTienda(int num) {
        Connection connection = this.daoFactory.getConnection();
        if (connection != null) {
            PreparedStatement stmt = null;
            try {
                String sql = "SELECT IdTienda, NombreTienda, Direccion, Localidad, Telefono FROM tienda where IdTienda = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setInt(1, num);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int idTienda = rs.getInt("IdTienda");
                    String nombreTienda = rs.getString("NombreTienda");
                    String direccion = rs.getString("Direccion");
                    String localidad = rs.getString("Localidad");
                    String telefono = rs.getString("Telefono");

                    this.tienda = new Tienda(idTienda, nombreTienda, direccion, localidad, telefono);
                }

                rs.close();
                stmt.close();

                this.daoFactory.closeConnection(connection);
            } catch (SQLException ex) {
                logger.error("Error al realizar la consulta. ", ex);
                System.out.println("Exception: " + ex);
            }
        }
        return this.tienda;
    }

    @Override
    public List<Tienda> getTiendas() {
        List<Tienda> tiendas = new ArrayList<Tienda>();
        Connection connection = this.daoFactory.getConnection();
        if (connection != null) {
            PreparedStatement stmt = null;
            try {
                String sql = "SELECT IdTienda, NombreTienda, Direccion, Localidad, Telefono FROM tienda";
                stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int idTienda = rs.getInt("IdTienda");
                    String nombreTienda = rs.getString("NombreTienda");
                    String direccion = rs.getString("Direccion");
                    String localidad = rs.getString("Localidad");
                    String telefono = rs.getString("Telefono");

                    Tienda tienda = new Tienda(idTienda, nombreTienda, direccion, localidad, telefono);
                    tiendas.add(tienda);
                }
                rs.close();
                stmt.close();

                this.daoFactory.closeConnection(connection);
            } catch (SQLException ex) {
                logger.error("Error al realizar la consulta. ", ex);
                System.out.println("Exception: " + ex);
            }
        }
        return tiendas;
    }

    @Override
    public int addTienda(Tienda tiendaRequest) {
        int num = 0;
        List<Tienda> tiendas = this.getTiendas();
        if (tiendas.size() > 0) {
            int lastId = this.getLastId(tiendas);
            if (lastId != -1) {
                Connection connection = this.daoFactory.getConnection();
                if (connection != null) {
                    PreparedStatement stmt = null;
                    try {
                        String sql = "insert into tienda values (?, ?, ?, ?, ?)";
                        stmt = connection.prepareStatement(sql);
                        stmt.setInt(1, lastId + 1);
                        stmt.setString(2, tiendaRequest.getNombreTienda());
                        stmt.setString(3, tiendaRequest.getDireccion());
                        stmt.setString(4, tiendaRequest.getLocalidad());
                        stmt.setString(5, tiendaRequest.getTelefono());
                        num = stmt.executeUpdate(); // Devuelve el número de filas afectadas.
                        stmt.close();
                        this.daoFactory.closeConnection(connection);
                    } catch (SQLException ex) {
                        logger.error("Error al realizar la consulta. ", ex);
                        System.out.println("Exception: " + ex);
                    }
                }
            }
        }
        return num;
    }

    public int getLastId(List<Tienda> tiendas) {
        Tienda lastRegister = tiendas.get(tiendas.size() - 1);
        int id = lastRegister.getIdTienda();
        if (id > 0) {
            return id;
        } else {
            return -1;
        }
    }

}
