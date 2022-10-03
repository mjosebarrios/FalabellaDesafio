Feature: Falabella

  Background:
    Given I Go App Main Site
    Then I load the DOM Information Falabella.json

  @test
  Scenario: Registrar Usuario
    And I do a click in element BttnAceptarCookies
    And I do mouse move to element BttnMenuHolaInicioSesion
    And I do mouseover in button element BttnMenuHolaInicioSesion and desplegable Button element BttnRegistrate
    And I wait 5 seconds
    Then I wait element InputNombre to be visible
    And I do a click in element InputNombre
    And I set InputNombre with text Maria Jose
    And I set InputApellido with text Barrios
    And I set InputRut with text 310000000
    And I set InputTelefono with text 123456789
    And I set InputCorreo with text mariajose266192@gmail.com
    And I set InputClave with text Uno234567.
    And I wait 3 seconds
    When I check the checkbox having CheckTratamientoDatos
    And I do a click in element CheckTratamientoDatos
    And I do a click in element CheckTerminos
    And I do a click in element BttonRegistrarse
    And I wait 3 seconds

@test
  Scenario: Registrar Usuario con correo existente
    And I do a click in element BttnAceptarCookies
    And I do mouse move to element BttnMenuHolaInicioSesion
    And I do mouse move to element BttnMenuHolaInicioSesion
    And I do mouseover in button element BttnMenuHolaInicioSesion and desplegable Button element BttnRegistrate
  And I wait 5 seconds
  Then I wait element InputNombre to be visible
    And I do a click in element InputNombre
    And I set InputNombre with text Maria Jose
    And I set InputApellido with text Barrios
    And I set InputRut with text 310000000
    And I set InputTelefono with text 123456789
    And I set InputCorreo with text mariajose266192@gmail.com
    And I set InputClave with text Uno234567.
    Then I wait element LabelCorreoExistente to be visible
    Then Assert if LabelCorreoExistente equals to Este correo electrónico ya se encuentra registrado

  @test
  Scenario: Iniciar Sesion
    And I do mouse move to element BttnMenuHolaInicioSesion
    And I do mouseover in button element BttnMenuHolaInicioSesion and desplegable Button element BttnIniciarSesion
    Then I wait element InputEmailInicioSesion to be visible
    And I do a click in element InputEmailInicioSesion
    And I set InputEmailInicioSesion with text mariajose266192@gmail.com
    And I set InputClaveInicioSesion with text Uno234567.
    And I do a click in element BttonIngresar










