CREATE TABLE user_tb(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    created_at TIMESTAMP
);

CREATE TABLE product_tb(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    price INT NOT NULL,
    qty INT NOT NULL,
    created_at TIMESTAMP
);

CREATE TABLE purchase_tb(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id int,
    product_id int,
    created_at TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user_tb (id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product_tb (id)
);