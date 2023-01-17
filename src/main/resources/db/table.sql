create table product(
    id int AUTO_INCREMENT primary key,
    name varchar not null unique,
    price int not null,
    qty int not null,
    createdAt timestamp
);