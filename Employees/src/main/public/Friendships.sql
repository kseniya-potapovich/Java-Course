create table "Friendships"
(
    id       bigserial
        primary key,
    user1_id integer not null
        references "User",
    user2_id integer not null
        references "User"
);

alter table "Friendships"
    owner to postgres;

