INSERT INTO VETERINARIAN (VETERINARIAN_ID, FIRST_NAME, LAST_NAME) VALUES (1, 'James', 'Carter');
INSERT INTO VETERINARIAN (VETERINARIAN_ID, FIRST_NAME, LAST_NAME) VALUES (2, 'Helen', 'Leary');
INSERT INTO VETERINARIAN (VETERINARIAN_ID, FIRST_NAME, LAST_NAME) VALUES (3, 'Linda', 'Douglas');
INSERT INTO VETERINARIAN (VETERINARIAN_ID, FIRST_NAME, LAST_NAME) VALUES (4, 'Rafael', 'Ortega');
INSERT INTO VETERINARIAN (VETERINARIAN_ID, FIRST_NAME, LAST_NAME) VALUES (5, 'Henry', 'Stevens');
INSERT INTO VETERINARIAN (VETERINARIAN_ID, FIRST_NAME, LAST_NAME) VALUES (6, 'Sharon', 'Jenkins');

INSERT INTO SPECIALTY (SPECIALTY_ID, NAME) VALUES (1, 'radiology');
INSERT INTO SPECIALTY (SPECIALTY_ID, NAME) VALUES (2, 'surgery');
INSERT INTO SPECIALTY (SPECIALTY_ID, NAME) VALUES (3, 'dentistry');

INSERT INTO VETERINARIAN_SPECIALTY (VETERINARIAN_ID, SPECIALTY_ID) VALUES (2, 1);
INSERT INTO VETERINARIAN_SPECIALTY (VETERINARIAN_ID, SPECIALTY_ID) VALUES (3, 2);
INSERT INTO VETERINARIAN_SPECIALTY (VETERINARIAN_ID, SPECIALTY_ID) VALUES (3, 3);
INSERT INTO VETERINARIAN_SPECIALTY (VETERINARIAN_ID, SPECIALTY_ID) VALUES (4, 2);
INSERT INTO VETERINARIAN_SPECIALTY (VETERINARIAN_ID, SPECIALTY_ID) VALUES (5, 1);
