
/* Создание и заполнение всех таблиц (учитывать внешние ключи)*/
create table person
(
    id         int primary key,
    name       varchar,
    sex        varchar,
    birth_date date
);

insert into person values (1, 'Ivan', 'MAN', '1978-12-12');
insert into person values (2, 'Pavel', 'MAN', '1989-03-15');
insert into person values (3, 'Oleg', 'MAN', '1993-11-01');
insert into person values (4, 'Alex', 'MAN', '2001-09-30');
insert into person values (5, 'Maxim', 'MAN', '1964-05-10');
insert into person values (6, 'Alesya', 'WOMAN', '2002-06-24');
insert into person values (7, 'Anna', 'WOMAN', '1980-07-28');
insert into person values (8, 'Svetlana', 'WOMAN', '1975-08-23');
insert into person values (9, 'Melaniya', 'WOMAN', '2018-09-05');
insert into person values (10, 'Sofiya', 'WOMAN', '2013-10-17');
insert into person values (11, 'Kate', 'WOMAN', '1999-10-17');

create table hobby_type
(
    id   int primary key,
    name varchar
);

insert into hobby_type values (1, 'active');
insert into hobby_type values (2, 'calm');

create table hobby
(
    id      int primary key,
    name    varchar,
    type_id int,
    constraint fk_hobby_type foreign key (type_id) references hobby_type(id)
);

insert into hobby values (1, 'football', 1);
insert into hobby values (2, 'hockey', 1);
insert into hobby values (3, 'reading', 2);
insert into hobby values (4, 'cooking', 2);
insert into hobby values (5, 'knitting', 2);
insert into hobby values (6, 'drawing', 2);
insert into hobby values (7, 'fishing', 1);
insert into hobby values (8, 'gardening', 2);
insert into hobby values (9, 'woodcraft', 2);
insert into hobby values (10, 'fitness', 1);

create table hobby_attachment
(
    id int primary key,
    person_id int,
    hobby_id int,
    constraint fk_person foreign key (person_id) references person(id),
    constraint fk_hobby foreign key (hobby_id) references hobby(id)
);

insert into hobby_attachment values (1,1,1);
insert into hobby_attachment values (2,1,3);
insert into hobby_attachment values (3,1,6);
insert into hobby_attachment values (4,2,2);
insert into hobby_attachment values (5,2,3);
insert into hobby_attachment values (6,2,10);
insert into hobby_attachment values (7,3,3);
insert into hobby_attachment values (8,3,9);
insert into hobby_attachment values (9,4,5);
insert into hobby_attachment values (10,4,6);
insert into hobby_attachment values (11,4,7);
insert into hobby_attachment values (12,5,3);
insert into hobby_attachment values (13,5,5);
insert into hobby_attachment values (14,5,7);
insert into hobby_attachment values (15,5,9);
insert into hobby_attachment values (16,6,3);
insert into hobby_attachment values (17,6,6);
insert into hobby_attachment values (18,6,8);
insert into hobby_attachment values (19,7,10);
insert into hobby_attachment values (20,7,1);
insert into hobby_attachment values (21,7,2);
insert into hobby_attachment values (22,8,1);
insert into hobby_attachment values (23,8,2);
insert into hobby_attachment values (24,8,3);
insert into hobby_attachment values (25,9,4);
insert into hobby_attachment values (26,9,5);
insert into hobby_attachment values (27,9,6);
insert into hobby_attachment values (28,10,7);
insert into hobby_attachment values (29,10,8);
insert into hobby_attachment values (30,10,9);
insert into hobby_attachment values (31,11,10);





/*Вывести всех людей старше какого-либо возраста */
select * from person where age(now(),birth_date)>'30 years';

/* Вывести сколько людей каждого пола есть в бд */
select sex,count(*) from person group by sex;

/* Вывести информацию о людях и их хобби */
select person.name, h.name from person
                                    join hobby_attachment ha on person.id = ha.person_id
                                    join hobby h on ha.hobby_id = h.id;

/* Вывести список людей у которых более одного хобби */
select name from person
                     join hobby_attachment ha on person.id = ha.person_id
group by name
having count(*) > 1;

/* Вывести список людей у которых только пассивные хобби (*) */
select person.name from person
                            join hobby_attachment ha on person.id = ha.person_id
                            join hobby h on ha.hobby_id = h.id
                            join hobby_type ht on h.type_id = ht.id
where ht.name='calm'

except

select person.name from person
                            join hobby_attachment ha on person.id = ha.person_id
                            join hobby h on ha.hobby_id = h.id
                            join hobby_type ht on h.type_id = ht.id
where ht.name='active';

/* Вывести какое количество активных хобби и пассивных хобби есть в бд */
select hobby_type.name,count(*)from hobby_type
                                        join hobby h on hobby_type.id = h.type_id
group by hobby_type.name;

/* Вывести информацию какое хобби активное а какое пассивное */
select h.name,hobby_type.name as type from hobby_type
                                               join hobby h on hobby_type.id = h.type_id;

/* Последовательное удаление таблиц */
drop table hobby_attachment;
drop table person;
drop table hobby;
drop table hobby_type;