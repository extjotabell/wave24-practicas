# Social Meli Grupo 02

## Descripción del Problema
Desarrollar una API para un escenario determinado de manera grupal. En el punto A de la siguiente sección se encuentra una descripción detallada del escenario y cada uno de los requerimientos solicitados. La idea es que puedan trabajar en equipo, haciendo la correspondiente división de tareas para lograr la resolución en conjunto del escenario correspondiente.

## Definiciones de Equipo

### Ejecución de la API
- Clonar el repositorio
- Se levantan algunos registros tanto en UserRepository ([user.json](src/main/resources/json/users.json)) como en PostRepository ([post.json](src/main/resources/json/posts.json))
- Ejecutar main de la clase BeJavaHispW24G002Application.java
- La API se ejecutará en el puerto 8080
- Se puede hacer un ```mvn clean compile``` para compilar el proyecto si es necesario

### Pruebas
- Se encuentra la colección de Postman en la carpeta [docs](src/main/resources/docs) del proyecto

## Endpoints y Responsables
- [US0001] - Follow user - Juan Felipe Saenz Garcia
- [US0002] - Count of followers for a user - Juan Esteban Guevara Perez
- [US0003] - Get followers list for a user - Ignacio Collado
- [US0004] - Get followed list for a user - Stefano Guillermo Tagliaferri
- [US0005] - Add a new post - Jose Joaquin Cabello Alegria
- [US0006] - Get recent posts from the followed users - Juan Camilo Guerrero Alarcon y Juan Esteban Guevara Perez
- [US0007] - Unfollow user - Juan Felipe Saenz Garcia y Jose Joaquin Cabello Alegria
- [US0008] - Get followers or followed list for a user, with order by name asc and desc - Ignacio Collado y Stefano Guillermo Tagliaferri
- [US0009] - Get recent posts from the followed users, with order by date asc and desc - Juan Camilo Guerrero Alarcon

## Test y Responsables
- [T0001] - Verify follow user - Juan Felipe Saenz Garcia
- [T0002] - Verify that user to follow exist - Jose Joaquin Cabello Alegria
- [T0003] - Verify params to order followers and followed - Ignacio Collado
- [T0004] - Verify that list is successfully ordered - Stefano Guillermo Tagliaferri
- [T0005] - Verify params to order by date - Jose Joaquin Cabello Alegria
- [T0006] - Verify that list of post is successfully ordered - Juan Camilo Guerrero Alarcon
- [T0007] - Verify that followers count of a user is correct - Juan Esteban Guevara
- [T0008] - Verify that post of list are from two weeks - Juan Esteban Guevara y Juan Camilo Guerrero Alarcon

## Integrantes
- Ignacio Benjamin Collado
- Stefano Guillermo Tagliaferri
- Jose Joaquin Cabello Alegria
- Juan Camilo Guerrero Alarcon
- Juan Esteban Guevara Perez
- Juan Felipe Saenz Garcia

## Cierre y Agradecimientos
- En este proyecto se logró aplicar los conocimientos adquiridos durante el curso hasta ahora. Aprendimos a trabajar en equipo y dividir las tareas de manera eficiente.
- Agradecemos a los profesores por la dedicación y el tiempo que nos brindaron durante el curso. Tambien la oportunidad de hacer un proyecto en equipo y poder aplicar los conocimientos adquiridos durante el curso.
