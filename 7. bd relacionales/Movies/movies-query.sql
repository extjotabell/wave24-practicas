-- MOSTRAR REGISTROS DE LA TABLA MOVIES--
use movies_db;
select * from movies;

-- Mostrar nombre , apellido y rating actores--
select first_name, last_name, rating from actors;

-- Mosgtrat titulo y usar alias , nombre de la talba en español --
select title as titulo from series as series;

-- nombres y apellidos cuyo raiting mayor 7.5 --
select first_name, last_name from actors where rating > 7.5; 

-- titulo de movies , raiting > 7.5 y premios >2

select title, rating , awards from movies where rating > 7.5 and awards >2;

-- titulo , rating ordenados asc
select title, rating from movies order by rating ASC;

-- titulos de los 3 primeros registros de la bd --
select title from movies limit 3;

-- mostrar el top 5 de movies con mayor rating
select title from movies order by rating DESC LIMIT 5; 

-- listar los primeros 10 actores --
select first_name, last_name from actors limit 10; 

-- titulo , rating de todas pemliculos titulo toy story
select title , rating from movies where title Like 'Toy Story%'; 

-- todos actores cuyo nombre empicen SAM
select first_name , last_name from actors where first_name like 'Sam%';

-- titulo de pelicuas entre 2004 y 2008
select title  from movies where release_date between '2004-01-01' and '2008-12-31'; 

-- titulo de peliculas rating > 3 premio > 1 , fecha entre 1998 and 2009 ordenar por rating
select title from movies where rating > 3 and awards > 1 and release_date between '1998-01-01' and '2009-12-31' order by rating;
