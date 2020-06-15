package commons

import java.awt.Desktop
import java.awt.image.BufferedImage

import java.io.File
import java.io.IOException
import java.nio.file.*

import javax.imageio.ImageIO

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.Scenario
import cucumber.api.java.After
import internal.GlobalVariable

import utils.Direcciones as direcciones


class Hooks {
	@After ()
	def capturarPantalla(Scenario scenario) {
		//scenario.write("Escenario completado")
		if (scenario.isFailed()) {
			try {
				scenario.write("Escenario fallido")
				WebUI.delay(15)
				WebUI.executeJavaScript("document.body.style.zoom='80%'", null)
				BufferedImage screenshot = ImageIO.read(new File(WebUI.takeScreenshot()))
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write( screenshot, "png", baos );
				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();
				scenario.embed(imageInByte, "image/png")
				generarReporte()
			} catch (IOException e) {
				WebUI.comment("ERROR::::HOOKS:::: -> " + e.getMessage())
			}
		}
		else {
			try{
				scenario.write("Escenario Exitoso")
				BufferedImage screenshot = ImageIO.read(new File(WebUI.takeScreenshot()))
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write( screenshot, "png", baos );
				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();
				scenario.embed(imageInByte, "image/png")
			} catch (Exception e) {
				WebUI.comment("ERROR:ES_EXITOSO:::HOOKS:::: -> " + e.getMessage())
			}
		}

		generarReporte()

	}
	// aqui empieza abrir reporte:

	def generarReporte(){
		try{
			WebUI.comment(direcciones.getDireccionReporteNodeJS())
			/*Se le pasa al archivo la ruta por defecto*/
			File file = new File(direcciones.getDireccionReporteNodeJS())
			if(!Desktop.isDesktopSupported()){
				println('Desktop is not supported')
				return
			}
			Desktop desktop = Desktop.getDesktop()
			if(file.exists()) desktop.open(file)
			println ('File Opened Sucessfully \r')
		} catch (Exception e) {
			WebUI.comment("::ERROR::\n" + "Clase:\ncommons.HOOKS\n:Método:::GENERAR_REPORTE:: - \n" + e.getMessage())
		}
	}



	// Custom keyword for deleting file - provide file path as a parameter



	def Delete_File(String FilePath) {

		File file = new File(FilePath)

		try

		{

			Files.deleteIfExists(Paths.get(FilePath))

		}

		catch(NoSuchFileException e)

		{

			System.out.println('No such File/Directory Exists')

		}

		catch(DirectoryNotEmptyException e)

		{

			System.out.println('Directory is not Empty.')

		}

		catch(IOException e)

		{

			System.out.println('Invalid Permissions.')

		}

		System.out.println('File Deletion is Successful.')

	}
}
