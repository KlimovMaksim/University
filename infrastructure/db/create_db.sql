create database students;
create table students_list
(
    id          integer generated by default as identity
        primary key,
    full_name   varchar not null,
    card_number varchar not null
        unique
);

insert into students_list(full_name, card_number)
values
    ('Skyler White', 'IJ91011KL12'),
    ('Jimmy McGill', 'AB1234CD57')

