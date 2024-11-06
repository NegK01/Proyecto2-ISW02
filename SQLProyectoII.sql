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
Create Table Usuarios(  
	Usuario     Varchar(50),
	Contraseña  Varchar(50)
);

 -- Vehiculos --
Create Table Vehiculos();


 -- Combustibles --
Create Table Combustibles();


 -- TanquesCombustible --
Create Table TanquesCombustible();


 -- IngresoDeCombustible --
Create Table IngresoDeCombustible();


 -- Dispensadores --
Create Table Dispensadores();


 -- DispensandoDeCombustible --
Create Table DispensandoDeCombustible();


 -- PartesDeEquipos --
Create Table PartesDeEquipos();


 -- TiposDeMantenimientos --
Create Table TiposDeMantenimientos();


 -- AsignacionDeMantenimientos --
Create Table AsignacionDeMantenimientos();


 -- BoletasDeMantenimientos --
Create Table BoletasDeMantenimientos();


---------------------------------------------------------|
-- Selects De Prueba ------------------------------------|
...
---------------------------------------------------------|