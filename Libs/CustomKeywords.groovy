
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import cucumber.api.Scenario

import java.lang.String

import java.lang.Class


def static "utils.CapturaPantalla.capturarPantalla"(
    	Scenario scenario	) {
    (new utils.CapturaPantalla()).capturarPantalla(
        	scenario)
}

def static "utils.Direcciones.getDireccionActual"() {
    (new utils.Direcciones()).getDireccionActual()
}

def static "utils.Direcciones.getSlashOS"(
    	String direccion	) {
    (new utils.Direcciones()).getSlashOS(
        	direccion)
}

def static "utils.Direcciones.getDireccionReporteNodeJS"() {
    (new utils.Direcciones()).getDireccionReporteNodeJS()
}

def static "utils.Direcciones.getDireccionImagenDeEjemplo"() {
    (new utils.Direcciones()).getDireccionImagenDeEjemplo()
}

def static "utils.Direcciones.getDireccionPDF"() {
    (new utils.Direcciones()).getDireccionPDF()
}

def static "utils.Reportes.generarReporte"(
    	String jsonDir	
     , 	String repPath	
     , 	String timeIni	
     , 	String timeFin	
     , 	Object titulo	) {
    (new utils.Reportes()).generarReporte(
        	jsonDir
         , 	repPath
         , 	timeIni
         , 	timeFin
         , 	titulo)
}

def static "utils.EjecutarPrueba.ejecutar"(
    	Class runner	) {
    (new utils.EjecutarPrueba()).ejecutar(
        	runner)
}

def static "utils.EjecutarPrueba.ejecutarConAmbosReportes"(
    	Class runner	
     , 	String tituloReporte	) {
    (new utils.EjecutarPrueba()).ejecutarConAmbosReportes(
        	runner
         , 	tituloReporte)
}

def static "utils.EjecutarPrueba.ejecutarConReporteBonito"(
    	Class runner	
     , 	String tituloReporte	) {
    (new utils.EjecutarPrueba()).ejecutarConReporteBonito(
        	runner
         , 	tituloReporte)
}

def static "utils.EjecutarPrueba.ejecutarConReporteKatalon"(
    	Class runner	) {
    (new utils.EjecutarPrueba()).ejecutarConReporteKatalon(
        	runner)
}

def static "utils.Dates.getFechaActual"(
    	int dia	) {
    (new utils.Dates()).getFechaActual(
        	dia)
}

def static "utils.Dates.getTimeStamp"() {
    (new utils.Dates()).getTimeStamp()
}

def static "utils.Dates.getTimeStampSpanish"() {
    (new utils.Dates()).getTimeStampSpanish()
}

def static "utils.Dates.convertirHora"(
    	String arg	) {
    (new utils.Dates()).convertirHora(
        	arg)
}

def static "utils.Dates.fechaRandom"() {
    (new utils.Dates()).fechaRandom()
}

def static "utils.Dates.fechaPatios"() {
    (new utils.Dates()).fechaPatios()
}
