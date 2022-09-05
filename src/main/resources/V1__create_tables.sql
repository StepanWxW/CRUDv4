create table crud.posts (post_id bigserial not null, created timestamp(6), post varchar(255), poststatus varchar(255), updated timestamp(6), primary key (post_id));
create table crud.regions (region_id bigserial not null, name varchar(255), primary key (region_id));
create table crud.writers (writer_id bigserial not null, firstName varchar(255), lastName varchar(255), region_region_id bigint, primary key (writer_id));
create table writers_posts (Writer_writer_id bigint not null, post_post_id bigint not null)