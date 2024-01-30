# Bootcamp Backend Java Sprint Nº 2 - Spring

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


### Endpoints

- **GET /users/{userId}/follow/{userIdToFollow}**
  - Responsable: [@storresarias](https://github.com/storresarias)

- **GET /users/{userId}/followers/count**
  - Responsable: [@ImanolSuppoMELI](https://github.com/ImanolSuppoMELI)

- **GET /users/{userId}/followers/list**
  - Responsable: [@jzapatamacias](https://github.com/jzapatamacias)

- **GET /users/{userId}/followed/list**
  - Responsable: [@Yoiber017](https://github.com/Yoiber017)
  
- **POST /products/post**
  - Responsable: [@lgordillomal](https://github.com/lgordillomal)

- **GET /products/followed/{userId}/list**
  - Responsable: [@JuanIgnacioZunino](https://github.com/JuanIgnacioZunino)
  
- **GET /users/{userId}/unfollow/{userIdToUnfollow}**
  - Responsable: [@storresarias](https://github.com/storresarias)
  
- **GET /users/{UserID}/followers/list?order=name_asc**
  - Responsable: [@storresarias](https://github.com/storresarias)
  
- **GET /users/{UserID}/followers/list?order=name_desc**
  - Responsable: [@storresarias](https://github.com/storresarias)
  
- **GET /users/{UserID}/followed/list?order=name_asc**
  - Responsable: [@Yoiber017](https://github.com/Yoiber017)
  
- **GET /users/{UserID}/followed/list?order=name_desc**
  - Responsable: [@Yoiber017](https://github.com/Yoiber017)
  
- **GET /products/followed/{userId}/list?order=date_asc**
  - Responsable: [@JuanIgnacioZunino](https://github.com/JuanIgnacioZunino)
  
- **GET /products/followed/{userId}/list?order=date_desc**
  - Responsable: [@JuanIgnacioZunino](https://github.com/JuanIgnacioZunino)


### Testing
| Situaciones de entrada                                                                               | Comportamiento Esperado                                                               |
|------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| T-0001 Verificar que el usuario a seguir exista. (US-0001)                                          | - Se cumple: Permite continuar con normalidad.                                         |
|                                                                                                      | - No se cumple: Notifica la no existencia mediante una excepción.                      |
| T-0002 Verificar que el usuario a dejar de seguir exista. (US-0007)                                  | - Se cumple: Permite continuar con normalidad.                                         |
|                                                                                                      | - No se cumple: Notifica la no existencia mediante una excepción.                      |
| T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008) name_asc , name_desc         | - Se cumple: Permite continuar con normalidad.                                         |
|                                                                                                      | - No se cumple: Notifica la no existencia mediante una excepción.                      |
| T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)             | - Devuelve la lista ordenada según el criterio solicitado.                              |
| T-0005 Verificar que el tipo de ordenamiento por fecha exista (US-0009) date_asc , date_desc         | - Se cumple: Permite continuar con normalidad.                                         |
|                                                                                                      | - No se cumple: Notifica la no existencia mediante una excepción.                      |
| T-0006 Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)              | - Devuelve la lista ordenada según el criterio solicitado.                              |
| T-0007 Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)    | - Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.|
| T-0008 Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)| - Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.|


### Integrantes
#### Developers:
- [@ImanolSuppoMELI](https://github.com/ImanolSuppoMELI) - Imanol Suppo Alaniz
- [@JuanIgnacioZunino](https://github.com/JuanIgnacioZunino) - Juan Ignacio Zunino
- [@jzapatamacias](https://github.com/jzapatamacias) - Juan Camilo Zapata Macias
- [@lgordillomal](https://github.com/lgordillomal) - Laura Ximena Gordillo Maldonado
- [@storresarias](https://github.com/storresarias) - Santiago Torres Arias
- [@Yoiber017](https://github.com/Yoiber017) - Yoiber Andres Beitar Renteria

#### Scrum Master:
- [@extjotabell](https://github.com/extjotabell) - Johanna Tabella

### Agradecimientos

Agradecemos la oportunidad de participar en este proyecto y la invaluable ayuda de nuestros compañeros y tutores. ¡Esperamos que esta API cumpla con las expectativas!