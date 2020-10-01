package controller;

import java.sql.Connection;

import config.cBaseDatos;

public class cNegocioBase {
	protected cBaseDatos objDB = null;

    public Connection obtenerConexion() {
        return objDB.obtenerConexion();
    }

    public cBaseDatos obtenerObjetoDB() {
        return objDB;
    }

}
