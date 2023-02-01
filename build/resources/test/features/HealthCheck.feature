Feature: Verificador de la salud de los servicios

 @UnhappyPaths
  Scenario: Verficar que lo servicios funcionen correctamente
    When El usuario admin consume el servicio PING
    Then El servidor me responde el codigo de estado 200 con el mensaje CREATED
