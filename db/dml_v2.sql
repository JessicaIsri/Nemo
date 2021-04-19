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

INSERT INTO job_opportunity (jo_id, jo_name, description, contract_type, 
working_hours, salary_range_ini, salary_range_end, gender, availability, 
workplace_country, workplace_city, workplace_neighborhood, workplace_street, 
workplace_home_number, workplace_complement, workplace_zip_code, workplace_latitude, 
workplace_longitude, divulgation_ini, divulgation_end) 
VALUES(1, 'Programador XPTO', 'Programar tudo', 'CLT', '08:00:00', 1800.0, 2200.0, 
'M', 'MT', 'Brasil', 'SJC', 'Aquarius', 'Rua  Aquarius', 123, NULL, '12345678', 12.0, -58.0, '2021-04-18 17:53:42.401431', '2021-04-18 17:53:42.401431')


INSERT INTO jo_exp_req (fk_jo_id, fk_post_id, exp_time) VALUES(1, 2, 6); -- 6 months as developer
INSERT INTO jo_exp_req (fk_jo_id, fk_post_id, exp_time) VALUES(1, 3, 6); -- 6 months as janitor


INSERT INTO jo_skill_req (fk_jo_id, fk_skill_id, skill_level) VALUES(1, 5, '5'); -- golang  expert

INSERT INTO jo_formation_req (fk_jo_id, fk_course_id, finished) VALUES(1, 2, true); -- finished programming
INSERT INTO jo_formation_req (fk_jo_id, fk_course_id, finished) VALUES(1, 1, false); -- coursing dentristy







