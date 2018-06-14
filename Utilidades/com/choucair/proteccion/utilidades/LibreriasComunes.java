package com.choucair.proteccion.utilidades;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class LibreriasComunes {

	public LibreriasComunes() {

	}

	public enum Browser {
		ph, ff, ie, chr, novalue;

		public static Browser getValue(String str) {
			try {
				return valueOf(str);
			} catch (IllegalArgumentException ex) {
				return novalue;
			}
		}
	}

	public static void abrirBrowser(String strURL, String strBrowser) {

		// WebDriver driver;
		String baseUrl = "";
		try {
			switch (Browser.getValue(strBrowser)) {
			case ph:
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						"lib\\phantomjs.exe");
				Mdl_variables.driver = new PhantomJSDriver(caps);
				// File file = new File("lib/phantomjs.exe");
				// System.setProperty("phantomjs.binary.path",
				// file.getAbsolutePath());
				// driver = new PhantomJSDriver();
				break;
			case ff:
				Mdl_variables.driver = new FirefoxDriver();
				break;
			case ie:
				Mdl_variables.driver = new FirefoxDriver();
				break;
			case chr:
				System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
				Mdl_variables.driver = new ChromeDriver();
				break;
			default:
				Mdl_variables.driver = new FirefoxDriver();
				break;
			}
			baseUrl = strURL; // "https://www.proteccion.com/";
			Mdl_variables.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Mdl_variables.driver.get(baseUrl);
		} catch (Exception e) {
			System.out.println("ERROR en función abrirBrowser: " + e.getMessage());
		}
	}

	public static Date modifyDateLayout(String inputDate, String strFormato) throws ParseException {

		// Date date = new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(inputDate);
		Date date = new SimpleDateFormat(strFormato).parse(inputDate);
		return date; // new
						// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(date);
	}
	
	public static int desplazarScrollAElemento(WebDriver driver, By selectorElementoAEncontrar, int tamanioDePantalla) {
		JavascriptExecutor executorJs = (JavascriptExecutor) driver;
		int desplazamientoParaEncontrarBotonSeguido = driver.findElement(selectorElementoAEncontrar).getLocation()
				.getY() - tamanioDePantalla;
		if (desplazamientoParaEncontrarBotonSeguido > 0) {
			executorJs.executeScript("scroll(0," + desplazamientoParaEncontrarBotonSeguido + ");");
			return desplazamientoParaEncontrarBotonSeguido;
		}
		return -1;
	}

	/**
	 * Permite obtener una propiedad de un archivo de propiedades
	 * 
	 * @param archivo
	 * @param propiedad
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String obtenerPropiedadDeUnArchivoDePropiedades(String archivo, String propiedad)
			throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(archivo));
		return props.getProperty(propiedad);
	}
	/**
	 * 
	 * @param archivo
	 * @param propiedad
	 * @param valor
	 * @throws IOException
	 */
	public static void agregarPropiedadAunArchivoDePropiedades(String archivo, String propiedad, String valor)
			throws IOException {
		FileWriter fstream = new FileWriter(archivo, true);
		BufferedWriter out = new BufferedWriter(fstream);
		out.newLine();
		out.write(propiedad+"="+valor);
		out.flush();
		out.close();
		fstream.close();
	}
	
	
	/**
	 * 
	 * @param archivo
	 * @param propiedad
	 * @param valor
	 * @throws IOException
	 */
	public static void crearUnArhivoDePropiedadesConUnaPropiedad(String archivo, String propiedad, String valor)
			throws IOException {
		FileWriter fstream = new FileWriter(archivo, false);
		BufferedWriter out = new BufferedWriter(fstream);
		out.newLine();
		out.write(propiedad+"="+valor);
		out.flush();
		out.close();
		fstream.close();
	}
	public static String obtenerXpathFecha(int intDia){
		String strPos = "1"; if (intDia > 15) strPos = "last()";
		String strXpath = "(//div[contains(@class,'react-datepicker') and . = '"+intDia+"'])["+strPos+"]";
		return strXpath;
	}
	
	public static void SeleccionarCampoFecha(WebDriver driver, String strFecha, String strFormato ) throws Exception{
		// Convierte String en Fecha
		Date dtFecha = modifyDateLayout(strFecha, strFormato);
		//Selecciona año en el datepicker
		new Select(driver.findElement(By.cssSelector("select.react-datepicker__year-select"))).
		selectByVisibleText(new SimpleDateFormat("yyyy").format(dtFecha));
		//Selecciona mes en el datepicker
	    new Select(driver.findElement(By.cssSelector("select.react-datepicker__month-select"))).
	    selectByVisibleText(new SimpleDateFormat("MMMM",  new Locale("es")).format(dtFecha));
		//Selecciona dia en el datepicker
	    driver.findElement(By.xpath(obtenerXpathFecha(Integer.parseInt(new SimpleDateFormat("dd").format(dtFecha))))).click();
	}
	
	public static String consultarAccionAEjecutar(String integralActual, String casoActual) {
		// TODO Auto-generated method stub
		String accionAEjecutar="";
		ResultSet rs= Conexion_bd.getInstanceConexionBD().LeerDatosRegistroDeDataDriven("sql", integralActual, casoActual);
		try {
			while(rs.next())
			{
				accionAEjecutar= rs.getString("REALIZAR_ACCION");
			}
			rs.close();
			return accionAEjecutar;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accionAEjecutar;
	}
	
	public static  int obtenerUltimoDiaMes (int anio, int mes) {

		Calendar calendario=Calendar.getInstance();
		calendario.set(anio, mes-1, 1);
		return calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

		}
}
