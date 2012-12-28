create table board_user (
	id varchar(10) primary key,
	name varchar(100),
	email varchar(100)
);

create table article(
	article_seq INT PRIMARY KEY,
	title varchar(100),
	contents varchar(100),
	view_count int,
	reg_ymdt timestamp,
	board_user_id varchar(10)
);