package com.choucair.Sincronizar.definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@CucumberOptions(
plugin = {"pretty", "html:target/cucumber-html-report"},
features="src/test/resources/Features/Comunes/Sincronizacion_AD_AS400.feature", tags = "@sincronizar")
@RunWith(CucumberWithSerenity.class )

public class Sincronizacion_AD_AS400Runner {

}
