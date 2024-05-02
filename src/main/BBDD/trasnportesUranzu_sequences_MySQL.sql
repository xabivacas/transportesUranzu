/* Drops*/
DROP PROCEDURE IF EXISTS INSERT_CAMIONERO;
DROP PROCEDURE IF EXISTS DELETE_CAMIONERO;
DROP PROCEDURE IF EXISTS UPDATE_CAMIONERO;
DROP PROCEDURE IF EXISTS INSERT_CAMION;
DROP PROCEDURE IF EXISTS DELETE_CAMION;
DROP PROCEDURE IF EXISTS UPDATE_CAMION;
DROP PROCEDURE IF EXISTS INSERT_VIAJE;
DROP PROCEDURE IF EXISTS DELETE_VIAJE;
DROP PROCEDURE IF EXISTS UPDATE_VIAJE;
DROP PROCEDURE IF EXISTS INSERT_CARGA;
DROP PROCEDURE IF EXISTS DELETE_CARGA;
DROP PROCEDURE IF EXISTS UPDATE_CARGA;
DROP PROCEDURE IF EXISTS INSERT_CLIENTE;
DROP PROCEDURE IF EXISTS DELETE_CLIENTE;
DROP PROCEDURE IF EXISTS UPDATE_CLIENTE;
DROP PROCEDURE IF EXISTS VIAJESDECAMIONERO;

-- Procedures Camioneros
DELIMITER //
CREATE PROCEDURE INSERT_CAMIONERO (IN DNI VARCHAR(9), IN NOMBRE VARCHAR(255), IN APELLIDO VARCHAR(255))
BEGIN
    INSERT INTO CAMIONEROS (DNI, NOMBRE, APELLIDO) VALUES (DNI, NOMBRE, APELLIDO);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE DELETE_CAMIONERO(IN DNI VARCHAR(9))
BEGIN
    DELETE FROM CAMIONEROS WHERE DNI = DNI;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE UPDATE_CAMIONERO(IN DNI VARCHAR(9), IN NOMBRE VARCHAR(255), IN APELLIDO VARCHAR(255))
BEGIN
    UPDATE CAMIONEROS SET NOMBRE = NOMBRE, APELLIDO = APELLIDO WHERE DNI = DNI;
END //
DELIMITER ;

-- Procedures camiones
DELIMITER //
CREATE PROCEDURE INSERT_CAMION(IN MATRICULA VARCHAR(7), IN MARCA VARCHAR(255), IN MODELO VARCHAR(255))
BEGIN
    INSERT INTO CAMIONES (MATRICULA, MARCA, MODELO) VALUES (MATRICULA, MARCA, MODELO);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE DELETE_CAMION(IN MATRICULA VARCHAR(7))
BEGIN
    DELETE FROM CAMIONES WHERE MATRICULA = MATRICULA;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE UPDATE_CAMION(IN MATRICULA VARCHAR(7), IN MARCA VARCHAR(255), IN MODELO VARCHAR(255))
BEGIN
    UPDATE CAMIONES SET MARCA = MARCA, MODELO = MODELO WHERE MATRICULA = MATRICULA;
END //
DELIMITER ;

-- Procedures VIAJE
DELIMITER //
CREATE PROCEDURE INSERT_VIAJE(IN ORIGEN VARCHAR(255), IN DESTINO VARCHAR(255))
BEGIN
    INSERT INTO VIAJES (ORIGEN, DESTINO) VALUES (ORIGEN, DESTINO);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE DELETE_VIAJE(IN ID INT)
BEGIN
    DELETE FROM VIAJES WHERE ID = ID;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE UPDATE_VIAJE(IN ID INT, IN ORIGEN VARCHAR(255), IN DESTINO VARCHAR(255))
BEGIN
    UPDATE VIAJES SET ORIGEN = ORIGEN, DESTINO = DESTINO WHERE ID = ID;
END //
DELIMITER ;

-- Procedures CARGA
DELIMITER //
CREATE PROCEDURE INSERT_CARGA(IN PESO DECIMAL(10,2), IN DIMENSIONES VARCHAR(255), IN VIAJE INT, IN TIPO VARCHAR(255))
BEGIN
    INSERT INTO CARGA (PESO, DIMENSIONES, VIAJE, TIPO) VALUES (PESO, DIMENSIONES, VIAJE, TIPO);
END //
DELIMITER ;

-- Procedures Clientes
DELIMITER //
CREATE PROCEDURE DELETE_CLIENTE(IN CIF_DELETE VARCHAR(9))
BEGIN
	DELETE FROM CLIENTES WHERE CIF = CIF_DELETE;
END //
DELIMITER ;

DELIMITER //

CREATE PROCEDURE VIAJESDECAMIONERO(IN DNICAMIONERO VARCHAR(9))
BEGIN
    SELECT *
    FROM CAMIONEROS AS C
    INNER JOIN VIAJE_CAMIONES_CAMIONEROS AS VCC ON C.DNI = VCC.CAMIONERO
    INNER JOIN CAMIONES AS CA ON VCC.MATRICULA = CA.MATRICULA
    INNER JOIN VIAJES AS V ON VCC.VIAJE = V.ID
    WHERE C.DNI = DNICAMIONERO;
END//

DELIMITER ;

CALL VIAJESDECAMIONERO('12345678A')