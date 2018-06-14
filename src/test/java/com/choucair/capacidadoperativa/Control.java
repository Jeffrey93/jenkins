package com.choucair.capacidadoperativa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import cucumber.runtime.junit.SanityChecker;

public class Control {
	
	@Test
	 public  void ControlEjecucion() throws FileNotFoundException, IOException {
	 	Properties p = new Properties();
	 	p.load(new FileReader("src/test/resources/configejecucion.properties"));
	 	if (p.getProperty("aplicacion").equals("trm")) {
	 		SanityChecker.run(RunnerFeaturetrm.class, true);	
	 	}else {
	 		SanityChecker.run(RunnerFeature.class, true);
	 	}			
		
	}

}
