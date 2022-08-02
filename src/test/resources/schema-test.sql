create table land_lords (id bigint generated by default as identity, name varchar(255), primary key (id));
create table rent_object (id bigint generated by default as identity, area double, description varchar(255), name varchar(255), price double, primary key (id));
create table reservations (id bigint generated by default as identity, end_date date, final_price double, start_date date, land_lord_id bigint, rent_object_id bigint, tenant_id bigint, primary key (id));
create table tenant (id bigint generated by default as identity, name varchar(255), primary key (id));
alter table reservations add constraint land_lord_fk foreign key (land_lord_id) references land_lords;
alter table reservations add constraint rent_object_fk foreign key (rent_object_id) references rent_object;
alter table reservations add constraint tenant_id_fk foreign key (tenant_id) references tenant;