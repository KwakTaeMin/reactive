CREATE DATABASE IF NOT EXISTS webflux_practice;

-- auto-generated definition
create table todo
(
    id          bigint auto_increment primary key,
    content     varchar(200) not null,
    done        tinyint(1)   not null,
    created_at  datetime     not null,
    modified_at datetime     not null
);
