/* ************* DLL ************* */

DROP TABLE IF EXISTS "candidate_skill";
DROP TYPE IF EXISTS "skill_level";
DROP TABLE IF EXISTS "skill";
DROP TABLE IF EXISTS "candidate_exp";
DROP TABLE IF EXISTS "company";
DROP TABLE IF EXISTS "post";
DROP TABLE IF EXISTS "candidate_formation";
DROP TABLE IF EXISTS "institution";
DROP TABLE IF EXISTS "course";
DROP TABLE IF EXISTS "candidate";
DROP TYPE IF EXISTS "availability";

/* Enum 'availability' */
CREATE TYPE availability
AS ENUM('M', 'T', 'N', 'S', 'MT', 'MN', 'MS', 'TN', 'NS', 'MTN', 'MTS', 'MNS', 'TNS', 'MTNS');

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
availability availability NOT NULL,
city varchar(30) NOT NULL,
neighborhood varchar(30) NOT NULL,
street varchar(30) NOT NULL,
home_number integer NOT NULL,
complement varchar(30),
zip_code varchar(8) NOT NULL,
latitude float8 NOT NULL,
longitude float8 NOT NULL,
create_dt date NOT NULL default CURRENT_DATE,
update_dt date,
PRIMARY KEY(can_id)
);

/* Table 'skill' */
CREATE TABLE "skill" (
skill_id serial,
description varchar(20) NOT NULL UNIQUE,
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
CONSTRAINT fk_can_id_cs FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_skill_id_cs FOREIGN KEY(fk_skill_id) REFERENCES "skill"(skill_id)
);

/* Table 'company' */
CREATE TABLE "company" (
company_id serial NOT NULL,
com_name varchar(30) UNIQUE NOT NULL,
PRIMARY KEY(company_id));

/* Table 'post' */
CREATE TABLE "post" (
post_id serial NOT NULL,
post_name varchar(30) UNIQUE NOT NULL,
PRIMARY KEY(post_id));

/* Table 'candidate_exp' */
CREATE TABLE "candidate_exp" (
fk_can_id serial NOT NULL,
fk_company_id serial NOT NULL,
fk_post_id serial NOT NULL,
dt_start date NOT NULL,
dt_end date,
description text NOT NULL,
PRIMARY KEY(fk_can_id,fk_company_id,fk_post_id),
CONSTRAINT fk_can_id_ce FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_company_id FOREIGN KEY(fk_company_id) REFERENCES "company"(company_id),
CONSTRAINT fk_post_id FOREIGN KEY(fk_post_id) REFERENCES "post"(post_id));


/* Table 'institution' */
CREATE TABLE "institution" (
inst_id serial NOT NULL,
inst_name varchar(30) UNIQUE NOT NULL,
PRIMARY KEY(inst_id));

/* Table 'course' */
CREATE TABLE "course" (
course_id serial NOT NULL,
course_name varchar(30) UNIQUE NOT NULL,
PRIMARY KEY(course_id));

/* Table 'candidate_formation' */
CREATE TABLE "candidate_formation" (
fk_can_id serial NOT NULL,
fk_inst_id serial NOT NULL,
fk_course_id serial NOT NULL,
dt_start date NOT NULL,
dt_end date NOT NULL,
PRIMARY KEY(fk_can_id,fk_inst_id,fk_course_id),
CONSTRAINT fk_can_id_cf FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_inst_id FOREIGN KEY(fk_inst_id) REFERENCES "institution"(inst_id),
CONSTRAINT fk_course_id FOREIGN KEY(fk_course_id) REFERENCES "course"(course_id));

/* ************* DML ************* */

INSERT INTO candidate (can_name, email, phone, country, city, neighborhood, street, home_number, complement, zip_code, cpf_cnpj, gender, birthday, latitude, longitude, availability) 
values
('Bruce Wayne', 'batman@gmail.com', '05512991222222', 'USA', 'Gothan', 'Palisades', 'Batman Street', 11, 'Cave', '12222012', '22222222221', 'Male', '1991-08-12', 40.730610, -73.935242,'NS'),
('Joker', 'joker@gmail.com', '05512991222222', 'USA', 'Gothan', 'Palisades', 'Unknown', 66, 'Unknown', '12222012', '22222222223', 'Male', '1991-08-12', 40.730610, -73.935242, 'MTNS'),
('Barbara Gordon', 'barbara_gordon@gmail.com', '05512991222222', 'USA', 'Washington', 'Palisades', '15 Street ', 12, 'Unknown', '12222012', '22222222225', 'Female', '2001-12-12', 38.889248, -77.050636, 'MT');

INSERT INTO skill (description) VALUES ('Martial Arts'), ('Python'), ('Java'), ('PHP'), ('GOlang'), ('C'), ('Brainfuck');

INSERT INTO candidate_skill (fk_can_id, fk_skill_id, skill_level) VALUES 
(1, 1, '5'), (1, 2, '5'), (1, 3, '5'), (1, 6, '5'), (1, 4, '5'), -- batman's skills
(2, 1, '5'), (2, 2, '2'), (2, 4, '2'), (2, 7, '5'), -- joker's skills
(3, 1, '5'), (3, 2, '5'), (3, 5, '5'), (3, 4, '5') -- barb's skills
; 

INSERT INTO company (com_name) VALUES('Gothan Zoo'), ('Goathan Bank'), ('Goathan Police');
INSERT INTO post (post_name) VALUES('Police Officer'), ('Developer'), ('Janitor');

INSERT INTO candidate_exp (fk_can_id, fk_company_id, fk_post_id, dt_start, dt_end, description) values
(1, 1, 2, '1998-03-22', '2008-03-22', 'fassdada'), -- batman's experience
(2, 2, 3, '1992-03-22', '2008-03-22', 'aythgdgfd'), -- joker's experience
(3, 3, 1, '1998-03-22', NULL, 'fassdada') -- barb's experience (still working / current job)
;

INSERT INTO institution (inst_name) VALUES('Gothan University'), ('University of Gothan');
INSERT INTO course (course_name) VALUES('Dentistry'), ('Computer engineering');

INSERT INTO candidate_formation (fk_can_id, fk_inst_id , fk_course_id , dt_start, dt_end) values
(1, 1, 2, '2013-03-22', '2018-03-22'), -- batman's formation (finished)
(2, 2, 1, '2019-06-22', '2022-12-22') -- joker's formation  (on course)
;


/* ************* SAMPLE QUERY ************* */

-- Searching candidates that have mastered Python
select can_id, can_name from candidate where can_id in (select distinct(fk_can_id) from candidate_skill cs where (cs.fk_skill_id = 2 and cs.skill_level = '5'));

-- Searching candidates that have mastered Brainfuck and Martial Arts
select can_id, can_name from candidate where can_id in (select distinct(fk_can_id) from candidate_skill cs where (cs.fk_skill_id = 1 and cs.skill_level = '5') and fk_can_id in (select distinct(fk_can_id) 
from candidate_skill cs where (cs.fk_skill_id = 7 and cs.skill_level = '5')));






