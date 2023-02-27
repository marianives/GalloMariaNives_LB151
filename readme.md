Man braucht NetBeans  und JDBC ( ein Jar file)

SQL für Datenbank:

CREATE DATABASE Gewinnspiel;
USE Gewinnspiel;

CREATE TABLE Satz (
  Satz VARCHAR(255),
  Kategorie VARCHAR(255)
);

CREATE TABLE Highscore (
  Score INT,
  Name VARCHAR(255)
);


INSERT INTO Satz (Satz, Kategorie) VALUES ('Hallo wie gehts?', 'Frage');
INSERT INTO Satz (Satz, Kategorie) VALUES ('Mir gehts gut', 'Aussage');

