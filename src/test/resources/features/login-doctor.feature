Feature: Login de doctor
    Scenario Outline: Validación de login de doctor 
        Given que el usuario accede a la página de login 
        When ingresa el usuario <usuario> y la clave <password> 
        Then debería ver el mensaje "<mensaje>"

    Examples:  
        | usuario | clave     | mensaje                     
        | doctor  | password  | Ficha Clínica           
        | medico  | 123456    | Credenciales inválidas. Intenta de nuevo.                  
               