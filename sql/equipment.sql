create table equipment(
	id integer not null,
	ip varchar(255) not null,
	status varchar(255) not null,
	constraint pk_equipment primary key (id)
);

create sequence seq_equipment;

insert into equipment(id, ip, status)
values (nextval('seq_equipment'), '192.168.0.0', 'ok');

select * from equipment;