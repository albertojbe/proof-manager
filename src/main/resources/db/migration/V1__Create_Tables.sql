CREATE TABLE IF NOT EXISTS `tb_teacher` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UKkujic8ksvexewnd7d1xulbxk6` (`name`)
);


CREATE TABLE IF NOT EXISTS `tb_discipline` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `name` varchar(255) NOT NULL,
                                 `period` int NOT NULL,
                                 `teacher_id` bigint DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `FK2a958hrol0f4wvomr2g4tfmof` (`teacher_id`),
                                 CONSTRAINT `FK2a958hrol0f4wvomr2g4tfmof` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`id`)
);

CREATE TABLE IF NOT EXISTS `tb_proof` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `note` float NOT NULL,
                            `theme` varchar(255) NOT NULL,
                            `discipline_id` bigint DEFAULT NULL,
                            `teacher_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FK357vgr824kvy0t5hn2phpykbj` (`discipline_id`),
                            KEY `FKsnww42uhi6nvnq9hctx82vo7u` (`teacher_id`),
                            CONSTRAINT `FK357vgr824kvy0t5hn2phpykbj` FOREIGN KEY (`discipline_id`) REFERENCES `tb_discipline` (`id`),
                            CONSTRAINT `FKsnww42uhi6nvnq9hctx82vo7u` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`id`)
);

