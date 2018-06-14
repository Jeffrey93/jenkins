package com.choucair.capacidadoperativa.Definition;

import com.choucair.capacidadoperativa.steps.ContaiSteps;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class ContaiDefinition {
	
	@Steps
	ContaiSteps contaiSteps;
	
	
	@Given("^Abrir aplicativo contai$")
	public void abrir_aplicativo_contai() throws Exception {
		contaiSteps.AbrirAplicativo();
	}

}
