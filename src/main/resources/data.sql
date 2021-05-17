INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (1, '서울');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (2, '경기');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (3, '인천');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (4, '강원');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (5, '충남');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (6, '충북');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (7, '경남');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (8, '경북');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (9, '전남');
INSERT INTO AREA (AREA_NUM, AREA_NAME) VALUES (10, '전북');

INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (1, '요리');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (2, '친목');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (3, '교양');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (4, '문화');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (5, '운동');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (6, '정치');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (7, '여행');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (8, '코딩');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (9, '공연');
INSERT INTO INTEREST_CATEGORY (INTEREST_NUM, INTEREST_NAME) VALUES (10,'취업');

INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 1);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 2);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 3);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 4);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 5);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 6);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 7);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 8);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 9);
INSERT INTO MEMBER_INTEREST (EMAIL, INTEREST_NUM) VALUES ('cofls749@naver.com', 10);

INSERT INTO FAQ (TITLE, CONTENT) 
VALUES ('Q1. 회원가입은 어떻게 하나요?', 
'웹페이지 혹은 스마트폰 등을 통해, 우동 홈페이지와 App에서 모두 손쉽게 가입할 수 있으며 3가지 방법으로 가입이 가능합니다.
[3가지 가입 방법]
- 페이스북 계정이 있는 경우, [페이스북으로 연결하기]를 클릭하시면 손쉽게 회원가입 할 수 있습니다.
- 카카오톡 계정이 있는 경우, [카카오톡으로 연결하기]를 클릭하시면 손쉽게 회원가입 할 수 있습니다.
- 혹은, 이메일 주소와 패스워드만 입력하셔도 가입이 가능합니다.');
INSERT INTO FAQ (TITLE, CONTENT) 
VALUES ('Q2. 비회원도 우동을 이용할 수 있나요?', 
'우동 신청은 회원 가입을 통해서만 가능합니다. 우동 회원으로 가입하시면 새로운 우동과 이벤트 소식을 받아보실 수 있으며 다양한 혜택을 누리실 수 있습니다.');
INSERT INTO FAQ (TITLE, CONTENT) 
VALUES ('Q3. 우동은 무엇인가요?', '우동이란 [우리들의 동아리]의 준말입니다. 우동은 사람들을 모아 다양한 종류의 동아리를 함께 즐기고 소통하며 더 행복한 삶을 살 수 있게 도와주는 서비스 플랫폼입니다.
지친 일상 속에서 우동을 통해 활력을 찾아보시길 바랍니다.
');
INSERT INTO FAQ (TITLE, CONTENT) 
VALUES ('Q4. 동아리의 추천수 랭킹을 알고 싶어요', '상단 메뉴바에서 동아리 버튼 클릭 후 랭킹 버튼을 누르면 추천 수 상위 10개의 동아리를 확인할 수 있습니다.');

INSERT INTO CLUB (CLUB_NAME, INTRO, CONTENT, EMAIL, CLUB_NUM, TIME, MEMBER_COUNT) VALUES ('동아리 1', '동아리 인트로 입니다.', '저희 동아리는 동아리  1입니다.', 'cofls749@naver.com', 1, NOW(), 0);
INSERT INTO CLUB (CLUB_NAME, INTRO, CONTENT, EMAIL, CLUB_NUM, TIME, MEMBER_COUNT) VALUES ('동아리 2', '동아리 인트로 입니다.', '저희 동아리는 동아리  2입니다.', 'cofls749@naver.com', 2, NOW(), 0);
INSERT INTO CLUB (CLUB_NAME, INTRO, CONTENT, EMAIL, CLUB_NUM, TIME, MEMBER_COUNT) VALUES ('동아리 3', '동아리 인트로 입니다.', '저희 동아리는 동아리  3입니다.', 'cofls749@naver.com', 3, NOW(), 0);
INSERT INTO CLUB (CLUB_NAME, INTRO, CONTENT, EMAIL, CLUB_NUM, TIME, MEMBER_COUNT) VALUES ('동아리 4', '동아리 인트로 입니다.', '저희 동아리는 동아리  4입니다.', 'cofls749@naver.com', 4, NOW(), 0);
INSERT INTO CLUB (CLUB_NAME, INTRO, CONTENT, EMAIL, CLUB_NUM, TIME, MEMBER_COUNT) VALUES ('동아리 5', '동아리 인트로 입니다.', '저희 동아리는 동아리  5입니다.', 'cofls749@naver.com', 5, NOW(), 0);

INSERT INTO CLUB_AREA(CLUB_NUM, AREA_NUM) VALUES(1, 1);
INSERT INTO CLUB_AREA(CLUB_NUM, AREA_NUM) VALUES(1, 2);
INSERT INTO CLUB_AREA(CLUB_NUM, AREA_NUM) VALUES(2, 2);
INSERT INTO CLUB_AREA(CLUB_NUM, AREA_NUM) VALUES(3, 3);
INSERT INTO CLUB_AREA(CLUB_NUM, AREA_NUM) VALUES(4, 4);
INSERT INTO CLUB_AREA(CLUB_NUM, AREA_NUM) VALUES(5, 5);

INSERT INTO CLUB_INTEREST(CLUB_NUM, INTEREST_NUM) VALUES(1, 1);
INSERT INTO CLUB_INTEREST(CLUB_NUM, INTEREST_NUM) VALUES(2, 2);
INSERT INTO CLUB_INTEREST(CLUB_NUM, INTEREST_NUM) VALUES(3, 3);
INSERT INTO CLUB_INTEREST(CLUB_NUM, INTEREST_NUM) VALUES(4, 4);
INSERT INTO CLUB_INTEREST(CLUB_NUM, INTEREST_NUM) VALUES(5, 5);

INSERT INTO MEMBER (EMAIL, BIRTH_MONTH, BIRTH_DAY, AREA_NUM, GRADE) VALUES ('test@naver.com', 12, 11, 1, 1);
-- INSERT INTO MEMBER (EMAIL, NAME, GENDER, BIRTH_YEAR, BIRTH_MONTH, BIRTH_DAY, NICKNAME, AREA_NUM, GRADE) VALUES ('cofls749@naver.com', '전채린', 'W', 1997, 12, 11, '접니다', 2, 2);

INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (1, NOW(), 'test post 01', 'CONTENT', 'test@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (1, NOW(), 'test post 02', 'CONTENT', 'cofls749@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (2, NOW(), 'test post 03', 'CONTENT', 'test@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (2, NOW(), 'test post 04', 'CONTENT', 'test@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (3, NOW(), 'test post 05', 'CONTENT', 'test@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (4, NOW(), 'test post 06', 'CONTENT', 'test@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (4, NOW(), 'test post 07', 'CONTENT', 'test@naver.com');
INSERT INTO BOARD (CATEGORY_NUM, TIME, TITLE, CONTENT, EMAIL) VALUES (4, NOW(), 'test post 08', 'CONTENT', 'test@naver.com');

INSERT INTO COMMENT(EMAIL, POST_NUM, TIME, CONTENT) VALUES ('test@naver.com', 1, NOW(), '그래용');
INSERT INTO COMMENT(EMAIL, POST_NUM, TIME, CONTENT) VALUES ('cofls749@naver.com', 1, NOW(), '하하');

INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '질문을 했는데 답변이 없습니다.', '질문한지 1년이 지났는데 답이 없습니다. ', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '랭킹 1위 동아리 상금 있나요?', '랭킹 1위 동아리에 선정되었는데 상금은 없나요?', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '랭킹 꼴찌 동아리 후원금 있나요?', '랭킹 꼴찌에 당첨되었는데 후원금 없슘니까', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '웹 개발자가 누군가요?', '웹 사이트 잘만드셨군요', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '웹사이트가 깰끔한가요?', '아주 깔끔합니당', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '마이페이지를 찾을 수 없습니다.', '만들지 않았기 때문이죠', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '이현주가 누구인가요?', '접니다요', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '아이 해브 어 퀘스쳔', 'i have a question', 'zago@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '동아리 개설 어떻게 하나요?', '동아리 개설 페이지를 찾을 수 없는 데 어디있나요?', 'test@naver.com');
INSERT INTO QNA (TIME, TITLE, CONTENT, EMAIL) VALUES (NOW(), '질문 있슘다.', '제가 바로 질문이 있다구요!', 'test@naver.com');

-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 01', 'POST_NUM 01', 'CONTENT 01', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 02', 'POST_NUM 02', 'CONTENT 02', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 03', 'POST_NUM 03', 'CONTENT 03', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 04', 'POST_NUM 04', 'CONTENT 04', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 05', 'POST_NUM 05', 'CONTENT 05', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 06', 'POST_NUM 06', 'CONTENT 06', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 07', 'POST_NUM 07', 'CONTENT 07', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 08', 'POST_NUM 08', 'CONTENT 08', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 09', 'POST_NUM 09', 'CONTENT 09', NOW());
-- INSERT INTO COMMENT (ID, POST_NUM, CONTENT, TIME) VALUES ('ID 10', 'POST_NUM 10', 'CONTENT 10', NOW());

-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 01', 'POST_NUM 01');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 02', 'POST_NUM 02');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 03', 'POST_NUM 03');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 04', 'POST_NUM 04');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 05', 'POST_NUM 05');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 06', 'POST_NUM 06');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 07', 'POST_NUM 07');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 08', 'POST_NUM 08');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 09', 'POST_NUM 09');
-- INSERT INTO RECOMMEND (ID, POST_NUM) VALUES ('ID 10', 'POST_NUM 10');

INSERT INTO CATEGORY (CATEGORY_NUM, CATEGORY_NAME) VALUES (01, 'free');
INSERT INTO CATEGORY (CATEGORY_NUM, CATEGORY_NAME) VALUES (02, 'qna');
INSERT INTO CATEGORY (CATEGORY_NUM, CATEGORY_NAME) VALUES (03, 'event');
INSERT INTO CATEGORY (CATEGORY_NUM, CATEGORY_NAME) VALUES (04, 'notice');
