@login @ficha @reglas
Feature: Validación de ficha médica 

    Scenario Outline: Completar datos del paciente en ficha clínica 
        Given que el usuario ingresa a ficha clínica accediendo con usuario "doctor" y clave "password"
        When completa la ficha con <paciente>, <diagnóstico>, <edad> y <tratamiento>
        Then recibe los mensajes
            | <mensaje1> |
            | <mensaje2> |
            | <mensaje3> |          
            
        Examples:  
        | paciente  | diagnóstico   | edad | tratamiento       | mensaje1                                                       | mensaje2                                                       | mensaje3                                             |
        | Andrea J  | rosácea       | 50   | Crema tópica      | Ficha registrada con éxito.                                    |                                                                |                                                      |
        | Sofía E   | T.E.A.        | 10   | Terapia psico     | Para menores de 12 años, el diagnóstico debe ser "Pediátrico". |                                                                |                                                      |
        | Víctor M  | Pediátrico    | 11   | Terapia kine      | Ficha registrada con éxito.                                    |                                                                |                                                      |
        | Francisca | Gripe         | 12   | Nastizol          | Ficha registrada con éxito.                                    |                                                                |                                                      |
        | Juana S   |               | 39   | Ejercicios        | Todos los campos son obligatorios.                             |                                                                |                                                      |
        |           | lumbago       | 21   | Ejercicios        | Todos los campos son obligatorios.                             |                                                                |                                                      |
        | Luisa M   | hipertensión  |      | Antihipertensivos | Todos los campos son obligatorios.                             |                                                                |                                                      |
        | Juan B    | otitis        | 45   |                   | Todos los campos son obligatorios.                             | El tratamiento es obligatorio para guardar la ficha.           |                                                      |
        | Miguel    | otitis        | 10   |                   | Todos los campos son obligatorios.                             | Para menores de 12 años, el diagnóstico debe ser "Pediátrico". | El tratamiento es obligatorio para guardar la ficha. |
        |           |               |      |                   | Todos los campos son obligatorios.                             |     El tratamiento es obligatorio para guardar la ficha.       |                                                      |         

            