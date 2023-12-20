/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/12/20 14:08:48                          */
/*==============================================================*/


alter table Log 
   drop foreign key FK_LOG_LOGGING_USERBASE;

alter table MenuFood 
   drop foreign key FK_MENUFOOD_MANAGEMEN_ADMINIST;

alter table MenuTag 
   drop foreign key FK_MENUTAG_MANAGETAG_ADMINIST;

alter table User 
   drop foreign key FK_USER_BELONG2_USERBASE;

alter table User 
   drop foreign key FK_USER_CONTROL_ADMINIST;

alter table UserBase 
   drop foreign key FK_USERBASE_BELONG_USER;

drop table if exists Administer;


alter table Log 
   drop foreign key FK_LOG_LOGGING_USERBASE;

drop table if exists Log;


alter table MenuFood 
   drop foreign key FK_MENUFOOD_MANAGEMEN_ADMINIST;

drop table if exists MenuFood;


alter table MenuTag 
   drop foreign key FK_MENUTAG_MANAGETAG_ADMINIST;

drop table if exists MenuTag;


alter table User 
   drop foreign key FK_USER_BELONG2_USERBASE;

alter table User 
   drop foreign key FK_USER_CONTROL_ADMINIST;

drop table if exists User;


alter table UserBase 
   drop foreign key FK_USERBASE_BELONG_USER;

drop table if exists UserBase;

/*==============================================================*/
/* Table: Administer                                            */
/*==============================================================*/
create table Administer
(
   AD_Name              varchar(20) not null  comment '',
   AD_Pwd               varchar(50)  comment '',
   CreateDate           datetime  comment '',
   primary key (AD_Name)
);

/*==============================================================*/
/* Table: Log                                                   */
/*==============================================================*/
create table Log
(
   UserName             varchar(20)  comment '',
   SelectedNo           varchar(20)  comment '',
   SelectedName         varchar(20)  comment ''
);

/*==============================================================*/
/* Table: MenuFood                                              */
/*==============================================================*/
create table MenuFood
(
   MenuNo               varchar(20) not null  comment '',
   AD_Name              varchar(20)  comment '',
   MenuName             varchar(50)  comment '',
   MenuFeature          varchar(100)  comment '',
   primary key (MenuNo)
);

/*==============================================================*/
/* Table: MenuTag                                               */
/*==============================================================*/
create table MenuTag
(
   FoodNo               varchar(20) not null  comment '',
   AD_Name              varchar(20)  comment '',
   FoodName             varchar(50)  comment '',
   FoodTag              varchar(100)  comment '',
   primary key (FoodNo)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   UserName             varchar(20)  comment '',
   AD_Name              varchar(20)  comment '',
   Name                 varchar(20)  comment '',
   Age                  int  comment '',
   Address              varchar(100)  comment ''
);

/*==============================================================*/
/* Table: UserBase                                              */
/*==============================================================*/
create table UserBase
(
   UserName             varchar(20) not null  comment '',
   UserPwd              varchar(50)  comment '',
   primary key (UserName)
);

alter table Log add constraint FK_LOG_LOGGING_USERBASE foreign key (UserName)
      references UserBase (UserName) on delete restrict on update restrict;

alter table MenuFood add constraint FK_MENUFOOD_MANAGEMEN_ADMINIST foreign key (AD_Name)
      references Administer (AD_Name) on delete restrict on update restrict;

alter table MenuTag add constraint FK_MENUTAG_MANAGETAG_ADMINIST foreign key (AD_Name)
      references Administer (AD_Name) on delete restrict on update restrict;

alter table User add constraint FK_USER_BELONG2_USERBASE foreign key (UserName)
      references UserBase (UserName) on delete restrict on update restrict;

alter table User add constraint FK_USER_CONTROL_ADMINIST foreign key (AD_Name)
      references Administer (AD_Name) on delete restrict on update restrict;

alter table UserBase add constraint FK_USERBASE_BELONG_USER foreign key (UserName)
      references User (UserName) on delete restrict on update restrict;

