package com.choucair.proteccion.utilidades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.UnknownHostException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Diligenciarexel {

public static void LlenarExcel(String Parametro) {
			
			
			try {
				// Definición de Variable para ruta de archivo excel
				String strRutaArchXls = "Setdatos/Setdatos.xlsx";

				// Apertura del Archivo y seleccion de Hoja, tener presente que debe tener un titulo la columna
				InputStream inp = new FileInputStream(strRutaArchXls);
				Workbook wb = WorkbookFactory.create(inp);
				Sheet sheet = wb.getSheetAt(0);
				
				//Adicion de valor en la ultima posicion de la hoja seleccionada
				String Valor = Parametro;		
				sheet.createRow((sheet.getLastRowNum()+1)).createCell(0).setCellValue(Valor);			
				
				//guardando cambios del libro
				FileOutputStream fileOut = new FileOutputStream(strRutaArchXls);
				wb.write(fileOut);
				fileOut.close();
							
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
			
		public static void main(String[] args) throws UnknownHostException {

			LlenarExcel("Prueba");
		}
		
	}
	
	
	

