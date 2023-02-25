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

INSERT INTO product VALUES('100001','ȭ��', 16000,'�Ҽ��ֿ� ȫ���� ��� �����߽��ϴ�.', '������', '25',5200,'ȭ��.jpeg');
INSERT INTO product VALUES('100002','������',60000,'�ѱ��� ��(�ִ��ۺ����� �̿��� ���Դϴ�.)','������','44',2500,'������.jpg');
INSERT INTO product VALUES('100003','����',25700,'����� ����, ����� ǳ��� ���Դϴ�.','������','53',3000,'����.jpg');
INSERT INTO product VALUES('100004','�� 40',23000,'������ ���� �̿��� ������ �Դϴ�.','������','40',4000,'�� 40.jpg');
INSERT INTO product VALUES('100005','�� 25',15000,'������ ���� �̿��� ������ �Դϴ�.','������','25',4000,'�� 25.jpg');
INSERT INTO product VALUES('100006','�̵�',26000,'����� �ҷ� ���� ���� ������մ��� 22���� �������� �⸰ ����','������','22',3000,'�̵�.jpg');
INSERT INTO product VALUES('100007','ȭ��',30000,'�ѱ��� ������ ������ �ϳ�. ȭ���� �̸��� ������ �Ҹ� ������ ���̴�.','������','41',3000,'ȭ��.jpg');
INSERT INTO product VALUES('100008','������������',6500,'������ ���ַ�, �����������ɸ��� �����ؼ� �����','������','21',10000,'�������� ����.jpg');
INSERT INTO product VALUES('100009','���ϴ�',11000,'�λ��� ���ɸ��� �ÿ��� ������ ��ǰ�Դϴ�.','������','9',7000,'���ϴ�.jpg');
INSERT INTO product VALUES('100010','�����',13000,'100�� ���� ������ ����� ������ ������ ���ɸ�','������','10',6000,'�����.jpg');
INSERT INTO product VALUES('100011','�������� ���ɸ�',4500,'�Ұ� ����, �׸��� ���� ���� ���ɸ� ��� ������ ���� ��ȿ �̻����� �ӵ��� �����Ǵ� �������� ���ɸ�.','������','6',15000,'�������� ���ɸ�.jpg');
INSERT INTO product VALUES('100012','��â 12',15500,'ù ����� ����Ʈ ���� �ణ�� �ܸ��� �������� �ö���� ������ ��ǰ�� �ε巯�� ���ɸ�','������','12',5000,'��â 12.jpg');
INSERT INTO product VALUES('100013','��ȭ����',12000,'��, ������ �̿��� �ε巯�� �Ͼ� ���� �������̶�� ��Ī�� �ֽ��ϴ�.','������','6',4000,'��ȭ����.jeg');
INSERT INTO product VALUES('100014','������ �ܸ��ɸ�','6000','���� ��ȿ�� ���� ���ɸ��� �ʹ� ���� �ʴ� �Ҹ��ɸ��Դϴ�.','������','6',12000,'������ �ܸ��ɸ�.jpg');
INSERT INTO product VALUES('100015','�������� ������','6000','�������� �̿��� ����� ���ɸ��Դϴ�.','������','6',12000,'�������� ������.jpg');
INSERT INTO product VALUES('100016','Ƽ��',55000,'TINA�� ���⸦ �������� ���� ��ǰ ��ť���Դϴ�. �� �ϴ� LED ������ �ֽ��ϴ�.','ȥ����','16',2000,'Ƽ��.jpg');
INSERT INTO product VALUES('100017','����',23000,'�� ���� Ȳ�ŽǷθ� ��� �Ž��� ������ -3��C�� ��Ⱓ �ż� ���� ������ ��ģ ���� �����ϰ� �Ž��� ���� 100%�� ��� �Ž����Դϴ�.','ȥ����','15',3500,'����.jpg');
INSERT INTO product VALUES('100018','���������� �ٳ���',1800,'�ٳ��� ���� ���� ��â�� �ִ� ���ɸ� �Դϴ�.','������','4',5000,'������ ���� �ٳ���.jpg');
INSERT INTO product VALUES('100019','�߻�',25000,'���������ο��� ���� ����� ����� �����Ͽ� �������� Į�ٵ����� �����ϰ� ��ũ�� ������ ����������̴�.','������','40',3000,'�߻�.jpg');
INSERT INTO product VALUES('100020','�����' ,10800,'�޴��� ���ο� �� ��� ������ ������ ��ǰ�� û�ʹ밡 ������ ���� �Դϴ�.','������','40',2000,'�����.jpg');
INSERT INTO product VALUES('100021','����������',8000,'����, ������, ���ʸ� �ְ� 100�ϰ� ���� ���� Ư�����Դϴ�.','������','20',3500,'����������.jpg');
