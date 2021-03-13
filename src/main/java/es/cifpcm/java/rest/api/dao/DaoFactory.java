/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.java.rest.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Florencia Del Castillo Fleitas
 */
public class DaoFactory {

    private final Logger logger = LoggerFactory.getLogger(DaoFactory.class);
    private static DaoFactory instance;
    protected final DaoConfig dfc;

    // Se ejecuta una sola vez
    protected DaoFactory() {
        this.dfc = new DaoConfig();
        ResourceBundle rb = ResourceBundle.getBundle("database");
        try {
            this.dfc.setDriverClassName(rb.getString("database.driver"));
            this.dfc.setDatabaseUrl(rb.getString("database.url"));
            this.dfc.setDatabaseUser(rb.getString("database.user"));
            this.dfc.setDatabasePassword(rb.getString("database.password"));

            Class.forName(this.dfc.getDriverClassName());
        } catch (ClassNotFoundException ex) {
            logger.debug("Error cargando driver." + ex.toString());
            logger.error("Error cargando driver.", ex);
        }
    }

    /**
     * Se llama la primera vez para crear la fábrica de objetos.
     *
     * @return
     */
    public static synchronized DaoFactory createInstance() {
        // El método es synchronized, no pueden entrar dos hilos a la vez
        // Se asegura que sólo se crea una instancia de la DaoFactory
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(dfc.getDatabaseUrl(),
                    dfc.getDatabaseUser(), dfc.getDatabasePassword());
        } catch (SQLException ex) {
            logger.error("getConnection", ex);
            return null;
        }
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.error("closeConnection", ex);
            }
        }
    }

    /**
     * Devuelve la fábrica creada
     *
     * @return
     */
    public static DaoFactory getInstance() {
        return instance;
    }

}
