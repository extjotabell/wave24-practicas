# SocialMeli

Mercado Libre continues to grow, and for the coming year, its goal is to begin implementing a series of tools that will allow buyers and sellers to have a completely innovative experience, where the bond between them is much closer.

The launch date is approaching, so the presentation of a Beta version of what will be known as 'SocialMeli' is necessary. In this platform, buyers will be able to follow their favorite sellers and stay informed about all the updates they post.

## Sprint 1

## API Reference

#### US 0001 (Marcos Anzurez)

Follow a specific user.

```http
  POST /users/{userId}/follow/{userIdToFollow}

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of user|
| `userIdToFollow` | `int` | **Required**. id of seller to follow|

| Response |      | Description                |
| :-------- | :------- | :------------------------- |
| `200` | `OK` | bodyless or dto|
| `400` | `Bad Request` | bodyless or dto|

#### US 0002 (Desiree Melisa Limachi)

Number of users following a specific seller.

```http
  GET /users/{userId}/followers/count

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of seller|


<table>
<tr>
<td> Status </td> <td> Response </td>
</tr>
<tr>
<td> 200 </td>
<td>

```json
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers_count": 35
}
```

</td>
</tr>
<tr>
</tr>
</table>

#### US 0003 (Doris Elena Salazar)

List of all users following a specific seller.

```http
  GET /users/{userId}/followers/list

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of seller|


<table>
<tr>
<td> Status </td> <td> Response </td>
</tr>
<tr>
<td> 200 </td>
<td>

```json
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers": [
        {
            "user_id": 4698,
            "user_name": "usuario1"
        },
        {
            "user_id": 1536,
            "user_name": "usuario2"
        },
        {
            "user_id": 2236,
            "user_name": "usuario3"
        }
    ]
}

```

</td>
</tr>
<tr>
</tr>
</table>

#### US 0004 (Yamila Carrada)

List of all the sellers followed by a specific user.

```http
  GET /users/{userId}/followed/list

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of user|

<table>
<tr>
<td> Status </td> <td> Response </td>
</tr>
<tr>
<td> 200 </td>
<td>

```json
{
    "user_id": 4698,
    "user_name": "usuario1",
    "followed": [
        {
            "user_id": 234,
            "user_name": "vendedor1"
        },
        {
            "user_id": 6932,
            "user_name": "vendedor2"
        },
        {
            "user_id": 6631,
            "user_name": "vendedor3"
        }
    ]
}

```

</td>
</tr>
<tr>
</tr>
</table>

#### US 0005 (Victoria Borquez)

Create a new Post

```http
  POST /products/post

```


<table>
<tr>
<td> Payload </td>
</tr>
<tr>
<td>

```json
{
    "user_id": 123,
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
    "price": 1500.50
}


```

</td>
</tr>
<tr>
</tr>
</table>

| Response |      |
| :-------- | :------- |
| `200` | `OK` | 
| `400` | `Bad Request` | 


| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | **Required**. id of user|
| `date` | `LocalDate` | **Required**. date of post|
| `product_id` | `int` | **Required**. id of product|
| `product_name` | `String` | **Required**. name of product|
| `type` | `String` | **Required**. type of product|
| `brand` | `String` | **Required**. brand of product|
| `color` | `String` | **Required**. color of product|
| `notes` | `String` | **Required**. observations/notes of product|
| `category` | `int` | **Required**. category of product. ex 100: Sillas, 58: Teclados|
| `price` | `double` | **Required**. price of product|

#### US 0006 (Camilo Galezo)

Get a list of posts made by the sellers that a user follows in the last two weeks (sorted by date, with the most recent listings first).

```http
  GET /products/followed/{userId}/list

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of user|

<table>
<tr>
<td> Status </td> <td> Response </td>
</tr>
<tr>
<td> 200 </td>
<td>

```json
{
    "user_id": 4698,
    "posts": [ {
            “user_id”: 123,
            "postId": 32,
            "date": "01-05-2021",
            "product": {
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
        },
        {
            “user_id”: 234,
            "postId": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.50
        }
    ]
}

```

</td>
</tr>
<tr>
</tr>
</table>

#### US 0007 (Marcos Anzurez)

Unfollow a specific user.

```http
  POST /users/{userId}/unfollow/{userIdToUnfollow}

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of user|
| `userIdToUnfollow` | `int` | **Required**. id of seller to unfollow|

#### US 0008 (Doris Elena Salazar & Yamila Carrada)

Ordered list of all users following a specific seller.

Ordered list of all the sellers followed by a specific user.

```http
  GET /users/{UserID}/followers/list?order=name_asc
  GET /users/{UserID}/followers/list?order=name_desc
  GET /users/{UserID}/followed/list?order=name_asc
  GET /users/{UserID}/followed/list?order=name_desc

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of user|
| `name_asc` | `String` | **Required**. name asc sort|
| `name_desc` | `String` | **Required**. name desc sort|

#### US 0009 (Desiree Melisa Limachi)

Ordered list of posts made by the sellers that a user follows in the last two weeks.

```http
  GET /products/followed/{userId}/list?order=date_asc
  GET /products/followed/{userId}/list?order=date_desc

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id of user|
| `date_asc` | `String` | **Required**. date asc sort|
| `date_desc` | `String` | **Required**. date desc sort|


## Tests (Postman)

To run tests, use the postman collection located in the following directory:

```bash
  /src/main/resources/collectionPostman
```

## Sprint 2

#### Validaciones (Desiree Melisa Limachi)
| Parameter | Validation     |  Error message               |  
| :-------- | :------- | :------------------------- | 
| user_id | - Que el campo no esté vacío. <br>  - Mayor 0 | - El id no puede estar vacío. <br> - El id debe ser mayor a cero | 
| date | - Que el campo no esté vacío. | - La fecha no puede estar vacía. | 
| product_id | - Que el campo no esté vacío. <br>  - Mayor 0 | - El id no puede estar vacío. <br> - El id debe ser mayor a cero| 
| product_name | - Que el campo no esté vacío. <br>  - Longitud máxima de 40 caracteres. <br>  - Que no posea caracteres especiales (%, &, $, etc), permite espacios. | - El campo no puede estar vacío. <br> - La longitud no puede superar los 40 caracteres. <br> - El campo no puede poseer caracteres especiales. | 
| type | - Que el campo no esté vacío. <br>  - Longitud máxima de 15 caracteres. <br>  - Que no posea caracteres especiales (%, &, $, etc) | - El campo no puede estar vacío. <br> - La longitud no puede superar los 15 caracteres. <br>  - El campo no puede poseer caracteres especiales.| 
| brand | - Que el campo no esté vacío. <br>  - Longitud máxima de 25 caracteres. <br>  - Que no posea caracteres especiales (%, &, $, etc) | - El campo no puede estar vacío. <br> - La longitud no puede superar los 25 caracteres. <br>  - El campo no puede poseer caracteres especiales.| 
| color | - Que el campo no esté vacío. <br>  - Longitud máxima de 15 caracteres. <br>  - Que no posea caracteres especiales (%, &, $, etc) | - El campo no puede estar vacío. <br> - La longitud no puede superar los 15 caracteres. <br>  - El campo no puede poseer caracteres especiales.| 
| notes | - Longitud máxima de 80 caracteres. <br>  - Que no posea caracteres especiales (%, &, $, etc), permite espacios. | - La longitud no puede superar los 80 caracteres. <br> - El campo no puede poseer caracteres especiales. | 
| category | - Que el campo no esté vacío. | - El id no puede estar vacío. | 
| price | - Que el campo no esté vacío. <br> - El precio máximo puede ser 10.000.000.| - El campo no puede estar vacío. <br> - El precio máximo por producto es de 10.000.000 | 



#### Test Unitarios
| Test unitario | Entry situations     | Expected behavior                |  Author             |
| :-------- | :------- | :------------------------- | :------------------------- |
| T-0001 | Verificar que el usuario a seguir exista (US-0001) | **Se cumple:** permite continuar con normalidad <br> **No se cumple:** Notifica la no existencia mediante una excepción| Marcos Anzurez|
| T-0002 | Verificar que el usuario a dejar de seguir exista (US-0007) | **Se cumple:** permite continuar con normalidad <br> **No se cumple:** Notifica la no existencia mediante una excepción| Marcos Anzurez|
| T-0003 | Verificar que el tipo de ordenamiento alfabético exista (US-0008) name_asc , name_desc | **Se cumple:** permite continuar con normalidad <br>**No se cumple:** Notifica la no existencia mediante una excepción| Doris Salazar - Yamila Carrada|
| T-0004 | Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008) | Devuelve la lista ordenada según el criterio solicitado| Doris Salazar - Yamila Carrada|
| T-0005 | Verificar que el tipo de ordenamiento por fecha exista (US-0009) date_asc , date_desc | **Se cumple:** permite continuar con normalidad <br>**No se cumple:** Notifica la no existencia mediante una excepción| Camilo Galezo|
| T-0006 | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009) | Devuelve la lista ordenada según el criterio solicitado | Camilo Galezo|
| T-0007 | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002) | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.| Desiree Limachi|
| T-0008 | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006) | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | Victoria Bórquez|


## Authors

- [@cgalezo-meli](https://github.com/cgalezo-meli)
- [@victoriaborquezcarm](https://github.com/victoriaborquezcarm)
- [@mellimachi](https://github.com/mellimachi)
- [@yamilacarrada](https://github.com/yamilacarrada)
- [@mAnzurez](https://github.com/mAnzurez)
- [@DorisMELI](https://github.com/DorisMELI)

## Acknowledgements

Gratitude to the [Playground Digital House](https://playground.digitalhouse.com/) team and [Mercado Libre](https://mercadolibre.com/) for allowing us to learn every day.
