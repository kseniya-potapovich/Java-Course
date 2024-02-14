create table health
(
    id       bigserial
        primary key,
    user_id  bigserial
        references users,
    date     timestamp not null,
    pulse    integer,
    weight   numeric,
    activity varchar(255)
);

alter table health
    owner to postgres;

