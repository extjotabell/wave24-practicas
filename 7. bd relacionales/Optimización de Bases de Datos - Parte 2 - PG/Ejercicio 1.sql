DROP DATABASE IF EXISTS normalizacion;

CREATE DATABASE normalizacion;

USE normalizacion;

CREATE TABLE clientes(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    direccion VARCHAR(40) NOT NULL
);

CREATE TABLE articulos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(40) NOT NULL
);

CREATE TABLE facturas(
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    forma_pago DECIMAL(10.0) NOT NULL,
    IVA DECIMAL(10.0),
    cantidad INT NOT NULL,
    importe DECIMAL(10.0),
    id_cliente INT NOT NULL,
    id_articulo INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes (id),
    FOREIGN KEY (id_articulo) REFERENCES articulos (id)
);