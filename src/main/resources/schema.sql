
CREATE TABLE member (
    id int primary key auto_increment,
    email varchar unique,
    username varchar,
    password varchar
);