insert into posts(title, author, content, created_date, modified_date) values ('테스트1', 'test1@gmail.com', '테스트1의 본문', now(), now());
insert into posts(title, author, content, created_date, modified_date) values ('테스트2', 'test2@gmail.com', '테스트2의 본문', now(), now());
insert into user(u_mail, u_name, u_tel, u_birth, u_pw)
values ('test@test.com', 'test_name', '010-xxx-xxxx', '2000-01-01', 'test_pw');
insert into board(b_number, b_title, b_content, b_writer, b_wdate, b_category, b_views, b_like)
values (0, 'test_title', 'test_content', 'test@test.com', '2000-01-01', 0, 0, 0);
insert into comment(c_number, c_writer, c_content, c_wdate, c_bnumber)
values (0, 'test@test.com', 'test_content', '2000-01-01', 0);
