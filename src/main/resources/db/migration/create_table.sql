CREATE TABLE reshma(
	id serial PRIMARY KEY,
	name VARCHAR(255),
	ip_range VARCHAR(255),
	zone_name VARCHAR(255),
	create_date timestamp,
	last_modified_date timestamp,
	created_by VARCHAR(255),
	dc_location VARCHAR(255),
	cluster_name VARCHAR(255),
	app_type VARCHAR(255),
	app_environment VARCHAR(255)
);