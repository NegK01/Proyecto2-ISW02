-- Nombre de la DataBase

Create database TransportesIIIPatitos
---------------------------------------------------------|
-- Mauricio Oporta Rosales
-- Elías Salas Méndez
---------------------------------------------------------|
Use TransportesIIIPatitos
---------------------------------------------------------|
-- Crear Tablas -----------------------------------------|
DROP DATABASE TransportesIIIPatitos;

-- *****Usuarios***** -- 
CREATE TABLE Usuarios(  
    id	        int primary key,
	usuario		varchar(55) unique not null,
	contrasena	varchar(256) not null,
	rol			int not null, -- 1 = Admin  / 0	 = Usuario
	estado      int not null, -- 1 = Activo / 0 = Inactivo
);
--insert into Usuarios values (1,'1','c4ca4238a0b923820dcc509a6f75849b',1,1);

-- vehiculos --
CREATE TABLE vehiculos(
    id					int PRIMARY KEY,
    placa				varchar(20) UNIQUE NOT NULL,
	nombre              varchar(65) not null,
	marca				varchar(65),
    modelo				varchar(55) not null,
    id_combustible  	int NOT NULL, 
    activo				int NOT NULL -- activo = 1, inactivo = 0
	CONSTRAINT fk_combustible	FOREIGN KEY(id_combustible) REFERENCES combustibles(id)
);

-- *****combustibles***** --
CREATE TABLE combustibles(
    id				   int PRIMARY KEY,
    nombre             varchar(55) UNique NOT NULL,
    --precio             decimal(10,2) NOT NULL,
    activo             int NOT NULL -- activo = 1, inactivo = 0
);

-- tanques_combustible --
CREATE TABLE tanques_combustible(
    id							int PRIMARY KEY,
    id_combustible				int NOT NULL,
    capacidad					decimal(10,2) NOT NULL,
    ubicacion					varchar(55),
    CONSTRAINT fk_combustible	FOREIGN KEY(id_combustible) REFERENCES combustibles(id)
);

-- ingreso_de_combustible (factura) --
CREATE TABLE ingreso_de_combustible(
    id							int PRIMARY KEY,
    id_dispensado				int NOT NULL,
    fecha_ingreso				date NOT NULL,
    cantidad					decimal(10,2) NOT NULL,
    CONSTRAINT fk_dispensado	FOREIGN KEY(id_dispensado) REFERENCES dispensadores(id)
);

-- proveedores --
CREATE TABLE proveedores(
    id								int PRIMARY KEY,
    nombre							varchar(100) NOT NULL,
    direccion						varchar(255),
    telefono						varchar(15),
    email							varchar(100),
    fecha_compra					date NOT NULL,
    id_usuario						int NOT NULL,
    CONSTRAINT fk_usuario_compra	FOREIGN KEY(id_usuario) REFERENCES usuarios(id)
);

-- dispensadores --
CREATE TABLE dispensadores(
    id						int PRIMARY KEY,
    id_tanque				int NOT NULL,
    ubicacion				varchar(55),
    CONSTRAINT fk_tanque	FOREIGN KEY(id_tanque) REFERENCES tanques_combustible(id)
);

-- dispensando_de_combustible --
CREATE TABLE dispensando_de_combustible(
    id								int PRIMARY KEY,
    fecha_dispension				date NOT NULL,
    id_dispensador					int NOT NULL,
    id_vehiculo						int NOT NULL,
    id_usuario						int NOT NULL,
    cantidad_dispensa				decimal(10,2) NOT NULL,
    CONSTRAINT fk_dispensador		FOREIGN KEY(id_dispensador) REFERENCES dispensadores(id),
    CONSTRAINT fk_vehiculo			FOREIGN KEY(id_vehiculo) REFERENCES vehiculos(id),
    CONSTRAINT fk_usuario_dispensa	FOREIGN KEY(id_usuario) REFERENCES usuarios(id)
);

-- *****partes_de_equipos (partes reemplazables)***** --
CREATE TABLE partes_de_equipos(
    id		           int PRIMARY KEY,
	--id_vehiculo		   int NOT NULL,
    --nombre             varchar(100) NOT NULL,
    descripcion        varchar(255) NOT NULL,
    --precio             decimal(10,2) NOT NULL,
    --cantidad_stock     int NOT NULL,
	activo             int NOT NULL
);

-- *****tipos_de_mantenimientos***** --
CREATE TABLE tipos_de_mantenimientos(
    id				   int PRIMARY KEY,
    descripcion        varchar(255) NOT NULL,
    --precio             decimal(10,2) NOT NULL,	
	activo             int NOT NULL
);

-- asignacion_de_mantenimientos --
CREATE TABLE asignacion_de_mantenimientos(
    id										int PRIMARY KEY,
    id_placa_vehiculo						varchar(20) NOT NULL,
    id_mantenimiento						int NOT NULL,
	id_parte_de_equipo						int NOT NULL,
    fecha_de_desgaste						date NOT NULL, -- *
	-- Preguntar si se utiliza estos 2 en conjunto o solo 1 
    kilometraje								int NOT NULL, -- * 
	--activo                                  int NOT NULL
    CONSTRAINT fk_vehiculo_mantenimiento	FOREIGN KEY(id_placa_vehiculo) REFERENCES vehiculos(placa),
    CONSTRAINT fk_mantenimiento				FOREIGN KEY(id_mantenimiento) REFERENCES tipos_de_mantenimientos(id),
	CONSTRAINT fk_parte_de_equipo		    FOREIGN KEY(id_parte_de_equipo) REFERENCES partes_de_equipos(id)
);

-- boletas_de_mantenimientos --
CREATE TABLE boletas_de_mantenimientos(
    id							int PRIMARY KEY,
    id_asignacion				int NOT NULL,
    fecha_emision				date NOT NULL,
    costo_total					decimal(10,2) NOT NULL,
    CONSTRAINT fk_asignacion	FOREIGN KEY(id_asignacion) REFERENCES asignacion_de_mantenimientos(id)
);

-- *****bitacora***** --
CREATE TABLE bitacora(
	id int primary key,
	fecha date not null,
	hora varchar(10) not null,
	usuario varchar(55) not null,
	movimiento varchar(55) not null,
	lugar varchar(55) not null,
	CONSTRAINT fk_usuario	FOREIGN KEY(usuario) REFERENCES Usuarios(usuario)
);

---------------------------------------------------------|
-- Selects De Prueba ------------------------------------|
Select * From bitacora

---------------------------------------------------------|
