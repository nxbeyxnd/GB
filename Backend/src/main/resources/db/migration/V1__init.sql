create table roles
(
    id              serial primary key,
    name            varchar(50)
);

create table users
(
    id              bigserial primary key,
    email           varchar(30),
    password        varchar(100),
    firstname       varchar(200),
    secondname      varchar(200),
    role_id  integer
        constraint user_table_role_table_id_fk
            references roles
);

create table users_roles
(
    user_id int,
    role_id int,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create
    unique index user_table_email_uindex
    on users (email);

create table products
(
    id bigserial primary key,
    title VARCHAR(255),
    cost int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

INSERT into roles(name)
values
       ('CUSTOMER'),
       ('ADMIN');

insert into products (title, cost)
VALUES ('potatoe', 100),
       ('carrot', 120),
       ('tomato', 300),
       ('corn', 400),
       ('juice', 1500),
       ('milk', 1100),
       ('meat', 3000),
       ('ketchup', 1700),
       ('cookie', 7100),
       ('cookie2', 7200),
       ('cookie3', 7030),
       ('cookie4', 7004),
       ('cookie5', 7600);