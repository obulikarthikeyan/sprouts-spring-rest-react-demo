/* Create User Table */
CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30),
    email_id VARCHAR(50) NOT NULL,
    phone_number BIGINT,
    is_active BOOLEAN,
    time_created BIGINT,
    time_updated BIGINT,
    PRIMARY KEY (id),
    UNIQUE KEY unique_email (email_id)
);

/** Set Initial value of AUTO_INCREMENT **/
ALTER TABLE users AUTO_INCREMENT=100;

/** Insert Default Users **/
INSERT INTO users(first_name, last_name, email_id, phone_number, is_active, time_created, time_updated)
values('John', 'Doe', 'johndoe@test.com', 8888888888, 1, 1538331433, 1538331433);

INSERT INTO users(first_name, last_name, email_id, phone_number, is_active, time_created, time_updated)
values('Jane', 'Smith', 'janesmith@test.com', 99999999999, 1, 1538331434, 1538331434);
