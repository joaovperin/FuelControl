/**
 * Author:  joaovperin
 * Created: 27/02/2018
 */

CREATE USER IF NOT EXISTS 'Administrador' IDENTIFIED BY 'admin@1234';
CREATE USER IF NOT EXISTS 'Administrador'@'%' IDENTIFIED BY 'admin@1234';
CREATE USER IF NOT EXISTS 'Administrador'@'localhost' IDENTIFIED BY 'admin@1234';

DROP DATABASE IF EXISTS `FuelControl`;
CREATE DATABASE IF NOT EXISTS `FuelControl`;

GRANT ALL ON FuelControl TO Administrador;
GRANT ALL ON FuelControl.* TO Administrador;

GRANT ALL ON FuelControl TO 'Administrador'@'%';
GRANT ALL ON FuelControl.* TO 'Administrador'@'%';

GRANT ALL ON FuelControl TO 'Administrador'@'localhost';
GRANT ALL ON FuelControl.* TO 'Administrador'@'localhost';

USE `FuelControl`;

CREATE TABLE IF NOT EXISTS `usuarios` (
  `usuario` varchar(40) NOT NULL,
  `senha` varchar(18) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `usuarios_login` (
  `usuario` varchar(40) NOT NULL,
  `hora` TIMESTAMP NULL,
  PRIMARY KEY (`usuario`),
  INDEX `FK_Usuarios_Usuarios_Login_idx` (`usuario` ASC),
  CONSTRAINT `FK_Usuarios_Usuarios_Login`
    FOREIGN KEY (`usuario`)
    REFERENCES `usuarios` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `registros` (
  `usuario` varchar(40) NOT NULL,
  `horaEnvio` TIMESTAMP NOT NULL,
  `kmInicial` varchar(18) NOT NULL,
  `kmFinal` varchar(18) NOT NULL,
  PRIMARY KEY (`usuario`, `horaEnvio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;

INSERT INTO `usuarios` (`usuario`, `senha`) VALUES
('admin', '1234'), ('perin', '1234'), ('batata', 'pass');

INSERT INTO `usuarios_login` VALUES 
('admin', SYSDATE()), ('perin', SYSDATE()), ('batata', SYSDATE());

INSERT INTO `registros` VALUES ('admin', '2018-02-24 18:19:03', '100', '120')