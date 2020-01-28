create table animal (id int8 generated by default as identity, gender int4, name varchar(255), owner_id int8, primary key (id));
create table customer (id int8 generated by default as identity, email varchar(255), first_name varchar(255), last_name varchar(255), primary key (id));
create table customer_pets (customer_id int8 not null, pets_id int8 not null, primary key (customer_id, pets_id));

alter table if exists customer add constraint UQ_customer_email unique (email);
alter table if exists customer_pets add constraint UQ_customer_pets_pets_id unique (pets_id);
alter table if exists animal add constraint FK_animal_owner_id foreign key (owner_id) references customer;
alter table if exists customer_pets add constraint FK_customer_pets_pets_id foreign key (pets_id) references animal;
alter table if exists customer_pets add constraint FK_customer_pets_customer_id foreign key (customer_id) references customer;