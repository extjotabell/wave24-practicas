
# SocialMeli

Mercado Libre está experimentando un crecimiento continuo y planea ofrecer a compradores y vendedores una experiencia innovadora el próximo año. Para lograrlo, están desarrollando "SocialMeli", una plataforma que permitirá a los compradores seguir a sus vendedores favoritos y mantenerse al tanto de sus novedades. Ante la inminente fecha de lanzamiento, se ha identificado la necesidad de presentar una versión Beta. Un analista funcional ha delineado una serie de requerimientos, entre los que se destaca la creación de una API Rest que posibilite acciones como seguir a un usuario, obtener la cantidad de seguidores de un vendedor, obtener listados de seguidores y seguidos, dar de alta una nueva publicación, y acceder a publicaciones recientes de vendedores seguidos, además de permitir dejar de seguir a un vendedor. Debido a la complejidad de estos requerimientos y la limitación de tiempo, se planifica ejecutarlos en equipos de trabajo.

## Definiciones de equipo

Para realizar pruebas sobre la aplicación, descargar el archivo socialmeli.json ubicado en main/resources/collection.

Luego importar el archivo utilizando Postman para visualizar y realizar pruebas sobre todos los endpoints desarrollados. 

## Endpoints

| **User Story** | **Endpoint**                                              | **Responsable**                   |
|------------|-------------------------------------------------------|--------------------------------|
| US0001     | POST - /users/{userId}/follow/{userIdToFollow}        | Nicolas Ortega                 |
| US0002     | GET - /users/{userId}/followers/count                 | Victoria Iglesias Márquez      |
| US0003     | GET - /users/{userId}/followers/list                  | Facundo Mamani Flores          |
| US0004     | GET - /users/{userId}/followed/list                   | Jorge Guerra                   |
| US0005     | POST - /products/post                                 | Comilo Roldan Quijano          |
| US0006     | GET - /products/followed/{userId}/list                | Guillermo Arturo Marcano Funes |
| US0007     | POST - /users/{userId}/unfollow/{userIdToUnfollow}    | Nicolas Ortega                 |
| US0008     | GET - /users/{UserID}/followers/list?order=name_asc   | Jorge Guerra                   |
| US0009     | GET - /products/followed/{userId}/list?order=date_asc | Guillermo Arturo Marcano Funes |

## Integrantes

| **Integrante**                     | **Email**                                  |
|--------------------------------|----------------------------------------|
| Jorge Guerra                   |jorge.guerraguzman@mercadolibre.cl                                        |
| Victoria Iglesias Márquez      |victoria.marquez@mercadolibre.com                                        |
| Comilo Roldan Quijano          |camilo.roldanquijano@mercadolibre.com.co                                        |
| Nicolas Ortega                 |nicolas.ortegacaicedo@mercadolibre.com.co                                        |
| Guillermo Arturo Marcano Funes |guillermo.marcano@mercadolibre.com.co                                       |
| Facundo Mamani Flores          | facundo.fmamaniflores@mercadolibre.com |

# Requerimientos incrementales

| **User Story**           | **Endpoint**                |
|--------------------------|-----------------------------|
| **US 0010**: Llevar a cabo la publicación de un nuevo producto en promoción            | POST - /products/promo-post |
| **US 0011**: Obtener la cantidad de productos en promoción de un determinado vendedor | GET - /products/promo-post                      |

# Requirimiento BONUS

SocialMeli tiene como objetivo que los usuarios puedan aplicar ciertos filtros a la búsqueda de publicaciones que tienen promociones. Para este caso se decide que se puede reducir la búsqueda filtrando por *tipo* y *marca* de producto.

| **Method** | **SIGN**                                          |
|------------|---------------------------------------------------|
| GET        | /products/promo-post/search?type={type}&brand={brand} |

**Response:** 

```json 
{
    "user_id": 101,
    "post_id": 1,
    "date": "2024-01-10",
    "product": {
        "type": "Electronics",
        "brand": "ExampleBrand1",
        "color": "Red",
        "notes": "Product notes 1",
        "product_id": 1,
        "product_name": "Product 1"
    },
    "category": 1,
    "price": 49.99,
    "has_promo": true,
    "discount": 0.25
},
{
    "user_id": 103,
    "post_id": 4,
    "date": "2024-01-13",
    "product": {
        "type": "Electronics",
        "brand": "ExampleBrand4",
        "color": "Black",
        "notes": "Product notes 4",
        "product_id": 4,
        "product_name": "Product 4"
    },
    "category": 2,
    "price": 39.99,
    "has_promo": true,
    "discount": 0.25
}
```

| **Parámetros** | **Tipo** | **Descripción**                                             |
|----------------|----------|-------------------------------------------------------------|
| **type**       | String   | Cadena de caracteres que representa el tipo de un producto  |
| **brand**      | String   | Cadena de caracteres que representa la marca de un producto |


