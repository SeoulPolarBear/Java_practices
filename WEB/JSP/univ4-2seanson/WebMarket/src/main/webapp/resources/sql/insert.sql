INSERT INTO product VALUES('P1234','iPhone6s', 800000,
'1334X750 Renina HD display, 8-megapixel iSight Camera',
'Smart Phone', 'Apple',1000,'new', 'P1234.png');

INSERT INTO product VALUES('P1235','LG PC gram', 1500000,
'3.3-inch, IPS LED display, 5rd Generation Intel Core processors',
'Notebook', 'LG',1000,'new', 'P1235.png');

INSERT INTO product VALUES('P1236','Galaxy Tab S', 900000,
'3.3-inch, 212.8*125.6*6.6mm, Super AmoLED display,Octa-Core processor',
'Tablet', 'Samsung',1000,'new', 'P1236.png');

ALTER TABLE PRODUCT CHANGE COLUMN P_name p_name varchar(20);

ALTER TABLE PRODUCT CHANGE COLUMN P_manufacturer p_alcohol Integer;

ALTER TABLE PRODUCT CHANGE COLUMN P_alcohol p_alcohol varchar(20);

SELECT * from product;

desc product;

delete from product;

ALTER TABLE product DROP p_condition;

INSERT INTO product VALUES('100001','화주', 16000,'쌀소주에 홍삼을 담아 증류했습니다.', '증류주', '25',5200,'화주.jpeg');
INSERT INTO product VALUES('100002','부자진',60000,'한국의 진(주니퍼베리를 이용한 술입니다.)','증류주','44',2500,'부자진.jpg');
INSERT INTO product VALUES('100003','독산',25700,'고소한 누룩, 곡물향을 풍기는 술입니다.','증류주','53',3000,'독산.jpg');
INSERT INTO product VALUES('100004','려 40',23000,'고구마와 쌀을 이용한 증류주 입니다.','증류주','40',4000,'려 40.jpg');
INSERT INTO product VALUES('100005','려 25',15000,'고구마와 쌀을 이용한 증류주 입니다.','증류주','25',4000,'려 25.jpg');
INSERT INTO product VALUES('100006','이도',26000,'유기농 쌀로 만든 소주 세종대왕님이 22세에 즉위함을 기린 소주','증류주','22',3000,'이도.jpg');
INSERT INTO product VALUES('100007','화요',30000,'한국의 증류식 소주의 하나. 화요라는 이름은 소주의 소를 파자한 것이다.','증류주','41',3000,'화요.jpg');
INSERT INTO product VALUES('100008','느린마을소주',6500,'증류식 소주로, 느린마을막걸리를 증류해서 만든다','증류주','21',10000,'느린마을 소주.jpg');
INSERT INTO product VALUES('100009','설하담',11000,'부산의 막걸리고 시원한 배향이 일품입니다.','양조주','9',7000,'설하담.jpg');
INSERT INTO product VALUES('100010','백년향',13000,'100일 동안 양조한 담백한 은은한 과일향 막걸리','양조주','10',6000,'백년향.jpg');
INSERT INTO product VALUES('100011','느린마을 막걸리',4500,'쌀과 누룩, 그리고 물로 만들어낸 막걸리 재료 본연의 맛과 발효 미생물의 속도로 결정되는 느린마을 막걸리.','양조주','6',15000,'느린마을 막걸리.jpg');
INSERT INTO product VALUES('100012','해창 12',15500,'첫 모금은 요쿠르트 같고 약간의 단맛과 새콤함이 올라오는 끝맛이 일품인 부드러운 막걸리','양조주','12',5000,'해창 12.jpg');
INSERT INTO product VALUES('100013','이화백주',12000,'쌀, 누룩을 이용한 부드러운 하얀 술로 막페인이라는 별칭이 있습니다.','양조주','6',4000,'이화백주.jeg');
INSERT INTO product VALUES('100014','참살이 꿀막걸리','6000','벌꿀 발효를 통한 막걸리로 너무 달지 않는 쌀막걸리입니다.','양조주','6',12000,'참살이 꿀막걸리.jpg');
INSERT INTO product VALUES('100015','생옥수수 동동주','6000','옥수수를 이용한 고소한 막걸리입니다.','양조주','6',12000,'생옥수수 동동주.jpg');
INSERT INTO product VALUES('100016','티나',55000,'TINA는 딸기를 숙성시켜 만든 명품 리큐르입니다. 병 하단 LED 조명이 있습니다.','혼성주','16',2000,'티나.jpg');
INSERT INTO product VALUES('100017','원매',23000,'잘 익은 황매실로만 담근 매실주 원액을 -3°C의 장기간 신선 저장 과정을 거친 국내 유일하게 매실주 원주 100%로 담근 매실주입니다.','혼성주','15',3500,'원매.jpg');
INSERT INTO product VALUES('100018','조은술세종 바나나',1800,'바나나 맛이 나는 독창성 있는 막걸리 입니다.','양조주','4',5000,'조은술 세종 바나나.jpg');
INSERT INTO product VALUES('100019','추사',25000,'예산사과와인에서 직접 재배한 사과를 증류하여 프랑스의 칼바도스와 동일하게 오크통 숙성한 사과증류주이다.','증류주','40',3000,'추사.jpg');
INSERT INTO product VALUES('100020','문배술' ,10800,'달달한 향기로운 꽃 향과 상쾌한 배향이 일품인 청와대가 선택한 소주 입니다.','증류주','40',2000,'문배술.jpg');
INSERT INTO product VALUES('100021','동강더덕주',8000,'대추, 오미자, 감초를 넣고 100일간 빚은 영월 특산주입니다.','양조주','20',3500,'동강더덕주.jpg');
