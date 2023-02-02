-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-02-2023 a las 06:37:36
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd-aplicativo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `usuario` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(100) NOT NULL,
  `habilitado` varchar(100) NOT NULL,
  `cuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`usuario`, `contraseña`, `nombre`, `apellido`, `dni`, `habilitado`, `cuenta`) VALUES
('liza', '12345', 'Lizardo', 'Silva', '74163598', 'True', 3),
('Utpino', 'bask3t*16', 'Utpino', 'Centro', '76511489', 'True', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codigo_cliente` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dni` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `monto_compras_realizadas` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo_cliente`, `nombre`, `apellido`, `dni`, `edad`, `monto_compras_realizadas`) VALUES
('CLI0', 'Anonimo', 'Linux', '74123569', 19, 96.03);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo_p` varchar(100) NOT NULL,
  `producto` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `dimension` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo_p`, `producto`, `cantidad`, `precio`, `dimension`) VALUES
('CODP000', 'Camotito', 500, 120, '15cm x 24 cm x 30 cm'),
('CODP001', 'Manza', 120, 1.2, '14cm x 25 cm x 36 cm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_general`
--

CREATE TABLE `venta_general` (
  `codigo_venta` varchar(100) NOT NULL,
  `codigo_p` varchar(100) NOT NULL,
  `compra` double NOT NULL,
  `descuento` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta_general`
--

INSERT INTO `venta_general` (`codigo_venta`, `codigo_p`, `compra`, `descuento`, `total`) VALUES
('VENT[G]-0', 'CODP000', 100, 3.9699999999999998, 96.03);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo_cliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo_p`);

--
-- Indices de la tabla `venta_general`
--
ALTER TABLE `venta_general`
  ADD PRIMARY KEY (`codigo_venta`),
  ADD UNIQUE KEY `codigo_p` (`codigo_p`),
  ADD UNIQUE KEY `codigo_p_3` (`codigo_p`),
  ADD KEY `codigo_p_2` (`codigo_p`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
