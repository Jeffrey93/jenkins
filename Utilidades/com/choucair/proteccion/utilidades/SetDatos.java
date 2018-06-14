package com.choucair.proteccion.utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;


public class SetDatos {

	public static Map<String, String> credenciales = Utilidades.getCredentials("=");
	public static ConexionAS400 conexionAS400 = getConexionAS400();
	public static final Map<String,String> mapaValores = Maps.newHashMap();
	
	
	private static ConexionAS400 getConexionAS400(){	
		ConexionAS400 conexion = new ConexionAS400(credenciales.get("systemProp.as400.ip"), 
				credenciales.get("systemProp.as400.user"), credenciales.get("systemProp.as400.pasw"));
		
		return conexion;
	}
	
	
	public static List<Afiliado> setDatosBuscarAfiliado(){
		List<Afiliado> resultado=Lists.newArrayList();
		long identificacion = (long) (Math.random() * 99999999l);
		
		String sql= "SELECT AFINUM, AFITIP FROM UNICLIDA.ZAFARC, UNICLIDA.ZPRARC "
				+ "WHERE AFINUM = PRONUM AND PROCO2 = 'VOL' AND PROEST = 'ACT' AND PROES1 = 'ACT' AND PROTID = 'CC'"
				+ " AND AFINUM IN (SELECT CLACED FROM SISCLADA.CLAVES WHERE CLACL1 = 'gCZIG4SybvY8MjebHYhcLKRmEnO7') AND AFINUM >= "+identificacion+" limit 4";
		
		
	   try {
		ResultSet rs = conexionAS400.consultar(sql);
	   
	   while (rs != null && rs.next()) {
		    
		    String tipoID = rs.getString("AFITIP").trim();
			String numID = rs.getString("AFINUM").trim();
			String usuario = tipoID + numID;
			resultado.add(new Afiliado(tipoID, numID, usuario));
	   }
		
	   } 
	   catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		if(resultado.isEmpty()){
			setDatosBuscarAfiliado();
		}
	   
		return resultado;
	}
	
}
