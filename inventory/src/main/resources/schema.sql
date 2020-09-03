DROP TABLE IF EXISTS product;

CREATE TABLE product(
    id VARCHAR(36),
    name VARCHAR(50),
    description VARCHAR(250),
    sku VARCHAR(50),
    brand VARCHAR(50),
    size VARCHAR(50),
    quantity INT,
    created_on TIMESTAMP,
    created_by VARCHAR(50),
    last_updated_on TIMESTAMP,
    last_updated_by VARCHAR(50),
    PRIMARY KEY (id)
);
