create table security
(
    id                bigserial
        primary key,
    login             varchar(20)  not null
        unique,
    password          varchar(20)  not null,
    user_id           bigserial
        references users,
    is_deleted        boolean      not null,
    role              varchar(255) not null,
    date_registration date         not null,
    last_entry        date         not null
);

alter table security
    owner to postgres;

