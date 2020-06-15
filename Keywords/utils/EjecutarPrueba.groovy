package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import utils.Dates
import utils.Direcciones as direcciones
import utils.Reportes

public class EjecutarPrueba {
	public static String rutaProyecto = direcciones.getDireccionActual();
	public static String rutaReporteKatalon = direcciones.getSlashOS(rutaProyecto + "\\reportecucumber\\cucumber.html\\index.html");
	public static String rutaReporteNodeJS = direcciones.getSlashOS(rutaProyecto + "\\reportecucumber");

	@Keyword
	public static ejecutar(Class runner){
		WebUI.comment("Se ejecuto la prueba sin reportes");
		CucumberKW.runWithCucumberRunner(runner.class, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	public static ejecutarConAmbosReportes(Class runner, String tituloReporte){
		Reportes reporte = new Reportes();
		String inicio = Dates.getTimeStampSpanish();
		CucumberKW.runWithCucumberRunner(runner, FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.openBrowser(rutaReporteKatalon);
		WebUI.maximizeWindow();
		reporte.generarReporte(rutaReporteNodeJS, './reportecucumber/cucumber-statics' , inicio, Dates.getTimeStampSpanish(), tituloReporte);
	}

	@Keyword
	public static ejecutarConReporteBonito(Class runner, String tituloReporte){
		Reportes reporte = new Reportes();
		String inicio = Dates.getTimeStampSpanish();
		CucumberKW.runWithCucumberRunner(runner, FailureHandling.CONTINUE_ON_FAILURE);
		reporte.generarReporte(rutaReporteNodeJS, './reportecucumber/cucumber-statics' , inicio, Dates.getTimeStampSpanish(), tituloReporte);
	}

	@Keyword
	public static ejecutarConReporteKatalon(Class runner){
		CucumberKW.runWithCucumberRunner(runner, FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.openBrowser(rutaReporteKatalon);
		WebUI.maximizeWindow();
	}
}
