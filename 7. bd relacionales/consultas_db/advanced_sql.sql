-- Mostrar el título y el nombre del género de todas las series.
SELECT g.name AS 'Nombre', g.ranking AS 'Ranking' FROM genres g
INNER JOIN series s ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, ac.first_name, ac.last_name FROM actor_episode ae
INNER JOIN actors ac ON ac.id = ae.actor_id
INNER JOIN episodes e ON e.id = ae.episode_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, COUNT(*) AS 'Total' 
FROM series ser
INNER JOIN seasons sea ON sea.serie_id = ser.id
GROUP BY ser.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, COUNT(*) AS 'Total'
FROM genres gen
INNER JOIN movies ON movies.genre_id = gen.id
GROUP BY gen.id;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT ac.first_name, ac.last_name
FROM actor_movie am
INNER JOIN movies mov ON mov.id = am.movie_id
INNER JOIN actors ac ON ac.id = am.actor_id
WHERE am.movie_id IN (SELECT id FROM movies WHERE title LIKE 'La Guerra de las galaxias%')
GROUP BY ac.id;