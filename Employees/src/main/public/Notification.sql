create table "Notification"
(
    id           bigserial
        primary key,
    id_recipient integer   not null
        references "User",
    text         varchar   not null,
    datetime     timestamp not null
);

alter table "Notification"
    owner to postgres;

