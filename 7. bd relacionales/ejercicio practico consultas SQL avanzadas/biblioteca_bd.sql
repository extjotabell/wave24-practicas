CREATE TABLE biblioteca.AUTOR
(
	idAutor INT primary key not null,
    Nombre VARCHAR (50),
    Nacionalidad VARCHAR (30)
);

CREATE TABLE biblioteca.LIBRO
(
	idLibro INT primary key not null,
    Titulo VARCHAR (50),
    Editorial VARCHAR (30),
    Area VARCHAR (30)
);


CREATE TABLE biblioteca.LIBROAUTOR
(
	idAutor INT ,
    idLibro INT,
    foreign key (idAutor) references AUTOR(idAutor) on update cascade on delete cascade,
    foreign key (idLibro) references LIBRO(idLibro) on update cascade on delete cascade
);

CREATE TABLE biblioteca.ESTUDIANTE
(
	idLector INT primary key not null,
    Nombre VARCHAR (20),
    Apellido VARCHAR (30),
    Direccion VARCHAR (50),
    Carrera VARCHAR (50),
    EDAD VARCHAR (3)
);

CREATE TABLE biblioteca.PRESTAMO
(
    id_prestamo INT primary key not null,
    idLector INT,
	idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    foreign key (idLector) references ESTUDIANTE(idLector) on update cascade on delete cascade,
    foreign key (idLibro) references LIBRO(idLibro) on update cascade on delete cascade
);

INSERT INTO biblioteca.AUTOR (idAutor, Nombre, Nacionalidad) 
VALUES (1, "J.K. Rowling", "inglesa"),
(2, "Julio Verne", "francesa"),
(3, "Umberto Eco", "italiana"),
(4, "García Márquez", "colombiana"),
(5, "Vargas Llosa", "peruana"); 

INSERT INTO biblioteca.LIBRO (idLibro, Titulo, Editorial, Area) 
VALUES (1, "El Universo: Guía de viaje", "Salamandra" , "internet"),
(2, "Mysql", "pollito", "Base de datos"),
(3, "MAC", "apple", "ordenadores"),
(4, "ASUS", "microsoft", "ordenadores"),
(5, "Carla la protegida", "mato", "internet"); 

INSERT INTO biblioteca.LIBROAUTOR (idAutor, idLibro) 
VALUES (1, 2),
(2, 3),
(3, 5),
(4, 1),
(5, 2); 

INSERT INTO biblioteca.ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) 
VALUES (1, "Filippo", "Galli" , "bogota", "sistemas", "25"),
(2, "Gabriel", "Perez", "medellin", "sistemas", "22"),
(3, "Carlos", "Cataño", "cali", "derecho", "33"),
(4, "Maria", "Cortez", "pereira", "mecatronica", "28"),
(5, "Carla", "Murillo", "choco", "contaduria", "34"),
(6, "Sofia", "Herrera", "cartagena", "informatica", "20");

INSERT INTO biblioteca.PRESTAMO (id_prestamo, idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) 
VALUES (1, 2, 1 , "2021-07-10", "2021-07-16", true),
(2, 1, 5, "2021-04-11", "2021-05-16", true),
(3, 4, 2, "2021-03-12", "2021-03-13", false),
(4, 5, 3, "2021-08-26", "2021-08-26", false),
(5, 3, 4, "2021-01-06", "2021-01-16", true); 

-- 1. Listar los datos de los autores.
select * from biblioteca.AUTOR;

-- 2. Listar nombre y edad de los estudiantes
select Nombre, Edad from biblioteca.ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
select * from biblioteca.ESTUDIANTE where Carrera = "informatica";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
select * from biblioteca.AUTOR where Nacionalidad = "francesa" or Nacionalidad = "italiana";

-- 5. ¿Qué libros no son del área de internet?
select * from biblioteca.LIBRO where Area != "internet";
