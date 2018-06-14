package com.choucair.proteccion.utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Conexion_bd {
	static Connection cnn;
	public static Conexion_bd instanceConexionBD;

	public Conexion_bd() {
		setConnection(Mdl_variables.strServidor,Mdl_variables.strBD,Mdl_variables.strUsuario,Mdl_variables.strPassword);
	}

	public static Conexion_bd getInstanceConexionBD(){
		if(instanceConexionBD==null)
			return new Conexion_bd();
		else
			return instanceConexionBD;
	}

	public enum BDs {
		sql, integral, novalue;
		public static BDs getValue(String str) {
			try {
				return valueOf(str);
			} catch (IllegalArgumentException ex) {
				return novalue;
			}
		}
	}

	public void setConnection(String strServidor, String strDatabase, String strUsuario, String strContrasena) {
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

	public Connection getConnection() {
		return cnn;
	}

	public void closeConection() throws SQLException{
		cnn.close();
	}

	/**
	 * Metodo sin previa inicializacion de la conexion
	 * @param strBD
	 * @param strDD
	 * @param strID_CASO_ACTUAL
	 * @param cnn
	 * @return
	 */
	public ResultSet LeerDatosRegistroDeDataDriven(String strBD, String strDD, String strID_CASO_ACTUAL,
			Connection cnn) {
		ResultSet rs = null;

		switch (BDs.getValue(strBD)) {
		case sql:
			StringBuilder consulta = new StringBuilder();
			try {

				// Abrir el recordset indicando la tabla a la que queremos acceder
				if (!strID_CASO_ACTUAL.equals("") && strID_CASO_ACTUAL != null)
					consulta.append("SELECT * FROM \"" + strDD + "\" WHERE ID_CASO = '" + strID_CASO_ACTUAL
							+ "' ORDER BY \"ID_CASO\"");
				// Cuando es un datadriven que es llamado de un principal, en este caso 
				// solo devuelve un caso especifico
				else
					consulta.append("SELECT * FROM \"" + strDD + "\" ORDER BY \"ID_CASO\"");
				// Cuando es un datadriven principal,ene este caso devuelve todos los casos 
				// de prueba que serán ejecutados y por cada uno llama datadriven secundarios
				rs = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
						.executeQuery(consulta.toString());
				return rs;
			} catch (Exception e) {
				System.out.println("ERROR en LeerDatosRegistro: " + e.getMessage());
			}
		case integral:
			StringBuilder consultaint = new StringBuilder();
			try {
				// Abrir el recordset indicando la tabla a la que queremos acceder
				if (!strID_CASO_ACTUAL.equals("") && strID_CASO_ACTUAL != null)
					consultaint.append("SELECT * FROM \"" + strDD + "\" WHERE ID_CASO = '" + strID_CASO_ACTUAL
							+ "' AND ESTADO_CASO = 'Activo' ORDER BY \"ID_CASO\"");
				// Cuando es un Datadriven que es llamado de un principal, en este caso 
				// solo devuelve un caso especifico
				else
					consultaint.append("SELECT * FROM " + strDD + " WHERE ESTADO_CASO = 'Activo' ORDER BY ID_CASO");
				// Cuando es un Datadriven principal,ene este caso devuelve todos los casos
				// de prueba que seran ejecutados y por cada uno llama datadriven secundarios
				rs = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
						.executeQuery(consultaint.toString());
				return rs;
			} catch (Exception e) {
				System.out.println("ERROR en LeerDatosRegistro: " + e.getMessage());
			}

		}
		return rs;
	}

	/**
	 * Metodo sin previa inicializacion de la conexion
	 * @param strBD
	 * @param strDD
	 * @param strID_CASO_ACTUAL
	 * @return
	 */
	public ResultSet LeerDatosRegistroDeDataDriven(String strBD, String strDD, String strID_CASO_ACTUAL) {
		ResultSet rs = null;

		switch (BDs.getValue(strBD)) {
		case sql:
			StringBuilder consulta = new StringBuilder();
			try {

				// Abrir el recordset indicando la tabla a la que queremos acceder
				if (!strID_CASO_ACTUAL.equals("") && strID_CASO_ACTUAL != null)
					consulta.append("SELECT * FROM \"" + strDD + "\" WHERE ID_CASO = '" + strID_CASO_ACTUAL
							+ "' ORDER BY \"ID_CASO\"");
				// Cuando es un datadriven que es llamado de un principal, en este caso 
				// solo devuelve un caso especifico
				else
					consulta.append("SELECT * FROM \"" + strDD + "\" ORDER BY \"ID_CASO\"");
				// Cuando es un datadriven principal, en este caso devuelve todos los casos
				// de prueba que seran ejecutados y por cada uno llama datadriven secundarios
				rs = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
						.executeQuery(consulta.toString());
				return rs;
			} catch (Exception e) {
				System.out.println("ERROR en LeerDatosRegistro: " + e.getMessage());
			}
		case integral:
			StringBuilder consultaint = new StringBuilder();
			try {
				// Abrir el recordset indicando la tabla a la que queremos acceder
				if (!strID_CASO_ACTUAL.equals("") && strID_CASO_ACTUAL != null)
					consultaint.append("SELECT * FROM \"" + strDD + "\" WHERE ID_CASO = '" + strID_CASO_ACTUAL
							+ "' AND ESTADO_CASO = 'Activo' ORDER BY \"ID_CASO\"");
				// Cuando es un datadriven que es llamado de un principal, en este caso solo devuelve un
				// caso especifico
				else
					consultaint.append("SELECT * FROM " + strDD + " WHERE ESTADO_CASO = 'Activo' ORDER BY ID_CASO");
				// cuando es un datadriven principal,ene este caso devuelve
				// todos los casos
				// de prueba que ser?n ejecutados y por cada uno llama
				// datadriven secundarios

				rs = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
						.executeQuery(consultaint.toString());
				return rs;
			} catch (Exception e) {
				System.out.println("ERROR en LeerDatosRegistro: " + e.getMessage());
			}
		}
		return rs;
	}


	/**
	 * 
	 * @param strBD
	 *            tipo de consulta a realizar
	 * @param strDD
	 *            Nombre de la tabla a modificar
	 * @param strID_CASO_ACTUAL
	 *            Registro de la tabla a modificar
	 * @param strColMod
	 *            Columna del registro a modificar
	 * @param strValColum
	 *            valor a modificar en el registro
	 * @param cnn
	 *            conexion de la bd para poder ejecutar la consulta
	 * @return
	 */
	public boolean modificarValorEnTabla(String strBD, String strDD, String strID_CASO_ACTUAL, String strColMod,
			String strValColum, Connection cnn) {
		boolean encontroValor = false;

		switch (BDs.getValue(strBD)) {
		case sql:
			StringBuilder consulta = new StringBuilder();

			// Consulta para la tabla a la que queremos acceder para realizar el update
			consulta.append("UPDATE " + strDD + " SET " + strColMod + "='" + strValColum + "' " + "WHERE ID_CASO = '"
					+ strID_CASO_ACTUAL + "'");
			try {
				cnn.createStatement().executeUpdate(consulta.toString());
				System.out.println("Se realiza efectiva los updates correspondientes");
				return true;
			} catch (SQLException e) {
				System.out.println("ERROR en LeerDatosRegistro: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return encontroValor;
	}
}