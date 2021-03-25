DROP TABLE IF EXISTS "candidate_skill";
DROP TYPE IF EXISTS "skill_level";
DROP TABLE  IF EXISTS "skill";
DROP TABLE  IF EXISTS "candidate";
DROP TABLE  IF EXISTS "client";

/* Table 'candidate' */
CREATE TABLE "candidate" (
can_id SERIAL,
can_name varchar(100) NOT NULL,
email varchar(30) NOT null UNIQUE,
cpf varchar(13) NOT null UNIQUE,
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
AS ENUM('ONE','TWO','THREE','FOUR','FIVE');

/* Table 'candidate_skill' */
CREATE TABLE "candidate_skill" (
fk_can_id serial,
fk_skill_id serial,
skill_level skill_level NOT null,
PRIMARY KEY(fk_can_id, fk_skill_id),
CONSTRAINT fk_can_id FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_skill_id FOREIGN KEY(fk_skill_id) REFERENCES "skill"(skill_id)
);

/* Table 'client' */
CREATE TABLE "client" (
client_id varchar(50),
client_secret varchar(100) NOT NULL,
PRIMARY KEY(client_id));
