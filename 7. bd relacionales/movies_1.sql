-- EJERCICIO movies_db.sql

-- 1. Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies;

-- 2. Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating
from actors;

-- 3. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
Select title as titulo
from series as series_de_television;

-- 4. Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name, rating
from actors where rating > 7.5;

-- 5. Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
Select title, rating, awards
from movies where rating > 7.5 AND awards > 2;

-- 6. Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
Select title, rating
from movies
order by rating;

-- 7. Mostrar los títulos de las primeras tres películas en la base de datos.
select *
from movies
limit 3;

-- 8. Mostrar el top 5 de las películas con mayor rating.
select title, rating
from movies
order by rating DESC
limit 5;

-- 9. Listar los primeros 10 actores.
select *
from actors
limit 10;

-- 10. Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select title, rating
from movies
where title LIKE 'TOY STORY%';

-- 11. Mostrar a todos los actores cuyos nombres empiezan con Sam.
select *
from actors
where first_name LIKE 'SAM%';

-- 12. Mostrar el título de las películas que salieron entre el 2004 y 2008.
select title, release_date
from movies
where release_date BETWEEN '2004-01-01' AND '2008-12-31';

-- 13. Traer el título de las películas con el rating mayor a 3, 
-- con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. 
-- Ordenar los resultados por rating.
select title, rating, awards, release_date
from movies
where rating > 3 AND awards >1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
order by rating;

