-- �α��� ������
CREATE TABLE join_info(
	id 			VARCHAR(10) 	PRIMARY KEY,
	name		CHAR(10) 		NOT NULL,
	password 	CHAR(10)		NOT NULL,
	nickName	CHAR(10)		NOT NULL
);

-- ��ȣ, ���� , �ۼ���, �ۼ���
CREATE TABLE board_info(
	b_id 			INT			PRIMARY KEY 		AUTO_INCREMENT,
	b_title		CHAR(20)	NOT NULL,
	b_content	CHAR(50)	NOT NULL,
	b_date		CHAR(40) 	NOT NULL
);
DESC join_info;