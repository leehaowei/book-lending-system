CREATE TABLE app_user (
    user_id SERIAL PRIMARY KEY,
    phone_number VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    registration_time TIMESTAMP NOT NULL,
    lastLogin_time TIMESTAMP
);

CREATE TABLE inventory (
    inventory_id SERIAL PRIMARY KEY,
    isbn BIGINT NOT NULL,
    store_time TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE book (
    isbn BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    introduction TEXT
);

CREATE TABLE borrowing_record (
    user_id INTEGER NOT NULL,
    inventory_id INTEGER NOT NULL,
    borrowing_time TIMESTAMP NOT NULL,
    return_time TIMESTAMP,
    PRIMARY KEY (user_id, inventory_id),
    FOREIGN KEY (user_id) REFERENCES app_user(user_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id)
);
