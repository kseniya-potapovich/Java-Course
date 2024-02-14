create table products
(
    id       bigserial
        primary key,
    name     varchar(255) not null,
    calories integer      not null
);

alter table products
    owner to postgres;

