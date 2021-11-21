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

INSERT into roles(name)
values
       ('CLIENT'),
       ('ADMIN')