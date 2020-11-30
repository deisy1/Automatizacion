Feature: Inicio de sesion

  Scenario: Inicio de sesion
    Given un cliente con correo valido
    When cuando ingrese informacion valida
    Then inicia sesion de manera exitosa