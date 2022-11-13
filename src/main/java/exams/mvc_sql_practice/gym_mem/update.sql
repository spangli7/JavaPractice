

USE testdb;



CREATE TABLE gym_member (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(500),
address VARCHAR(500),
tel_number VARCHAR(500)
);

CREATE TABLE gym_ticket (
user_id INT,
ticket_type_id INT,
price INT,
from_date date,
to_date date
);


CREATE TABLE gym_ticket_type (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(500),
price INT,
duration_in_days INT
);


---------------------------------------------------------------
INSERT INTO gym_member (name, address, tel_number)
VALUES ('Szotak Tamas', 'Kisvarda', '306591988');

INSERT INTO gym_member (name, address, tel_number)
VALUES ('Szotak Zoltan', 'Ansonia', '4752310519');

INSERT INTO gym_member (name, address, tel_number)
VALUES ('Nagy Viktoria', 'Ansonia', '4752310300');


 ---------------------------------------------------------------

INSERT INTO gym_ticket_type (name, price, duration_in_days)
VALUES ('Napi Jegy', 2000, 1);

INSERT INTO gym_ticket_type (name, price, duration_in_days)
VALUES ('Heti Berlet', 5000, 7);

INSERT INTO gym_ticket_type (name, price, duration_in_days)
VALUES ('Havi Berlet', 15000, 31);

---------------------------------------------------------------

INSERT INTO gym_ticket (user_id, ticket_type_id, price, from_date, to_date)
VALUES (3, 2, 5000, '2022-11-07', '2022-11-14');

---------------------------------------------------------------

SELECT * FROM gym_ticket T
INNER JOIN gym_member M ON M.id = T.user_id
INNER JOIN gym_ticket_type TT ON TT.id = T.ticket_type_id;



