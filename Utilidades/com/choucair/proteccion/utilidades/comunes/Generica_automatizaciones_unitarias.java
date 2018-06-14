package com.choucair.proteccion.utilidades.comunes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Generica_automatizaciones_unitarias {

	/**
	 * Localizacion a frame lateral izquierdo en BPM para realizar operacion de
	 * busqueda de menus
	 * 
	 * @param driver
	 */
	public void cambiarAFrameLateralIzquierdoBpm(WebDriver driver) {
		// salir del frame 0
		driver.switchTo().defaultContent();
		// Entrar al frame lateral izquierdo
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
	}

	/**
	 * Localizacion a frame lateral central de gestionar aseoria en BPM
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_gestionar_asesoria(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'Gestión de asesorias')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));
	}

	/**
	 * Localizacion a frame lateral central de gestionar aseoria en BPM para
	 * gestionar tarea en una asesoria
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_gestionar_tarea(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'Contacto telefónico')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));

	}

	/**
	 * Localizacion a frame lateral central para la ultimat pantalla de gestionr
	 * asesoria en BPM para terminar de gestionar una asesoria
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_pantalla_ultima_gestionar_asesoria(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'Asesoría preliminar')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));

	}

	/**
	 * Localizacion a frame lateral central para la primer pantalla de aprobar
	 * contabilidaa en BPM
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_gestion_servicio_contable(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'Gestionar Servicio Contable')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));
	}

	/**
	 * Localizacion a frame lateral central para la ultima pantalla de aprobar
	 * contabilidaa en BPM
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_aprobar_contabilidad(WebDriver driver) {

		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'n Contabilidad')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));
	}
	/**
	 * Localizacion a frame lateral central para la ultima pantalla de aprobar
	 * autotizacion de pago en BPM
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_aprobar_pagos(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'Pagos por aprobar')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));
	}
	/**
	 * Localizacion a frame lateral central para la ultima pantalla de aprobar
	 * autotizacion de pago en BPM
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_pantalla(WebDriver driver,String pantalla) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'"+pantalla+"')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));
	}

	/**
	 * Localizacion a frame lateral central para buscar el registro de
	 * cotabilidad en BPM
	 * 
	 * @param driver
	 */
	public void cambiarAFrameCentral_ingreso_carga_datacredito(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement)driver.findElement(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		// salir del frame 0
		driver.switchTo().defaultContent();
		// frame 1
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='2025.f2ce5588-cee2-301c-ac68-86199faefeba']")));

		// frame 2
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@fill-vertical='fillVertical && !iOS']")));

		// frame 3
		WebDriverWait wait = new WebDriverWait(driver, 12);
		By locatorTercerFrame = By.xpath("//*[contains(@title,'Trabajo')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTercerFrame));
		driver.switchTo().frame((WebElement)driver.findElement(locatorTercerFrame));
	}

	/**
	 * 
	 * @param valorAValidar
	 *            Valor con el que se evalua si es necesario lanzar la excepcion
	 * 
	 * @throws Exception
	 *             en el caso de que la validacion sea false convierte necesario
	 *             lanzar un try catch en donde se evidencia que la aplicacion
	 *             probada fallo
	 */
	public void lanzarExcepcionAValidacionFallido(boolean valorAValidar) throws Exception {
		if (valorAValidar == false)
			throw new Exception();
	}

	/**
	 * 
	 * @param strTXT_MENU1
	 *            menu que se busca acceder desdeBPM
	 * @param driver
	 *            del navegador actual que se encuentra actualmente ejecutado
	 */
	public void buscarMenuEnBPM(String strTXT_MENU1, WebDriver driver) throws Exception {
		esperaCargarInicialBPM(driver);

		// Ingresa a la parte izquierda del frama lateral izquierdo en BPM
		cambiarAFrameLateralIzquierdoBpm(driver);

		WebElement panelBuscarMenu = null;
		List<WebElement> paneles = driver.findElements(By.cssSelector(".form-group"));
		for (WebElement panel : paneles) {
			if (panel.getText().contains("Dashboards"))
				panelBuscarMenu = panel.findElement(By.cssSelector("input"));
		}
		try {
			for (int i = 0; i < strTXT_MENU1.length(); i++) {
				Thread.sleep(100);
				panelBuscarMenu.sendKeys("" + strTXT_MENU1.charAt(i));

			}
			System.out.println("TXT_MENU1 ejecutado con exito" + strTXT_MENU1);
		} catch (Exception e) {
			System.out.println("FALLO, no se encontro el buscador de menu");
			// TODO: handle exception
		}
	}

	/**
	 * Este metodo permite esperar cuando carga en primera instancia BPM
	 * 
	 * @param driver
	 *            el drive con el cual se esta manejando el browser
	 * @throws InterruptedException
	 */
	protected void esperaCargarInicialBPM(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("2025.f2ce5588-cee2-301c-ac68-86199faefeba")));
		cambiarAFrameLateralIzquierdoBpm(driver);
		By locatorFrameIntermnedioCentral = By.xpath("//*[@fill-vertical='fillVertical && !iOS']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorFrameIntermnedioCentral));
		// salir del frame 0
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @param strTXT_MENU1
	 *            con este valor se logra seleccionar el menu en los resultados
	 *            de la busqueda de buscarMenuEnBPM
	 * @param driver
	 */
	public void seleccionarMenuEnResultados(String strTXT_MENU1, WebDriver driver) throws Exception {
		driver.findElement(By.xpath("//*[contains(text(),'" + strTXT_MENU1 + "')]")).click();
		Thread.sleep(5000);
	}

	/**
	 * Este metodo se encarga de encontrar la ruta del proyecto en el equipo que
	 * se esta realizando la ejecucion
	 * 
	 * @param rutaDelArchivoEnElProyecto
	 *            Ruta del archivo en el proyecto
	 * @return ruta en la que se encuentra el archivo a modificar
	 */
	public String encontrarRutaActualDelArchivo(String rutaDelArchivoEnElProyecto) throws Exception{
		// TODO Auto-generated method stub
		String ruta = System.getProperty("java.class.path");
		
		String[] rutas = ruta.split(";");
		String rutaEncontrada="";
		String rutaActualProyecto="";
		String rutaActualDelArchivoEnElProyecto="";
		for (int i = 0; i < rutas.length; i++) {
			if (rutas[i].contains("build"))
			{
				rutaEncontrada=rutas[i];
				int finalDeRutaDetectada = rutaEncontrada.lastIndexOf("build");
				rutaActualProyecto= rutaEncontrada.substring(0, finalDeRutaDetectada);
			}
		}
		if(!rutaActualProyecto.equals(""))
		{	
		rutaActualDelArchivoEnElProyecto = rutaActualProyecto + rutaDelArchivoEnElProyecto;
		rutaActualDelArchivoEnElProyecto = rutaActualDelArchivoEnElProyecto.replace('/', '\\');
		System.out.println(String.format("Ruta en donde se encuentra el archivo %s",rutaActualDelArchivoEnElProyecto));
		}
		else{
			throw new Exception("No se encontro la ruta especificada para obtener el archivo");
		}
		return rutaActualDelArchivoEnElProyecto;
	}

	/**
	 * Permite llenar un formulario emergente con el teclado del pc local
	 * @param user el usuario para ingresar a la app
	 * @param password requerido para ingresar a la app
	 */
	public static void llenarFormularioEmergenteLogin(String user, String password) {
		// TODO Auto-generated method stub	

		Robot robot;
		try {
			// cargar el clipboard para guardar en el portapapeles el user
			StringSelection ss = new StringSelection(user);
			Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(ss, null);
			
			// ctrl c + ctrl v el usuario para filenet
			robot = new Robot();	    
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_CONTROL);		
			Thread.sleep(2000);
			// Realizar TAB8
		    robot.keyPress(KeyEvent.VK_TAB);	
		    Thread.sleep(2000);
		    

//			cargar el clipboard para guardar en el portapapeles el password
					StringSelection ps = new StringSelection(password);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ps, null);
					clipboard.setContents(ps, null);
					
	/// ctrl c + ctrl v para el password
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);		
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(6500);
			System.err.println("listo");
			


		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void desplazarScrollAElemento(WebDriver driver,By selectorElementoAEncontrar, int tamanioDePantalla)
	{
		JavascriptExecutor executorJs=(JavascriptExecutor)driver;
		int desplazamientoParaEncontrarBotonSeguido=driver.findElement(selectorElementoAEncontrar).getLocation().getY()-tamanioDePantalla;
		if(desplazamientoParaEncontrarBotonSeguido>0)
		{
			executorJs.executeScript("scroll(0,"+desplazamientoParaEncontrarBotonSeguido+");");
		}
	}
	
	

	

}
