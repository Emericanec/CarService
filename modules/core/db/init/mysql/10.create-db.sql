-- begin CARSERVICE_CITY
create table CARSERVICE_CITY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    IS_DEFAULT boolean not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CITY
-- begin CARSERVICE_CUSTOMER
create table CARSERVICE_CUSTOMER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(255) not null,
    PHONE varchar(255) not null,
    EMAIL varchar(255) not null,
    DTYPE varchar(255),
    --
    primary key (ID)
)^
-- end CARSERVICE_CUSTOMER
-- begin CARSERVICE_INDIVIDUAL
create table CARSERVICE_INDIVIDUAL (
    ID varchar(32),
    --
    PASSPORT_NO varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_INDIVIDUAL
-- begin CARSERVICE_COMPANY
create table CARSERVICE_COMPANY (
    ID varchar(32),
    --
    INN varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_COMPANY
-- begin CARSERVICE_CAR_SERVICE_CENTER
create table CARSERVICE_CAR_SERVICE_CENTER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE varchar(255) not null,
    ADDRESS varchar(255) not null,
    CITY_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER
-- begin CARSERVICE_EMPLOYEE
create table CARSERVICE_EMPLOYEE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    BIRTH_DATE date not null,
    EMAIL varchar(255) not null,
    SALARY decimal(19, 2) not null,
    CENTER_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_EMPLOYEE
-- begin CARSERVICE_REPAIR
create table CARSERVICE_REPAIR (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255) not null,
    CENTER_ID varchar(32),
    EMPLOYEE_ID varchar(32),
    --
    primary key (ID)
)^
-- end CARSERVICE_REPAIR
-- begin CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID varchar(32),
    CUSTOMER_ID varchar(32),
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
