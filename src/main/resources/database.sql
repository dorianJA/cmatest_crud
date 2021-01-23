--Table student
create table student
(
    student_id  int auto_increment primary key,
    first_name  varchar(20),
    last_name   varchar(20),
    middle_name varchar(20),
    grp_id int,
    foreign key (grp_id) references students_group (id),
    birthday    date

)
-- Table group
create table students_group
(
    id int auto_increment primary key,
    name varchar(20)
)
--insert
insert into students_group (id, name)
VALUES (3, 'CC-1')

insert into student (id, birthday_date, first_name, last_name, middle_name, group_id)
VALUES (2, DATE '1997-11-17', 'Mike', 'A', 'Fill', 3)
