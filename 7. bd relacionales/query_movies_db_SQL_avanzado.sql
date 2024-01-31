-- Mostrar el título y el nombre del género de todas las series.
SELECT 
	s.title AS Titulo, 
    g.name AS Genero
FROM SERIES s
INNER JOIN GENRES g
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT 
	e.title AS Titulo_Episodio, 
    a.first_name AS Nombre, 
    a.last_name AS Apellido 
FROM actor_episode ae
INNER JOIN episodes e
ON ae.episode_id = e.id
INNER JOIN actors a
ON ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT 
	series.title AS Titulo_Serie,
    COUNT(series.id) AS Total_Temporadas
FROM seasons
INNER JOIN series
ON seasons.serie_id = series.id
GROUP BY Titulo_Serie;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
	g.name AS Genero,
    COUNT(m.id) AS Cantidad_Peliculas
FROM movies m
INNER JOIN genres g
ON m.genre_id = g.id
GROUP BY Genero
HAVING Cantidad_Peliculas >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT
	DISTINCT
    a.first_name AS Nombre,
    a.last_name AS Apellido
FROM actor_movie am
INNER JOIN actors a
ON am.actor_id = a.id
INNER JOIN movies m
ON am.movie_id = m.id
WHERE m.title LIKE "La Guerra de las galaxias%";
