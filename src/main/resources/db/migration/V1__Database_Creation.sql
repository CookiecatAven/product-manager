CREATE TABLE categories
(
    id     INT AUTO_INCREMENT NOT NULL,
    active TINYINT            NOT NULL,
    name   VARCHAR(255)       NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            INT AUTO_INCREMENT NOT NULL,
    active        TINYINT            NOT NULL,
    sku           VARCHAR(100)       NOT NULL,
    name          VARCHAR(500)       NOT NULL,
    image         VARCHAR(1000)      NOT NULL,
    `description` MEDIUMTEXT         NOT NULL,
    price         FLOAT              NOT NULL,
    stock         INT                NOT NULL,
    category_id   INT                NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE users
(
    id       INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255)       NOT NULL,
    password VARCHAR(255)       NOT NULL,
    `role`   VARCHAR(255)       NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT uc_products_sku UNIQUE (sku);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);