
# SocialMeli

Mercado Libre está experimentando un crecimiento continuo y planea ofrecer a compradores y vendedores una experiencia innovadora el próximo año. Para lograrlo, están desarrollando "SocialMeli", una plataforma que permitirá a los compradores seguir a sus vendedores favoritos y mantenerse al tanto de sus novedades. Ante la inminente fecha de lanzamiento, se ha identificado la necesidad de presentar una versión Beta. Un analista funcional ha delineado una serie de requerimientos, entre los que se destaca la creación de una API Rest que posibilite acciones como seguir a un usuario, obtener la cantidad de seguidores de un vendedor, obtener listados de seguidores y seguidos, dar de alta una nueva publicación, y acceder a publicaciones recientes de vendedores seguidos, además de permitir dejar de seguir a un vendedor. Debido a la complejidad de estos requerimientos y la limitación de tiempo, se planifica ejecutarlos en equipos de trabajo.

## Definiciones de equipo

Para realizar pruebas sobre la aplicación, descargar el archivo socialmeli.json ubicado en main/resources/collection.

Luego importar el archivo utilizando Postman para visualizar y realizar pruebas sobre todos los endpoints desarrollados. 

## Endpoints

| **User Story** | **Endpoint**                                                       | **Responsable**                |
|----------------|--------------------------------------------------------------------|--------------------------------|
| US0001         | POST - /users/{userId}/follow/{userIdToFollow}                     | Nicolas Ortega                 |
| US0002         | GET - /users/{userId}/followers/count                              | Victoria Iglesias Márquez      |
| US0003         | GET - /users/{userId}/followers/list                               | Facundo Mamani Flores          |
| US0004         | GET - /users/{userId}/followed/list                                | Jorge Guerra                   |
| US0005         | POST - /products/post                                              | Comilo Roldan Quijano          |
| US0006         | GET - /products/followed/{userId}/list                             | Guillermo Arturo Marcano Funes |
| US0007         | POST - /users/{userId}/unfollow/{userIdToUnfollow}                 | Nicolas Ortega                 |
| US0008         | GET - /users/{UserID}/followers/list?order=name_asc                | Jorge Guerra                   |
| US0009         | GET - /products/followed/{userId}/list?order=date_asc              | Guillermo Arturo Marcano Funes |
| US00010        | POST - /products/promo-post                                        | Victoria Iglesias Márquez      |
| US00011        | GET - /products/promo-post/count?user_id={userId}                  | Victoria Iglesias Márquez      |
| US00012        | GET - /products/promo-post/category/{category}/list?order=name_asc | Victoria Iglesias Márquez      |

## Integrantes

| **Integrante**                     | **Email**                                  |
|--------------------------------|----------------------------------------|
| Jorge Guerra                   |jorge.guerraguzman@mercadolibre.cl                                        |
| Victoria Iglesias Márquez      |victoria.marquez@mercadolibre.com                                        |
| Comilo Roldan Quijano          |camilo.roldanquijano@mercadolibre.com.co                                        |
| Nicolas Ortega                 |nicolas.ortegacaicedo@mercadolibre.com.co                                        |
| Guillermo Arturo Marcano Funes |guillermo.marcano@mercadolibre.com.co                                       |
| Facundo Mamani Flores          | facundo.fmamaniflores@mercadolibre.com |

## Documentación Ejercicio Bonus
US 0006: Obtener un listado de las publicaciones con promo de una categoría en particular, ordenadas por nombre de producto.

**Sign:**

|**Method** | **SIGN**|
|-----------|---------|
|GET | /products/promo-post/category/{category}/list?order=name_asc|
RESPONSE:

    {
        "user_id": 102,
        "post_id": 11,
        "date": "2024-01-18",
        "product": {
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition",
            "product_id": 1,
            "product_name": "Silla Gamer Descuento"
        },
        "category": 100,
        "price": 1500.5
    }

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo**                              |
|----------------|----------|------------------------------------------------------|
| category       | int      | Número que identifica a la categoría de un producto. |




