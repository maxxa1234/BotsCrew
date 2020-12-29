DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS articles;

CREATE TABLE departments (
            id int NOT NULL AUTO_INCREMENT,
            name varchar(50) NOT NULL,
            head_name varchar (50) NOT NULL ,
            PRIMARY KEY (id)
);

CREATE TABLE lectors (
        id int NOT NULL AUTO_INCREMENT,
        name varchar(50) NOT NULL,
        degree varchar(30) NOT NULL,
        salary int NOT NULL,
        department_id int NOT NULL,
        PRIMARY KEY (id),
        FOREIGN Key (department_id) REFERENCES departments (id)  ON DELETE NO ACTION ON UPDATE NO ACTION
);

