CREATE TABLE IF NOT EXISTS product(
	p_id VARCHAR(20) NOT NULL,
	p_name VARCHAR(30),
	p_unitPrice INTEGER,
	p_description TEXT,
	p_category VARCHAR(20),
	p_alcohol VARCHAR(20),
	p_unitsInStock LONG,
	p_fileName VARCHAR(20),
	PRIMARY KEY(p_id)
)default CHARSET=utf8;--한글 부분으로 변경(default CHARSET set utf8 collate utf8_general_ci;

desc product;

