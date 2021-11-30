/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  02/11/2021 16:11:01                      */
/*==============================================================*/


drop table if exists A_COMME;

drop table if exists CIVILITE;

drop table if exists CORRESPONDANT;

drop table if exists EST_DE;

drop table if exists EST_PROGRAMME;

drop table if exists GROUPE;

drop table if exists INSTRUMENT;

drop table if exists MEMBRE;

drop table if exists ORGANISATEUR;

drop table if exists PAYS;

drop table if exists REGION;

drop table if exists RENCONTRE;

drop table if exists REPERTOIRE;

drop table if exists SPECIALITE;

drop table if exists TYPE_REPERTOIRE;

drop table if exists UTILISE;

/*==============================================================*/
/* Table : A_COMME                                              */
/*==============================================================*/
create table A_COMME
(
   ID_MEMBRE            int not null,
   ID_SPECIALITE        int not null,
   primary key (ID_MEMBRE, ID_SPECIALITE)
);

/*==============================================================*/
/* Table : CIVILITE                                             */
/*==============================================================*/
create table CIVILITE
(
   ID_CIVILITE          int not null auto_increment,
   TYPE_CIVILITE        char(3),
   primary key (ID_CIVILITE)
);

/*==============================================================*/
/* Table : CORRESPONDANT                                        */
/*==============================================================*/
create table CORRESPONDANT
(
   ID_CORRESPONDANT     int not null auto_increment,
   NOM_CORRESPONDANT    varchar(30),
   PRENOM_CORRESPONDANT varchar(30),
   TELEPHONE_CORRESPONDANT varchar(14),
   FAX_CORRESPONDANT    varchar(30),
   EMAIL_CORRESPONDANT  varchar(40),
   NUMERO_RUE_CORRESPONDANT varchar(10),
   RUE_CORRESPONDANT    varchar(30),
   VILLE_CORRESPONDANT  varchar(25),
   CODE_POSTAL_CORRESPONDANT varchar(6),
   primary key (ID_CORRESPONDANT)
);

/*==============================================================*/
/* Table : EST_DE                                               */
/*==============================================================*/
create table EST_DE
(
   ID_TYPEREPERTOIRE    int not null,
   ID_REPERTOIRE        int not null,
   primary key (ID_TYPEREPERTOIRE, ID_REPERTOIRE)
);

/*==============================================================*/
/* Table : EST_PROGRAMME                                        */
/*==============================================================*/
create table EST_PROGRAMME
(
   ID_GROUPE            int not null,
   ID_RENCONTRE         int not null,
   DATE_PASSAGE_GROUPE  date,
   HEURE_DEBUT_PRESTATION time,
   HEURE_FIN_PRESTATION time,
   LIEU_PRESTATION      varchar(30),
   TITRE_PRESENTE       varchar(30),
   TEMPS_PREVU          varchar(5),
   primary key (ID_GROUPE, ID_RENCONTRE)
);

/*==============================================================*/
/* Table : GROUPE                                               */
/*==============================================================*/
create table GROUPE
(
   ID_GROUPE            int not null auto_increment,
   ID_REGION            int not null,
   ID_CORRESPONDANT     int not null,
   ID_PAYS              int not null,
   DENOMINATION_GROUPE  varchar(30),
   primary key (ID_GROUPE)
);

/*==============================================================*/
/* Table : INSTRUMENT                                           */
/*==============================================================*/
create table INSTRUMENT
(
   ID_INSTRUMENT        int not null auto_increment,
   NOM_INSTRUMENT       varchar(30),
   TYPE_INSTRUMENT      varchar(30),
   primary key (ID_INSTRUMENT)
);

/*==============================================================*/
/* Table : MEMBRE                                               */
/*==============================================================*/
create table MEMBRE
(
   ID_MEMBRE            int not null auto_increment,
   ID_GROUPE            int not null,
   ID_CIVILITE          int not null,
   NOM_MEMBRE           varchar(30),
   PRENOM_MEMBRE        varchar(30),
   DATENAISSANCE_MEMBRE date,
   RESPONSABOILITE_MEMBRE varchar(30),
   primary key (ID_MEMBRE)
);

/*==============================================================*/
/* Table : ORGANISATEUR                                         */
/*==============================================================*/
create table ORGANISATEUR
(
   ID_ORGANISATEUR      int not null auto_increment,
   NOM_ORGANISATEUR     varchar(30),
   PRENOM_ORGANISATEUR  varchar(30),
   TELEPHONE_ORGANISATEUR varchar(14),
   FAX_ORGANISATEUR     varchar(30),
   EMAIL_ORGANISATEUR   varchar(30),
   VILLE_ORGANISATEUR   varchar(20),
   NUMERO_RUE_ORGANISATEUR varchar(5),
   RUE_ORGANISATEUR     varchar(50),
   CODE_POSTAL_ORGANISATEUR varchar(6),
   primary key (ID_ORGANISATEUR)
);

/*==============================================================*/
/* Table : PAYS                                                 */
/*==============================================================*/
create table PAYS
(
   ID_PAYS              int not null auto_increment,
   NOM_PAYS             varchar(30),
   primary key (ID_PAYS)
);

/*==============================================================*/
/* Table : REGION                                               */
/*==============================================================*/
create table REGION
(
   ID_REGION            int not null auto_increment,
   NOM_REGION           varchar(30),
   primary key (ID_REGION)
);

/*==============================================================*/
/* Table : RENCONTRE                                            */
/*==============================================================*/
create table RENCONTRE
(
   ID_RENCONTRE         int not null auto_increment,
   ID_ORGANISATEUR      int not null,
   NOM_RENCONTRE        varchar(30),
   LIEU_RENCONTRE       varchar(30),
   DATE_DEBUT_DEROULE_RENCONTRE datetime,
   DATE_FIN_DEROULE_RENCONTRE datetime,
   PERIODICITE_RENCONTRE varchar(30),
   NB_SPECTATEUR_RENCONTRE int,
   primary key (ID_RENCONTRE)
);

/*==============================================================*/
/* Table : REPERTOIRE                                           */
/*==============================================================*/
create table REPERTOIRE
(
   ID_REPERTOIRE        int not null auto_increment,
   ID_GROUPE            int not null,
   TITRE_REPERTOIRE     varchar(30),
   DATE_APPARITION_TITRE date,
   NOM_AUTEUR_REPERTOIRE varchar(30),
   PRENOM_AUTEUR_REPERTOIRE varchar(30),
   DUREE_REPERTOIRE     int,
   primary key (ID_REPERTOIRE)
);

/*==============================================================*/
/* Table : SPECIALITE                                           */
/*==============================================================*/
create table SPECIALITE
(
   ID_SPECIALITE        int not null auto_increment,
   NOM_SPECIALITE       varchar(30),
   primary key (ID_SPECIALITE)
);

/*==============================================================*/
/* Table : TYPE_REPERTOIRE                                      */
/*==============================================================*/
create table TYPE_REPERTOIRE
(
   ID_TYPEREPERTOIRE    int not null auto_increment,
   TYPE_REPERTOIRE      varchar(30),
   primary key (ID_TYPEREPERTOIRE)
);

/*==============================================================*/
/* Table : UTILISE                                              */
/*==============================================================*/
create table UTILISE
(
   ID_MEMBRE            int not null,
   ID_INSTRUMENT        int not null,
   primary key (ID_MEMBRE, ID_INSTRUMENT)
);

alter table A_COMME add constraint FK_A_COMME foreign key (ID_MEMBRE)
      references MEMBRE (ID_MEMBRE) on delete restrict on update restrict;

alter table A_COMME add constraint FK_A_COMME2 foreign key (ID_SPECIALITE)
      references SPECIALITE (ID_SPECIALITE) on delete restrict on update restrict;

alter table EST_DE add constraint FK_EST_DE foreign key (ID_TYPEREPERTOIRE)
      references TYPE_REPERTOIRE (ID_TYPEREPERTOIRE) on delete restrict on update restrict;

alter table EST_DE add constraint FK_EST_DE2 foreign key (ID_REPERTOIRE)
      references REPERTOIRE (ID_REPERTOIRE) on delete restrict on update restrict;

alter table EST_PROGRAMME add constraint FK_EST_PROGRAMME foreign key (ID_GROUPE)
      references GROUPE (ID_GROUPE) on delete restrict on update restrict;

alter table EST_PROGRAMME add constraint FK_EST_PROGRAMME2 foreign key (ID_RENCONTRE)
      references RENCONTRE (ID_RENCONTRE) on delete restrict on update restrict;

alter table GROUPE add constraint FK_APPARTIENT_A foreign key (ID_REGION)
      references REGION (ID_REGION) on delete restrict on update restrict;

alter table GROUPE add constraint FK_A_POUR foreign key (ID_CORRESPONDANT)
      references CORRESPONDANT (ID_CORRESPONDANT) on delete restrict on update restrict;

alter table GROUPE add constraint FK_FAIT_PARTIE_DE foreign key (ID_PAYS)
      references PAYS (ID_PAYS) on delete restrict on update restrict;

alter table MEMBRE add constraint FK_EST_COMPOSE foreign key (ID_GROUPE)
      references GROUPE (ID_GROUPE) on delete restrict on update restrict;

alter table MEMBRE add constraint FK_EST_DE_TYPE foreign key (ID_CIVILITE)
      references CIVILITE (ID_CIVILITE) on delete restrict on update restrict;

alter table RENCONTRE add constraint FK_GERE foreign key (ID_ORGANISATEUR)
      references ORGANISATEUR (ID_ORGANISATEUR) on delete restrict on update restrict;

alter table REPERTOIRE add constraint FK_POSSEDE foreign key (ID_GROUPE)
      references GROUPE (ID_GROUPE) on delete restrict on update restrict;

alter table UTILISE add constraint FK_UTILISE foreign key (ID_MEMBRE)
      references MEMBRE (ID_MEMBRE) on delete restrict on update restrict;

alter table UTILISE add constraint FK_UTILISE2 foreign key (ID_INSTRUMENT)
      references INSTRUMENT (ID_INSTRUMENT) on delete restrict on update restrict;

