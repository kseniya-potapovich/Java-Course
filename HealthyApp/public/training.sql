create table training
(
    id          bigserial
        primary key,
    user_id     bigserial
        references users,
    time_start  timestamp    not null,
    time_finish timestamp    not null,
    type        varchar(255) not null,
    workout     varchar(255) not null
);

alter table training
    owner to postgres;

