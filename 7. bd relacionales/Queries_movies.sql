SELECT * FROM movies_db.movies;

SELECT first_name, last_name, rating FROM movies_db.actors;

SELECT title as "Titulo" FROM movies_db.series as Serie;

SELECT first_name, last_name FROM movies_db.actors where rating > 7.5;

SELECT title, rating, awards FROM movies_db.movies where rating > 7.5 AND awards > 2;

SELECT title, rating FROM movies_db.movies order by rating;

SELECT title FROM movies_db.movies LIMIT 3;

SELECT title FROM movies_db.movies order by rating DESC LIMIT 5;

SELECT first_name, last_name FROM movies_db.actors LIMIT 10;

SELECT title, rating FROM movies_db.movies where title like '%Toy Story%';

SELECT first_name, last_name FROM movies_db.actors where first_name like 'Sam%';

SELECT title FROM movies_db.movies where YEAR(release_date) BETWEEN 2004 AND 2008;

SELECT title FROM movies_db.movies where rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN 1988 AND 2009 order by rating;