





CREATE TABLE web_shop_orders (
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
price FLOAT,
order_time DATETIME
);


CREATE TABLE web_shop_order_products (
order_id INT,
product_id INT,
number INT
);

CREATE TABLE web_shop_products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(500),
price FLOAT,
number_in_stock INT
);


CREATE TABLE web_shop_users (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(500),
address VARCHAR(500),
email  VARCHAR(500)
);


--------------------------------------------------------------------------------------------


INSERT INTO web_shop_users (name, address, email)
VALUES ('Szotak Tamas', 'Kisvarda', 'szoti13@gmail.com');

INSERT INTO web_shop_users (name, address, email)
VALUES ('Szotak Zoltan', 'Ansonia', 'szoti15@gmail.com');

INSERT INTO web_shop_users (name, address, email)
VALUES ('Nagy Viktoria', 'Ansonia', 'nagyviktoria16@gmail.com');

 --------------------------------------------------------------------------------------------


INSERT INTO web_shop_products (name, price, number_in_stock)
VALUES ('Pepsi', 2.1, 10);

INSERT INTO web_shop_products (name, price, number_in_stock)
VALUES ('Cereal', 4.1, 20);

INSERT INTO web_shop_products (name, price, number_in_stock)
VALUES ('Milk', 3.9, 2);

INSERT INTO web_shop_products (name, price, number_in_stock)
VALUES ('Bread', 1.3, 12);

 --------------------------------------------------------------------------------------------

INSERT INTO web_shop_orders (user_id, price, order_time)
VALUES (2, 8, NOW());

INSERT INTO web_shop_order_products (order_id, product_id, number)
VALUES (1, 2, 1);

INSERT INTO web_shop_order_products (order_id, product_id, number)
VALUES (1, 3, 1);

 --------------------------------------------------------------------------------------------


 SELECT U.*, O.order_time, O.price 'order_price', OP.number, P.name, P.price
 FROM web_shop_orders O
 INNER JOIN web_shop_order_products OP ON OP.order_id = O.id
 INNER JOIN web_shop_users U ON U.id = O.user_id
 INNER JOIN web_shop_products P ON P.id = OP.product_id;





/*
web_shop_orders
az alap order infok (ossz ar)

web_shop_order_products
az order id-hoz tartozo termekek (es hany db-ot rendeltek)
*/