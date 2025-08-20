@reglas
Feature: Validación de las reglas clínicas para asegurar el correcto ingreso de datos
    Scenario Outline: Regla para diagnóstico pediátrico e ingreso obligatorio de tratamiento 
        Given que el doctor está en la página de la ficha clínica
        And completa el nombre del paciente "Francisca", el diagnóstico <diag>, la edad <edad> y el tratamiento <trat>
        And guarda la ficha
        Then debe ver el mensaje de error <mensaje>

        Examples: 
        | diag            |     edad |      trat    |     mensaje                                                    |
        | Pediátrico      |     10   | Inhalador    | Ficha registrada con éxito.                                    |
        | Pediátrico      |     11   |              | El tratamiento es obligatorio para guardar la ficha.           |
        | Bronquitis      |     8    | Antibióticos | Para menores de 12 años, el diagnóstico debe ser "Pediátrico". |



    Scenario: Múltiples escenarios de error pediátrico y tratamiento faltante 
        Given el doctor está en la página de la ficha clínica
        And completa el nombre del paciente "Francisca", el diagnóstico "Pediátrico, la edad 10 y el tratamiento ""
        And guarda la ficha
        Then debe ver los siguientes mensajes de error:

        | Para menores de 12 años, el diagnóstico debe ser "Pediátrico". |
        | El tratamiento es obligatorio para guardar la ficha.           |

             
               