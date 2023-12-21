/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/12/21 8:19:50                           */
/*==============================================================*/


alter table log 
   drop foreign key FK_LOG_LOGGING_USER_BAS;

alter table menu_food 
   drop foreign key FK_MENU_FOO_MANAGE_ME_ADMINIST;

alter table menu_tag 
   drop foreign key FK_MENU_TAG_MANAGE_TA_ADMINIST;

alter table user 
   drop foreign key FK_USER_BELONG2_USER_BAS;

alter table user 
   drop foreign key FK_USER_CONTROL_ADMINIST;

alter table user_base 
   drop foreign key FK_USER_BAS_BELONG_USER;

drop table if exists administer;


alter table log 
   drop foreign key FK_LOG_LOGGING_USER_BAS;

drop table if exists log;


alter table menu_food 
   drop foreign key FK_MENU_FOO_MANAGE_ME_ADMINIST;

drop table if exists menu_food;


alter table menu_tag 
   drop foreign key FK_MENU_TAG_MANAGE_TA_ADMINIST;

drop table if exists menu_tag;


alter table user 
   drop foreign key FK_USER_BELONG2_USER_BAS;

alter table user 
   drop foreign key FK_USER_CONTROL_ADMINIST;

drop table if exists user;


alter table user_base 
   drop foreign key FK_USER_BAS_BELONG_USER;

drop table if exists user_base;

/*==============================================================*/
/* Table: administer                                            */
/*==============================================================*/
create table administer
(
   admin_name           varchar(20) not null  comment '',
   admin_pwd            varchar(50)  comment '',
   create_date          datetime  comment '',
   primary key (admin_name)
);

/*==============================================================*/
/* Table: log                                                   */
/*==============================================================*/
create table log
(
   user_name            varchar(20)  comment '',
   select_no            varchar(20)  comment '',
   select_name          varchar(20)  comment ''
);

/*==============================================================*/
/* Table: menu_food                                             */
/*==============================================================*/
create table menu_food
(
   menu_no              varchar(20) not null  comment '',
   admin_name           varchar(20)  comment '',
   menu_name            varchar(50)  comment '',
   menu_feature         varchar(100)  comment '',
   primary key (menu_no)
);

/*==============================================================*/
/* Table: menu_tag                                              */
/*==============================================================*/
create table menu_tag
(
   food_no              varchar(20) not null  comment '',
   admin_name           varchar(20)  comment '',
   food_name            varchar(50)  comment '',
   food_tag             varchar(100)  comment '',
   primary key (food_no)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_name            varchar(20)  comment '',
   admin_name           varchar(20)  comment '',
   name                 varchar(20)  comment '',
   id                   varchar(50)  comment '',
   age                  int  comment '',
   address              varchar(100)  comment ''
);

/*==============================================================*/
/* Table: user_base                                             */
/*==============================================================*/
create table user_base
(
   user_name            varchar(20) not null  comment '',
   user_pwd             varchar(50)  comment '',
   primary key (user_name)
);

alter table log add constraint FK_LOG_LOGGING_USER_BAS foreign key (user_name)
      references user_base (user_name) on delete restrict on update restrict;

alter table menu_food add constraint FK_MENU_FOO_MANAGE_ME_ADMINIST foreign key (admin_name)
      references administer (admin_name) on delete restrict on update restrict;

alter table menu_tag add constraint FK_MENU_TAG_MANAGE_TA_ADMINIST foreign key (admin_name)
      references administer (admin_name) on delete restrict on update restrict;

alter table user add constraint FK_USER_BELONG2_USER_BAS foreign key (user_name)
      references user_base (user_name) on delete restrict on update restrict;

alter table user add constraint FK_USER_CONTROL_ADMINIST foreign key (admin_name)
      references administer (admin_name) on delete restrict on update restrict;

alter table user_base add constraint FK_USER_BAS_BELONG_USER foreign key (user_name)
      references user (user_name) on delete restrict on update restrict;

