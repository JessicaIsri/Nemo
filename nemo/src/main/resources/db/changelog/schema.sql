DROP TABLE IF EXISTS "candidate_skill";
DROP TYPE  IF EXISTS "skill_level";
DROP TABLE IF EXISTS "desired_journey";
DROP TABLE IF EXISTS "available_period";
DROP TABLE IF EXISTS "work_modality";
DROP TABLE IF EXISTS "skill";
DROP TABLE IF EXISTS "candidate";
DROP TABLE IF EXISTS "client";
DROP TABLE IF EXISTS "course";
DROP TABLE IF EXISTS "institution";
DROP TABLE IF EXISTS "candidate_formation";
DROP TABLE IF EXISTS "company";
DROP TABLE IF EXISTS "post";
DROP TABLE IF EXISTS "candidate_exp";

CREATE TABLE "desired_journey" (
id SMALLINT,
name varchar(255) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE "available_period" (
id SMALLINT,
name varchar(255) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE "work_modality" (
id SMALLINT,
name varchar(255) NOT NULL,
PRIMARY KEY(id)
);

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
pretensionSalary NUMERIC(17, 4) NOT NULL,
desired_journey_fk SMALLINT NOT NULL,
available_period_fk SMALLINT NOT NULL,
work_modality_fk SMALLINT NOT NULL,
PRIMARY KEY(can_id),
FOREIGN KEY(desired_journey_fk) REFERENCES desired_journey(id),
FOREIGN KEY(available_period_fk) REFERENCES available_period(id),
FOREIGN KEY(work_modality_fk) REFERENCES work_modality(id)
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

/* Table 'candidate_formation' */
CREATE TABLE "candidate_formation" (
id serial,
fk_can_id serial,
institution varchar(255) NOT NULL,
course varchar(255) NOT NULL,
dt_start date NOT NULL,
dt_end date,
PRIMARY KEY(id),
CONSTRAINT fk_can_id FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id)
);

/* Table 'candidate_exp' */
CREATE TABLE "candidate_exp" (
id serial,
fk_can_id serial,
company varchar(255) NOT NULL,
job_title varchar(255) NOT NULL,
dt_start date NOT NULL,
dt_end date,
description varchar(255) NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_can_id FOREIGN KEY(fk_can_id) REFERENCES "candidate"(can_id)
);
