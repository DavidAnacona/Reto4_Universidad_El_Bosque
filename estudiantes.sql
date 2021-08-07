-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-08-2021 a las 22:06:10
-- Versión del servidor: 10.6.3-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_estudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `nombres` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidos` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fechaNacimiento` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correoInstitucional` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correoPersonal` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numeroCelular` bigint(15) DEFAULT NULL,
  `numeroFijo` bigint(15) DEFAULT NULL,
  `programaAcademico` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`nombres`, `apellidos`, `fechaNacimiento`, `correoInstitucional`, `correoPersonal`, `numeroCelular`, `numeroFijo`, `programaAcademico`) VALUES
('Luis Ernesto', 'Poveda Garces', '1980-05-29', 'lpovedag@lafloresta.edu.co', 'luispov@hotmail.com', 3167556688, 2916565, 'Contaduría'),
('Luis Ernesto', 'Poveda Garces', '1980-05-29', 'lpovedag@lafloresta.edu.co', 'luispov@hotmail.com', 3167556688, 2916565, 'Contaduría');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
