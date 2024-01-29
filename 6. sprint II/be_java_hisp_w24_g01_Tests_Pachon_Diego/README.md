
# SocialMeli Equipo 01 - Sprint 1 W24 👥 🤝

Mercado Libre tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora,  por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como **SocialMeli** (API), en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Definiciones de Equipo 

Para ejecutar la API es necesario descargar los archivos de este repositorio y abrirlos con un IDE, de preferencia **IntelliJ IDEA**. Dentro del IDE basta con ejecutar el archivo **SocialMeliAplication** ubicado en **src/main/java/SocialMeliAplication. La API corre por defecto en el **puerto 8080 de localhost.**

Para hacer pruebas se recomienda usar Postman. Todos los endpoints y casos de prueba del API están recogidos en esta colección: resources/postman_collection/SOCIALMEDIA_W24_G01.postman_collection.json.

Por otra parte se puede hacer uso de Swagger y para su acceso : http://localhost:8080/swagger-ui/index.html

## Endpoints y responsables 📍

| Requerimiento | Descripción                                                                                                           | Responsable	|
|---------------|-----------------------------------------------------------------------------------------------------------------------|---------------|
| US0001        | Poder realizar la acción de “Follow” (seguir) a un determinado vendedor                                               | Anderson Pedroza        	|
| US0002        | Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor                                  | Alejandro Knubel       	|
| US0003        | Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)                      | Jesus David Roso       	|
| US0004        | Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)                | Diego Fernando 		 	|
| US0005        | Dar de alta una nueva publicación                                                                                     | Enzo Comba		 	|
| US0006        | Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas | Andres Felipe Robledo		 	|
| US0007        | Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.                                   |    Alejandro Knubel     	|
| US0008        | Ordenamiento alfabético ascendente y descendente                                                                      | Jesus David Roso  - Diego Fernando      	|
| US0009        | Ordenamiento por fecha ascendente y descendente                                                                       | Andres Felipe Robledo       	|

# Sprint 2 W24 Testing 👥 💯

## Tests y responsables 🪲

| Requerimiento | Descripción                                                                                                           | Responsable	|
|---------------|-----------------------------------------------------------------------------------------------------------------------|---------------|
| T-0001        | Verificar que el usuario a seguir exista. | Anderson Pedroza        	|
| T-0002        | Verificar que el usuario a dejar de seguir exista.| Alejandro Knubel       	|
| T-0003        | Verificar que el tipo de ordenamiento alfabético exista name_asc , name_desc| Jesus David Roso       	|
| T-0004        | Verificar el correcto ordenamiento ascendente y descendente por nombre.       | Jesus David Roso 		 	|
| T-0005        | Verificar que el tipo de ordenamiento por fecha exista date_asc , date_desc| Enzo Comba		 	|
| T-0006        | Verificar el correcto ordenamiento ascendente y descendente por fecha. | Enzo Comba		 	|
| T-0007        | Verificar que la cantidad de seguidores de un determinado usuario sea correcta.|    Diego Fernando     	|
| T-0008        | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas.|  Andrés Felipe Robledo Gaviria      	|

## Validaciones ✅

| Dato/Parámetro | ¿Obligatorio? | Validación                                                | Mensaje de Error                                            |
|-----------------|----------------|-----------------------------------------------------------|-------------------------------------------------------------|
| user_id         | Sí             | No debe estar vacío. Debe ser mayor a 0.                  | El id no puede estar vacío. El id debe ser mayor a cero.    |
| date            | Sí             | No debe estar vacío.                                      | La fecha no puede estar vacía.                               |
| product_id      | Sí             | No debe estar vacío. Debe ser mayor a 0.                  | La id no puede estar vacía. La id debe ser mayor a cero.    |
| product_name    | Sí             | No debe estar vacío. Longitud máxima de 40 caracteres. No debe contener caracteres especiales. | El campo no puede estar vacío. La longitud no puede superar los 40 caracteres. El campo no puede poseer caracteres especiales. |
| type            | Sí             | No debe estar vacío. Longitud máxima de 15 caracteres. No debe contener caracteres especiales. | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| brand           | Sí             | No debe estar vacío. Longitud máxima de 25 caracteres. No debe contener caracteres especiales. | El campo no puede estar vacío. La longitud no puede superar los 25 caracteres. El campo no puede poseer caracteres especiales. |
| color           | Sí             | No debe estar vacío. Longitud máxima de 15 caracteres. No debe contener caracteres especiales. | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| notes           | No             | Longitud máxima de 80 caracteres. No debe contener caracteres especiales, permite espacios. | La longitud no puede superar los 80 caracteres. El campo no puede poseer caracteres especiales. |
| category        | Sí             | No debe estar vacío.                                      | El campo no puede estar vacío.                               |
| price           | Sí             | No debe estar vacío. El precio máximo puede ser 10,000,000. | El campo no puede estar vacío. El precio máximo por producto es de 10,000,000. |





## Authors 👨🏻‍💻
-Anderson Pedroza [@AnderPMDev](https://github.com/AnderPMDev)

-Alejandro Knubel [@AlejandroKnubelMELI](https://github.com/AlejandroKnubelMELI)

-Andrés Felipe Robledo Gaviria [@arobledogavi](https://github.com/arobledogavi)

-Enzo Comba[@combaenzo](https://github.com/combaenzo)

-Diego FernandoPachón Quintero [@Diego-Pachon](https://github.com/Diego-Pachon)

-Jesús David Roso Flórez [@JesusRosoFlorez](https://github.com/JesusRosoFlorez)


## MELI -2024



