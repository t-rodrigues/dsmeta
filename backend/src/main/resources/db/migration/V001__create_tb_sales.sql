create table tb_sales(
    id bigint auto_increment,
    seller_name varchar(150) not null,
    visited int not null default 0,
    deals int not null default 0,
    amount decimal(10,2),
    date date,

    primary key (id)
);
