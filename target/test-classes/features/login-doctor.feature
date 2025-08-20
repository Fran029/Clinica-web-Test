@login
Feature: Login de doctor
    Scenario: Login exitoso
        Given que el usuario accede a la página de login 
        When ingresa credenciales válidas
        Then accede a la ficha clínica

    Scenario: Login fallido
        Given que el usuario accede a la página de login 
        When ingresa credenciales inválidas
        Then debería ver el mensaje de error de login