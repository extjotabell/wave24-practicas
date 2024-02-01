-- Listar los datos de los autores.
SELECT * FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido 
FROM Estudiante
WHERE carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor a 
WHERE nacionalidad = "francesa"  OR nacionalidad = "italiana" ;

-- ¿Qué libros no son del área de internet?
SELECT * FROM libro
WHERE area != "internet";

-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro
WHERE editorial = 'salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM  Estudiante
WHERE edad > (SELECT AVG(edad) FROM Estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM Estudiante
WHERE apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM Autor a 
INNER JOIN LibroAutor la ON a.id_autor = la.id_autor 
INNER JOIN libro l ON l.id_libro = la.id_libro 
WHERE l.titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM libro l 
INNER JOIN Prestamo p ON p.id_libro = l.id_libro  
INNER JOIN Estudiante e ON p.id_lector = e.id_lector 
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";


-- Listar el nombre del estudiante de menor edad.
SELECT nombre FROM Estudiante e
ORDER BY e.edad ASC
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre FROM Estudiante e 
INNER JOIN Prestamo p ON p.id_lector = e.id_lector 
INNER JOIN libro l ON l.id_libro = p.id_libro 
WHERE l.area = "Bse de Datos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * FROM libro l 
INNER JOIN LibroAutor la ON la.id_libro = l.id_libro 
INNER JOIN Autor a ON a.id_autor = la.id_autor 
WHERE a.nombre = "J. K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro l
INNER JOIN Prestamo p ON p.id_libro = l.id_libro 
WHERE p.fechaDevolucion = "16/07/2021";
