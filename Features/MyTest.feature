Feature: Ingreso de usuario

  Scenario: Ingresar nombre de usuario y contraseña correctos
    Given que el usuario está en la página de inicio de sesión
    When el usuario ingresa un nombre de usuario y una contraseña correctos
    Then el usuario debería ser redirigido a la página de inicio

  Scenario: Ingresar nombre de usuario y contraseña incorrecto
    Given que el usuario está en la página de inicio de sesión
    When el usuario ingresa un nombre de usuario y una contraseña incorrectos
    Then se debe mostrar un mensaje de error

  Scenario: Ingresar valores vacíos
    Given que el usuario está en la página de inicio de sesión
    When el usuario no ingresa un nombre de usuario ni una contraseña
    Then se debe mostrar un mensaje de error
