/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  joaovperin
 * Created: 27/02/2018
 */

DROP DATABASE IF EXISTS FuelControl;
CREATE DATABASE IF NOT EXISTS FuelControl;

CREATE USER 'Administrador' IDENTIFIED BY 'admin@1234';
CREATE USER 'Administrador'@'%' IDENTIFIED BY 'admin@1234';
CREATE USER 'Administrador'@'localhost' IDENTIFIED BY 'admin@1234';

GRANT ALL ON FuelControl TO Administrador;
GRANT ALL ON FuelControl.* TO Administrador;

GRANT ALL ON FuelControl TO 'Administrador'@'%';
GRANT ALL ON FuelControl.* TO 'Administrador'@'%';

GRANT ALL ON FuelControl TO 'Administrador'@'localhost';
GRANT ALL ON FuelControl.* TO 'Administrador'@'localhost';

CREATE DATABASE IF NOT EXISTS `FuelControl`;
USE `FuelControl`;

CREATE TABLE IF NOT EXISTS `usuarios` (
  `Usuario` varchar(40) NOT NULL,
  `Senha` varchar(18) NOT NULL,
  PRIMARY KEY (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `usuarios_login` (
  `Usuario` varchar(40) NOT NULL,
  `HoraUltimoLogin` TIMESTAMP NOT NULL,
  PRIMARY KEY (`Usuario`),
  INDEX `FK_Usuarios_Usuarios_Login_idx` (`Usuario` ASC),
  CONSTRAINT `FK_Usuarios_Usuarios_Login`
    FOREIGN KEY (`Usuario`)
    REFERENCES `usuarios` (`Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `registros` (
  `Usuario` varchar(40) NOT NULL,
  `HoraEnvio` TIMESTAMP NOT NULL,
  `KmInicial` varchar(18) NOT NULL,
  `KmFinal` varchar(18) NOT NULL,
  PRIMARY KEY (`Usuario`, `HoraEnvio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;

INSERT INTO `usuarios` (`Usuario`, `Senha`) VALUES
('admin', '1234'), ('perin', '1234'), ('batata', 'pass');

INSERT INTO `usuarios_login` VALUES ('batata', SYSDATE());

INSERT INTO `registros` VALUES ('admin', '2018-02-24 18:19:03', '100', '120');