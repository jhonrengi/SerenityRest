package io.petstore.swagger.runners;
/*
 * @(#) Runner.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "io.petstore.swagger.stepDefinitions",
        tags = "@GetUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
