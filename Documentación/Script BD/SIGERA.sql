CREATE TABLE Carrera (
  Clave VARCHAR(25) NOT NULL,
  Nombre VARCHAR(100) NULL,
  PRIMARY KEY(Clave)
);

CREATE TABLE Alumno (
  Id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  NoControl VARCHAR(20) NOT NULL UNIQUE,
  Carrera_Clave VARCHAR(25) NOT NULL,
  Nombre VARCHAR(25) NULL,
  Apellido_Paterno VARCHAR(25) NULL,
  Apellido_Materno VARCHAR(25) NULL,
  CURP VARCHAR(25) NOT NULL UNIQUE,
  Semestre INTEGER UNSIGNED NULL,
  Estado BOOL NULL,
  Direccion VARCHAR(100) NULL,
  PRIMARY KEY(Id),
  INDEX Alumno_FKIndex1(Carrera_Clave),
  FOREIGN KEY(Carrera_Clave)
    REFERENCES Carrera(Clave)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('IGE', 'Ingenieria en Gestion Empresarial');
INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('IA', 'Ingenieria en Administracion');
INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('IIA', 'Ingenieria en Industrias Alimentarias');
INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('CP', 'Contador Publico');
INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('ISC', 'Ingenieria en Sistemas Computacionales');
INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('IEM', 'Ingenieria en Electro Mecanica');
INSERT INTO `carrera` (`Clave`, `Nombre`) VALUES ('ITICS', 'Ingenieria en Tecnologias de la Informacion y Comunicacion');
