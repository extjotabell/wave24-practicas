-- Ejercicios Consultas SQL Parte 1

-- 1) Mostrar todos los registros de la tabla de movies

select * from movies;

-- 2) Mostrar el nombre, apellido y rating de todos los actores

select first_name, last_name, rating from actors;

-- 3) Mostrar el titulo de todas las series y usar alias para que tanto el nombre de la tabla como el campo esten en español

select title as Titulo from series as Series;

-- 4) Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5

select first_name as Nombre, last_name as Apellido from actors as Actores where rating > 7.5;

-- 5) Mostrar el titulo de las peliculas, el rating y los premios de las peliculas con un rating mayor a 7.5 y con más de dos premios

select title as Titulo, rating as Rating, awards as Premios from movies as Peliculas where rating > 7.5 and awards > 2;

-- 6) Mostrar el titulo de las peliculas y el rating ordenado por rating en forma ascendente

select title as Titulo, rating as Rating from movies as Peliculas order by rating;

-- 7) Mostrar los titulos de las primeras tres peliculas en la base de datos 

select title as Titulo from movies as Peliculas limit 3;

-- 8) Mostrar el top 5 de las peliculas con mayor rating 

select title as Titulo, rating as Rating, awards as Premios from movies as Peliculas order by rating desc limit 5;

-- 9) Listar los primeros 10 actores

select first_name as Nombre, last_name as Apellido, rating as Rating from actors as Actores limit 10;

-- 10) Mostrar el titulo y rating de todas las peliculas cuyo titulo sea de Toy Story

select title as Titulo, rating as Rating, awards as Premios from movies as Peliculas where title like "%Toy Story%";

-- 11) Mostrar todos los actores cuyos nombres empiezan con Sam

select first_name as Nombre, last_name as Apellido, rating as Rating from actors as Actores where first_name like "Sam%";

-- 12) Mostrar el titulo de las peliculas que salieron entre el 2004 y 2008

select title as Titulo from movies as Peliculas where release_date between "2004-01-01" and "2008-12-31";

-- 13) Traer el titulo de las peliculas  con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating

select title as Titulo from movies as Peliculas where rating > 3 and awards > 1 and release_date between "1988-01-01" and "2009-12-31" order by rating;


