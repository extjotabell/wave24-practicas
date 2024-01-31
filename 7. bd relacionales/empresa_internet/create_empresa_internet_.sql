CREATE DATABASE `empresa_internet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- empresa_internet.clientes definition

CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `provincia` varchar(100) DEFAULT NULL,
  `id_plan` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `clientes_planes_FK` (`id_plan`),
  CONSTRAINT `clientes_planes_FK` FOREIGN KEY (`id_plan`) REFERENCES `planes` (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- empresa_internet.planes definition

CREATE TABLE `planes` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `megas` varchar(100) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `descuento` decimal(10,0) DEFAULT NULL,
  `nombre_plan` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

