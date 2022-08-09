DROP TABLE IF EXISTS brands;
CREATE TABLE brands(
    id INTEGER AUTO_INCREMENT,
	brand_name VARCHAR(4),
	PRIMARY KEY(id)
);

INSERT INTO brands (brand_name) VALUES ('ZARA');
INSERT INTO brands (brand_name) VALUES ('NIKE');


DROP TABLE IF EXISTS prices;
CREATE TABLE prices(
    id INTEGER AUTO_INCREMENT,
	brand_id INTEGER,
	start_date TIMESTAMP,
	end_date TIMESTAMP,
	price_list INTEGER,
	product_id INTEGER,
	priority INTEGER,
	price DECIMAL,
	curr VARCHAR,
	PRIMARY KEY(id),
	FOREIGN KEY(brand_id) REFERENCES brands(id)
);

INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES (1, '2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.50,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES (1, '2020-06-14 15:00:00','2020-06-14 18:30:00',2,35455,1,25.45,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES (1, '2020-06-15 00:00:00','2020-06-15 11:00:00',3,35455,1,30.50,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES (1, '2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR');
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES (2, '2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR');