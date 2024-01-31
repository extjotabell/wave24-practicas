-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies_db.movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM movies_db.actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title as Titulo FROM movies_db.series as Serie;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name FROM movies_db.actors where rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM movies_db.movies where rating > 7.5 AND awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies_db.movies order by rating;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies_db.movies LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating.
SELECT title FROM movies_db.movies order by rating DESC LIMIT 5;

-- Listar los primeros 10 actores.
SELECT first_name, last_name FROM movies_db.actors LIMIT 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating FROM movies_db.movies where title = 'Toy Story';

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT first_name, last_name FROM movies_db.actors where first_name like 'Sam%';

-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title FROM movies_db.movies where YEAR(release_date) BETWEEN 2004 AND 2008;

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title FROM movies_db.movies where rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN 1988 AND 2009 order by rating;