
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

# Testing

| **User Story** | **Descripción**                                              | **Responsable**                   |
|------------|-------------------------------------------------------|--------------------------------|
| T-0001     | Verificar que el usuario a seguir exista. (US-0001)        | Comilo Roldan Quijano                 |
| T-0002     | Verificar que el usuario a dejar de seguir exista. (US-0007)                 | Victoria Iglesias Márquez      |
| T-0003     | Verificar que el tipo de ordenamiento alfabético exista (US-0008) name_asc , name_desc                 | Facundo Mamani Flores          |
| T-0004     | Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)                | Jorge Guerra                   |
| T-0005     | Verificar que el tipo de ordenamiento por fecha exista (US-0009) date_asc , date_desc                                | Facundo Mamani Flores          |
| T-0006     | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)               | Guillermo Arturo Marcano Funes |
| T-0007     | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)   | Nicolas Ortega                 |
| T-0008     | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)   | Guillermo Arturo Marcano Funes                   |
| V-0001     | Realizar todas las validaciones adecuadas | Comilo Roldan Quijano
| Fix-0001   | Refactoring Controller/Service Code | Nicolas Ortega |
