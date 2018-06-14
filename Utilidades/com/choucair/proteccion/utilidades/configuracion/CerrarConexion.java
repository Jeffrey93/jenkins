package com.choucair.proteccion.utilidades.configuracion;

import java.sql.SQLException;
import org.junit.Test;
import com.choucair.proteccion.utilidades.Mdl_variables;

public class CerrarConexion {

	@Test
	public void Cerrar() {
		try {
			Mdl_variables.cnn.close();
			System.out.println("Cerrando conexión al Set de datos.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}