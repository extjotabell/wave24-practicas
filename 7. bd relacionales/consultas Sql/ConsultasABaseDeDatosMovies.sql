use movies_db;
select * from movies;
select first_name as Nombre,last_name as Apellido,rating as Rating from actors;
select title as Titulo from series as Series;
select first_name as Nombre,last_name as Apellido from actors where rating>7.5;
select title as Titulo,rating as Rating, awards as Premios from movies where rating>7.5 AND awards >2;
select title as Titulo,rating as Rating from movies order by rating asc;
select title as Titulo from movies limit 3;
select * from movies order by rating desc limit 5;
select * from actors limit 10;
select title As Titulo, rating as Rating from movies where title like '%Toy Story%';
select * from actors where first_name like 'Sam%';
select title as Titulo from movies where year(release_date) between 2004 and 2008;
select title as Titulo from movies where rating>3 and awards>1 and year(release_date) between 1998 and 2009 order by rating;

