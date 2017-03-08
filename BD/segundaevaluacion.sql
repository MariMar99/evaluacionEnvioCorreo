-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-03-2017 a las 11:25:33
-- Versión del servidor: 10.0.29-MariaDB-0ubuntu0.16.10.1
-- Versión de PHP: 7.0.15-0ubuntu0.16.10.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `segundaevaluacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correos`
--

CREATE TABLE `correos` (
  `idCorreo` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `correos`
--

INSERT INTO `correos` (`idCorreo`, `correo`, `idUsuario`) VALUES
(1, 'ma412@misena.edu.co', 1),
(2, 'alexandrams1999@hotmail.com', 2),
(3, 'girlwholovesGod@gmail.com', 2),
(4, 'mari@hotmialc.h', 9),
(5, '6391@misena.edu.co', 10),
(6, 'ma412@misena.edu.co', 11),
(7, 'ma412@misena.edu.co', 12),
(8, 'ma412@misena.edu.co', 13),
(9, 'lolagmao.cmk', 14),
(10, 'lolagmao.cmk', 15),
(11, 'ma412@misena.edu.co', 16),
(12, 'ma412@misena.edu.co', 17);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `nombreRol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRol`, `nombreRol`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE `telefonos` (
  `idTelefono` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`idTelefono`, `numero`, `idUsuario`) VALUES
(1, 301778629, 1),
(2, 7168115, 2),
(3, 7177187, 2),
(4, 0, 9),
(5, 5678, 10),
(6, 888888, 11),
(7, 888888, 12),
(8, 787878, 13),
(9, 66666, 14),
(10, 66666, 15),
(11, 33333, 16),
(12, 2222, 17);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `cedula` int(11) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombre`, `apellido`, `cedula`, `clave`, `idRol`) VALUES
(1, 'Mariana', 'Martinez', 990306, '123', 1),
(2, 'Alexandra', 'Saldaña', 2214, '123', 2),
(3, 'Brayan', 'Castellanos', 12345, '123', 1),
(5, 'asdfg', 'gdfgh', 23456, '23456', 2),
(6, 'Prueba', 'Uno', 65656565, '123', 2),
(7, 'Prueba', 'Uno', 787878, 'NC8ICU', 2),
(8, 'Jeferson', 'Toro', 1092909, 'ICE7R4', 2),
(9, 'Prueba', 'Cinco', 86868668, '1RO0H1', 2),
(10, 'Laura', 'Seis', 878787, 'QRVMNM', 2),
(11, 'dfghjk', 'dfghjk', 56789, 'XHJ8ZN', 2),
(12, 'dfghjk', 'dfghjk', 56789, 'RYOGQS', 2),
(13, 'Nuevo', 'Registro', 123456789, 'QTU6I9', 2),
(14, 'Lola', 'Yes', 55555, '946X3Y', 2),
(15, 'Lola', 'Yes', 55555, 'RPPKAU', 2),
(16, 'Hola', 'Lo', 5555, '5Y4V22', 2),
(17, 'eeeee', 'rrrrr', 44444, 'KV4JCG', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `correos`
--
ALTER TABLE `correos`
  ADD PRIMARY KEY (`idCorreo`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD PRIMARY KEY (`idTelefono`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idRol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `correos`
--
ALTER TABLE `correos`
  MODIFY `idCorreo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  MODIFY `idTelefono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `correos`
--
ALTER TABLE `correos`
  ADD CONSTRAINT `correos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD CONSTRAINT `telefonos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
