INSERT INTO persons (id,version,first_name,last_name) VALUES (1, 0, 'James', 'Carter');
INSERT INTO persons (id,version,first_name,last_name) VALUES (2, 0, 'Helen', 'Leary');
INSERT INTO persons (id,version,first_name,last_name) VALUES (3, 0, 'Linda', 'Douglas');
INSERT INTO persons (id,version,first_name,last_name) VALUES (4, 0, 'Rafael', 'Ortega');
INSERT INTO persons (id,version,first_name,last_name) VALUES (5, 0, 'Henry', 'Stevens');
INSERT INTO persons (id,version,first_name,last_name) VALUES (6, 0, 'Sharon', 'Jenkins');

INSERT INTO persons (id,version,first_name,last_name) VALUES (7, 0, 'George', 'Franklin');
INSERT INTO persons (id,version,first_name,last_name) VALUES (8, 0, 'Betty', 'Davis');
INSERT INTO persons (id,version,first_name,last_name) VALUES (9, 0, 'Eduardo', 'Rodriquez');
INSERT INTO persons (id,version,first_name,last_name) VALUES (10, 0, 'Harold', 'Davis');
INSERT INTO persons (id,version,first_name,last_name) VALUES (11, 0, 'Peter', 'McTavish');
INSERT INTO persons (id,version,first_name,last_name) VALUES (12, 0, 'Jean', 'Coleman');
INSERT INTO persons (id,version,first_name,last_name) VALUES (13, 0, 'Jeff', 'Black');
INSERT INTO persons (id,version,first_name,last_name) VALUES (14, 0, 'Maria', 'Escobito');
INSERT INTO persons (id,version,first_name,last_name) VALUES (15, 0, 'David', 'Schroeder');
INSERT INTO persons (id,version,first_name,last_name) VALUES (16, 0, 'Carlos', 'Estaban');


INSERT INTO vets (id) VALUES (1);
INSERT INTO vets (id) VALUES (2);
INSERT INTO vets (id) VALUES (3);
INSERT INTO vets (id) VALUES (4);
INSERT INTO vets (id) VALUES (5);
INSERT INTO vets (id) VALUES (6);

INSERT INTO specialties (id,version,name) VALUES (1, 0, 'radiology');
INSERT INTO specialties (id,version,name) VALUES (2, 0, 'surgery');
INSERT INTO specialties (id,version,name) VALUES (3, 0, 'dentistry');

INSERT INTO vet_specialties (vets_id,specialties_id) VALUES (2, 1);
INSERT INTO vet_specialties (vets_id,specialties_id) VALUES (3, 2);
INSERT INTO vet_specialties (vets_id,specialties_id) VALUES (3, 3);
INSERT INTO vet_specialties (vets_id,specialties_id) VALUES (4, 2);
INSERT INTO vet_specialties (vets_id,specialties_id) VALUES (5, 1);

INSERT INTO types (id,version,name) VALUES (1, 0, 'cat');
INSERT INTO types (id,version,name) VALUES (2, 0, 'dog');
INSERT INTO types (id,version,name) VALUES (3, 0, 'lizard');
INSERT INTO types (id,version,name) VALUES (4, 0, 'snake');
INSERT INTO types (id,version,name) VALUES (5, 0, 'bird');
INSERT INTO types (id,version,name) VALUES (6, 0, 'hamster');

INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (7, '110 W. Liberty St.', 'Madison', '6085551023','HOME');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (8, '638 Cardinal Ave.', 'Sun Prairie', '6085551749','HOME');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (9, '2693 Commerce St.', 'McFarland', '6085558763','WORK');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (10, '563 Friendly St.', 'Windsor', '6085553198','HOME');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (11, '2387 S. Fair Way', 'Madison', '6085552765','WORK');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (12, '105 N. Lake St.', 'Monona', '6085552654','WORK');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (13, '1450 Oak Blvd.', 'Monona', '6085555387','WORK');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (14, '345 Maple St.', 'Madison', '6085557683','HOME');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (15, '2749 Blackhawk Trail', 'Madison', '6085559435','HOME');
INSERT INTO owners (id,address,city,telephone,phone_type) VALUES (16, '2335 Independence La.', 'Waunakee', '6085555487','WORK');

INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (1, 0, 'Leo', '2000-09-07', 1, 7);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (2, 0, 'Basil', '2002-08-06', 6, 8);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (3, 0, 'Rosy', '2001-04-17', 2, 9);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (4, 0, 'Jewel', '2000-03-07', 2, 9);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (5, 0, 'Iggy', '2000-11-30', 3, 10);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (6, 0, 'George', '2000-01-20', 4, 11);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (7, 0, 'Samantha', '1995-09-04', 1, 12);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (8, 0, 'Max', '1995-09-04', 1, 12);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (9, 0, 'Lucky', '1999-08-06', 5, 13);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (10, 0, 'Mulligan', '1997-02-24', 2, 14);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (11, 0, 'Freddy', '2000-03-09', 5, 15);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (12, 0, 'Lucky', '2000-06-24', 2, 16);
INSERT INTO pets (id,version,name,birth_date,type_id,owner_id) VALUES (13, 0, 'Sly', '2002-06-08', 1, 16);

INSERT INTO visits (id,version,pet_id,pos_index,visit_date,description,checkup) VALUES (1, 0, 7, 0, '1996-03-04', 'rabies shot',false);
INSERT INTO visits (id,version,pet_id,pos_index,visit_date,description,checkup) VALUES (2, 0, 8, 0, '1996-03-04', 'rabies shot',false);
INSERT INTO visits (id,version,pet_id,pos_index,visit_date,description,checkup) VALUES (3, 0, 8, 1, '1996-06-04', 'neutered',true);
INSERT INTO visits (id,version,pet_id,pos_index,visit_date,description,checkup) VALUES (4, 0, 7, 1, '1996-09-04', 'spayed',false);

INSERT INTO images (pet_id,image_name,filename,width,height) VALUES (1,'leo1','leo.png',300,600);
INSERT INTO images (pet_id,image_name,filename,width,height) VALUES (1,'leo2','leo2.png',500,700);
INSERT INTO images (pet_id,image_name,filename,width,height) VALUES (7,'kitty1','kitty.png',400,500);
INSERT INTO images (pet_id,image_name,filename,width,height) VALUES (7,'kitty2','my_kitty.jpeg',500,200);
INSERT INTO images (pet_id,image_name,filename,width,height) VALUES (7,'kitty3','kitty3.gif',100,300);

ALTER SEQUENCE hibernate_sequence RESTART WITH 100;

