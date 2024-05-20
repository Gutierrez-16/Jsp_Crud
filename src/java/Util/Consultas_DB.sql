


create database sis_ventas_db 
use sis_ventas_db

CREATE TABLE tbl_Proveedores (
    proveedor_id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    contacto VARCHAR(255),
    telefono CHAR(9),
    direccion VARCHAR(255),
    ciudad VARCHAR(255),
    pais VARCHAR(255),
    EstadoProveedor CHAR(1) DEFAULT '1',
    PRIMARY KEY (proveedor_id)
);

CREATE TABLE Categoria (
    IDCategoria INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NombreCategoria VARCHAR(50),
    EstadoCategoria CHAR(1) DEFAULT '1'
);

CREATE TABLE Linea (
    IDLinea INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NombreLinea VARCHAR(50),
    EstadoLinea CHAR(1) DEFAULT '1'
);

CREATE TABLE UnidadMedida (
    IDUnidadMedida INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NombreUnidadMedida VARCHAR(50),
    EstadoUnidadMedida CHAR(1) DEFAULT '1'
);

CREATE TABLE Marca (
    IDMarca INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NombreMarca VARCHAR(50),
    EstadoMarca CHAR(1) DEFAULT '1'
);

CREATE TABLE tbl_Productos (
    producto_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    precio decimal(10,2),
    cantidad_stock int,
    fecha_registro VARCHAR(50),
    proveedor_id INT,
    IDCategoria INT,
    IDLinea INT,
    IDMarca INT,
    IDUnidadMedida INT,
    EstadoProducto CHAR(1) DEFAULT '1',
    FOREIGN KEY (proveedor_id) REFERENCES tbl_Proveedores(proveedor_id),
    FOREIGN KEY (IDCategoria) REFERENCES Categoria(IDCategoria),
    FOREIGN KEY (IDLinea) REFERENCES Linea(IDLinea),
    FOREIGN KEY (IDMarca) REFERENCES Marca(IDMarca),
    FOREIGN KEY (IDUnidadMedida) REFERENCES UnidadMedida(IDUnidadMedida)
);


drop table  tbl_Proveedores
select * from   tbl_Productos
show tables



-- Insertar datos en tbl_Proveedores
INSERT INTO tbl_Proveedores (nombre, contacto, telefono, direccion, ciudad, pais, EstadoProveedor)
VALUES 
('Proveedor Industrial SAC', 'Juan Pérez', '987654321', 'Av. Industrial 123', 'Lima', 'Perú', '1'),
('Comercializadora Andina EIRL', 'María López', '923456789', 'Calle Comercio 456', 'Cusco', 'Perú', '1'),
('Distribuidora Norte SRL', 'Carlos Sánchez', '956123478', 'Jr. Libertad 789', 'Trujillo', 'Perú', '1');


-- Insertar datos en Categoria
INSERT INTO Categoria (NombreCategoria, EstadoCategoria)
VALUES 
('Electrónica', '1'),
('Ropa', '1'),
('Alimentos', '1');



-- Insertar datos en Linea
INSERT INTO Linea (NombreLinea, EstadoLinea)
VALUES 
('Línea Blanca', '1'),
('Línea Marrón', '1'),
('Línea de Vestimenta', '1');


-- Insertar datos en UnidadMedida
INSERT INTO UnidadMedida (NombreUnidadMedida, EstadoUnidadMedida)
VALUES 
('Kilogramo', '1'),
('Litro', '1'),
('Unidad', '1');


-- Insertar datos en Marca
INSERT INTO Marca (NombreMarca, EstadoMarca)
VALUES 
('Marca A', '1'),
('Marca B', '1'),
('Marca C', '1');
