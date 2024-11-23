-- Nombre de la DataBase

Create database TransportesIIIPatitos
---------------------------------------------------------|
-- Mauricio Oporta Rosales
-- Elías Salas Méndez
---------------------------------------------------------|
Use TransportesIIIPatitos
---------------------------------------------------------|
-- Crear Tablas -----------------------------------------|

-- //Usuarios\\ -- 
CREATE TABLE Usuarios(   
    id	        int primary key,
	usuario		varchar(55) unique not null,
	contrasena	varchar(256) not null,
	rol			int not null, -- 1 = Admin  / 0	 = Usuario
	activo      int not null  -- 1 = Activo / 0 = Inactivo
);

-- //empleados\\ --
CREATE TABLE empleados(
	id	        int primary key,
	cedula      int unique not null,
	nombre		varchar(55) not null,
	rol			int not null, -- 1 = Chofer / 0 = Mecanico
	activo		int not null
	CONSTRAINT fk_idEmpleado	FOREIGN KEY(id) REFERENCES Usuarios(id)
);

-- //vehiculos\\ 
CREATE TABLE vehiculos(
    id					int PRIMARY KEY,
    placa				varchar(20) UNIQUE NOT NULL,
	marca              varchar(65) not null,
	modelo				varchar(65) not null,
    anio				varchar(55) not null,
    id_combustible  	int NOT NULL, 
    activo				int NOT NULL -- activo = 1, inactivo = 0
	CONSTRAINT fk_combustible	FOREIGN KEY(id_combustible) REFERENCES combustibles(id)
);

-- //combustibles\\ --
CREATE TABLE combustibles(
    id				   int PRIMARY KEY,
    nombre             varchar(55) UNique NOT NULL,
    activo             int NOT NULL -- activo = 1, inactivo = 0
);

-- //tanques_combustible\\ -- 
CREATE TABLE tanques_combustible(
    id							int PRIMARY KEY,
	nombre						varchar(60) Unique NOT NULL,
	descripcion					varchar(255) NOT NULL, -- una descipcion por si desea agregar mas detalles como su ubicacion
	capacidad					int NOT NULL, --capacidad del 0 al 100%, se modifica segun compra 
    id_combustible				int NOT NULL,
	activo                      int NOT NULL
    CONSTRAINT foreing_combustible	FOREIGN KEY(id_combustible) REFERENCES combustibles(id)
);

-- //proveedores\\ -- 
CREATE TABLE proveedores(
    id								int PRIMARY KEY,
    nombre							varchar(100) NOT NULL,
    direccion						varchar(255),
    email							varchar(100),
    activo							int NOT NULL
);

-- //ingreso_de_combustible Encabezado\\ -- (compra combustible)
CREATE TABLE ingreso_de_combustible(
    id							int PRIMARY KEY,
    id_proveedor				int NOT NULL,
    fecha_ingreso				date NOT NULL,
	activo                      int NOT NULL
    CONSTRAINT fk_combustibleProveedor	FOREIGN KEY(id_proveedor) REFERENCES proveedores(id)
);

-- //ingreso_de_combustible Detalle\\ --
CREATE TABLE ingreso_de_combustible_detalle(
    id							int PRIMARY KEY,
	id_ingreso_encabezado		int not null,
	id_combustible				int not null,
	id_tanque					int not null,
    cantidad_comprada			int not null, -- cantidad de combustible comprado, recordar que tanque se mide de 0 a 100%
    costo_de_compra				decimal not null  -- costo de la compra de ese combustible
    CONSTRAINT fk_ingreso_encabezado	FOREIGN KEY(id_ingreso_encabezado) REFERENCES ingreso_de_combustible(id),
	CONSTRAINT fk_ingreso_combustible	FOREIGN KEY(id_combustible) REFERENCES combustibles(id),
	CONSTRAINT fk_ingreso_tanque		FOREIGN KEY(id_tanque) REFERENCES tanques_combustible(id)
);

-- //dispensadores\\ --
CREATE TABLE dispensadores(
    id							int PRIMARY KEY,
	nombre						varchar(60) Unique NOT NULL,
	descripcion					varchar(255) NOT NULL, -- una descipcion por si desea agregar mas detalles como su ubicacion
    id_tanque					int NOT NULL,
	id_combustible				int NOT NULL,
	activo						int NOT NULL
    CONSTRAINT fk_tanque				FOREIGN KEY(id_tanque) REFERENCES tanques_combustible(id),-- cantidad
	CONSTRAINT fk_dispensar_combustible	FOREIGN KEY(id_combustible) REFERENCES combustibles(id)
);

-- //dispensando_de_combustible\\ -- 
CREATE TABLE dispensando_de_combustible(
    id								int PRIMARY KEY,
	id_dispensador					int NOT NULL,
    id_vehiculo						int NOT NULL,
    id_chofer						int NOT NULL,
	id_combustible					int NOT NULL,
	kilometraje						int NOT NULL,
    fecha_dispension				date NOT NULL,
    activo							int NOT NULL
    CONSTRAINT fk_dispensador				FOREIGN KEY(id_dispensador) REFERENCES dispensadores(id),
    CONSTRAINT fk_vehiculo					FOREIGN KEY(id_vehiculo) REFERENCES vehiculos(id),
    CONSTRAINT fk_chofer_dispensado			FOREIGN KEY(id_chofer) REFERENCES usuarios(id),
	CONSTRAINT fk_combustible_dispensado	FOREIGN KEY(id_combustible) REFERENCES combustibles(id)
);

-- //partes_de_equipos\\ --
CREATE TABLE partes_de_equipos(
    id		           int PRIMARY KEY,
    descripcion        varchar(255) NOT NULL,
	activo             int NOT NULL
);

-- //tipos_de_mantenimientos\\ --
CREATE TABLE tipos_de_mantenimientos(
    id				   int PRIMARY KEY,
    descripcion        varchar(255) NOT NULL,	
	activo             int NOT NULL
);

-- //asignacion_de_mantenimientos\\ --
CREATE TABLE asignacion_de_mantenimientos(
    id										int PRIMARY KEY,
    id_vehiculo								varchar(20) NOT NULL,
	id_parte_del_equipo						int NOT NULL,
    id_tipo_mantenimiento					int NOT NULL,	
	kilometraje								int, -- kilometraje de duracion del mantenimiento
    dias									int, -- dias de duracion del mantenimiento
	activo                                  int NOT NULL
    CONSTRAINT fk_vehiculo_mantenimiento	FOREIGN KEY(id_vehiculo) REFERENCES vehiculos(placa),
	CONSTRAINT fk_parte_de_equipo		    FOREIGN KEY(id_parte_del_equipo) REFERENCES partes_de_equipos(id),
	CONSTRAINT fk_mantenimiento				FOREIGN KEY(id_tipo_mantenimiento) REFERENCES tipos_de_mantenimientos(id)
);
/*
	-en el primer dispensado de combustible el auto tiene 1000km.
	-hace un mantenimiento que tiene de kilometraje 7000km de vida util.
	-si en el siguiente registro de dispensado tiene 7000km aun le quedan 1000km para usar.
	-si en el siguiente registro de dispensado tiene 7500km se debe advertir que esta cerca 
		de la caducidad y que se debe hacer un mantenimiento.
	-si en el siguiente registro de dispensado tiene 8000km se debe mostrar de manera resaltada
		que acaba de caducar y se debe hacer un mantenimiento por estar sobrefecha, obviamente
		se debe indicar de que es el cambio, si es de llantas o de cambio de aceite u otra cosa.
*/

-- //boletas_de_mantenimientos_encabezado\\ --
CREATE TABLE boletas_de_mantenimientos_encabezado(
    id								int PRIMARY KEY,
	id_vehiculo						varchar(20) NOT NULL,
    kilometraje						int NOT NULL, -- kilometraje actual de vehículo
	mecanico						int NOT NULL,
	fecha_emision					date NOT NULL, -- fecha de emision de la boleta
	activo							int NOT NULL
    CONSTRAINT fk_placa_vehiculo			FOREIGN KEY(id_vehiculo) REFERENCES vehiculos(placa),
	CONSTRAINT fk_mecanico_mantenimiento	FOREIGN KEY(mecanico) REFERENCES empleados(id)
);

-- //boletas_de_mantenimientos_detalle\\ --
CREATE TABLE boletas_de_mantenimientos_detalle(
    id								int NOT NULL,
	id_tipo_mantenimiento			int NOT NULL,
	id_parte_de_equipo				int NOT NULL,
	id_boleta_encabezado			int NOT NULL
	CONSTRAINT fk_mantenimiento				FOREIGN KEY(id_tipo_mantenimiento) REFERENCES tipos_de_mantenimientos(id),
	CONSTRAINT fk_parte_de_equipo		    FOREIGN KEY(id_parte_de_equipo)	REFERENCES partes_de_equipos(id),
	CONSTRAINT fk_boleta_encabezado			FOREIGN KEY(id_boleta_encabezado) REFERENCES boletas_de_mantenimientos_encabezado(id)
);

-- //bitacora\\ --
CREATE TABLE bitacora(
	id								int primary key,
	fecha							date not null,
	hora							varchar(10) not null,
	usuario							varchar(55) not null,
	movimiento						varchar(55) not null,
	lugar							varchar(55) not null,
	CONSTRAINT fk_usuario	FOREIGN KEY(usuario) REFERENCES Usuarios(usuario)
);

---------------------------------------------------------|
-- Pruebas ----------------------------------------------|
DROP DATABASE TransportesIIIPatitos;
delete from bitacora
drop table bitacora
Select * From bitacora
insert into Usuarios values (1,'1','c4ca4238a0b923820dcc509a6f75849b',1,1);
Select * from Usuarios
select * from combustibles where activo in (1,0)
select id,nombre, Case When activo = 1 theN 'activo' 
                When activo = 0 then 'inactivo' 
                Else 'Desconocido' 
                end as estado_activo 
                from  combustibles;
select * from partes_de_equipos where activo in (0)
---------------------------------------------------------|
