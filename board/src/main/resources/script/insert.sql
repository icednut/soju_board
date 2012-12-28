INSERT INTO board_user (id, name, email)
VALUES ('crazybnn', '이완근', 'wangeun.lee@nhn.com');

INSERT INTO article (article_seq, title, contents, reg_ymdt, board_user_id)
VALUES (1, 'TEST 1', 'TEST 1 content', to_timestamp('2012-12-20 11:23:01', 'YYYY-MM-DD HH24:MI:SS'), 'crazybnn');

INSERT INTO article (article_seq, title, contents, reg_ymdt, board_user_id)
VALUES (2, 'TEST 2', 'TEST 2 content', to_timestamp('2012-12-21 11:23:01', 'YYYY-MM-DD HH24:MI:SS'), 'crazybnn');

INSERT INTO article (article_seq, title, contents, reg_ymdt, board_user_id)
VALUES (3, 'TEST 3', 'TEST 3 content', to_timestamp('2012-12-22 11:23:01', 'YYYY-MM-DD HH24:MI:SS'), 'crazybnn');