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
    id	        int primary key,
	usuario		varchar(55) unique not null,
	contrasena	varchar(256) not null,
	rol			int not null,
	estado      int not null,
);

INSERT INTO Usuarios (id, usuario, contrasena, rol, estado) VALUES
(1, 'Admin', 'password', 1, 1),
(2, 'Sarzzzo', '123', 2, 1),
(3, 'Neg', '321', 2, 1);

Select * from Usuarios
SELECT contrasena, rol FROM Usuarios WHERE usuario = 'Neg'

-- Vehiculos --
CREATE TABLE Vehiculos(
    id			        int primary key,
	placa				varchar(20) unique not null,
	modelo				varchar(55),
	tipo_combustible	varchar(55) not null,
	kilometraje			int not null,
	ubicacion_puerto	varchar(100) not null,
);

-- Combustibles --
CREATE TABLE Combustibles(
	 id             int primary key,
	 nombre			varchar(55) not null,
	 precio			decimal(10,2) not null,
);

-- TanquesCombustible --
CREATE TABLE TanquesCombustible(
	id              int primary key,
	id_combustible	int not null,
	capacidad		int not null,
	ubicacion		varchar(55),
);

-- IngresoDeCombustible (Factura) --
CREATE TABLE IngresoDeCombustible(
    id                      int primary key,
	id_dispensado			int not null,
);

--tabla proveedores, fecha de compra, usuario que realizo compra, otros datos...
CREATE TABLE Proveedores(

);

-- Dispensadores --
CREATE TABLE Dispensadores(
    id	                int primary key,
	id_tanque			int not null,
	ubicacion			varchar(55),
);

-- DispensandoDeCombustible --
CREATE TABLE DispensandoDeCombustible(
	id                  int primary key,
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
	id                  int primary key,
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
