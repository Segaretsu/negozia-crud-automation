#language: es
@CreacionDeUsuarios
Característica: Creación de usuarios
  Prueba automatizada de creación de usuario básico

  @Correcto
  Escenario: Creación de usuarios en un mundo ideal, donde el usuario ingresa todo bien.
    Dado que diligencio el formulario con mi información personal
      | nombres   | apellidos       | sexo | telefono | tipoTelefono | correo             |
      | katalon S | Automation test | M    |  4321678 | Home         | Katalon@prueba.com |
    Cuando termino de diligenciar mi información doy clic en el botón guardar
    Entonces verifico que mi usuario se haya guardado exitosamente

  #@CorreoIncorrecto
  #Escenario: Creación de usuarios en un mundo ideal, donde el usuario ingresa sin dominio el correo.
    #Dado que diligencio el formulario con mi información personal
      #| nombres      | apellidos | sexo | telefono | tipoTelefono | correo         |
      #| Esto no debe | crearse   | M    |        0 | Home         | Katalon@prueba |
    #Cuando termino de diligenciar mi información doy clic en el botón guardar
    #Entonces verifico que mi usuario se haya guardado exitosamente
