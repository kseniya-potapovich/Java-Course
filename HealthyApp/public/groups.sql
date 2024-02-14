create table groups
(
    id          bigserial
        primary key,
    name        varchar(255) not null,
    description varchar
);

alter table groups
    owner to postgres;

