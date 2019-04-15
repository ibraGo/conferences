INSERT INTO conferences (id, durationdays, endsubmission, name, startdate, startsubmission) VALUES (1, 3, '2019-03-26', 'conference', '2019-04-03', '2019-03-14');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_REVIEWER');
INSERT INTO roles (id, name) VALUES (4, 'ROLE_AUTHOR');


INSERT INTO services (id, description, label, prix, conference_id) VALUES (4, 'service - description', 'service - label', 119.989998, 1);

INSERT INTO users (id, email, firstname, lastname, password, username, role_id) VALUES (1, 'admin@mail.com', 'admin', 'bimmh', '$2a$11$M5Me5bEOi/1J1y4MYGWKouMdABYrh7lISht.fx2Mwth3XqDgQmPG6', 'admin-bimmh', 2);

INSERT INTO users (id, email, firstname, lastname, password, username, role_id) VALUES (2, 'ibrahim@mail.com', 'ibra', 'him', '$2a$11$qCPes8RxED6mkbGY47Q96.B9eKdo8b8Xt2awxT28ad6hL8fDXBGGq', 'ibrahim', 3);

INSERT INTO users (id, email, firstname, lastname, password, username, role_id) VALUES (3, 'author@gmail.com', 'ibra', 'him', '$2a$11$qCPes8RxED6mkbGY47Q96.B9eKdo8b8Xt2awxT28ad6hL8fDXBGGq', 'ibrahimauth', 4);

INSERT INTO presentations (id, title, speaker_id) VALUES (2, 'Encaisser', 2);

INSERT INTO programs_sections (id, description, enddate, label, startdate, conference_id, presentation_id) VALUES (3, 'Presentaion - description', '2019-03-01 11:05:30', 'Presentaion - label', '2019-03-01 09:00:29', 1, 2);

INSERT INTO professions (id, label) VALUES (9, 'BI');
INSERT INTO professions (id, label) VALUES (10, 'AI');
