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
	estado      int not null, -- 1 = Activo
);

INSERT INTO Usuarios (id, usuario, contrasena, rol, estado) VALUES
(1, 'Admin',	'password', 1, 1),
(2, 'Sarzzzo',	'123',		2, 1),
(3, 'Neg',		'321',		2, 1);

Select * from Usuarios
SELECT contrasena, rol FROM Usuarios WHERE usuario = 'Neg'

-- vehiculos --
CREATE TABLE vehiculos(
    id					int PRIMARY KEY,
    placa				varchar(20) UNIQUE NOT NULL,
    modelo				varchar(55),
    tipo_combustible	varchar(55) NOT NULL, -- Cambiar a int y relacionarlo con combustible
    kilometraje         decimal(10,3) NOT NULL, -- ta mal cruzzz
    ubicacion_puerto	varchar(100) NOT NULL,
    activo				int NOT NULL -- activo = 1, inactivo = 0
);

-- combustibles --
CREATE TABLE combustibles(
    id				   int PRIMARY KEY,
    nombre             varchar(55) NOT NULL,
    precio             decimal(10,2) NOT NULL,
    activo             int NOT NULL -- activo = 1, inactivo = 0
);

select * from combustibles
delete from combustibles

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

-- partes_de_equipos (partes reemplazables) --
CREATE TABLE partes_de_equipos(
    id		           int PRIMARY KEY,
	--id_vehiculo		   int NOT NULL,
    --nombre             varchar(100) NOT NULL,
    descripcion        varchar(255) NOT NULL,
    precio             decimal(10,2) NOT NULL,
    --cantidad_stock     int NOT NULL,
	activo             int NOT NULL
);

-- tipos_de_mantenimientos --
CREATE TABLE tipos_de_mantenimientos(
    id				   int PRIMARY KEY,
    descripcion        varchar(255) NOT NULL,
    precio             decimal(10,2) NOT NULL,
	activo             int NOT NULL
);

select * from tipos_de_mantenimientos

-- asignacion_de_mantenimientos --
CREATE TABLE asignacion_de_mantenimientos(
    id										int PRIMARY KEY,
    id_vehiculo								int NOT NULL,
    id_mantenimiento						int NOT NULL,
    fecha_asignacion						date NOT NULL,
    id_usuario								int NOT NULL,
	activo                                  int NOT NULL
    CONSTRAINT fk_vehiculo_mantenimiento	FOREIGN KEY(id_vehiculo) REFERENCES vehiculos(id),
    CONSTRAINT fk_mantenimiento				FOREIGN KEY(id_mantenimiento) REFERENCES tipos_de_mantenimientos(id),
    CONSTRAINT fk_usuario_asignacion		FOREIGN KEY(id_usuario) REFERENCES usuarios(id)
);

-- boletas_de_mantenimientos --
CREATE TABLE boletas_de_mantenimientos(
    id							int PRIMARY KEY,
    id_asignacion				int NOT NULL,
    fecha_emision				date NOT NULL,
    costo_total					decimal(10,2) NOT NULL,
    CONSTRAINT fk_asignacion	FOREIGN KEY(id_asignacion) REFERENCES asignacion_de_mantenimientos(id)
);

---------------------------------------------------------|
-- Selects De Prueba ------------------------------------|


---------------------------------------------------------|
