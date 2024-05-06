/*
BBDD: Crear dos Roles de BBDD. Uno especifico DBA (appAdmin) y el otro para los usuarios Clientes de la aplicación (appUser). 
Cuando en la aplicación se logee el administrador, lo hara con el usuario appAdmin y con appUser para los demás casos. 
appUser, solamente podrá ejecutar operaciones de DML y appAdmin creará los usuarios que se logeen con appUser.
*/

/*DROPS
DROP ROLE appAdmin;
DROP ROLE appUser;
DROP USER ADMIN;
DROP USER CLIENTE;
*/

CREATE ROLE appAdmin;
CREATE ROLE appUser ;

GRANT SELECT,INSERT,UPDATE,DELETE ON CAMIONEROS TO appUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON CAMIONES TO appUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON CLIENTES TO appUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON CARGA TO appUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON VIAJE_CAMIONES_CAMIONEROS TO appUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON VIAJE_CARGA_CLIENTES TO appUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON VIAJES TO appUser;
GRANT CREATE SESSION TO appUser;

GRANT CREATE USER,ALTER USER,DROP USER TO appAdmin;
GRANT CREATE SESSION  TO appAdmin;

CREATE USER ADMIN IDENTIFIED BY 'ADMIN' DEFAULT TABLESPACE transportesUranzu;
CREATE USER CLIENTE IDENTIFIED BY 'CLIENTE' DEFAULT TABLESPACE transportesUranzu;

GRANT appAdmin TO ADMIN;
GRANT appUser TO CLIENTE;