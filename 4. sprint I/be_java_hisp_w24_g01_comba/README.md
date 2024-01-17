
# SocialMeli Equipo 01 - Sprint 1 W24 👥 🤝

Mercado Libre tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora,  por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como **SocialMeli** (API), en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Definiciones de Equipo 

Para ejecutar la API es necesario descargar los archivos de este repositorio y abrirlos con un IDE, de preferencia **IntelliJ IDEA**. Dentro del IDE basta con ejecutar el archivo **SocialMeliAplication** ubicado en **src/main/java/SocialMeliAplication. La API corre por defecto en el **puerto 8080 de localhost.**

Para hacer pruebas se recomienda usar Postman. Todos los endpoints y casos de prueba del API están recogidos en esta colección: resources/postman_collection/SOCIALMEDIA_W24_G01.postman_collection.json.

Por otra parte se puede hacer uso de Swagger y para su acceso : http://localhost:8080/swagger-ui/index.html

## Endpoints y responsables 📍

| Requerimiento | Descripción                                                                                                         | Responsable	                              |
|---------------|---------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| US0001        | Poder realizar la acción de “Follow” (seguir) a un determinado vendedor                                             | Anderson Pedroza        	                 |
| US0002        | Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor                                | Alejandro Knubel       	                  |
| US0003        | Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)                    | Jesus David Roso       	                  |
| US0004        | Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)              | Diego Fernando 		 	                       |
| US0005        | Dar de alta una nueva publicación                                                                                   | Enzo Comba		 	                            |
| US0006        | Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas | Andres Felipe Robledo		 	                 |
| US0007        | Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.                                 | Alejandro Knubel     	                    |
| US0008        | Ordenamiento alfabético ascendente y descendente                                                                    | Jesus David Roso  - Diego Fernando      	 |
| US0009        | Ordenamiento por fecha ascendente y descendente                                                                     | Andres Felipe Robledo       	             |
| US00010       | Llevar a cabo la publicación de un nuevo producto en promoción                                                      | Enzo Comba       	                        |
| US00011       | Obtener la cantidad de productos en promoción de un determinado vendedor                                            | Enzo Comba       	             |
| US00012       | Poder promocionar un post determinado                                                                               | Enzo Comba       	             |
| US00013       | Poder quitar la promoción a un post determinado                                                                     | Enzo Comba       	             |


## Desarrollo BONUS 🎁

### US 0012: Poder promocionar un post determinado

| Method  | SIGN                            |
|---------|---------------------------------|
| GET     | /products/post/{postId}/promote |        	                 
| Payload | { "discount": 10 }              |   


Response 
```json 
{
  "id": 304,
  "user_id": 104,
  "date": "2024-01-23",
  "product_id": 204,
  "product_name": "Wireless Earbuds",
  "category_id": 3,
  "category_name": "Appliances",
  "price": 149.99,
  "has_promo": true,
  "discount": 40
}
```

Filters/Parameters:

| Parameter | Type | Description         |
|-----------|------|---------------------|
| postId    | int  | Post identification |

### US 0013: Poder quitar la promoción a un post determinado

| Method  | SIGN                              |
|---------|-----------------------------------|
| GET     | /products/post/{postId}/unpromote |


Response
```json 
{
  "id": 304,
  "user_id": 104,
  "date": "2024-01-23",
  "product_id": 204,
  "product_name": "Wireless Earbuds",
  "category_id": 3,
  "category_name": "Appliances",
  "price": 149.99,
  "has_promo": false,
  "discount": 40
}
```

Filters/Parameters:

| Parameter | Type | Description         |
|-----------|------|---------------------|
| postId    | int  | Post identification |



## Authors 👨🏻‍💻
-Anderson Pedroza [@AnderPMDev](https://github.com/AnderPMDev)

-Alejandro Knubel [@AlejandroKnubelMELI](https://github.com/AlejandroKnubelMELI)

-Andrés Felipe Robledo Gaviria [@arobledogavi](https://github.com/arobledogavi)

-Enzo Comba[@combaenzo](https://github.com/combaenzo)

-Diego FernandoPachón Quintero [@Diego-Pachon](https://github.com/Diego-Pachon)

-Jesús David Roso Flórez [@JesusRosoFlorez](https://github.com/JesusRosoFlorez)


## MELI -2024



