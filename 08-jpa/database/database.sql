IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'db_springboot')
    CREATE DATABASE db_springboot
GO

USE db_springboot

INSERT INTO persons (name, lastname, programming_language) VALUES ('Andres', 'Guzman', 'Java');
INSERT INTO persons (name, lastname, programming_language) VALUES ('Pepe', 'Doe', 'Python');
INSERT INTO persons (name, lastname, programming_language) VALUES ('John', 'Dow', 'JavaScript');
INSERT INTO persons (name, lastname, programming_language) VALUES ('Maria', 'Roe', 'Java');
INSERT INTO persons (name, lastname, programming_language) VALUES ('Josefa', 'Rae', 'Java');

SELECT * FROM persons;