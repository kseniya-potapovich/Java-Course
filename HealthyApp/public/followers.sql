create table followers
(
    id       bigserial
        primary key,
    group_id bigserial
        references groups,
    user_id  bigserial
        references users
);

alter table followers
    owner to postgres;

