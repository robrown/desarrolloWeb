package controller;

import java.util.Vector;

import config.cBaseDatos;
import config.cParametro;

public class cUsuario extends cNegocioBase {

    public cUsuario() {
       this.objDB = new cBaseDatos();
       this.objDB.conectar();
    }

    public cUsuario(cBaseDatos objDB) {
       this.objDB = objDB;
    }

    public Vector getRegistros() {
    	String sql  = "select codigo, nombre, login, tipo, estado " +
    	              "from usuarios order by codigo ";
        Vector vr = this.objDB.query(sql);
    	return vr;
    }

    public Vector getRegistro( String pCodigo ) {
        String sql  = "select codigo, nombre, login, tipo, estado, clave " +
    	              "from usuarios where codigo=?";
        cParametro[] aParam = { new cParametro( pCodigo, cParametro.TIPOS.INT) };
    	Vector vr = this.objDB.query( sql, aParam );
        Vector fila = (Vector)vr.get(0);
    	return fila;
    }

    protected String getNuevoCodigo() {
    	String rpta = "";
    	String sql = "select count(*) from usuarios";
        int cant = Integer.parseInt(this.objDB.querySimple(sql).toString());
    	if ( cant <= 0 )
    		rpta = "1001";
    	else {
        	sql = "select max(codigo*1) from usuarios";
                cant = Integer.parseInt(this.objDB.querySimple(sql).toString()) + 1;
    		rpta = "" + cant;
    	}
    	return rpta;
    }

    public void grabarNuevoRegistro( String[] datos ) {
        if ( datos[4].trim().length() > 0 ) {
            if ( datos[4].trim().equals( datos[5].trim() ) ) {
               cParametro[] aParam = {
                   new cParametro( this.getNuevoCodigo(), cParametro.TIPOS.INT),
                   new cParametro( datos[0], cParametro.TIPOS.VARCHAR ),    //nombre
                   new cParametro( datos[1], cParametro.TIPOS.VARCHAR ),    //login
                   new cParametro( datos[2], cParametro.TIPOS.VARCHAR ),    //tipo
                   new cParametro( datos[3], cParametro.TIPOS.VARCHAR ),    //estado
                   new cParametro( datos[3], cParametro.TIPOS.VARCHAR )     //clave
               };
               String sql = "insert into usuarios (codigo,nombre,login,tipo," +
                            "estado,clave) values (?,?,?,?,?,?) ";
               this.objDB.insert(sql, aParam);
            }
        }
        else {
            cParametro[] aParam = {
                new cParametro( this.getNuevoCodigo(), cParametro.TIPOS.INT),
                new cParametro( datos[0], cParametro.TIPOS.VARCHAR ),    //nombre
                new cParametro( datos[1], cParametro.TIPOS.VARCHAR ),    //login
                new cParametro( datos[2], cParametro.TIPOS.VARCHAR ),    //tipo
                new cParametro( datos[3], cParametro.TIPOS.VARCHAR )     //estado
            };
            String sql = "insert into usuarios (codigo,nombre,login,tipo," +
                         "estado) values (?,?,?,?,?) ";
            this.objDB.insert(sql, aParam);
        }
    }

    public void grabarModificarRegistro( String[] datos ) {
        if ( datos[4].trim().length() > 0 ) {
            if ( datos[4].trim().equals( datos[5].trim() ) ) {
               cParametro[] aParam = {
                   new cParametro( datos[1], cParametro.TIPOS.VARCHAR ),  //nombre
                   new cParametro( datos[2], cParametro.TIPOS.VARCHAR ),  //login
                   new cParametro( datos[3], cParametro.TIPOS.VARCHAR ),  //tipo
                   new cParametro( datos[4], cParametro.TIPOS.VARCHAR ),  //estado
                   new cParametro( datos[5], cParametro.TIPOS.VARCHAR ),  //clave
                   new cParametro( datos[0], cParametro.TIPOS.INT )       //codigo
               };
               String sql = "update usuarios set nombre=?, login=?, tipo=?, " +
                            "estado=?, clave=? where codigo=? ";
               this.objDB.update(sql, aParam);
            }
        }
        else {
            cParametro[] aParam = {
                new cParametro( datos[1], cParametro.TIPOS.VARCHAR ),  //nombre
                new cParametro( datos[2], cParametro.TIPOS.VARCHAR ),  //login
                new cParametro( datos[3], cParametro.TIPOS.VARCHAR ),  //tipo
                new cParametro( datos[4], cParametro.TIPOS.VARCHAR ),  //estado
                new cParametro( datos[0], cParametro.TIPOS.INT )       //codigo
            };
            String sql = "update usuarios set nombre=?, login=?, tipo=?, " +
                         "estado=? where codigo=? ";
            this.objDB.update(sql, aParam);
        }
    }

    public void eliminarRegistros( String[] datos ) {
	boolean inicio;
    	if ( datos.length <= 0 )
    	   return;
    	String sql  = "DELETE FROM usuarios WHERE codigo in ( ";
    	inicio = true;
        cParametro[] aParam = new cParametro[datos.length];
    	for( int xc = 0 ; xc < datos.length ; xc++ ) {
            aParam[xc] = new cParametro(datos[xc], cParametro.TIPOS.INT);
    	    if ( inicio )
    	      sql += "?";
    	    else
    	      sql += ",?";
    	    inicio = false;
    	}
    	sql += ")";
    	this.objDB.delete( sql, aParam );
    }

    public boolean existeUsuario(String pLogin, String pClave) {
        boolean rpta = false;
        String sql = "select count(*) from usuarios where login=? and clave=?";
        cParametro[] aParam = { new cParametro( pLogin, cParametro.TIPOS.VARCHAR),
                                new cParametro( pClave,  cParametro.TIPOS.VARCHAR)};
        int cantidad = ((Long)objDB.querySimple(sql, aParam)).intValue();
        if ( cantidad > 0 )
            rpta = true;
        return rpta;
    }

}