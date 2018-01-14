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
-- begin DDCSEF_COMMENTS
create table DDCSEF_COMMENTS (
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
-- end DDCSEF_COMMENTS
-- begin DDCSEF_NOTABLE
create table DDCSEF_NOTABLE (
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
    NOTABLE varchar(50),
    --
    primary key (ID)
)^
-- end DDCSEF_NOTABLE
