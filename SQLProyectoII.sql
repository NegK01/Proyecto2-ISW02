-- Nombre de la DataBase

Create database TransportesIIIPatitos
---------------------------------------------------------|
-- Mauricio Oporta Rosales
-- Elías Salas Méndez
---------------------------------------------------------|
Use TransportesIIIPatitos
---------------------------------------------------------|
-- Crear Tablas -----------------------------------------|

-- Usuarios --
CREATE TABLE Usuarios(  
    id_usuario	int primary key,
	usuario		varchar(55) not null,
	contraseña	varchar(55) not null,
	rol			int not null, -- Considerar Tabla roles
);

-- Vehiculos --
CREATE TABLE Vehiculos(
    id_vehiculo			int primary key,
	placa				varchar(20) unique not null,
	modelo				varchar(55),
	tipo_combustible	varchar(55) not null,
	kilometraje			int not null,
	ubicacion_puerto	varchar(100) not null,
);

-- Combustibles --
CREATE TABLE Combustibles(
	 id_combustible	 int primary key,
	 nombre			varchar(55) not null,
	 precio			decimal(10,2) not null,
);

-- TanquesCombustible --
CREATE TABLE TanquesCombustible(
	id_tanque		int primary key,
	id_combustible	int not null,
	capacidad		int not null,
	ubicacion		varchar(55),
);

-- IngresoDeCombustible (Factura) --
CREATE TABLE IngresoDeCombustible(
    id_ingresocombustible	int primary key,
	id_dispensado			int not null,

);

--tabla proveedores, fecha de compra, usuario que realizo compra, otros datos...
CREATE TABLE Proveedores(

);

-- Dispensadores --
CREATE TABLE Dispensadores(
    id_dispensadores	int primary key,
	id_tanque			int not null,
	ubicacion			varchar(55),
);

-- DispensandoDeCombustible --
CREATE TABLE DispensandoDeCombustible(
	id_dispesando		int primary key,
	fecha_dispension	Date not null,
	id_dispensador      int not null,
	id_vehiculo         int not null,
	id_usuario			int not null,
);

-- PartesDeEquipos (Partes remplazables?) --
CREATE TABLE PartesDeEquipos(
	
);

-- TiposDeMantenimientos --
CREATE TABLE TiposDeMantenimientos(
	id_mantenimiento	int primary key,
	tipo				varchar(55) not null,
	precio				decimal(10,2) not null,
);

-- AsignacionDeMantenimientos --
CREATE TABLE AsignacionDeMantenimientos(
	
);

-- BoletasDeMantenimientos --
CREATE TABLE BoletasDeMantenimientos(
    
);


---------------------------------------------------------|
-- Selects De Prueba ------------------------------------|
...
---------------------------------------------------------|
