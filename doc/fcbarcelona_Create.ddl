CREATE SEQUENCE seq_USUARIO;
CREATE SEQUENCE seq_PASIVO;
CREATE SEQUENCE seq_ACTIVO;
CREATE SEQUENCE seq_CONTRATO;
CREATE SEQUENCE seq_DATO_CONTACTO;
CREATE SEQUENCE seq_SOCIO;
CREATE SEQUENCE seq_PERSONAL;
CREATE TABLE USUARIO (ID number(19) NOT NULL, NOMBRE_USUARIO varchar2(50) NOT NULL UNIQUE, PASSWORD varchar2(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE ESTADO_PASIVO (ID number(2) NOT NULL, ESTADO varchar2(20) NOT NULL, DESCRIPCION varchar2(255), PRIMARY KEY (ID));
CREATE TABLE PASIVO (ID number(19) NOT NULL, VALOR number(10) NOT NULL, ESTADO_PASIVO_ID number(2) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE TIPO_ACTIVO (ID number(2) NOT NULL, TIPO varchar2(20) NOT NULL, DESCRIPCION varchar2(255), PRIMARY KEY (ID));
CREATE TABLE ACTIVO (ID number(19) NOT NULL, VALOR number(10) NOT NULL, TIPO_ACTIVO_ID number(2) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE CONTRATO (ID number(19) NOT NULL, FECHA_INICIO date NOT NULL, FECHA_EXPIRACION date NOT NULL, MENSUALIDAD number(10) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE TIPO_CONTACTO (ID number(2) NOT NULL, TIPO varchar2(20) NOT NULL, DESCRIPCION varchar2(255), PRIMARY KEY (ID));
CREATE TABLE DATO_CONTACTO (ID number(19) NOT NULL, DATO_VALOR varchar2(255) NOT NULL, TIPO_CONTACTO_ID number(2) NOT NULL, SOCIO_ID number(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE SOCIO (ID number(19) NOT NULL, NACIONALIDAD_ID number(3), NOMBRE varchar2(50) NOT NULL, APELLIDO varchar2(255) NOT NULL, FECHA_NACIMIENTO date NOT NULL, DERECHO_ASIENTO number(1) NOT NULL, CONTRATO_ID number(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE TIPO_PERSONAL (ID number(3) NOT NULL, TIPO varchar2(20) NOT NULL UNIQUE, DESCRIPCION varchar2(255), PRIMARY KEY (ID));
CREATE TABLE NACIONALIDAD (ID number(3) NOT NULL, PAIS varchar2(50) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE PERSONAL (ID number(19) NOT NULL, NOMBRE varchar2(50) NOT NULL, APELLIDO varchar2(50) NOT NULL, FECHA_NACIMIENTO date NOT NULL, CONTRATADO number(1) NOT NULL, VALOR_BASE number(10), TIPO_PERSONAL_ID number(3) NOT NULL, NACIONALIDAD_ID number(3) NOT NULL, CONTRATO_ID number(19), PRIMARY KEY (ID));
ALTER TABLE PASIVO ADD CONSTRAINT FKPASIVO826210 FOREIGN KEY (ESTADO_PASIVO_ID) REFERENCES ESTADO_PASIVO (ID);
ALTER TABLE ACTIVO ADD CONSTRAINT FKACTIVO296738 FOREIGN KEY (TIPO_ACTIVO_ID) REFERENCES TIPO_ACTIVO (ID);
ALTER TABLE SOCIO ADD CONSTRAINT FKSOCIO861365 FOREIGN KEY (CONTRATO_ID) REFERENCES CONTRATO (ID);
ALTER TABLE PERSONAL ADD CONSTRAINT FKPERSONAL581091 FOREIGN KEY (CONTRATO_ID) REFERENCES CONTRATO (ID);
ALTER TABLE DATO_CONTACTO ADD CONSTRAINT FKDATO_CONTA619761 FOREIGN KEY (SOCIO_ID) REFERENCES SOCIO (ID);
ALTER TABLE DATO_CONTACTO ADD CONSTRAINT FKDATO_CONTA253513 FOREIGN KEY (TIPO_CONTACTO_ID) REFERENCES TIPO_CONTACTO (ID);
ALTER TABLE SOCIO ADD CONSTRAINT FKSOCIO290601 FOREIGN KEY (NACIONALIDAD_ID) REFERENCES NACIONALIDAD (ID);
ALTER TABLE PERSONAL ADD CONSTRAINT FKPERSONAL429124 FOREIGN KEY (NACIONALIDAD_ID) REFERENCES NACIONALIDAD (ID);
ALTER TABLE PERSONAL ADD CONSTRAINT FKPERSONAL193013 FOREIGN KEY (TIPO_PERSONAL_ID) REFERENCES TIPO_PERSONAL (ID);

