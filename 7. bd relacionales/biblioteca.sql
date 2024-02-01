-- Crear base de datos
create DATABASE biblioteca;

-- Crear tabla Autor
create TABLE biblioteca.autor (
	id_autor INT auto_increment NOT NULL,
	nombre varchar(45) NOT NULL,
	nacionalidad varchar(45) NOT NULL,
	CONSTRAINT NewTable_PK PRIMARY KEY (id_autor)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- Crear tabla Libro
create TABLE biblioteca.libro (
	id_libro INT auto_increment NOT NULL,
	titulo varchar(45) NOT NULL,
	editorial varchar(45) NOT NULL,
	area varchar(45) NOT NULL,
	CONSTRAINT libro_pk PRIMARY KEY (id_libro)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- Crear tabla Autor_Libro
create TABLE biblioteca.libro_autor (
	id_autor INT NOT NULL,
	id_libro INT NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- Crear tabla Prestamo
create TABLE `prestamo` (
  `id_lector` int NOT NULL,
  `id_libro` int NOT NULL,
  `fecha_prestamo` datetime NOT NULL,
  `fecha_devolucion` datetime NOT NULL,
  `devuelto` tinyint(1) DEFAULT '0'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- Crear tabla Estudiante
create TABLE biblioteca.estudiante (
	id_lector INT auto_increment NOT NULL,
	nombre varchar(45) NOT NULL,
	apellido varchar(45) NULL,
	direccion varchar(45) NULL,
	carrera varchar(45) NOT NULL,
	edad INT DEFAULT 16 NOT NULL,
	CONSTRAINT estudiante_pk PRIMARY KEY (id_lector)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- Crear Foreing Keys Libro_Autor
ALTER TABLE biblioteca.libro_autor
    ADD CONSTRAINT libro_autor_autor_FK
    FOREIGN KEY (id_autor)
    REFERENCES biblioteca.autor(id_autor);
ALTER TABLE biblioteca.libro_autor
    ADD CONSTRAINT libro_autor_libro_FK
    FOREIGN KEY (id_libro)
    REFERENCES biblioteca.libro(id_libro);

-- Crear Foreing Keys Prestamo
ALTER TABLE biblioteca.prestamo
    ADD CONSTRAINT prestamo_libro_FK
    FOREIGN KEY (id_libro)
    REFERENCES biblioteca.libro(id_libro);
ALTER TABLE biblioteca.prestamo
    ADD CONSTRAINT prestamo_estudiante_FK
    FOREIGN KEY (id_lector)
    REFERENCES biblioteca.estudiante(id_lector);

-- Insertar datos en tabla Autor
insert into biblioteca.autor (nombre, nacionalidad) values ('Antoine de Saint-Exupéry', 'Francia');
insert into biblioteca.autor (nombre, nacionalidad) values ('J. R. R. Tolkien', 'Inglaterra');
insert into biblioteca.autor (nombre, nacionalidad) values ('Gabriel García Márquez', 'Colombia');
insert into biblioteca.autor (nombre, nacionalidad) values ('Jorge Luis Borges', 'Argentina');
insert into biblioteca.autor (nombre, nacionalidad) values ('Fiodor Dostoyevski', 'Rusia');
insert into biblioteca.autor (nombre, nacionalidad) values ('Franz Kafka', 'Alemania');
insert into biblioteca.autor (nombre, nacionalidad) values ('Albert Camus', 'Francia');
insert into biblioteca.autor (nombre, nacionalidad) values ('León Tolstói', 'Rusia');
insert into biblioteca.autor (nombre, nacionalidad) values ('Ivan Turguéniev', 'Rusia');
insert into biblioteca.autor (nombre, nacionalidad) values ('Miguel de Cervantes', 'España');

-- Insertar datos en tabla Libro
insert into biblioteca.libro (titulo, editorial, area) values ('El principito', 'Norma', 'Ciencia ficción');
insert into biblioteca.libro (titulo, editorial, area)
    values ('El señor de los anillos', 'Norma', 'Fantasía');
insert into biblioteca.libro (titulo, editorial, area)
    values ('Cien años de soledad', 'Norma', 'Fantasía');
insert into biblioteca.libro (titulo, editorial, area) values ('El aleph', 'Norma', 'Literario');
insert into biblioteca.libro (titulo, editorial, area) values ('Crimen y castigo', 'Norma', 'Filosofía');
insert into biblioteca.libro (titulo, editorial, area) values ('El proceso', 'Norma', 'Filosofía');
insert into biblioteca.libro (titulo, editorial, area) values ('La metamorfosis', 'Norma', 'Fantasía');
insert into biblioteca.libro (titulo, editorial, area) values ('El extranjero', 'Norma', 'Filosofía');
insert into biblioteca.libro (titulo, editorial, area)
    values ('La muerte de Ivan Ilich', 'Norma', 'Comedia');
insert into biblioteca.libro (titulo, editorial, area)
    values ('Don Quijote de la Mancha', 'Norma', 'Farsa');
insert into biblioteca.libro (titulo, editorial, area) values ('El silmarillón', 'Norma', 'Fantasía');

-- Insertar datos en tabla Autor_Libro
insert into biblioteca.libro_autor (id_autor, id_libro) values (1, 1);
insert into biblioteca.libro_autor (id_autor, id_libro) values (2, 2);
insert into biblioteca.libro_autor (id_autor, id_libro) values (3, 3);
insert into biblioteca.libro_autor (id_autor, id_libro) values (4, 4);
insert into biblioteca.libro_autor (id_autor, id_libro) values (5, 5);
insert into biblioteca.libro_autor (id_autor, id_libro) values (6, 6);
insert into biblioteca.libro_autor (id_autor, id_libro) values (6, 7);
insert into biblioteca.libro_autor (id_autor, id_libro) values (7, 8);
insert into biblioteca.libro_autor (id_autor, id_libro) values (8, 9);
insert into biblioteca.libro_autor (id_autor, id_libro) values (10, 10);
insert into biblioteca.libro_autor (id_autor, id_libro) values (2, 11);

-- Insertar datos en tabla Estudiante
insert into biblioteca.estudiante (nombre, apellido, direccion, carrera, edad)
    values ('Juan', 'Pérez', 'Av. Siempreviva 742', 'Ingeniería', 16);
insert into biblioteca.estudiante (nombre, apellido, direccion, carrera, edad)
    values ('Pedro', 'Martínez', 'Calle Falsa 123', 'Ingeniería', 25);
insert into biblioteca.estudiante (nombre, apellido, direccion, carrera, edad)
    values ('María', 'Gómez', 'Calle Falsa 123', 'Ingeniería', 30);
insert into biblioteca.estudiante (nombre, apellido, direccion, carrera, edad)
    values ('Lucía', 'Rodríguez', 'Calle Falsa 123', 'Ingeniería', 22);
insert into biblioteca.estudiante (nombre, apellido, direccion, carrera, edad)
    values ('Andrés', 'López', 'Calle Falsa 123', 'Ingeniería', 21);

-- Insertar datos en tabla Prestamo
insert into biblioteca.prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
    values (1, 1, '2021-01-01 00:00:00', '2021-01-15 00:00:00', 1);
insert into biblioteca.prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
    values (1, 2, '2021-01-01 00:00:00', '2021-01-15 00:00:00', 1);
insert into biblioteca.prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
    values (3, 3, '2021-01-01 00:00:00', '2021-01-15 00:00:00', 1);
insert into biblioteca.prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
    values (5, 4, '2021-01-01 00:00:00', '2021-01-15 00:00:00', 1);
insert into biblioteca.prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
    values (2, 5, '2021-01-01 00:00:00', '2021-01-15 00:00:00', 1);

-- Listar los datos de los autores.
SELECT * FROM biblioteca.autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM biblioteca.estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM biblioteca.estudiante WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM biblioteca.autor WHERE nacionalidad = 'Francia' OR nacionalidad = 'Italia';

-- ¿Qué libros no son del área de internet?
SELECT * FROM biblioteca.libro WHERE area != 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM biblioteca.libro WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM biblioteca.estudiante WHERE edad > (SELECT AVG(edad) FROM biblioteca.estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM biblioteca.estudiante WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre
FROM biblioteca.autor
WHERE id_autor
    IN (
        SELECT id_autor
        FROM biblioteca.libro_autor
        WHERE id_libro = (
            SELECT id_libro FROM biblioteca.libro WHERE titulo = 'El Universo: Guía de viaje'));

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT titulo
FROM biblioteca.libro
WHERE id_libro
    IN (
        SELECT id_libro
        FROM biblioteca.prestamo
        WHERE id_lector = (
            SELECT id_lector FROM biblioteca.lector WHERE nombre = 'Filippo Galli'));

-- Listar el nombre del estudiante de menor edad.
SELECT nombre, edad FROM biblioteca.estudiante WHERE edad = (SELECT MIN(edad) FROM biblioteca.estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM biblioteca.estudiante e
JOIN biblioteca.prestamo p ON e.id_lector = p.id_lector
GROUP BY e.nombre;

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT titulo
FROM biblioteca.libro
WHERE id_libro
    IN (
        SELECT id_libro
        FROM biblioteca.libro_autor
        WHERE id_autor = (
            SELECT id_autor FROM biblioteca.autor WHERE nombre = 'J.K. Rowling'));

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo
FROM biblioteca.libro
WHERE id_libro
    IN (
        SELECT id_libro
        FROM biblioteca.prestamo
        WHERE fecha_devolucion = '2021-07-16 00:00:00');
