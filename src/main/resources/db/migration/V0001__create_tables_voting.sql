create table if not exists voting
(
    id                 bigserial    not null primary key,
    user_uuid          uuid       not null,
    vote_value         boolean
);
