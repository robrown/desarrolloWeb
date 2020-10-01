package config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class cParametro {
    public static enum TIPOS { INT , DOUBLE , VARCHAR , DATE };
    private TIPOS tipoP;
    private String valorS;
    private double valorD;
    private int valorI;
    private java.sql.Date valorF;

    public cParametro( String valor, TIPOS tipo) {
        tipoP = tipo;
        if (tipoP == TIPOS.INT )
            valorI = Integer.parseInt(valor);
        else if (tipoP == TIPOS.DOUBLE )
            valorD = Double.parseDouble(valor);
        else if (tipoP == TIPOS.VARCHAR )
            valorS = valor;
        else if (tipoP == TIPOS.DATE ) {
            try {
               DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
               java.util.Date fecha = df.parse( valor );
               long t = fecha.getTime();
               valorF = new java.sql.Date(t);
            } catch(Exception ex) {System.out.println(ex.toString());}
        }
    }

    public int getInt() { return valorI; }
    public double getDouble() { return valorD; }
    public String getVarchar() { return valorS; }
    public java.sql.Date getFecha() { return valorF; }

    public TIPOS getTipo() { return tipoP; }
}