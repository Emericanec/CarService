update CARSERVICE_CITY set IS_DEFAULT = false where IS_DEFAULT is null ;
alter table CARSERVICE_CITY modify column IS_DEFAULT boolean not null ;
