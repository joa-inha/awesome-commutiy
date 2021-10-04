-- sample datas
insert into TBL_USER values(unhex(replace(uuid(), '-', '')), 'test1', 'kim', '1234');
insert into TBL_USER values(unhex(replace(uuid(), '-', '')), 'test2', 'kim1', '1234');
insert into TBL_USER values(unhex(replace(uuid(), '-', '')), 'test3', 'kim3', '1234');

insert into TBL_BOARD (id, title, content, type, date) values('test1', 'test Title 1', 'test', 'free', CURDATE());
insert into TBL_BOARD (id, title, content, type, date) values('test2', 'test Title 2', 'test2', 'free', CURDATE());
insert into TBL_BOARD (id, title, content, type, date) values('test3', 'test Title 3', 'test3', 'free', CURDATE());

SELECT idx, username, title, content, type, date from TBL_BOARD natural join(TBL_USER) WHERE idx = 1;