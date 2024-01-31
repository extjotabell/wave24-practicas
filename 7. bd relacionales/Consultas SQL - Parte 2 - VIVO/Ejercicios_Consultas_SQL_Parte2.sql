-- ---------------------------------------------------------- --
-- ------------ Consultas SQL - Parte 2 - VIVO -------------- --
-- ---------------------------------------------------------- --

DROP DATABASE IF EXISTS empresa_internet;

-- Ejercicio 3
-- a) Se solicita crear una nueva base de datos llamada "empresa_internet"

create database empresa_internet;

create table Provincias(
	idProvincia int auto_increment primary key,
    nombre varchar(45) not null
);

create table Ciudades(
	idCiudad int auto_increment primary key,
    nombre varchar(45) not null,
    idProvincia int not null,
    FOREIGN KEY (idProvincia) REFERENCES Provincias(idProvincia)
);

create table Clientes(
	idCliente int auto_increment primary key,
    dni int not null,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    fecha_nacimiento datetime,
    idCiudad int not null,
    
    foreign key (idCiudad) references Ciudades (idCiudad)
);

create table Planes(
	idPlan int auto_increment primary key,
    velocidad int not null,
    precio decimal(2) not null,
    descuento int
);

create table Facturas(
	idFactura int auto_increment primary key,
    idCliente int not null,
    fecha datetime not null,
    total decimal(2),
    foreign key (idCliente) references Clientes (idCliente)
);

create table DetalleFactura(
	idDetalleFactura int auto_increment primary key,
    idFactura int not null,
    idPlan int not null,
    subtotal decimal(2),
    foreign key (idFactura) references Facturas (idFactura),
    foreign key (idPlan) references Planes (idPlan)
);

-- b) Incorporar 10 registros en la tabla clientes y 5 registros en la tabla planes de internet
-- c) Realizar las asociaciones/relaciones correspondientes entre estos registros

INSERT INTO Provincias (nombre)
VALUES ('Buenos Aires');

INSERT INTO Provincias (nombre)
VALUES ('Córdoba');

INSERT INTO Provincias (nombre)
VALUES ('Mendoza');

INSERT INTO Ciudades (nombre, idProvincia)
VALUES ('La Plata', 1);  -- La ciudad 'La Plata' pertenece a la provincia de Buenos Aires (idProvincia = 1)

INSERT INTO Ciudades (nombre, idProvincia)
VALUES ('Córdoba Capital', 2);  -- La ciudad 'Córdoba Capital' pertenece a la provincia de Córdoba (idProvincia = 2)

INSERT INTO Ciudades (nombre, idProvincia)
VALUES ('Mar del Plata', 1);  -- La ciudad 'Mar del Plata' pertenece a la provincia de Buenos Aires (idProvincia = 1)

INSERT INTO Ciudades (nombre, idProvincia)
VALUES ('Mendoza Capital', 3);  -- La ciudad 'Mendoza Capital' pertenece a la provincia de Mendoza (idProvincia = 3)

INSERT INTO Ciudades (nombre, idProvincia)
VALUES ('Villa Carlos Paz', 2);  -- La ciudad 'Villa Carlos Paz' pertenece a la provincia de Córdoba (idProvincia = 2)

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (11111111, 'Juan', 'Pérez', '1990-05-15', 1);  -- Ciudad: La Plata

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (22222222, 'Ana', 'Gómez', '1985-08-20', 2);  -- Ciudad: Córdoba Capital

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (33333333, 'Martín', 'López', '1992-03-10', 3);  -- Ciudad: Mar del Plata

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (44444444, 'Carla', 'Fernández', '1988-12-05', 4);  -- Ciudad: Mendoza Capital

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (55555555, 'Luis', 'Rodríguez', '1995-01-25', 5);  -- Ciudad: Villa Carlos Paz

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (66666666, 'Laura', 'Martínez', '1987-07-18', 1);  -- Ciudad: La Plata

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (77777777, 'Alejandro', 'Sánchez', '1998-09-30', 2);  -- Ciudad: Córdoba Capital

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (88888888, 'Silvia', 'Gutiérrez', '1984-04-12', 3);  -- Ciudad: Mar del Plata

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (99999999, 'Pedro', 'Díaz', '1993-06-22', 4);  -- Ciudad: Mendoza Capital

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, idCiudad)
VALUES (12345678, 'Ana', 'Ramírez', '1989-11-08', 5);  -- Ciudad: Villa Carlos Paz

-- Ejercicio 4

-- a) Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias

-- Obtener la cantidad de clientes por ciudad
SELECT c.idCiudad, COUNT(*) AS Cantidad_de_Clientes
FROM Clientes c
GROUP BY c.idCiudad;

-- Encontrar el cliente más joven
SELECT dni as DNI, nombre as Nombre, apellido as Apellido, fecha_nacimiento as "Fecha Nacimiento"
FROM Clientes
ORDER BY fecha_nacimiento ASC
LIMIT 1;

-- Listar clientes nacidos en un año específico
SELECT dni as DNI, nombre as Nombre, apellido as Apellido, fecha_nacimiento as "Fecha Nacimiento"
FROM Clientes
WHERE YEAR(fecha_nacimiento) = 1990;

-- Obtener el promedio de edad de los clientes por ciudad
SELECT c.idCiudad, AVG(YEAR(CURDATE()) - YEAR(c.fecha_nacimiento)) AS Promedio_Edad
FROM Clientes c
GROUP BY c.idCiudad;

-- Encontrar clientes cuyos nombres empiecen con la letra 'A'
SELECT dni as DNI, nombre as Nombre, apellido as Apellido, fecha_nacimiento as "Fecha Nacimiento"
FROM Clientes
WHERE nombre LIKE 'A%';

-- Encontrar clientes mayores de edad
SELECT dni as DNI, nombre as Nombre, apellido as Apellido, fecha_nacimiento as "Fecha Nacimiento"
FROM clientes 
WHERE YEAR(CURDATE()) - YEAR(fecha_nacimiento) >= 18;

-- Contar la cantidad de clientes menores de 30 años
SELECT COUNT(*) AS Cantidad_Clientes_Menores_30
FROM Clientes
WHERE YEAR(CURDATE()) - YEAR(fecha_nacimiento) < 30;


