INSERT INTO skill (description) VALUES ('Martial Arts'), ('Python'), ('Java'), ('PHP'), ('Golang'), ('C'), ('Brainfuck');

INSERT INTO work_modality (id, name) VALUES (1, 'PRESENCIAL'), (2, 'REMOTO');

INSERT INTO available_period (id, name) VALUES (1, 'MANHA'), (2, 'TARDE'), (3, 'NOITE'), (4, 'MADRUGADA'), (5, 'INTEGRAL_DIURNO'), (6, 'INTEGRAL_NOTURNO');

INSERT INTO desired_journey (id, name) VALUES (1, 'UMA_HORA'), (2, 'DUAS_HORAS'), (3, 'TRES_HORAS'), (4, 'QUATRO_HORAS'),
(5, 'CINCO_HORAS'), (6, 'SEIS_HORAS'), (7, 'SETE_HORAS'), (8, 'OITO_HORAS'), (9, 'NOVE_HORAS'), (10, 'DEZ_HORAS'), (11, 'ONZE_HORAS'), (12, 'DOZE_HORAS');

-- INSERT INTO candidate_skill (fk_can_id, fk_skill_id, skill_level) VALUES
-- (1, 1, 'FIVE'), (1, 2, 'FIVE'), (1, 3, 'FIVE'), (1, 6, 'FIVE'), (1, 4, 'FIVE'), -- batman's skills
-- (2, 1, 'FIVE'), (2, 2, 'TWO'), (2, 4, 'TWO'), (2, 7, 'FIVE'), -- joker's skills
-- (3, 1, 'FIVE'), (3, 2, 'FIVE'), (3, 5, 'FIVE'), (3, 4, 'FIVE') -- barb's skills
-- ;