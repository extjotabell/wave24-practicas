# Bootcamp Backend Java Sprint Nº 1 - Spring

## Descripción
Implementación de una API REST en Java con Spring para gestionar datos según los requisitos especificados en el enunciado del Bootcamp Backend Java Sprint Nº 1 de Mercado Libre.

## Definiciones de Equipo
La API se ejecuta localmente utilizando Spring Boot. Para las pruebas, se puede acceder a la colección de Postman alojada en la carpeta src -> main -> resources -> postman.

## Instrucciones de Ejecución:
### Clonar el repositorio
	 git clone https://github.com/Yoiber017/be_java_hisp_w24_g05.git

### Acceder al directorio del proyecto
	 cd be_java_hisp_w24_g05

### Ejecutar la aplicación
	 ./mvnw spring-boot:run


### Endpoints Individuales
|    **Method**    | **SIGN**                                    |
|------------------|---------------------------------------------|
|       POST       | /products/promo-post                        |
|        GET       | /products/promo-post/count?user_id={userId} |
|        GET       | /users/topfollowed                          |

### Especificación US 0012: (BONUS DESARROLLO INDIVIDUAL)
<ins>**US 0012: **</ins> Obtener una lista de los 10 usuarios con más seguidores (*más seguidos*) Ordenados de mayor a menor, con su user_name y cantidad de seguidores. 


<ins>**Sign:**</ins>

|    **Method**    | **SIGN**                                                                                                                                                                                                                                                            |
|------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|        GET       | /users/topfollowed                                                                                                                                                                                                                                                  |
|     Response     |   [<br>    {<br>      "position": 1,<br>      "user_name": "user1",<br>      "followers": 1000<br>    },<br>    {<br>      "position": 2,<br>      "user_name": "user2",<br>      "followers": 900<br>    },<br>    //More Users<br>  ] |




#### Scrum Master:
- [@extjotabell](https://github.com/extjotabell) - Johanna Tabella




