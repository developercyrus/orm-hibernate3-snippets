CREATE TABLE IF NOT EXISTS orm_hibernate_one2many_example1.language (
    `id` int(11) NOT NULL, 
    `symbol` varchar(100) NOT NULL, 
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS orm_hibernate_one2many_example1.student (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `sex` varchar(1) NOT NULL,
    `create_date` datetime NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS orm_hibernate_one2many_example1.student_loc (
  `student_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `firstname` varchar(100) character set UTF8 NOT NULL,
  PRIMARY KEY (`student_id`,`language_id`),
  CONSTRAINT `student_loc_language_FK` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, 
  CONSTRAINT `student_loc_student_FK` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
); 






