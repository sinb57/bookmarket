
CREATE TABLE member (
    id int primary key auto_increment,
    email varchar unique,
    username varchar,
    password varchar
);

CREATE TABLE category (
    id int primary key auto_increment,
    name varchar
);

CREATE TABLE book (
    id          int primary key auto_increment,
    category_id int,
    name        varchar,
    stock       int,
    price       int
);
