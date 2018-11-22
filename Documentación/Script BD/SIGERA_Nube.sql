
CREATE TABLE Usuario (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Carrera_Clave VARCHAR(25) NOT NULL,
  Nombre VARCHAR(25) NULL,
  Contrasenia VARCHAR(50) NULL,
  Nombre_Cola VARCHAR(150) NOT NULL,
  PRIMARY KEY(idUsuario),
  INDEX Usuario_FKIndex1(Carrera_Clave),
  FOREIGN KEY(Carrera_Clave)
    REFERENCES Carrera(Clave)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


