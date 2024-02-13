create table "Message"
(
    id           bigserial
        primary key,
    id_sender    integer   not null
        references "User",
    id_recipient integer   not null
        references "User",
    datetime     timestamp not null,
    text         varchar   not null
);

alter table "Message"
    owner to postgres;

