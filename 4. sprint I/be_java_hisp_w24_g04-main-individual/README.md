# SocialMeli

Mercado Libre está experimentando un crecimiento continuo y planea ofrecer a compradores y vendedores una experiencia
innovadora el próximo año. Para lograrlo, están desarrollando "SocialMeli", una plataforma que permitirá a los
compradores seguir a sus vendedores favoritos y mantenerse al tanto de sus novedades. Ante la inminente fecha de
lanzamiento, se ha identificado la necesidad de presentar una versión Beta. Un analista funcional ha delineado una serie
de requerimientos, entre los que se destaca la creación de una API Rest que posibilite acciones como seguir a un
usuario, obtener la cantidad de seguidores de un vendedor, obtener listados de seguidores y seguidos, dar de alta una
nueva publicación, y acceder a publicaciones recientes de vendedores seguidos, además de permitir dejar de seguir a un
vendedor. Debido a la complejidad de estos requerimientos y la limitación de tiempo, se planifica ejecutarlos en equipos
de trabajo.

## Definiciones de equipo

Para realizar pruebas sobre la aplicación, descargar el archivo socialmeli.json ubicado en main/resources/collection.

Luego importar el archivo utilizando Postman para visualizar y realizar pruebas sobre todos los endpoints desarrollados.

## Endpoints

| **User Story** | **Endpoint**                                          | **Responsable**                |
|----------------|-------------------------------------------------------|--------------------------------|
| US0001         | POST - /users/{userId}/follow/{userIdToFollow}        | Nicolas Ortega                 |
| US0002         | GET - /users/{userId}/followers/count                 | Victoria Iglesias Márquez      |
| US0003         | GET - /users/{userId}/followers/list                  | Facundo Mamani Flores          |
| US0004         | GET - /users/{userId}/followed/list                   | Jorge Guerra                   |
| US0005         | POST - /products/post                                 | Comilo Roldan Quijano          |
| US0006         | GET - /products/followed/{userId}/list                | Guillermo Arturo Marcano Funes |
| US0007         | POST - /users/{userId}/unfollow/{userIdToUnfollow}    | Nicolas Ortega                 |
| US0008         | GET - /users/{UserID}/followers/list?order=name_asc   | Jorge Guerra                   |
| US0009         | GET - /products/followed/{userId}/list?order=date_asc | Guillermo Arturo Marcano Funes |

## Integrantes

| **Integrante**                 | **Email**                                 |
|--------------------------------|-------------------------------------------|
| Jorge Guerra                   | jorge.guerraguzman@mercadolibre.cl        |
| Victoria Iglesias Márquez      | victoria.marquez@mercadolibre.com         |
| Comilo Roldan Quijano          | camilo.roldanquijano@mercadolibre.com.co  |
| Nicolas Ortega                 | nicolas.ortegacaicedo@mercadolibre.com.co |
| Guillermo Arturo Marcano Funes | guillermo.marcano@mercadolibre.com.co     |
| Facundo Mamani Flores          | facundo.fmamaniflores@mercadolibre.com    |

## Trabajo individual

### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

Para llevar a cabo la publicación de un nuevo producto en promoción, se agregó el endpoint **POST - /products/promo-post
** en el ProductController
utilizando como base el método existente para la publicación de un nuevo producto **POST - /products/post**.
Adicionalmente, se agregó la clase PromoPost que hereda de Post y los campos
correspondientes en el UserPostDTO. Por último, se agregó la lógica necesaria en el método **createUserPost** del
PostService para verificar
si el producto que se quiere publicar tiene una promoción y en caso de ser así, se crea un objeto PromoPost y se guarda
en la lista de publicaciones.

```http
  POST /products/promo-post
```

**Payload:**

```json
{
  "user_id": 234,
  "date": "29-04-2021",
  "product": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.25
}
```

| Parámetro      | Tipo        | Descripción                                                                                     |
|:---------------|:------------|:------------------------------------------------------------------------------------------------|
| `userId`       | `int`       | **Requerido**. Número que identifica a cada usuario                                             |
| `date`         | `LocalDate` | **Requerido**. Fecha de la publicación                                                          |
| `product_id`   | `int`       | **Requerido**. Número identificatorio de un producto asociado a una publicación                 |
| `product_name` | `string`    | **Requerido**. Cadena de caracteres que representa el nombre de un producto                     |
| `type`         | `string`    | **Requerido**. Cadena de caracteres que representa el tipo de un producto                       |
| `brand`        | `string`    | **Requerido**. Cadena de caracteres que representa la marca de un producto                      |
| `color`        | `string`    | **Requerido**. Cadena de caracteres que representa el color de un producto                      |
| `notes`        | `string`    | **Requerido**. Cadena de caracteres para colocar notas u observaciones de un producto           |
| `category`     | `int`       | **Requerido**. Identificador que sirve para conocer la categoría a la que pertenece un producto |
| `price`        | `double`    | **Requerido**. Precio de un producto                                                            |
| `has_promo`    | `boolean`   | **Requerido**. Indica si un producto tiene una promoción                                        |
| `discount`     | `double`    | **Requerido**. Descuento de un producto                                                         |

**Response:**

```json
{
  "statusCode": 200,
  "data": {
    "user_id": 101,
    "date": "2024-01-15",
    "product": {
      "type": "Gamer",
      "brand": "Racer",
      "color": "Red & Black",
      "notes": "Special Edition",
      "product_id": 1,
      "product_name": "Silla Gamer"
    },
    "category": 100,
    "price": 1500.5,
    "has_promo": true,
    "discount": 0.25
  }
}
```

### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

Para obtener la cantidad de productos en promoción de un determinado vendedor, se agregó el endpoint **GET -
/products/promo-post/count** en el ProductController.
Adicionalmente, se agregó el método **getPromoProductsCount** en el ProductService para obtener la cantidad de productos
en promoción de un determinado vendedor.
Finalmente, se creó la clase PromoPostCountDTO para devolver la información solicitada.

```http
  GET /products/promo-post/count?user_id={userId}
```

| Parámetro | Tipo  | Descripción                                         |
|:----------|:------|:----------------------------------------------------|
| `userId`  | `int` | **Requerido**. Número que identifica a cada usuario |

```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "promo_products_count": 23
}
```

## Bonus

### US 0012: Actualizar la información de una publicación

Para actualizar la información de una publicación, se agregó el endpoint **PUT - /products/posts/{postId}** en el
ProductController, que recibe el id de una publicación y en el payload la información que se desea actualizar. En el
PostService se agregó el método **updatePost** para actualizar la información de una publicación. Este método se encarga
de
validar que la publicación exista y manejar las excepciones correspondientes en caso de que no exista o no se pueda
actualizar,
diferenciando entre las publicaciones normales y las promocionadas. Finalmente, se actualizaron las clases PostDTO y
UserPostDTO
para que puedan recibir la información que se desea actualizar.

```http
  PUT /products/posts/{postId}
```

**Payload:**

```json
{
  "product": {
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.25
}
```

| Parámetro   | Tipo      | Descripción                                                                                     |
|:------------|:----------|:------------------------------------------------------------------------------------------------|
| `product`   | `Product` | **Requerido**. Información del producto asociado a la publicación                               |
| `category`  | `Product` | **Requerido**. Identificador que sirve para conocer la categoría a la que pertenece un producto |
| `price`     | `double`  | **Requerido**. Precio de un producto                                                            |
| `has_promo` | `boolean` | **Opcional**. Indica si un producto tiene una promoción                                         |
| `discount`  | `double`  | **Opcional**. Descuento de un producto si este tiene promoción                                  |

**Response:**

```json
{
  "statusCode": 200,
  "data": {
    "user_id": 101,
    "post_id": 11,
    "date": "2024-01-18",
    "product": {
      "type": "Gamer",
      "brand": "Racer",
      "color": "Red & Black",
      "notes": "New Special Edition",
      "product_id": 1,
      "product_name": "Silla Gamer"
    },
    "category": 101,
    "price": 500.5,
    "has_promo": true,
    "discount": 0.5
  }
}
```

