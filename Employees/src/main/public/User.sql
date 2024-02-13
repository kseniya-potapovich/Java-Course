create table "User"
(
    id         bigserial
        constraint user_pk
            primary key,
    first_name varchar(20) not null,
    last_name  varchar(20) not null,
    email      varchar(20) not null,
    age        integer     not null,
    birthday   date        not null,
    users      integer[]
);

alter table "User"
    owner to postgres;

