package com.choucair.proteccion.utilidades;

import java.sql.SQLException;
import org.junit.Test;

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