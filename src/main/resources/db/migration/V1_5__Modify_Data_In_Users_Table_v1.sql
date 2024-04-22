UPDATE error_handler.users as u
SET
    gender = 'MALE'
WHERE
    u.id = UUID_TO_BIN ('2d9784d0-6ef8-47a3-8aab-c9bfd5f47a60');

UPDATE error_handler.users as u
SET
    gender = 'FEMALE'
WHERE
    u.id = UUID_TO_BIN ('6440a6c3-4a37-4d77-ab38-a9def8112254');

UPDATE error_handler.users as u
SET
    gender = 'FEMALE'
WHERE
    u.id = UUID_TO_BIN ('cac197a1-56e8-43e6-908d-700fd4134255');

UPDATE error_handler.users as u
SET
    gender = 'MALE',
    first_name = 'Luis',
    second_name = 'Alberto',
    last_name = 'Huerta Romero'
WHERE
    u.id = UUID_TO_BIN ('975a08b3-2fc8-48fd-94df-456b65715bbf');

UPDATE error_handler.users as u
SET
    gender = 'MALE'
WHERE
    u.id = UUID_TO_BIN ('03531b93-cd7c-44af-8409-63e4f4a2cb6f');