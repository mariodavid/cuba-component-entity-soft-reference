-- begin DDCESF_CUSTOMER
create table DDCESF_CUSTOMER (
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
-- end DDCESF_CUSTOMER
-- begin DDCESF_COMMENT
create table DDCESF_COMMENT (
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
-- end DDCESF_COMMENT
-- begin DDCESF_ORDER
create table DDCESF_ORDER (
    ID integer not null,
    UUID varchar(36),
    --
    ORDER_DATE date,
    --
    primary key (ID)
)^
-- end DDCESF_ORDER
