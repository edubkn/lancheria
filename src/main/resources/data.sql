INSERT INTO user (facebook_id, name) VALUES ('10215610170554164', 'Eduardo Bueno');
INSERT INTO permission (name) VALUES ('PLACE_ORDER');
INSERT INTO user_permission (id_user, id_permission) VALUES (1, 1);

INSERT INTO ingredient_type (id, description) values (1, 'Pão');
INSERT INTO ingredient_type (id, description) values (2, 'Queijo');
INSERT INTO ingredient_type (id, description) values (3, 'Recheio');
INSERT INTO ingredient_type (id, description) values (4, 'Salada');
INSERT INTO ingredient_type (id, description) values (5, 'Molho');
INSERT INTO ingredient_type (id, description) values (6, 'Tempero');

INSERT INTO ingredient (name, value, id_type) values ('Italiano', 1.25, 1);
INSERT INTO ingredient (name, value, id_type) values ('Integral', 1.25, 1);

INSERT INTO ingredient (name, value, id_type) values ('Cheddar', 1.75, 2);
INSERT INTO ingredient (name, value, id_type) values ('Suíço', 1.75, 2);

INSERT INTO ingredient (name, value, id_type) values ('Frango Teriyaki', 3, 3);
INSERT INTO ingredient (name, value, id_type) values ('Pepperoni', 3, 3);

INSERT INTO ingredient (name, value, id_type) values ('Alface', 1.25, 4);
INSERT INTO ingredient (name, value, id_type) values ('Rúcula', 1.25, 4);
INSERT INTO ingredient (name, value, id_type) values ('Acelga', 1.25, 4);

INSERT INTO ingredient (name, value, id_type) values ('Italiano', 1, 5);
INSERT INTO ingredient (name, value, id_type) values ('Apimentado', 1, 5);

INSERT INTO ingredient (name, value, id_type) values ('Pimenta', 0.25, 6);
INSERT INTO ingredient (name, value, id_type) values ('Sal', 0.25, 6);
INSERT INTO ingredient (name, value, id_type) values ('Orégano', 0.25, 6);