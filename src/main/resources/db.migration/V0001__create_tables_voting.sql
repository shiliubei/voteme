create table if not exists voting
(
    id                 bigserial    not null primary key,
    user_id            bigint       not null,
    vote_value         boolean
);
