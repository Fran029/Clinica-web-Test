@login
Feature: Login exitoso de doctor
    Scenario: Validación de login de doctor 
        Given que el usuario accede a la página de login 
        When ingresa el usuario "doctor" y la clave "password" 
        Then debería ver el mensaje "Ficha Clínica"



   
               