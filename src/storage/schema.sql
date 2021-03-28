CREATE TABLE IF NOT EXISTS accommodation (
     id integer primary key
    ,name varchar(128) not null
    ,location varchar(128) not null
    ,rating DECIMAL(1,1)
    ,description VARCHAR(2048)
);
CREATE TABLE IF NOT EXISTS room (
     id integer primary key
    ,roomType varchar(32)
    ,price DECIMAL(12,2)
    ,cap integer
);
