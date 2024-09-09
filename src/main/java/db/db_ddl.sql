CREATE DATABASE staysure_db;

USE staysure_db;

CREATE TABLE habitacion (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    descripcion TEXT,
    pais VARCHAR(255),
    ciudad VARCHAR(255),
    imagen TEXT
);