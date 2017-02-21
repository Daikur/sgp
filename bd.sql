-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.24-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para sgp-ea-bd
DROP DATABASE IF EXISTS `sgp-ea-bd`;
CREATE DATABASE IF NOT EXISTS `sgp-ea-bd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sgp-ea-bd`;

-- Volcando estructura para tabla sgp-ea-bd.grupos
DROP TABLE IF EXISTS `grupos`;
CREATE TABLE IF NOT EXISTS `grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(45) NOT NULL,
  `grupo` varchar(45) NOT NULL,
  `id_tutor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tutor_idx` (`id_tutor`),
  CONSTRAINT `fk_tutor` FOREIGN KEY (`id_tutor`) REFERENCES `tutores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgp-ea-bd.grupos: ~7 rows (aproximadamente)
DELETE FROM `grupos`;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` (`id`, `curso`, `grupo`, `id_tutor`) VALUES
	(1, '1', 'A', 1),
	(2, '2', 'C', 2),
	(3, '1', 'B', 3),
	(4, '2', 'B', 5),
	(5, '4', 'A', 4),
	(6, '1', 'C', 6),
	(7, '3', 'A', 7);
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;

-- Volcando estructura para tabla sgp-ea-bd.pedidos
DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `persona` int(11) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_1_idx` (`persona`),
  CONSTRAINT `fk_1` FOREIGN KEY (`persona`) REFERENCES `personas` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgp-ea-bd.pedidos: ~3 rows (aproximadamente)
DELETE FROM `pedidos`;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` (`id`, `persona`, `precio`) VALUES
	(1, 1, 25),
	(2, 1, 30),
	(3, 2, 40);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;

-- Volcando estructura para tabla sgp-ea-bd.personas
DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgp-ea-bd.personas: ~2 rows (aproximadamente)
DELETE FROM `personas`;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`id_persona`, `nombre`, `email`, `telefono`) VALUES
	(1, 'david', 'david@hotmail.com', '12345678'),
	(2, 'borja', 'borja@hotmail.com', '12345678');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;

-- Volcando estructura para tabla sgp-ea-bd.profesores
DROP TABLE IF EXISTS `profesores`;
CREATE TABLE IF NOT EXISTS `profesores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgp-ea-bd.profesores: ~4 rows (aproximadamente)
DELETE FROM `profesores`;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` (`id`, `nombre`, `apellido`, `ciudad`) VALUES
	(1, 'Salva', 'Del Toro', 'Valencia'),
	(2, 'Mari Cruz', 'Garcia', 'Mislata'),
	(3, 'Jorge', 'Navarri', 'Valencia'),
	(4, 'Toni', 'Cambra', 'Valencia');
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;

-- Volcando estructura para tabla sgp-ea-bd.profesores_grupos
DROP TABLE IF EXISTS `profesores_grupos`;
CREATE TABLE IF NOT EXISTS `profesores_grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_profesor` int(11) DEFAULT NULL,
  `id_grupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profesor_idx` (`id_profesor`),
  KEY `fk_grupos_idx` (`id_grupo`),
  CONSTRAINT `fk_grupos` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgp-ea-bd.profesores_grupos: ~8 rows (aproximadamente)
DELETE FROM `profesores_grupos`;
/*!40000 ALTER TABLE `profesores_grupos` DISABLE KEYS */;
INSERT INTO `profesores_grupos` (`id`, `id_profesor`, `id_grupo`) VALUES
	(1, 1, 3),
	(2, 2, 1),
	(3, 3, 2),
	(4, 2, 1),
	(5, 3, 2),
	(6, 4, 4),
	(7, 3, 5),
	(8, 2, 2);
/*!40000 ALTER TABLE `profesores_grupos` ENABLE KEYS */;

-- Volcando estructura para tabla sgp-ea-bd.tutores
DROP TABLE IF EXISTS `tutores`;
CREATE TABLE IF NOT EXISTS `tutores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla sgp-ea-bd.tutores: ~7 rows (aproximadamente)
DELETE FROM `tutores`;
/*!40000 ALTER TABLE `tutores` DISABLE KEYS */;
INSERT INTO `tutores` (`id`, `nombre`) VALUES
	(1, 'Salva'),
	(2, 'Mari Cruz'),
	(3, 'Jorge'),
	(4, 'Loren'),
	(5, 'Lorenzo'),
	(6, 'Mati'),
	(7, 'Santi');
/*!40000 ALTER TABLE `tutores` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
