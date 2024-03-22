create table if not exists users (
    id bigint primary key,
    name varchar(255),
    surname varchar(255),
    email varchar(255) unique,
    password varchar(255)
);