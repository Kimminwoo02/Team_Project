DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
	`Key`	BIGINT	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`user_id`	BIGINT(100)	NOT NULL,
	`Field`	VARCHAR(255)	NULL,
	`state_id`	INT	NOT NULL,
	`city_id`	INT	NULL,
	`town_id`	INT	NULL,
	`Key2`	VARCHAR(255)	NOT NULL,
	`Key3`	VARCHAR(255)	NOT NULL
);

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
	`state_id`	INT	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`board_id`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`title`	VARCHAR(255)	NOT NULL,
	`view`	INT	NULL,
	`content`	VATCHAR(10000)	NOT NULL
);

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
	`city_id`	INT	NOT NULL,
	`state_id`	INT	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `town`;

CREATE TABLE `town` (
	`town_id`	INT	NOT NULL,
	`city_id`	INT	NOT NULL,
	`state_id`	INT	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `CopyOfCopyOfUntitled3`;

CREATE TABLE `CopyOfCopyOfUntitled3` (
	`Key`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `sport`;

CREATE TABLE `sport` (
	`sports_id`	BIGINT(50)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `CopyOfCopyOfUntitled34`;

CREATE TABLE `CopyOfCopyOfUntitled34` (
	`Key`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`category_id`	BIGINT(50)	NOT NULL,
	`Field`	VARCHAR(255)	NULL,
	`Field2`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`comment_id`	VARCHAR(255)	NOT NULL,
	`soccer_board_id`	BIGINT(50)	NOT NULL,
	`board_id2`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`content`	VARCHAR(2000)	NOT NULL
);

DROP TABLE IF EXISTS `hiking_board`;

CREATE TABLE `hiking_board` (
	`hiking_board_id`	BIGINT(50)	NOT NULL,
	`board_id2`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `soccer_board`;

CREATE TABLE `soccer_board` (
	`soccer_board_id`	BIGINT(50)	NOT NULL,
	`board_id2`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`content`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `basketball_board`;

CREATE TABLE `basketball_board` (
	`basketball_board_id`	BIGINT(50)	NOT NULL,
	`board_id2`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL
);

DROP TABLE IF EXISTS `CopyOfcomment`;

CREATE TABLE `CopyOfcomment` (
	`comment_id`	VARCHAR(255)	NOT NULL,
	`hiking_board_id`	BIGINT(50)	NOT NULL,
	`board_id2`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`content`	VARCHAR(2000)	NOT NULL
);

DROP TABLE IF EXISTS `CopyOfcomment2`;

CREATE TABLE `CopyOfcomment2` (
	`comment_id`	VARCHAR(255)	NOT NULL,
	`basketball_board_id`	BIGINT(50)	NOT NULL,
	`board_id2`	VARCHAR(255)	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`content`	VARCHAR(2000)	NOT NULL
);

DROP TABLE IF EXISTS `CopyOflocation`;

CREATE TABLE `CopyOflocation` (
	`Key`	BIGINT	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`modified_at`	DATETIME	NOT NULL,
	`user_id`	BIGINT(100)	NOT NULL,
	`Field`	VARCHAR(255)	NULL,
	`state_id`	INT	NOT NULL,
	`city_id`	INT	NULL,
	`town_id`	INT	NULL,
	`Key2`	VARCHAR(255)	NOT NULL,
	`Key3`	VARCHAR(255)	NOT NULL
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_id`	BIGINT(100)	NOT NULL,
	`Key`	VARCHAR(255)	NOT NULL,
	`modified_by`	VARCHAR(50)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`created_by`	VARCHAR(50)	NOT NULL,
	`email`	VARCHAR(50)	NOT NULL	COMMENT '로그인 아이디로 쓸 이메일',
	`nickname`	VARCHAR(15)	NOT NULL,
	`name`	VARCHAR(15)	NOT NULL,
	`pw`	VARCHAR(50)	NOT NULL,
	`tel`	VARCHAR(15)	NOT NULL,
	`gender`	INT	NOT NULL
);

ALTER TABLE `location` ADD CONSTRAINT `PK_LOCATION` PRIMARY KEY (
	`Key`
);

ALTER TABLE `state` ADD CONSTRAINT `PK_STATE` PRIMARY KEY (
	`state_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`board_id`
);

ALTER TABLE `city` ADD CONSTRAINT `PK_CITY` PRIMARY KEY (
	`city_id`,
	`state_id`
);

ALTER TABLE `town` ADD CONSTRAINT `PK_TOWN` PRIMARY KEY (
	`town_id`,
	`city_id`,
	`state_id`
);

ALTER TABLE `CopyOfCopyOfUntitled3` ADD CONSTRAINT `PK_COPYOFCOPYOFUNTITLED3` PRIMARY KEY (
	`Key`
);

ALTER TABLE `sport` ADD CONSTRAINT `PK_SPORT` PRIMARY KEY (
	`sports_id`
);

ALTER TABLE `CopyOfCopyOfUntitled34` ADD CONSTRAINT `PK_COPYOFCOPYOFUNTITLED34` PRIMARY KEY (
	`Key`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`category_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`comment_id`,
	`soccer_board_id`,
	`board_id2`
);

ALTER TABLE `hiking_board` ADD CONSTRAINT `PK_HIKING_BOARD` PRIMARY KEY (
	`hiking_board_id`,
	`board_id2`
);

ALTER TABLE `soccer_board` ADD CONSTRAINT `PK_SOCCER_BOARD` PRIMARY KEY (
	`soccer_board_id`,
	`board_id2`
);

ALTER TABLE `basketball_board` ADD CONSTRAINT `PK_BASKETBALL_BOARD` PRIMARY KEY (
	`basketball_board_id`,
	`board_id2`
);

ALTER TABLE `CopyOfcomment` ADD CONSTRAINT `PK_COPYOFCOMMENT` PRIMARY KEY (
	`comment_id`,
	`hiking_board_id`,
	`board_id2`
);

ALTER TABLE `CopyOfcomment2` ADD CONSTRAINT `PK_COPYOFCOMMENT2` PRIMARY KEY (
	`comment_id`,
	`basketball_board_id`,
	`board_id2`
);

ALTER TABLE `CopyOflocation` ADD CONSTRAINT `PK_COPYOFLOCATION` PRIMARY KEY (
	`Key`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`,
	`Key`
);

ALTER TABLE `city` ADD CONSTRAINT `FK_state_TO_city_1` FOREIGN KEY (
	`state_id`
)
REFERENCES `state` (
	`state_id`
);

ALTER TABLE `town` ADD CONSTRAINT `FK_city_TO_town_1` FOREIGN KEY (
	`city_id`
)
REFERENCES `city` (
	`city_id`
);

ALTER TABLE `town` ADD CONSTRAINT `FK_city_TO_town_2` FOREIGN KEY (
	`state_id`
)
REFERENCES `city` (
	`state_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_soccer_board_TO_comment_1` FOREIGN KEY (
	`soccer_board_id`
)
REFERENCES `soccer_board` (
	`soccer_board_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_soccer_board_TO_comment_2` FOREIGN KEY (
	`board_id2`
)
REFERENCES `soccer_board` (
	`board_id2`
);

ALTER TABLE `hiking_board` ADD CONSTRAINT `FK_board_TO_hiking_board_1` FOREIGN KEY (
	`board_id2`
)
REFERENCES `board` (
	`board_id`
);

ALTER TABLE `soccer_board` ADD CONSTRAINT `FK_board_TO_soccer_board_1` FOREIGN KEY (
	`board_id2`
)
REFERENCES `board` (
	`board_id`
);

ALTER TABLE `basketball_board` ADD CONSTRAINT `FK_board_TO_basketball_board_1` FOREIGN KEY (
	`board_id2`
)
REFERENCES `board` (
	`board_id`
);

ALTER TABLE `CopyOfcomment` ADD CONSTRAINT `FK_hiking_board_TO_CopyOfcomment_1` FOREIGN KEY (
	`hiking_board_id`
)
REFERENCES `hiking_board` (
	`hiking_board_id`
);

ALTER TABLE `CopyOfcomment` ADD CONSTRAINT `FK_hiking_board_TO_CopyOfcomment_2` FOREIGN KEY (
	`board_id2`
)
REFERENCES `hiking_board` (
	`board_id2`
);

ALTER TABLE `CopyOfcomment2` ADD CONSTRAINT `FK_basketball_board_TO_CopyOfcomment2_1` FOREIGN KEY (
	`basketball_board_id`
)
REFERENCES `basketball_board` (
	`basketball_board_id`
);

ALTER TABLE `CopyOfcomment2` ADD CONSTRAINT `FK_basketball_board_TO_CopyOfcomment2_2` FOREIGN KEY (
	`board_id2`
)
REFERENCES `basketball_board` (
	`board_id2`
);

