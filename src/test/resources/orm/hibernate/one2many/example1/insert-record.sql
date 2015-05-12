insert into orm_hibernate_one2many_example1.language (id, symbol) values (1, 'EN');
insert into orm_hibernate_one2many_example1.language (id, symbol) values (2, 'TC');
insert into orm_hibernate_one2many_example1.language (id, symbol) values (3, 'SC');

insert into orm_hibernate_one2many_example1.student (id, sex, create_date) values (1, 'M', NOW());
insert into orm_hibernate_one2many_example1.student (id, sex, create_date) values (2, 'F', NOW());

insert into orm_hibernate_one2many_example1.student_loc (student_id, language_id, firstname) values (1, 1, 'peter');
insert into orm_hibernate_one2many_example1.student_loc (student_id, language_id, firstname) values (1, 2, '彼得');
insert into orm_hibernate_one2many_example1.student_loc (student_id, language_id, firstname) values (1, 3, '彼得');
insert into orm_hibernate_one2many_example1.student_loc (student_id, language_id, firstname) values (2, 1, 'mary');
insert into orm_hibernate_one2many_example1.student_loc (student_id, language_id, firstname) values (2, 2, '瑪麗');
insert into orm_hibernate_one2many_example1.student_loc (student_id, language_id, firstname) values (2, 3, '玛丽');






