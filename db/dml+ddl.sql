/* ************* DLL ************* */

DROP TABLE IF EXISTS "candidate_skill";
DROP TYPE IF EXISTS "skill_level";
DROP TABLE  IF EXISTS "skill";
DROP TABLE  IF EXISTS "candidate";

/* Table 'candidate' */
CREATE TABLE "candidate" (
can_id SERIAL,
can_name varchar(100) NOT NULL,
email varchar(30) NOT null UNIQUE,
cpf_cnpj varchar(13) NOT null UNIQUE,
phone varchar(14) NOT NULL,
gender varchar(20) NOT NULL,
birthday date NOT NULL,
country varchar(20) NOT NULL,
city varchar(30) NOT NULL,
neighborhood varchar(30) NOT NULL,
street varchar(30) NOT NULL,
home_number integer NOT NULL,
complement varchar(30),
zip_code varchar(8) NOT NULL,
latitude float8 NOT NULL,
longitude float8 NOT NULL,
PRIMARY KEY(can_id)
);

/* Table 'skill' */
CREATE TABLE "skill" (
skill_id serial,
description varchar(20) NOT NULL,
PRIMARY KEY(skill_id));


/* Enum 'skill_level' */
CREATE TYPE skill_level
AS ENUM('1','2','3','4','5');

/* Enum 'candidate_skill' */
CREATE TABLE "candidate_skill" (
fk_can_id serial,
fk_skill_id serial,
skill_level skill_level NOT null,
PRIMARY KEY(fk_can_id, fk_skill_id),
CONSTRAINT fk_can_id FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_skill_id FOREIGN KEY(fk_skill_id) REFERENCES "skill"(skill_id)
);

/* ************* DML ************* */

INSERT INTO candidate (can_name, email, phone, country, city, neighborhood, street, home_number, complement, zip_code, cpf_cnpj, gender, birthday, latitude, longitude) 
values
('Bruce Wayne', 'batman@gmail.com', '05512991222222', 'USA', 'Gothan', 'Palisades', 'Batman Street', 11, 'Cave', '12222012', '22222222221', 'Male', '1991-08-12', 40.730610, -73.935242),
('Joker', 'joker@gmail.com', '05512991222222', 'USA', 'Gothan', 'Palisades', 'Unknown', 66, 'Unknown', '12222012', '22222222223', 'Male', '1991-08-12', 40.730610, -73.935242),
('Barbara Gordon', 'barbara_gordon@gmail.com', '05512991222222', 'USA', 'Washington', 'Palisades', '15 Street ', 12, 'Unknown', '12222012', '22222222225', 'Female', '2001-12-12', 38.889248, -77.050636);

INSERT INTO skill (description) VALUES ('Martial Arts'), ('Python'), ('Java'), ('PHP'), ('GOlang'), ('C'), ('Brainfuck');

INSERT INTO candidate_skill (fk_can_id, fk_skill_id, skill_level) VALUES 
(1, 1, '5'), (1, 2, '5'), (1, 3, '5'), (1, 6, '5'), (1, 4, '5'), -- batman's skills
(2, 1, '5'), (2, 2, '2'), (2, 4, '2'), (2, 7, '5'), -- joker's skills
(3, 1, '5'), (3, 2, '5'), (3, 5, '5'), (3, 4, '5') -- barb's skills
; 


/* ************* SAMPLE QUERY ************* */

-- Searching candidates that have mastered Python
select can_id, can_name from candidate where can_id in (select distinct(fk_can_id) from candidate_skill cs where (cs.fk_skill_id = 2 and cs.skill_level = '5'));

-- Searching candidates that have mastered Brainfuck and Martial Arts
select can_id, can_name from candidate where can_id in (select distinct(fk_can_id) from candidate_skill cs where (cs.fk_skill_id = 1 and cs.skill_level = '5') and fk_can_id in (select distinct(fk_can_id) 
from candidate_skill cs where (cs.fk_skill_id = 7 and cs.skill_level = '5')));




