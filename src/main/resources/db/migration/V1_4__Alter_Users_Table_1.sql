ALTER TABLE error_handler.users
ADD creationDateTime TIMESTAMP;

ALTER TABLE error_handler.users
ADD updatedDateTime TIMESTAMP;

ALTER TABLE error_handler.users
MODIFY gender VARCHAR(10);