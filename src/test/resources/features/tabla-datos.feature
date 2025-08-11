Feature: Formulario de datos usuario
    Scenario: Completar datos de Carla Soto en el formulario usando DataTable 
        Given que el usuario accede al formulario de datos 
        When completa los siguientes datos:

        | campo     | valor         | 
        | nombre    | Carla         | 
        | apellido  | Soto          | 
        | email     | carla@qa.com  | 
        | edad      | 35            | 

        Then los datos ingresados deben mostrarse correctamente 