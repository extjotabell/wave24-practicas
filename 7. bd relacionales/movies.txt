SELECT * FROM movies_db.movies;

SELECT first_name as nombre, last_name as apellido, rating FROM movies_db.actors;

SELECT title as titulo FROM movies_db.series;

SELECT first_name as nombre, last_name as apellido FROM movies_db.actors WHERE rating>7.5;

SELECT title as titulo, rating, awards as premios FROM movies_db.movies WHERE rating>7.5 and awards>2;

SELECT title as titulo, rating FROM movies_db.movies order by rating asc; 

SELECT title as titulo FROM movies_db.movies LIMIT 3;

SELECT * FROM movies_db.movies order by rating desc limit 5;

SELECT * FROM movies_db.actors LIMIT 10;

SELECT title as titulo, rating FROM movies_db.movies WHERE title="Toy Story";

SELECT title as titulo FROM movies_db.movies WHERE release_date BETWEEN '2004-01-01' AND '2008-01-01';

SELECT title as titulo FROM movies_db.movies WHERE rating > 3 and awards>1 and release_date BETWEEN '1998-01-01' AND '2009-01-01' order by rating;