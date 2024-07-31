create table "phonebook".contact
(
    id          bigserial    not null
        constraint contacts_pkey primary key,
    phone_number   varchar(255),
    name varchar(255),
    created_at  timestamp,
    updated_at  timestamp
);

insert into "phonebook".contact(phone_number, name, created_at, updated_at)
VALUES
    ('1234', 'John Doe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('9999999999999', 'Jane Doe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (null, 'Nomor Kosong', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('0812', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);