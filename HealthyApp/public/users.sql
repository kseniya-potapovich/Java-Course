create table users
(
    id         bigserial
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    email      varchar(255) not null
        unique,
    age        integer      not null,
    gender     varchar(255) not null
);

alter table users
    owner to postgres;

