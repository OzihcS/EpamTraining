DROP DATABASE rolesDB;

CREATE DATABASE rolesDB;

USE rolesDB;

CREATE TABLE roles (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE users (
  role_id INT,
  login   VARCHAR(15) UNIQUE NOT NULL,
  pass    VARCHAR(9)         NOT NULL,
  name    VARCHAR(25)        NOT NULL
);

INSERT INTO roles VALUE (DEFAULT, 'client');
INSERT INTO roles VALUE (DEFAULT, 'admin');

INSERT INTO users VALUES (1, 'ivanov', 'client', 'Ivanov');
INSERT INTO users VALUES (2, 'петров', 'admin', 'Петров');
INSERT INTO users VALUES (2, 'petrov', 'admin', 'Petrov');

SELECT *
FROM roles;
SELECT *
FROM users;

