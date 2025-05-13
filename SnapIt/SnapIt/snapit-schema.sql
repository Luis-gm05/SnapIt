CREATE DATABASE snapit;
USE snapit;
CREATE TABLE IF NOT EXISTS perfil(
	id INT AUTO_INCREMENT PRIMARY KEY,
    foto LONGBLOB NOT NULL,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena_hash VARCHAR(60) NOT NULL
);
CREATE TABLE IF NOT EXISTS publicacion(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    foto LONGBLOB NOT NULL,
    texto1 VARCHAR(50),
    texto2 VARCHAR(50),
    FOREIGN KEY(id_usuario) REFERENCES perfil(id)
);
CREATE TABLE IF NOT EXISTS likes(
    id int PRIMARY KEY AUTO_INCREMENT,
	id_usuario int,
    id_publicacion int,
    FOREIGN KEY(id_usuario) REFERENCES perfil (id),
    FOREIGN KEY(id_publicacion) REFERENCES publicacion(id)
);
CREATE TABLE IF NOT EXISTS seguidores(
    id int PRIMARY KEY AUTO_INCREMENT,
	id_seguidor INT,
    id_seguido INT,
    FOREIGN KEY(id_seguidor) REFERENCES perfil(id),
	FOREIGN KEY(id_seguido) REFERENCES perfil(id)
);
