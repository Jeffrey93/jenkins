package com.choucair.proteccion.utilidades.configuracion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import com.choucair.proteccion.utilidades.Conexion_bd;
import com.choucair.proteccion.utilidades.Mdl_variables;

public class ConfigurarEjecucionGeneral {

	@Test
	public void configurarIntegralesDisponibles() {

		Conexion_bd conexion_bd = new Conexion_bd();
		JSONParser parser = new JSONParser();
		JSONArray integralesAEjecutar = new JSONArray();
		JSONObject jsonIntegralesAEjecurar = new JSONObject();

		try {
			// Lectura del json de todas las integrales actuales
			Object obj = parser.parse(new FileReader(Mdl_variables.FILE_INTEGRALES_DISPONIBLES));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray integrales = (JSONArray) jsonObject.get("integrales");
			Iterator<String> iterator = integrales.iterator();

			while (iterator.hasNext()) {
				String itegralActual = (String) iterator.next();

				ResultSet rs = conexion_bd.LeerDatosRegistroDeDataDriven("integral", itegralActual, "");
				while (rs.next()) {
					ResultSet rsintegral = conexion_bd.LeerDatosRegistroDeDataDriven("sql", "VEJEZ_PANTALLA_DETALLE_D",
							rs.getString("ID_CASO"));
					String strIntegral = "";
					while (rsintegral.next()) {
						strIntegral = rsintegral.getString("INTEGRAL");
					}
					// Este es el id caso que se va a correr durante la
					// ejecucion
					if (strIntegral.equals(itegralActual)) {
						System.out.println("Se agrega a integral en ejecucion -----> "+itegralActual);
						integralesAEjecutar.add(itegralActual);
					}
				}
			}

			// Sentencia para almacenar las integrales disponibles en
			// archivo json
			jsonIntegralesAEjecurar.put("integrales", integralesAEjecutar);
			// Escritura del archivo json con las integrales que se encuentran
			// disponibles
			// para ejecutar, el cual sera leido por el build gradle y realizar
			// la ejecucion
			FileWriter fileWriter = new FileWriter(new File(Mdl_variables.FILE_INTEGRALES_ACTIVAS),false);
			BufferedWriter out= new BufferedWriter(fileWriter);
			out.write(jsonIntegralesAEjecurar.toJSONString());
			out.flush();
			out.close();
			fileWriter.close();

			if(!integralesAEjecutar.isEmpty())
			{	
			agregarPrimerIntegralAEjecutar((String)integralesAEjecutar.get(0));
			System.out.println(String.format("Se agrega para ejecutar la integral %s al archivo %s",(String)integralesAEjecutar.get(0),Mdl_variables.FILE_INTEGRAL_EN_EJEC));
			}
			else{
				System.out.println("No se encuentran integrales disponibles para ejecutar");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	private void agregarPrimerIntegralAEjecutar(String integral) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fileWriter=new FileWriter(Mdl_variables.FILE_INTEGRAL_EN_EJEC,false);
		BufferedWriter bufferWritter= new BufferedWriter(fileWriter);
		bufferWritter.write("index:"+"1");
		bufferWritter.newLine();
		bufferWritter.write("integral:"+integral);
		bufferWritter.flush();
		bufferWritter.close();
		fileWriter.close();

	}

}
