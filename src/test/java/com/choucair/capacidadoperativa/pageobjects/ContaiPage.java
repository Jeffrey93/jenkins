package com.choucair.capacidadoperativa.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class ContaiPage extends PageObject{
	static WiniumDriverService service=null;
	static WiniumDriver driver = null;	

	
	public void abrirprograma() throws IOException, AWTException {
        
       // String appPath = "I:\\iltda\\Contai\\ContaiwM.exe";
        String appPath = "C:\\Users\\sflorezr\\Desktop\\contai.lnk";
        
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        try {
        	service.stop();	
        }catch(Throwable t) {
        	
        }
        
        File driverPath = new File("lib/Winium.Desktop.Driver.exe");
        service =new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(false).withSilent(false).buildDesktopService();
        service.start();
        Robot robot=new Robot();
       // Screen screen =new  Screen();
       // driver = new WiniumDriver(new URL("http://localhost:9999"),option);
        driver = new WiniumDriver(service,option);
        waitFor(5).seconds();        
        robot.keyPress(KeyEvent.VK_ENTER);
        waitFor(5).seconds();  
        Serenity.takeScreenshot();
		WebElement window =  driver.findElementByClassName("TEntradaDlg");
		List<WebElement> lis = window.findElements(By.className("TOvcPictureField"));
	
		lis.get(0).sendKeys("6");
		robot.keyPress(KeyEvent.VK_TAB);
		waitFor(500).milliseconds();
		robot.keyPress(KeyEvent.VK_TAB);
		waitFor(500).milliseconds();
		robot.keyPress(KeyEvent.VK_TAB);
		waitFor(500).milliseconds();
		robot.keyPress(KeyEvent.VK_TAB);
		waitFor(500).milliseconds();
		//screen.type("TEM");
		waitFor(500).milliseconds();
		robot.keyPress(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_3);
		robot.keyPress(KeyEvent.VK_4);
		robot.keyPress(KeyEvent.VK_5);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void ClickEjecutar() {
		WebElement window =  driver.findElementByClassName("#32770");
		window.findElement(By.id("4426")).click();
	}


	public
	static String jvmBitVersion(){
	 return System.getProperty("sun.arch.data.model");
	}
}
