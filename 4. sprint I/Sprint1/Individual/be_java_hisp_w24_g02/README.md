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
- [US0010] - Create post with promo - Juan Esteban Guevara Perez
- [US0011] - Get count of promo products of user - Juan Esteban Guevara Perez
- 
### [US0012] - INDIVIDUAL BONUS : Get Post by brand - Endpoint GET: `/products/post/brand/ABC/list`

Realiza una solicitud GET para obtener una lista de posts relacionados con la marca "ABC".

### Response Example:

{
    "post_id": 2,
    "user_id": 2,
    "has_promo": false,
    "date": "2024-02-01",
    "product": {
        "type": "Smartphone",
        "brand": "ABC",
        "color": "Black",
        "notes": "Último modelo de smartphone con cámara de alta resolución",
        "product_id": 1002,
        "product_name": "Smartphone ABC"
    },
    "category": 2,
    "price": 799.99,
    "discount": 0.0
}

## Integrantes
- Juan Esteban Guevara Perez

## Cierre y Agradecimientos
- En este proyecto se logró aplicar los conocimientos adquiridos durante el curso hasta ahora. Aprendimos a trabajar en equipo y dividir las tareas de manera eficiente.
- Agradecemos a los profesores por la dedicación y el tiempo que nos brindaron durante el curso. Tambien la oportunidad de hacer un proyecto en equipo y poder aplicar los conocimientos adquiridos durante el curso.
