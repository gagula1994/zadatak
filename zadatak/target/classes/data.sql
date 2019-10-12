INSERT INTO users (id, username, password) VALUES (1, 'user', '$2a$10$5LfH6lMimH.h3vsmIvPtyetnXFmnsnBme3HPDJJuo8q5fYaglpfb.');
INSERT INTO users (id, username, password) VALUES (2, 'user1', '$2a$10$5LfH6lMimH.h3vsmIvPtyetnXFmnsnBme3HPDJJuo8q5fYaglpfb.');
/*password = password*/

INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);