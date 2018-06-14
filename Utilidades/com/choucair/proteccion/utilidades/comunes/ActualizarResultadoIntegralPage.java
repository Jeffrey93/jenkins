package com.choucair.proteccion.utilidades.comunes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;

import net.serenitybdd.core.pages.PageObject;
import com.choucair.proteccion.utilidades.Conexion_bd;
import com.choucair.proteccion.utilidades.Mdl_variables;


public class ActualizarResultadoIntegralPage  extends PageObject {
	
    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }
	

	public  void actualizarResultaIntegral() throws FileNotFoundException, IOException, NumberFormatException, ParseException, SQLException{

		System.out.println("Ingreso al método de la page para actualizar información");
		Conexion_bd bd=new Conexion_bd();
		String integral=Mdl_variables.INTEGRAL_EN_EJECUCION;
		
		if(Mdl_variables.P_TIPO_LOG == 1) 
        {
			System.out.println("La integral no presento errores en la ejecucion");
			if(bd.modificarValorEnTabla("sql", integral, Mdl_variables.strID_Caso_Actual, "ESTADO_CASO", "Inactivo", Mdl_variables.cnn))
			{	
				System.out.println("Caso " + Mdl_variables.strID_Caso_Actual + " de Integral" + integral +" Inactivado.");
			}else
			{
				System.err.println("Falló en Inactivación del caso:" + Mdl_variables.strID_Caso_Actual + " de la Integral" + integral);
				bd.modificarValorEnTabla("sql", "VEJEZ_PANTALLA_DETALLE_D", Mdl_variables.strID_Caso_Actual, "ESTADO_CASO", "Activo", Mdl_variables.cnn);
				Mdl_variables.P_TIPO_LOG = 2;
			}
        }else
        {
        	System.err.println("Caso no Inactivado por fallo en la Integral");
        	bd.modificarValorEnTabla("sql", "VEJEZ_PANTALLA_DETALLE_D", Mdl_variables.strID_Caso_Actual, "ESTADO_CASO", "Activo", Mdl_variables.cnn);
        	
        }
		//Como es la finalizacion de la integral se cierra el flujo
		//Mdl_variables.cnn.close();
		
		Mdl_variables.P_TIPO_LOG = 1;
	}



	public void verificacionDeEjecucionDePantalla() {
		// TODO Auto-generated method stub
		getDriver().getCurrentUrl();
	}

	public void verificacionDeActualizacionData() {
		// TODO Auto-generated method stub
		getDriver().getCurrentUrl();
	}
}
