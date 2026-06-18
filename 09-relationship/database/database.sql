IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'db_jpa_relationship')
    CREATE DATABASE db_jpa_relationship

USE db_jpa_relationship

INSERT INTO clients (name, lastname) VALUES ('Neider', 'Velez');
INSERT INTO clients (name, lastname) VALUES ('Juliet', 'Morales');

SELECT * FROM clients;

