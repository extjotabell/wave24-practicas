CREATE SCHEMA empresa_internet;
-- select * from Clientes;
-- select * from Planes;
-- select * from ClientesPlanes;


-- Creacion 
CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY,
    dni INT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);
CREATE TABLE Planes (
	id_plan INT PRIMARY KEY,
    velocidad INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);

-- Insertar regitros
INSERT INTO Clientes (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
    (1, 1234, 'David', 'Ospina', '1990-05-15', 'Medellin', 'Antioquia'),
    (2, 5678, 'Juan', 'Zuniga', '1985-09-20', 'Medellin', 'Antioquia'),
    (3, 91011, 'Mario', 'Yepes', '1985-09-20', 'Cali', 'Valle'),
    (4, 1213, 'Cristian', 'Zapata', '1985-09-20', 'Padilla', 'Cauca'),
    (5, 1415, 'Pablo', 'Armero', '1985-09-20', 'Tumaco', 'Nariño'),
    (6, 1617, 'Abel', 'Aguilar', '1985-09-20', 'Bogota', 'Bogota D.C'),
    (7, 1819, 'Juan', 'Cuadrado', '1985-09-20', 'Necocli', 'Antioquia'),
    (8, 2021, 'James', 'Rodriguez', '1985-09-20', 'Cucuta', 'Norte de santander'),
    (9, 2223, 'Teofilo', 'Gutierrez', '1985-09-20', 'Barranquilla', 'Atlantico'),
    (10,2425, 'Radamel', 'Falcao', '1985-09-20', 'Santa Marta', 'Magdalena'),
	(11,2425, 'Jose', 'Pekerman', '1985-09-20', 'Buenos Aires', 'BA')
    ;
INSERT INTO Planes (id_plan, velocidad, precio, descuento)
VALUES 
	(1, 50, 60.99, 0.10),
    (2, 100, 80.99, 0.10),
    (3, 150, 100.99, 0.20),
    (4, 300, 150.99, 0.20),
    (5, 500, 200.99, 0.30)
;

-- Asociar tablas mediante tabla intermedia
CREATE TABLE ClientesPlanes (
    id_clienteFK INT,
    id_planFK INT,
    PRIMARY KEY (id_clienteFK, id_planFK),
    FOREIGN KEY (id_clienteFK) REFERENCES Clientes(id_cliente),
    FOREIGN KEY (id_planFK) REFERENCES Planes(id_plan)
);

-- Agregar clientes
INSERT INTO ClientesPlanes (id_clienteFK, id_planFK)
VALUES
    (1, 1), -- David tiene Plan 1
    (2, 1), 
    (3, 2),
    (4, 2),
    (5, 3),
    (6, 3),
    (7, 4),
    (8, 4),
    (9, 5),
    (10, 5)
;







