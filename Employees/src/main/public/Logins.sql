create table "Logins"
(
    id       bigserial
        constraint logins_pk
            primary key,
    login    varchar(10) not null,
    password varchar(10) not null,
    user_id  integer
        references "User"
);

alter table "Logins"
    owner to postgres;

