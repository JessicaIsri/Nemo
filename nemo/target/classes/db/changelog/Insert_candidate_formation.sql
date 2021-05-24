insert into course (course_id, course_name) VALUES (1, 'Python Avancado');
insert into course (course_id, course_name) VALUES (2, '.NET');
insert into course (course_id, course_name) VALUES (3, 'Windows Server 2016 - MCSA');
insert into course (course_id, course_name) VALUES (4, 'Cabeamento Estruturado');
insert into course (course_id, course_name) VALUES (5, 'Cyber Security');
insert into course (course_id, course_name) VALUES (6, 'ISO 27001');
insert into course (course_id, course_name) VALUES (7, 'Java Avancado');


insert into institution (inst_id, inst_name) VALUES (1, 'IMPACTA');
insert into institution (inst_id, inst_name) VALUES (2, 'MACKENZIE');
insert into institution (inst_id, inst_name) VALUES (3, 'USP');
insert into institution (inst_id, inst_name) VALUES (4, 'UDEMY');
insert into institution (inst_id, inst_name) VALUES (5, '4LINUX');
insert into institution (inst_id, inst_name) VALUES (6, 'CISCO ACADEMY');
insert into institution (inst_id, inst_name) VALUES (7, 'MICROSOFT');

insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (1, 1, 3, '2020-01-20', '2020-12-10');
insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (2, 4, 6, '2021-02-14', '2021-03-25');
insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (3, 5, 4, '2019-01-20', '2019-05-10');
insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (4, 2, 3, '2020-04-16', '2020-06-15');
insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (5, 7, 4, '2020-01-10', '2020-09-03');
insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (6, 6, 7, '2020-07-14', '2020-08-21');
insert into candidate_formation (fk_can_id, fk_inst_id, fk_course_id, dt_start, dt_end) VALUES (7, 6, 1, '2018-10-24', '2018-12-10');
