-- Registros de la tabla `autor`
INSERT INTO autor VALUES
(1, "Harvey Deitel", "Estadounidense"),
(2, "Paul Deitel", "Estadounidense"),
(3, "George R. R. Martin", "Estadounidense"),
(4, "J. K. Rowling", "Británica"),
(5, "Mark A Garlick", "Británica"),
(6, "Oliver Berry", "Británica"),
(7, "Valerie Stimac", "Estadounidense"),
(8, "Mark Mackenzie", "Italiana");

-- Registros de la tabla `estudiante`
INSERT INTO estudiante VALUES
(1, "Filippo", "Galli", "Dirección uno", "Informática", 20),
(2, "Juan Carlos", "Escalante", "Dirección dos", "Finanzas", 22),
(3, "Pedro", "Vega", "Dirección tres", "Informática", 23),
(4, "Sergio", "Acosta", "Dirección cuatro", "Finanzas", 20),
(5, "Carlos", "Gomez", "Dirección cinco", "Derecho", 21);

-- Registros de la tabbla `libro`
INSERT INTO libro VALUES
(1, "Cómo programar en Java", "Deitel", "Computación"),
(2, "Juego de tronos", "Debolsillo", "Literatura"),
(3, "Choque de reyes", "Plaza & Janes", "Literatura"),
(4, "Tormenta de espadas", "Penguin Random House", "Literatura"),
(5, "Festín de cuervos", "Plaza & Janes", "Literatura"),
(6, "Cómo programar en C++", "Deitel", "Computación"),
(7, "Python para programdores", "Deitel", "Computación"),
(8, "Danza de dragones", "Plaza & Janes", "Literatura"),
(9, "Harry Potter y la piedra filosofal", "Penguin Random House", "Literatura"),
(10, "Harry Potter y la cámara secreta", "Penguin Random House", "Literatura"),
(11, "El universo: Guía de viaje", "Salamandra", "Literatura");

-- Registros de la tabla `libroautor`
INSERT INTO libroautor VALUES
(1, 1),
(2, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(1, 6),
(2, 6),
(2, 7),
(3, 8),
(4, 9),
(4, 10),
(5, 11),
(6, 11),
(7, 11),
(8, 11);

-- Registros de la tabla `prestamo`
INSERT INTO prestamo VALUES
(1, 1, '2023-12-01', '2023-12-15', 1),
(1, 6, '2023-12-05', '2023-12-22', 1),
(1, 2, '2023-12-15', '2024-02-01', 0),
(2, 9, '2023-12-20', '2024-01-17', 1),
(2, 10, '2024-01-17', '2024-02-15', 0),
(3, 7, '2024-01-17', '2024-02-01', 1),
(3, 1, '2024-01-17', '2024-02-01', 0),
(4, 8, '2024-01-21', '2024-02-01', 0),
(5, 9, '2024-02-01', '2024-02-15', 0);

-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes.
SELECT nombre, apellido, edad FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido FROM estudiante WHERE carrera = "Informática";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre FROM autor WHERE nacionalidad = "francesa" OR nacionalidad = "italiana";

-- ¿Qué libros no son del área de internet?
SELECT titulo FROM libro WHERE area = "internet";

-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (
	SELECT AVG(edad)
    FROM estudiante
);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido like "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libroautor la ON a.idAutor = la.autor_idAutor
INNER JOIN libro l ON la.libro_idLibro = l.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
INNER JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido, edad
FROM estudiante
ORDER BY edad
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Computación.
SELECT e.nombre, e.apellido
FROM estudiante e
INNER JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = "Computación";

-- Listar los libros que pertenecen a la autora J. K. Rowling.
SELECT l.titulo
FROM libro l
INNER JOIN libroautor la ON la.libro_idLibro = l.idLibro
INNER JOIN autor a ON la.autor_idAutor = a.idAutor
WHERE a.nombre = "J. K. Rowling";

-- Listar títulos de los libros que debían devolverse el 01/02/2024.
SELECT l.titulo
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = "2024-02-01" AND p.devuelto = 0;