create table "Post"
(
    id        bigserial
        primary key,
    author    varchar   not null,
    id_author integer   not null
        references "User",
    text      varchar   not null,
    datetime  timestamp not null,
    likes     integer,
    comments  varchar
);

alter table "Post"
    owner to postgres;

