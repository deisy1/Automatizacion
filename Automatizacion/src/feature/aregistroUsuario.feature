Feature: Registro de usuario

  Scenario: Registrar un nuevo usuario
    Given un usuario en el la pagina principal
    And seleccione el boton crear cuenta con un correo valido
    When se muestra el formulario donde se llena la informacion requerida
    Then se permite crear el cliente de manera exitosa