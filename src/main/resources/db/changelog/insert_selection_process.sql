INSERT INTO selection_process_status (status_name, fk_jo_id) VALUES('Pré-Selecionado', 1), ('Entrevista Marcada', 1),('Eliminado', 1),('Contratado', 1);

INSERT INTO selection_process (fk_jo_id, fk_can_id, fk_status_name, obs) VALUES(1, 2, 'Pré-Selecionado', 'Fera'), (1, 1, 'Pré-Selecionado', 'Fera');