CREATE TABLE app_user (
    user_id BIGSERIAL PRIMARY KEY,
    phone_number VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    registration_time TIMESTAMP NOT NULL DEFAULT NOW(),
    last_login_time TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE book (
    isbn VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    introduction TEXT
);

CREATE TABLE inventory (
    inventory_id BIGSERIAL PRIMARY KEY,
    isbn VARCHAR(255) NOT NULL,
    store_time TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    FOREIGN KEY (isbn) REFERENCES book(isbn)
);

CREATE TABLE borrowing_record (
    user_id INTEGER NOT NULL,
    inventory_id INTEGER NOT NULL,
    borrowing_time TIMESTAMP NOT NULL,
    return_time TIMESTAMP,
    PRIMARY KEY (user_id, inventory_id),
    FOREIGN KEY (user_id) REFERENCES "app_user"(user_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id)
);


