DROP TABLE IF EXISTS product_order;

CREATE TABLE product_order(
    id VARCHAR(36),
    name VARCHAR(50),
    customer_id  VARCHAR(50),
    total_price DOUBLE,
    created_on TIMESTAMP,
    created_by VARCHAR(50),
    last_updated_on TIMESTAMP,
    last_updated_by VARCHAR(50),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product_item;

CREATE TABLE product_item(
    id VARCHAR(36),
    name VARCHAR(50),
    price DOUBLE,
    order_id  VARCHAR(50),
    product_id VARCHAR(36),
    created_on TIMESTAMP,
    created_by VARCHAR(50),
    last_updated_on TIMESTAMP,
    last_updated_by VARCHAR(50),
    PRIMARY KEY (id)
);