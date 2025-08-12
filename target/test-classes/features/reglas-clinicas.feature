@reglas
Feature: Validación ficha clínica
    Scenario: Validación de edad del paciente 
        When el paciente es menor de 12 años
        Then debe ser paciente "pediátrico"

    Scenario: Validación ficha clínica 
        When no se completa el tratamiento
        Then no se puede guardar la ficha clínica

             
               