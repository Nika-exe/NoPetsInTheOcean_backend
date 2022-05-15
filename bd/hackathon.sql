SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hackathon`
--
CREATE DATABASE IF NOT EXISTS `hackathon` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hackathon`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tdirecciones_denuncias`
--

DROP TABLE IF EXISTS `tdirecciones_denuncias`;
CREATE TABLE `tdirecciones_denuncias` (
  `TDD_PK` int(11) NOT NULL,
  `TDD_FK_DENUNCIA` int(11) DEFAULT NULL,
  `TDD_AVENIDA` varchar(25) DEFAULT NULL,
  `TDD_CIUDAD` varchar(25) DEFAULT NULL,
  `TDD_ESTADO` varchar(25) DEFAULT NULL,
  `TDD_CP` varchar(5) DEFAULT NULL,
  `TDD_REFERENCIA` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tsolicitudes_adopcion`
--

DROP TABLE IF EXISTS `tsolicitudes_adopcion`;
CREATE TABLE `tsolicitudes_adopcion` (
  `TSA_PK` int(11) NOT NULL,
  `TSA_NOMBRE` varchar(50) DEFAULT NULL,
  `TSA_CORREO` varchar(50) DEFAULT NULL,
  `TSA_TELEFONO` varchar(15) DEFAULT NULL,
  `TSA_ESPECIE_MASCOTA` varchar(25) DEFAULT NULL,
  `TSA_MOTIVO` varchar(300) DEFAULT NULL,
  `TSA_ETAPA` int(11) DEFAULT 1,
  `TSA_FECHA_REGISTRO` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tsolicitudes_denuncias`
--

DROP TABLE IF EXISTS `tsolicitudes_denuncias`;
CREATE TABLE `tsolicitudes_denuncias` (
  `TSD_PK` int(11) NOT NULL,
  `TSD_DESCRIPCION_HECHO` varchar(300) DEFAULT NULL,
  `TSD_FECHA_REGISTRO` date DEFAULT current_timestamp(),
  `TSD_ETAPA` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tdirecciones_denuncias`
--
ALTER TABLE `tdirecciones_denuncias`
  ADD PRIMARY KEY (`TDD_PK`);

--
-- Indices de la tabla `tsolicitudes_adopcion`
--
ALTER TABLE `tsolicitudes_adopcion`
  ADD PRIMARY KEY (`TSA_PK`);

--
-- Indices de la tabla `tsolicitudes_denuncias`
--
ALTER TABLE `tsolicitudes_denuncias`
  ADD PRIMARY KEY (`TSD_PK`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tdirecciones_denuncias`
--
ALTER TABLE `tdirecciones_denuncias`
  MODIFY `TDD_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tsolicitudes_adopcion`
--
ALTER TABLE `tsolicitudes_adopcion`
  MODIFY `TSA_PK` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tsolicitudes_denuncias`
--
ALTER TABLE `tsolicitudes_denuncias`
  MODIFY `TSD_PK` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
