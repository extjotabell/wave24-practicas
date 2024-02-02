-- 1. Agregar una película a la tabla movies.
insert into movies (id, title, rating, awards, release_date, length, genre_id)
values (22,"Kami no uso", 8.2, 1, '2010-10-04 00:00:00', 150, 3);

-- 2. Agregar un género a la tabla genres.
insert into genres (id, name, ranking, active) values (13,"Saki", 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies set genre_id = 13 where id = 22; 

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id = 22 where id = 1; 

-- 5. Crear una tabla temporal copia de la tabla movies.
create temporary table temp_table_movies 
(id INT, created_at DATETIME, updated_at DATETIME, title VARCHAR(100), rating DECIMAL(3,1), awards INT, 
release_date DATETIME, length INT, genre_id INT);
insert into temp_table_movies
select * from movies;
select * from tempi_table_movies;

-- 6 Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from temp_table_movies where awards < 5;

-- 7 Obtener la lista de todos los géneros que tengan al menos una película.
select gen.name as name, count(mov.genre_id) as quantity from genres as gen 
join movies mov on gen.id = mov.genre_id
group by name having quantity > 1;

-- 8 Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select * from actors as act 
join movies as mov on act.favorite_movie_id = mov.id
where mov.awards > 3;

-- 9 Crear un índice sobre el nombre en la tabla movies.

-- 10 Chequee que el índice fue creado correctamente.

-- 11 En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Sí, ya que en el momento que crezcan los registros, en consultas que inolucren, por ejemplo, awards o rating, 
-- el filtro del índice mejora considerablemente el rendimiento en la búsqueda

-- 12 ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la tabal que priorizaría la creación de indices sería en episodes,
-- ya que su cantidad de registros puede crecer considerablemente al incrementar 
-- los registros en tablas como series y seasons. 