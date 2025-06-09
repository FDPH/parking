Hecho por **Freth David Piraban Hernandez**.

--- 
## Descripción
Ejercicio simple de como hacer un API para parking  


## Base de datos
![Diagram.png](mysql_data%2FDiagram.png)

Con el fin de soportar los datos de la aplicación en una base de datos relacional, se creó el modélo tal como se ve en
la imágen superior.

## Requerimientos Obtenidos
Crear una API REST que permita gestionar un sistema de parqueo, donde se puedan registrar los vehículos, los parqueaderos 
y los parqueos. 
Donde se puedan verficiar los valores a pagar  
Donde se pueda aplicar descuentos  
Donde se pueda hacer un cierre manual diario  

## Urls
Api localmente : http://localhost:8080/api  
DB Localmente : 127.0.0.1:3306/parking  
Swagger: http://localhost:8080/swagger-ui.html  

## Docker
Se crea un archivo Dockerfile y un archivo docker-compose.yml para trabajar los dos proyectos en contenedores  
ejecutar con el comando "docker-compose up --build -d"  
El archivo compose crea los usuarios y variables de entorno por lo que no es necesario modificar alguna propiedad
