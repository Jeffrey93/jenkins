package com.choucair.Sincronizar.pageobjects;

import java.awt.Desktop;
import org.junit.Test;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;

public class Sincronizacion_AD_AS400PageObject {	
	Desktop desktop;
	private Screen screen = new Screen();
		
	@Test	
	public void loginADPruebas(String servidor, String user, String password) throws InterruptedException, FindFailed{		
		Thread.sleep(1000);
		screen.type(Key.WIN);
		Thread.sleep(1000);
		screen.type("mstsc.exe");
		Thread.sleep(1000);
		screen.type(Key.ENTER);		
		Thread.sleep(2000);
		screen.type((Key.BACKSPACE)+servidor);
		Thread.sleep(2000);
		screen.type(Key.ENTER);
		Thread.sleep(2000);
		screen.click("src/test/resources/Images/1521039860451-1.png");
		Thread.sleep(5000);
		screen.click("src/test/resources/Images/1521039888326-1.png");
		Thread.sleep(2000);
		screen.type(user);
		Thread.sleep(2000);
		screen.type(Key.TAB);
		Thread.sleep(2000);
		screen.type(password);
		screen.type(Key.ENTER);
		Thread.sleep(2000);
		screen.type(password);
		Thread.sleep(2000);		
		screen.type(Key.ENTER);
		Thread.sleep(2000);
		screen.type(Key.ENTER);	    	   
	}
	
	
	
}
