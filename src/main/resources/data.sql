INSERT INTO land_lords (name) values ('Michal');
INSERT INTO land_lords (name) values ('Marcin');
INSERT INTO land_lords (name) values ('Jakub');
INSERT INTO land_lords (name) values ('Krzysztof');

INSERT INTO tenant (name) values ('Piotr');
INSERT INTO tenant (name) values ('Krystian');
INSERT INTO tenant (name) values ('Marian');
INSERT INTO tenant (name) values ('Sebastian');
INSERT INTO tenant (name) values ('Lukasz');

INSERT INTO rent_object (area,description,name,price) values (150,'Little house in the city center','House',120);
INSERT INTO rent_object (area,description,name,price) values (10,'Small studio below the stairs','Room',50);
INSERT INTO rent_object (area,description,name,price) values (80,'The apartment on the first floor','Apartment',300);
INSERT INTO rent_object (area,description,name,price) values (500,'A large castle with a princess','Castle',1500);

INSERT INTO reservations (end_date, final_price,start_date,land_lord_id,rent_object_id,tenant_id) values ('2016-03-25',120,'2016-03-25',1,1,1);
INSERT INTO reservations (end_date, final_price,start_date,land_lord_id,rent_object_id,tenant_id) values ('2016-03-25',120,'2016-03-25',1,2,1);
INSERT INTO reservations (end_date, final_price,start_date,land_lord_id,rent_object_id,tenant_id) values ('2016-03-25',120,'2016-03-25',1,3,1);
INSERT INTO reservations (end_date, final_price,start_date,land_lord_id,rent_object_id,tenant_id) values ('2016-03-25',120,'2016-03-25',1,4,1);

