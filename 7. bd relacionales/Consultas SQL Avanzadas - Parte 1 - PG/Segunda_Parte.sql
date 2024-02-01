-- ---------------------------------------------------------- --
-- ------------ Consultas SQL Avanzadas - Parte 1 - PG -------------- --
-- ---------------------------------------------------------- --

-- Segunda Parte
-- 1) Mostrar el titulo y el nombre del genero de todas las series

select s.title Titulo, g.name Generi from series s join genres g;

-- 2) Mostrar el titulo de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ello

select e.title "Nombre del episodio", CONCAT(a.first_name, ' ', a.last_name) AS "Actor"
from episodes e 
join actor_episode ae on e.id = ae.episode_id
join actors a on ae.actor_id = a.id;

-- 3) Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas

select s.title Serie, count(se.id) "Cantidad de Temporadas"
from series s
join seasons se on s.id = se.serie_id
group by s.id;

-- 4) Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

select g.name Genero, count(m.id) "Cantidad de Peliculas"
from genres g
join movies m on m.genre_id = g.id
group by g.id;

-- 5) Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan

select distinct a.first_name Nombre, a.last_name Apellido
from movies m
join actor_movie am on am.movie_id = m.id
join actors a on a.id = am.actor_id
where m.title like "La Guerra de las galaxias%"
