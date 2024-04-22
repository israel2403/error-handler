ALTER TABLE error_handler.users DROP name;

ALTER TABLE error_handler.users
MODIFY birthday DATE NOT NULL;

ALTER TABLE error_handler.users
MODIFY gender VARCHAR(10) NOT NULL;

ALTER TABLE error_handler.users
MODIFY first_name VARCHAR(100) NOT NULL;

ALTER TABLE error_handler.users
MODIFY last_name VARCHAR(100) NOT NULL;

ALTER TABLE error_handler.users
MODIFY email VARCHAR(255) NOT NULL;