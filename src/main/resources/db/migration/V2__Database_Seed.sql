INSERT INTO users (username, password, role)
-- pw ist admin
VALUES ('admin', '$2a$10$9Jw8eSsb.veMKOt7AlJbSOwotlyk41gfPBUu8gRVO9g1m3XwTsm7u', 'Admin');

INSERT INTO categories (id, active, name)
VALUES (1, 1, 'Test Kat 1'),
       (2, 1, 'Test Kat 2'),
       (3, 1, 'Test Kat 3');

INSERT INTO `product-manager`.products (id, active, sku, name, image, description, price, stock, category_id)
VALUES (1, 1, 'sku1232', 'Prod 1', 'image 1', 'description 1', 23.4, 2, 1),
       (2, 1, 'sku12312', 'Prod 2', 'image 2', 'description 2', 3.45, 5, 2),
       (3, 1, 'sku12212', 'Prod 3', 'image 3', 'description 3', 234.4, 5, 2),
       (4, 1, 'sku12412', 'Prod 4', 'image 4', 'description 4', 234.4, 5, null);
