DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
    id VARCHAR(36),
    name VARCHAR(50),
    phone VARCHAR(11),
    email VARCHAR(50),
    credit INT,
    created_on TIMESTAMP,
    created_by VARCHAR(50),
    last_updated_on TIMESTAMP,
    last_updated_by VARCHAR(50),
    PRIMARY KEY (id)
);
