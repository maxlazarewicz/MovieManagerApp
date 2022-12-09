DROP TABLE IF EXISTS `favorite_movies`;

CREATE TABLE `favorite_movies` (
  `id` bigint NOT NULL,
  `movie_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKstbwh1vbtc4hkti6owlydh7u8` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

