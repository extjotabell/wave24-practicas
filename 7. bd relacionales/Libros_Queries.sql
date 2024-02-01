-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = "Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = "Francia" OR nacionalidad = "Italia";

-- ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != "Internet";

-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE nombre like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a 
INNER JOIN libroautor lb ON lb.idAutor = a.idAutor
INNER JOIN libro l ON l.idLibro = lb.idLibro
WHERE l.titulo = "El Universo: Guía de viaje"
GROUP BY a.nombre;

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM libro l
INNER JOIN prestamo p ON p.idLibro = l.idLibro
INNER JOIN estudiante e ON e.idLector = p.idLector
WHERE e.nombre = "Filippo Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
ORDER BY edad asc
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre FROM libro l
INNER JOIN prestamo p ON p.idLibro = l.idLibro
INNER JOIN estudiante e ON e.idLector = p.idLector
WHERE l.area = "Base de Datos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM libro l
INNER JOIN libroautor la ON la.idLibro = l.idLibro
INNER JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro l
INNER JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = Date("2021-07-16");
