DROP TABLE IF EXISTS "candidate_skill";
DROP TYPE IF EXISTS "skill_level";
DROP TYPE IF EXISTS "desired_journey";
DROP TYPE IF EXISTS "available_period";
DROP TYPE IF EXISTS "work_modality";
DROP TABLE  IF EXISTS "skill";
DROP TABLE  IF EXISTS "candidate";
DROP TABLE  IF EXISTS "client";
DROP TABLE  IF EXISTS "course";
DROP TABLE  IF EXISTS "institution";
DROP TABLE  IF EXISTS "candidate_formation";
DROP TABLE  IF EXISTS "company";
DROP TABLE  IF EXISTS "post";
DROP TABLE  IF EXISTS "candidate_exp";

CREATE EXTENSION postgis;

/* Enum 'desired_journey' */
CREATE TYPE desired_journey
AS ENUM('UMA_HORA', 'DUAS_HORAS','TRES_HORAS', 'QUATRO_HORAS','CINCO_HORAS', 'SEIS_HORAS', 'SETE_HORAS', 'OITO_HORAS',
                'NOVE_HORAS', 'DEZ_HORAS', 'ONZE_HORAS', 'DOZE_HORAS');

/* Enum 'available_period' */
CREATE TYPE available_period
AS ENUM('MANHA','TARDE','NOITE','MADRUGADA','INTEGRAL_DIURNO','INTEGRAL_NOTURNO');

/* Enum 'work_modality' */
CREATE TYPE work_modality
AS ENUM('PRESENCIAL', 'REMOTO');

/* Table 'candidate' */
CREATE TABLE "candidate" (
can_id SERIAL,
can_name varchar(100) NOT NULL,
email varchar(100) NOT null UNIQUE,
cpf varchar(13) NOT null UNIQUE,
phone varchar(14) NOT NULL,
gender varchar(20) NOT NULL,
birthday date NOT NULL,
country varchar(20) NOT NULL,
city varchar(100) NOT NULL,
neighborhood varchar(100) NOT NULL,
street varchar(100) NOT NULL,
home_number integer NOT NULL,
complement varchar(100),
zip_code varchar(8) NOT NULL,
latitude float8 NOT NULL,
longitude float8 NOT NULL,
pretentionSalary varchar(15) NOT NULL,
desired_journey desired_journey NOT NULL,
available_period available_period NOT NULL,
work_modality work_modality NOT NULL,
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

/* Table 'course' */
CREATE TABLE "course" (
course_id serial,
course_name varchar(100) NOT NULL,
PRIMARY KEY(course_id));

/* Table 'institution' */
CREATE TABLE "institution" (
inst_id serial,
inst_name varchar(100) NOT NULL,
PRIMARY KEY(inst_id));


/* Table 'candidate_formation' */
CREATE TABLE "candidate_formation" (
fk_can_id serial,
fk_inst_id serial,
fk_course_id serial,
dt_start date NOT NULL,
dt_end date,
PRIMARY KEY(fk_can_id, fk_inst_id, fk_course_id),
CONSTRAINT fk_can_id FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_inst_id FOREIGN KEY(fk_inst_id) REFERENCES "institution"(inst_id),
CONSTRAINT fk_course_id FOREIGN KEY(fk_course_id) REFERENCES "course"(course_id)
);

/* Table 'company' */
CREATE TABLE "company" (
company_id serial,
com_name varchar(100) NOT NULL,
PRIMARY KEY(company_id));

/* Table 'post' */
CREATE TABLE "post" (
post_id serial,
post_name varchar(100) NOT NULL,
PRIMARY KEY(post_id));

/* Table 'candidate_exp' */
CREATE TABLE "candidate_exp" (
fk_can_id serial,
fk_company_id serial,
fk_post_id serial,
dt_start date NOT NULL,
dt_end date,
description varchar(100) NOT NULL,
PRIMARY KEY(fk_can_id, fk_company_id, fk_post_id),
CONSTRAINT fk_can_id FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id),
CONSTRAINT fk_company_id FOREIGN KEY(fk_company_id) REFERENCES "company"(company_id),
CONSTRAINT fk_post_id FOREIGN KEY(fk_post_id) REFERENCES "post"(post_id)
);
