<a href="https://zara.com/"><img src="https://www.revistagq.com/moda/articulos/nuevo-logo-de-zara/32991" width="180px" align="right" /></a>

# Test Zara
Proyecto cuya finalidad es consumir una API RESTful para la obtencion de una lista de precios , la lista esta almacenada en un banco de memoria H2.

## Tecnologías ocupadas en el desarrollo:

* Spring Framework
* Spring WEB
* Lombok
* Maven
* Java 8
* JUnit 5
* Spock & Groovy

## DataBase
La base de datos se crea al momento de correr la aplicacion , la estructura tambien se crea al momento de correr la aplicacion , la estructura la cual va a ser utilizada por la api de obtencion de lista de precios en la siguiente ruta:

`DROP TABLE IF EXISTS brands;
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
INSERT INTO prices (brand_id,start_date,end_date,price_list,product_id,priority,price,curr) VALUES (2, '2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR');`


## Despliegue

* Desde IDE
  Para poder desplegar el proyecto a traves del IDE , si ya tenemos importado el proyecto solo debemos hacer click en *run*

## APIs expuestas por el microservicios

| Type Method   | Method     | URL                              |
| ------------- | ---------- |----------------------------------|
| GET           | getPrices()| localhost:8080/api/v1/getPrices |
| GET           | getPricesWithFilter() | localhost:8080/api/v1/getPricesWithFilter |


*Autor*
***Felipe Galaz***