-- begin DDCSEF_CUSTOMER
create table DDCSEF_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end DDCSEF_CUSTOMER
-- begin DDCSEF_COMMENT
create table DDCSEF_COMMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEXT varchar(255),
    COMMENTABLE varchar(255),
    --
    primary key (ID)
)^
-- end DDCSEF_COMMENT
-- begin DDCSEF_ORDER
create table DDCSEF_ORDER (
    ID integer not null,
    UUID varchar(36),
    --
    ORDER_DATE date,
    --
    primary key (ID)
)^
-- end DDCSEF_ORDER
