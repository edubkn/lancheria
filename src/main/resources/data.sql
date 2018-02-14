INSERT INTO user (facebook_id, name) VALUES ('10215610170554164', 'Eduardo Bueno');
INSERT INTO permission (name) VALUES ('PLACE_ORDER');
INSERT INTO user_permission (user_id, permission_id) VALUES (1, 1);

INSERT INTO ingredient_type (id, description) values (1, 'Pão');
INSERT INTO ingredient_type (id, description) values (2, 'Queijo');
INSERT INTO ingredient_type (id, description) values (3, 'Recheio');
INSERT INTO ingredient_type (id, description) values (4, 'Salada');
INSERT INTO ingredient_type (id, description) values (5, 'Molho');
INSERT INTO ingredient_type (id, description) values (6, 'Tempero');

INSERT INTO ingredient (id, name, value, type_id) values (1, 'Italiano', 1.25, 1);
INSERT INTO ingredient (id, name, value, type_id) values (2, 'Integral', 1.25, 1);

INSERT INTO ingredient (id, name, value, type_id) values (3, 'Cheddar', 1.75, 2);
INSERT INTO ingredient (id, name, value, type_id) values (4, 'Suíço', 1.75, 2);

INSERT INTO ingredient (id, name, value, type_id) values (5, 'Frango Teriyaki', 3, 3);
INSERT INTO ingredient (id, name, value, type_id) values (6, 'Pepperoni', 3, 3);

INSERT INTO ingredient (id, name, value, type_id) values (7, 'Alface', 1.25, 4);
INSERT INTO ingredient (id, name, value, type_id) values (8, 'Rúcula', 1.25, 4);
INSERT INTO ingredient (id, name, value, type_id) values (9, 'Acelga', 1.25, 4);

INSERT INTO ingredient (id, name, value, type_id) values (10, 'Italiano', 1, 5);
INSERT INTO ingredient (id, name, value, type_id) values (11, 'Apimentado', 1, 5);

INSERT INTO ingredient (id, name, value, type_id) values (12, 'Pimenta', 0.25, 6);
INSERT INTO ingredient (id, name, value, type_id) values (13, 'Sal', 0.25, 6);
INSERT INTO ingredient (id, name, value, type_id) values (14, 'Orégano', 0.25, 6);