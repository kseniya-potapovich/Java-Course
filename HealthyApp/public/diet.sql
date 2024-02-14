create table diet
(
    id          bigserial
        primary key,
    user_id     bigserial
        references users,
    date        timestamp not null,
    products_id bigserial
        references products
);

alter table diet
    owner to postgres;

