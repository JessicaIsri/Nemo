INSERT INTO candidate (can_name, email, phone, country, city, neighborhood, street, home_number, complement, zip_code, cpf, gender, birthday, latitude, longitude)
values
('Bruce Wayne', 'batman@gmail.com', '05512991222222', 'USA', 'Gothan', 'Palisades', 'Batman Street', 11, 'Cave', '12222012', '22222222221', 'Male', '1991-08-12', 40.730610, -73.935242),
('Joker', 'joker@gmail.com', '05512991222222', 'USA', 'Gothan', 'Palisades', 'Unknown', 66, 'Unknown', '12222012', '22222222223', 'Male', '1991-08-12', 40.730610, -73.935242),
('Barbara Gordon', 'barbara_gordon@gmail.com', '05512991222222', 'USA', 'Washington', 'Palisades', '15 Street ', 12, 'Unknown', '12222012', '22222222225', 'Female', '2001-12-12', 38.889248, -77.050636);

INSERT INTO skill (description) VALUES ('Martial Arts'), ('Python'), ('Java'), ('PHP'), ('GOlang'), ('C'), ('Brainfuck');

INSERT INTO candidate_skill (fk_can_id, fk_skill_id, skill_level) VALUES
(1, 1, 'FIVE'), (1, 2, 'FIVE'), (1, 3, 'FIVE'), (1, 6, 'FIVE'), (1, 4, 'FIVE'), -- batman's skills
(2, 1, 'FIVE'), (2, 2, 'TWO'), (2, 4, 'TWO'), (2, 7, 'FIVE'), -- joker's skills
(3, 1, 'FIVE'), (3, 2, 'FIVE'), (3, 5, 'FIVE'), (3, 4, 'FIVE') -- barb's skills
;

INSERT INTO client (client_id, client_secret) VALUES
('admin','$2a$10$ixeP95H5dWnQ.SVZM1QJeuKXXxWiUdcFE5xVhj.CASWaLHXj8H8E2');