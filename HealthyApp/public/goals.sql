create table goals
(
    id          bigserial
        primary key,
    user_id     bigserial
        references users,
    type        varchar   not null,
    description varchar   not null,
    date_start  timestamp not null,
    date_finish timestamp not null
);

alter table goals
    owner to postgres;

