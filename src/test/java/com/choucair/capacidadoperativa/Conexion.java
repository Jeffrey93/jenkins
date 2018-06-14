package com.choucair.capacidadoperativa;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class Conexion {
	static Connection cnn;

	public static void main(String[] args) {

	}
	public
	static String jvmBitVersion(){
	 return System.getProperty("sun.arch.data.model");
	}
	public static void setConnection(String strServidor, String strDatabase, String strUsuario, String strContrasena) {
		try {
			if(cnn==null)
			{	
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser(strUsuario);
				ds.setPassword(strContrasena);
				ds.setServerName(strServidor);
				ds.setPortNumber(1433);
				ds.setDatabaseName(strDatabase);
				cnn = ds.getConnection();
			}
		} catch (Exception e) {
			System.out.println("ERROR en setConnection: " + e.getMessage());
		}
	}	

}
