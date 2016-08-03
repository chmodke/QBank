CREATE DATABASE qbank;
USE qbank;
-- 单项选择题数据表 --
CREATE TABLE s_select(
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
question varchar(600),
answerA varchar(100),
answerB varchar(100),
answerC varchar(100),
answerD varchar(100),
answer varchar(4),
flag int(1)
);
-- 判断题数据表 --
CREATE TABLE judge(
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
question varchar(600),
answer int(1),
flag int(1)
);

-- 填空题 -- 
CREATE TABLE filling(
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
question varchar(600),
answer varchar(200),
flag int(1)
);


CREATE TABLE game_guess(
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
adj varchar(100),
noun varchar(100),
flag int(1)
);


INSERT INTO s_select
(question,answerA,answerB,answerC,answerD,answer,flag)
VALUES
('科学揭示燃烧现象的是（ ）。','A波兰的哥白尼','B．英国的牛顿','C．法国的拉瓦锡','D．俄国的门捷列夫','C',0);

INSERT INTO judge
(question,answer,flag)
VALUES
('新购买的电脑要在使用之前首先要进行病毒检查，以免机器带毒。',0,0);

INSERT INTO filling
(question,answer,flag)
VALUES
('产生海水潮汐的主要原因是：','月球引力',0);

INSERT INTO game_guess
(adj,noun,flag)
VALUES
('愤怒','小鸟',0);

SELECT * FROM s_select;
SELECT * FROM judge;
SELECT * FROM filling;
SELECT * FROM game_guess;

SELECT COUNT(*) FROM s_select;