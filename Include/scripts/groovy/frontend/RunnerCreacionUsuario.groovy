package frontend

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin=["pretty" ,
	"html:reportecucumber/cucumber.html" ,
	"json:reportecucumber/cucumber.json",
	"junit:reportecucumber/cucumber.xml"],
features = ["Include/features/frontend/usuarios/CreacionUsuario.feature"],
glue = [""],
dryRun = false,
tags = [],
monochrome=false,
strict=true
)

class RunnerCreacionUsuario {
}