create table friendship
(
    id        bigserial
        primary key,
    user_id   bigserial
        references users,
    friend_id bigserial
        references users
);

alter table friendship
    owner to postgres;

