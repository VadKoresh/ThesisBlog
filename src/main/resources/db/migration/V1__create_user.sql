-- Создаем таблицу пользователя
create table users
(
    user_id      integer generated always as identity
        primary key,
    is_moderator smallint     not null,
    reg_time     timestamp without time zone not null,
    name         text      not null,
    email        text      not null,
    password     text      not null,
    code         text,
    photo        text
);

-- Создаем таблицу постов
create table posts
(
    post_id           integer generated always as identity
        primary key,
    is_active         smallint     not null,
    moderation_status text      not null,
    user_id           integer   not null
        constraint user_id
            references users,
    time              timestamp without time zone not null,
    title             text      not null,
    text              text      not null,
    view_count        integer   not null,
    moderator_id      integer
);

-- Создаем таблицу глобальных настроек
create table global_settings
(
    global_setting_id integer generated always as identity
        primary key,
    code              text not null,
    name              text not null,
    value             text not null
);

-- Создаем таблицу капчи
create table captcha_codes
(
    captcha_cod_id  integer generated always as identity
        primary key,
    time            timestamp without time zone not null,
    code            text      not null,
    secret_code     text      not null,
    captcha_code_id integer   not null
);

-- Создаем таблицу коментариев к посту
create table post_comments
(
    post_comment_id integer generated always as identity
        primary key,
    parent_id       integer,
    post_id         integer   not null
        constraint post_id
            references posts,
    user_id         integer   not null
        constraint user_id
            references users,
    time            timestamp without time zone not null,
    text            text      not null
);

-- Создаем таблицу лайки к посту
create table post_votes
(
    post_vote_id integer generated always as identity
        primary key,
    user_id      integer   not null
        constraint user_id
            references users,
    post_id      integer   not null
        constraint post_id
            references posts,
    time         timestamp without time zone not null,
    value        smallint     not null
);

-- Создаем таблицу тэгов
create table tags
(
    tag_id integer generated always as identity
        primary key,
    name   text not null
);

-- Создаём таблицу связи поста и тэга
create table tag2post
(
    tag2post_id integer generated always as identity
        primary key,
    post_id     integer not null
        constraint post_id
            references posts,
    tag_id      integer not null
        constraint tag_id
            references tags
);


-- Наполняем таблицу пользователя
insert into users (is_moderator, reg_time, name, email, password, code)
VALUES (1,'2014-04-04','Вадим','evilgod-2@mail.ru','koresh09','1314');

insert into users (is_moderator, reg_time, name, email, password, code)
VALUES (0,'2014-04-04','Алексей','oglok123@rambler.ru','koresh09','1314');

-- Наполняем таблицу пост
insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-04-08', 'Как много заработать',
        'Очень просто просто просто просто просто просто просто просто просто просто просто просто просто просто ' ||
        'просто просто просто просто просто просто просто просто просто ', 100,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-04-08', 'Тест 2','Ой всё', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count)
values (0,'NEW', 2, '2014-04-08', 'Тест 3','Думаешь сойдет?', 10);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-05-08', 'Тест 4','Тест 4', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2016-06-08', 'Тест 5','Тест 5', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2017-07-08', 'Тест 6','Тест 6', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-08-08', 'Тест 7','Тест 7', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-09-08', 'Тест 8','Тест 8', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-10-08', 'Тест 9','Тест 9', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-11-08', 'Тест 10','Тест 10', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2014-12-08', 'Тест 11','Тест 11', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 13','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 14','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 15','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 16','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 17','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 18','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 19','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 20','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 21','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 22','Тест 12', 10,1);

insert into posts (is_active, moderation_status, user_id, "time", title, text, view_count, moderator_id)
values (1,'ACCEPTED', 1, '2015-01-08', 'Тест 23','Тест 12', 10,1);

-- Наполняем таблицу глобальных настроек
insert into global_settings (code, name, "value")
values ('MULTIUSER_MODE','Многопользовательский режим','YES');

insert into global_settings (code, name, "value")
values ('STATISTICS_IS_PUBLIC','Показывать всем статистику блога','NO');

insert into global_settings (code, name, "value")
values ('POST_PREMODERATION','Премодерация постов','NO');

--Наполняяем таблицу tag
insert into tags (name) values ('Java');
insert into tags (name) values ('JS');

--НАполняем таблицу связи tag2post
insert into tag2post (post_id, tag_id) values (1,1);
insert into tag2post (post_id, tag_id) values (2,1);
insert into tag2post (post_id, tag_id) values (3,2);

--Наполняем таблицу post_votes
insert into post_votes (user_id, post_id, "time", "value")
values (1,1,'2014-04-08', 1);
insert into post_votes (user_id, post_id, "time", "value")
values (1,2,'2014-04-08', 1);
insert into post_votes (user_id, post_id, "time", "value")
values (2,2,'2014-04-08', -1);

--Наполняем таблицу post_comments
insert into post_comments (post_id, user_id, "time", text)
values (1,1, '2014-04-08', 'Годно!');
insert into post_comments (post_id, user_id, "time", text)
values (1,2, '2014-04-08', 'Очень годно!');
insert into post_comments (post_id, user_id, "time", text)
values (2,1, '2014-04-08', 'Переоцененная хрень!');