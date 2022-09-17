-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agencias`
--
DROP TABLE IF EXISTS agencias;

CREATE TABLE `agencias` (
  `idAgencia` int(11) NOT NULL,
  `nombreAgencia` varchar(45) NOT NULL,
  `direccionAgencia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destino`
--
DROP TABLE IF EXISTS destino;

CREATE TABLE `destino` (
  `id_destino` int(11) NOT NULL,
  `nombre_destino` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `origen`
--
DROP TABLE IF EXISTS origen;

CREATE TABLE `origen` (
  `id_origen` int(11) NOT NULL,
  `nombre_origen` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--
DROP TABLE IF EXISTS reservas;

CREATE TABLE `reservas` (
  `id_reservas` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_vuelo` int(11) NOT NULL,
  `numero_sillas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_usuarios`
--
DROP TABLE IF EXISTS rol_usuarios;

CREATE TABLE `rol_usuarios` (
  `id_rol_usuario` int(11) NOT NULL,
  `rol_nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--
DROP TABLE IF EXISTS rutas;

CREATE TABLE `rutas` (
  `id_ruta` int(11) NOT NULL,
  `nombre_ruta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vuelo`
--
DROP TABLE IF EXISTS tipo_vuelo;

CREATE TABLE `tipo_vuelo` (
  `id_tipo_vuelo` int(11) NOT NULL,
  `nombre_tipo_vuelo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--
DROP TABLE IF EXISTS usuarios;

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `documento` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `clave` varchar(30) NOT NULL,
  `direccion` int(30) NOT NULL,
  `rol_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--
DROP TABLE IF EXISTS vuelos;

CREATE TABLE `vuelos` (
  `id_vuelo` int(11) NOT NULL,
  `fechayhora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
