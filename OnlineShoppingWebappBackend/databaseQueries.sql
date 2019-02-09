Create TABLE category(
	
	id INT NOT NULL AUTO_INCREMENT,
	item_name varchar(50),
	description varchar(255),
	image_url varchar(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id primary key (id)
);