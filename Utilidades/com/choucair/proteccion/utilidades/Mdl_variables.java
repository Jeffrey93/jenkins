package com.choucair.proteccion.utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.openqa.selenium.WebDriver;



public class Mdl_variables {

	public static WebDriver driver;
	public static Connection cnn = null;
	
	public static String strEscenario="";
	public static String strDatadrivenLocal="";
	public static String strID_Caso_Actual="";
	public static String INTEGRAL_EN_EJECUCION="";
	
	public static int P_RESULTADO_GENERAL = 1;	
	public static String strServidor = "10.100.111.87";
	public final static String FILE_INTEGRAL_EN_EJEC="src/test/resources/data.properties";
	
	public final static String FILE_INTEGRALES_DISPONIBLES="src/test/resources/integralesDisponibles.json";
	public final static String FILE_INTEGRALES_ACTIVAS="src/test/resources/integralesAActualizar.json";
	public final static String NAME_INTEGRAL_INICIAL="INTEGRAL_CONFIG_INICIAL";
	
	public static String strBD = "BD_Advance";
	public static String strUsuario = "sa";
	public static String strPassword = "sql2015*";
	public static final int TAM_PANT=500;
	
	public static int P_TIPO_LOG;
	public static String strPathProject="C:\\PROTECCION\\ADVANCE\\VEJEZ\\";
							    
	public static String strLogName = "";
	public static String strCasoFallido = "Caso Fallido";
	public static String strCasoExitoso = "Caso Exitoso";
	
	//Variable para identificación de ambiente de ejecución
	public static String strambiente = "1";
	public static String LOGIN_APP="No ejecutado";
	public static String LOGIN_BPM="Ejecutado";
			
	public static String obtenerVariableDeAmbiente() throws FileNotFoundException, IOException{
        Properties props = new Properties();
        props.load(new FileInputStream("src/test/resources/config.properties"));
        String ambiente_vejez = props.getProperty("ambiente"); 
        return ambiente_vejez;
	}
	
}
