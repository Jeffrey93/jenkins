package com.choucair.capacidadoperativa.Definition;

import com.choucair.capacidadoperativa.steps.TRMSteps;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class TRMDefinition {
@Steps
TRMSteps TRmSteps;


@Given("^Consulta TRM$")
public void consulta_TRM() throws Exception {
	TRmSteps.trm();
}


}
