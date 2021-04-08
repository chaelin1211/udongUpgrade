-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- CLUB Table Create SQL
CREATE TABLE CLUB
(
    `CLUB_NAME`  VARCHAR(45)    NOT NULL        COMMENT '동아리명', 
    `INTRO`      VARCHAR(45)    NOT NULL        COMMENT '동아리 소개', 
    `AREA_NAME`  VARCHAR(45)    NOT NULL        COMMENT '활동 지역명', 
    `CONTENT`    VARCHAR(45)    NOT NULL        COMMENT '활동내용', 
    `EMAIL`      VARCHAR(45)     NOT NULL       COMMENT '팀장 이메일',
    `Nickname`   VARCHAR(45)    NULL            COMMENT '팀장 별명',  
    `CLUB_NUM`   INT            NOT NULL        AUTO_INCREMENT COMMENT '동아리 번호', 
    `INTEREST`   VARCHAR(45)    NOT NULL        COMMENT '활동 주제', 
    `RECOMMEND`  INT            NOT NULL        COMMENT '추천 수', 
    PRIMARY KEY (CLUB_NUM)
);

ALTER TABLE CLUB COMMENT '동아리';


CREATE TABLE MEMBER
(
    `EMAIL`      VARCHAR(45)    NOT NULL    COMMENT '아이디', 
    `NAME`       VARCHAR(45)    NULL        COMMENT '이름',  
    `GENDER`     VARCHAR(45)    NULL        COMMENT '성별',  
    `BIRTH_YEAR` INT            NULL        COMMENT '출생연도',  
    `BIRTH_MONTH`INT            NULL        COMMENT '생일-월',  
    `BIRTH_DAY`  INT            NULL        COMMENT '생일-일',  
    `Nickname`   INT            NULL        COMMENT '별명',
    PRIMARY KEY(EMAIL)
);

ALTER TABLE MEMBER COMMENT '멤버';


-- CLUB Table Create SQL
CREATE TABLE CLUB_MEMBER
( 
    `EMAIL`     VARCHAR(45)    NOT NULL     COMMENT '멤버 이메일'
    `CLUB_NUM`       INT       NOT NULL     COMMENT '클럽 번호', 
    PRIMARY KEY (EMAIL, CLUB_NUM)
);

ALTER TABLE CLUB_MEMBER COMMENT '동아리멤버';


-- CLUB Table Create SQL
CREATE TABLE AREA
(
    `AREA_NUM`   VARCHAR(45)    NULL        COMMENT '지역 번호', 
    `AREA_NAME`  VARCHAR(45)    NULL        COMMENT '지역명', 
    PRIMARY KEY (AREA_NUM)
);

ALTER TABLE AREA COMMENT '지역';


-- CLUB Table Create SQL
CREATE TABLE INTEREST_CATEGORY
(
    `INTEREST_NUM`  INT            NULL        COMMENT '분류 번호', 
    `NAME`          VARCHAR(45)    NULL        COMMENT '이름', 
    PRIMARY KEY (INTEREST_NUM)
);

ALTER TABLE INTEREST_CATEGORY COMMENT '흥미분야';


-- CLUB Table Create SQL
CREATE TABLE MEMBER_INTEREST
(
    `EMAIL` VARCHAR (45)    NOT NULL   COMMENT '이메일', 
    `NAME`  VARCHAR (45)    NOT NULL   COMMENT '분류 이름'
    PRIMARY KEY (EMAIL, NAME)
);

ALTER TABLE MEMBER_INTEREST COMMENT '멤버흥미';


-- BOARD Table Create SQL
CREATE TABLE BOARD
(
    `POSTNUM`   INT            NOT NULL    AUTO_INCREMENT COMMENT '글번호', 
    `CATEGORY`  VARCHAR(45)    NOT NULL    COMMENT '카테고리', 
    `TIME`      TIMESTAMP      NOT NULL    COMMENT '작성일자', 
    `TITLE`     VARCHAR(45)    NOT NULL    COMMENT '제목', 
    `CONTENT`   VARCHAR(45)    NOT NULL    COMMENT '내용', 
    `NICKNAME`  VARCHAR(45)    NOT NULL    COMMENT '작성자 별명',
    `EMAIL`     VARCHAR(45)    NOT NULL    COMMENT '작성자 이메일',
    `RECOMMEND` INT            NULL        COMMENT '추천' 
    PRIMARY KEY (POSTNUM)
);

ALTER TABLE BOARD COMMENT '게시판';


-- CATEGORY Table Create SQL
CREATE TABLE CATEGORY
(
    `NUM`   INT            NOT NULL    COMMENT '카테고리 번호', 
    `NAME`  VARCHAR(45)    NULL        COMMENT '카테고리 이름', 
    PRIMARY KEY (NUM)
);

ALTER TABLE CATEGORY COMMENT '게시글 카테고리';


-- FAQ Table Create SQL
CREATE TABLE FAQ
(
    `FAQ_NUM`       INT            NOT NULL    AUTO_INCREMENT COMMENT '글번호', 
    `TITLE`         VARCHAR(45)    NULL        COMMENT '제목', 
    `CONTENT`       VARCHAR(45)    NULL        COMMENT '내용', 
    PRIMARY KEY (FAQ_NUM)
);

ALTER TABLE FAQ COMMENT 'FAQ';


-- QNA Table Create SQL
CREATE TABLE QNA
(
    `NICKNAME`  VARCHAR(45)    NOT NULL    COMMENT '작성자 별명',
    `EMAIL`     VARCHAR(45)    NOT NULL    COMMENT '작성자 이메일',
    `QNA_NUM`   INT            NOT NULL    AUTO_INCREMENT COMMENT '질문 번호', 
    `TIME`      TIMESTAMP      NOT NULL    COMMENT '작성일자', 
    `TITLE`     VARCHAR(45)    NOT NULL    COMMENT '제목', 
    `CONTENT`   VARCHAR(45)    NOT NULL    COMMENT '내용', 
    PRIMARY KEY (QNA_NUM)
);

ALTER TABLE QNA COMMENT 'QNA';

-- COMMENT Table Create SQL
CREATE TABLE COMMENT
(
    `NICKNAME`  VARCHAR(45)   NOT NULL    COMMENT '작성자 별명',
    `EMAIL`     VARCHAR(45)   NOT NULL    COMMENT '작성자 이메일',
    `POST_NUM`  INT           NOT NULL    COMMENT '글번호', 
    `CONTENT`   VARCHAR(45)   NOT NULL    COMMENT '내용', 
    `TIME`      TIMESTAMP     NOT NULL    COMMENT '작성시간', 
    `CO_NUM`    INT           NOT NULL    AUTO_INCREMENT COMMENT '댓글번호', 
    PRIMARY KEY (CO_NUM)
);

ALTER TABLE COMMENT COMMENT '댓글';

-- RECOMMEND Table Create SQL
CREATE TABLE RECOMMEND
(
    `EMAIL`     VARCHAR(45)    NOT NULL    COMMENT '작성자 이메일',
    `POST_NUM`  VARCHAR(45)    NOT NULL    COMMENT '글번호'
    PRIMARY KEY (EMAIL, POST_NUM)
);

ALTER TABLE RECOMMEND COMMENT '추천';