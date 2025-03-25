create table schedule
(
    id           bigint auto_increment comment '일정 식별자'
        primary key,
    title        varchar(100) not null comment '제목',
    todo         varchar(100) null comment '할일',
    name         varchar(50)  not null comment '작성자',
    password     varchar(100) not null comment '비밀번호',
    created_date timestamp    not null comment '작성일',
    updated_date timestamp    null comment '수정일'
);