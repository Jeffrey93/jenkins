package com.choucair.proteccion.utilidades;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class ConfigurarEjecucionIntegral {

	@Test
	public void configurarData() {
		try {
			boolean encuentraCasoActivo=false;
			String archivoPropiedadesAmbiente = "src/test/resources/config.properties";
			
			Conexion_bd bd = Conexion_bd.getInstanceConexionBD();
			//A esta conexion accede  el resto de metodos de la integral en ejecucion
			bd.setConnection(Mdl_variables.strServidor, Mdl_variables.strBD, Mdl_variables.strUsuario,
					Mdl_variables.strPassword);
			Mdl_variables.cnn = bd.getConnection();
			
			String ambiente_vejez = LibreriasComunes
					.obtenerPropiedadDeUnArchivoDePropiedades(archivoPropiedadesAmbiente, "ambiente");
			String integralDeEjecucion = Mdl_variables.INTEGRAL_EN_EJECUCION; 
			System.out.println(" INTEGRAL A EJECUTAR------------->" + integralDeEjecucion);
			// Definicion de las integrales definidas para advance

			if (ambiente_vejez == null) {
				ambiente_vejez = "1";
				System.out.println("Ejecución en ambiente de Pruebas");
			}
			if (ambiente_vejez.equals("pruebas")) {
				ambiente_vejez = "1";
				System.out.println("Ejecución en ambiente de Pruebas");
			} else if (ambiente_vejez.equals("preproduccion")) {
				ambiente_vejez = "2";
				System.out.println("Ejecución en ambiente de Preproducción");
			}
			Mdl_variables.strambiente = ambiente_vejez;

			Mdl_variables.cnn = bd.getConnection();

			ResultSet rs = bd.LeerDatosRegistroDeDataDriven("integral", integralDeEjecucion, "", Mdl_variables.cnn);
			
			if (rs==null) throw new Exception(" <----- ERROR CONSULTANDO EN SET DE DATOS. ----->");
			
			while (rs.next()) {
				ResultSet rsintegral = bd.LeerDatosRegistroDeDataDriven("sql", "VEJEZ_PANTALLA_DETALLE_D",
						rs.getString("ID_CASO"), Mdl_variables.cnn);
				String strIntegral = "";
				while (rsintegral.next()) {
					strIntegral = rsintegral.getString("INTEGRAL");
				}
				// Este es el id caso que se va a correr durante la ejecucion
				if (strIntegral.equals(integralDeEjecucion)) {
					Mdl_variables.strID_Caso_Actual = rs.getString("ID_CASO");
					encuentraCasoActivo=true;
				}
			}
			if(encuentraCasoActivo==false)
			{
				Mdl_variables.strID_Caso_Actual = "";
			}
			System.out.println("El caso a ejecutar es : " + Mdl_variables.strID_Caso_Actual);
			Mdl_variables.P_TIPO_LOG = 1;

		} catch (IOException e) {
			Mdl_variables.P_TIPO_LOG = 2;
			e.printStackTrace();
		} catch (SQLException e) {
			Mdl_variables.P_TIPO_LOG = 2;
			e.printStackTrace();
		} catch (Exception e){
			Mdl_variables.P_TIPO_LOG = 2;
			e.printStackTrace();
		}
	}
}
