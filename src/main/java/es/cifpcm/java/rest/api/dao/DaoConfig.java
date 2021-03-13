/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.java.rest.api.dao;

/**
 *
 * @author Florencia Del Castillo Fleitas
 */
public class DaoConfig {

    private String driverClassName;
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;

    public DaoConfig() {
    }

    public DaoConfig(final DaoConfig dfc) {
        this.driverClassName = dfc.driverClassName;
        this.databaseUrl = dfc.databaseUrl;
        this.databaseUser = dfc.databaseUser;
        this.databasePassword = dfc.databasePassword;
    }

    public DaoConfig(String driverClassName, String databaseUrl, String databaseUser, String databasePassword) {
        this.driverClassName = driverClassName;
        this.databaseUrl = databaseUrl;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }
}
