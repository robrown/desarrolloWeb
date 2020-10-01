package config;

import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class cBaseDatos {
	/* 
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://172.16.0.176/bdcc";
    private final String user = "root";
    private final String pasw = "tecsup"; */

    private String driver= "org.postgresql.Driver";
    private String url   = "jdbc:postgresql://localhost:5432/bdcc";
    private String user  = "postgres";
    private String pasw  = "timmax0810"; 
    private Connection db;

    public cBaseDatos() {
    	try {
    		try {
    			// We register the PostgreSQL driver
                // Registramos el driver de PostgresSQL
    			Class.forName(driver);
    		} catch (ClassNotFoundException ex) {
    			System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
    		}
            
    		// Database connect
            // Conectamos con la base de datos
    		
            this.db = DriverManager.getConnection(url, user, pasw);
            boolean valid = this.db.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch(java.sql.SQLException sqle) {
        	System.out.println("Error: " + sqle);
        }
    }

    public boolean conectar(){
        try {
        	try {
        		Class.forName(driver);
        	} catch (ClassNotFoundException ex) {
    			System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
    		}
            
            this.db = DriverManager.getConnection(url, user, pasw);
            return true;
        } catch(java.sql.SQLException sqle) {
        	System.out.println("Error: " + sqle);
        }
        return false;
    }

    public boolean desconectar() {
        try {
            this.db.close();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Vector ResultSetToVector(ResultSet rs) throws SQLException {
        Vector vRows = new Vector();
        while(rs.next()) {
            Vector vCol = new Vector();
            int nroFields = rs.getMetaData().getColumnCount();
            for(int i=1 ; i <=nroFields; i++) {
                String strTmp = rs.getString(i);
                vCol.add(strTmp);
            }
            vRows.add(vCol);
        }
        return vRows;
    }

    public void performance(String str) {
        try {
            Statement stmt = this.db.createStatement();
            stmt.executeUpdate(str);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performance(String sql, cParametro aParam []) {
        PreparedStatement pstm;
        try {
            pstm = this.db.prepareStatement (sql);
            if ( aParam != null ) {
                for(int xc=0 ; xc < aParam.length ; xc ++) {
                   if ( aParam[xc].getTipo() == cParametro.TIPOS.INT )
                       pstm.setInt(xc+1, aParam[xc].getInt());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.DOUBLE )
                       pstm.setDouble(xc+1, aParam[xc].getDouble());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.VARCHAR )
                       pstm.setString(xc+1, aParam[xc].getVarchar());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.DATE )
                       pstm.setDate(xc+1, aParam[xc].getFecha());
               }
            }
            pstm.executeUpdate();
            pstm.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Vector query(String strQuery) {
        Vector vRet = null;
        try {
            Statement stm = this.db.createStatement();
            ResultSet rs = stm.executeQuery(strQuery);
            vRet = ResultSetToVector(rs);
            rs.close();
            stm.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return vRet;
    }

    public Object querySimple(String strQuerySimple ) {
        Object vRet = null;
        try {
            Statement stm = this.db.createStatement();
            ResultSet rs = stm.executeQuery(strQuerySimple);
            rs.next();
            vRet = rs.getObject(1);
            rs.close();
            stm.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return vRet;
    }

    public Vector query(String strQuery, cParametro aParam []) {
        Vector vRet = null;
        try {
            PreparedStatement pstm = this.db.prepareStatement(strQuery);
            if ( aParam != null ) {
                for(int xc=0 ; xc < aParam.length ; xc ++) {
                   if ( aParam[xc].getTipo() == cParametro.TIPOS.INT )
                       pstm.setInt(xc+1, aParam[xc].getInt());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.DOUBLE )
                       pstm.setDouble(xc+1, aParam[xc].getDouble());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.VARCHAR )
                       pstm.setString(xc+1, aParam[xc].getVarchar());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.DATE )
                       pstm.setDate(xc+1, aParam[xc].getFecha());
               }
            }
            ResultSet rs = pstm.executeQuery();
            vRet = ResultSetToVector(rs);
            rs.close();
            pstm.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return vRet;
    }

    public Object querySimple(String strQuerySimple, cParametro aParam []) {
        Object vRet = null;
        try {
        	
            PreparedStatement pstm = this.db.prepareStatement(strQuerySimple);
            if ( aParam != null ) {
                for(int xc=0 ; xc < aParam.length ; xc ++) {
                   if ( aParam[xc].getTipo() == cParametro.TIPOS.INT )
                       pstm.setInt(xc+1, aParam[xc].getInt());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.DOUBLE )
                       pstm.setDouble(xc+1, aParam[xc].getDouble());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.VARCHAR )
                       pstm.setString(xc+1, aParam[xc].getVarchar());
                   else if ( aParam[xc].getTipo() == cParametro.TIPOS.DATE )
                       pstm.setDate(xc+1, aParam[xc].getFecha());
               }
            }
            ResultSet rs = pstm.executeQuery();
            rs.next();
            vRet = rs.getObject(1);
            rs.close();
            pstm.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return vRet;
    }

    public void sp_proc (String sp_name, String aParam[]) {
        try {
            CallableStatement cs = this.db.prepareCall(sp_name);
            for(int xc=0 ; xc < aParam.length ; xc++)
                cs.setString(xc+1, aParam[xc]);
            cs.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String strDelete) {
        performance(strDelete);
    }

    public void update(String strUpdate) {
        performance(strUpdate);
    }

    public void insert(String strInsert) {
        performance(strInsert);
    }

    public void delete(String strDelete, cParametro aParam[]) {
        performance(strDelete, aParam);
    }

    public void update(String strUpdate, cParametro aParam[]) {
        performance(strUpdate, aParam);
    }

    public  void insert (String strInsert, cParametro aParam[]) {
        performance(strInsert, aParam);
    }

    public String codificar(String cad) {
        String rpta="";
        for(int xc=0; xc<cad.length(); xc++) {
            char c=cad.charAt(xc);
            if(c==' ')
                rpta += "+";
            else
                rpta += c;
        }
        return rpta;
    }

    public Connection obtenerConexion() {
        return db;
    }

    public String getFecha() {
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        DateFormat formato = new SimpleDateFormat( "yyyy-MM-dd" );
        return formato.format( date ) ;
    }
}