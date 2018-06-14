package com.choucair.proteccion.utilidades.comunes;
//package utilidades.eventosComunes;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import utilidades.Conexion_bd;
//import utilidades.Mdl_variables;
//
//
//public class Genericas_automatizaciones_integrales {
//	/**
//	 * @param args
//	 */
//	protected static String strDATADRIVEN = "MASTER_INTEGRALES";
//
//	protected static Conexion_bd bd_master = null;
//
//	//MASTER_INTEGRALES
//	// static MDL_VARIABLES vbls = new MDL_VARIABLES();
//
//	protected static String appUrlBase;
//	protected static String appUrlBpmqa;
//	protected static String appUrlGestorDocumental;
//	protected static String ambiente;
//
//
//	@BeforeTest
//	public void seleccionarEntornoEjecucion() {
//		try
//		{
//			bd_master= new Conexion_bd();
//			bd_master.setConnection(Mdl_variables.strServidor,Mdl_variables.strBD,Mdl_variables.strUsuario,Mdl_variables.strPassword);
//			ResultSet rs = bd_master.LeerDatosRegistro("sql", strDATADRIVEN, bd_master.getConnection());
//			while(rs.next())
//			{
//				appUrlBase=rs.getString("URL_APP");
//				appUrlBpmqa=rs.getString("URL_BPM");
//				appUrlGestorDocumental=rs.getString("URL_FILENET");
//				ambiente=rs.getString("AMBIENTE");
//
//			}
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}			
//
//	}
//
//}
