Create TABLE category(
	
	id IDENTITY,
	item_name varchar(50),
	description varchar(255),
	image_url varchar(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id primary key (id)
);