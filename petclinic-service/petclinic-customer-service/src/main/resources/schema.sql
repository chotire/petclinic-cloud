DROP TABLE PET IF EXISTS;
--DROP TABLE TYPE IF EXISTS;
DROP TABLE OWNER IF EXISTS;

--CREATE TABLE TYPE (
--  TYPE_ID INTEGER IDENTITY PRIMARY KEY,
--  NAME VARCHAR(80),
--  CREATED_BY VARCHAR(36),
--  CREATED_DATE TIMESTAMP,
--  CREATED_IP VARCHAR(30),
--  LAST_MODIFIED_BY VARCHAR(36),
--  LAST_MODIFIED_DATE TIMESTAMP,
--  LAST_MODIFIED_IP VARCHAR(30)
--);
--CREATE INDEX TYPE_NAME ON TYPE (NAME);

CREATE TABLE OWNER (
  OWNER_ID INTEGER IDENTITY PRIMARY KEY,
  FIRST_NAME VARCHAR(30),
  LAST_NAME VARCHAR(30),
  ADDRESS VARCHAR(255),
  CITY VARCHAR(80),
  TELEPHONE VARCHAR(20),
  CREATED_BY VARCHAR(36),
  CREATED_DATE TIMESTAMP,
  CREATED_IP VARCHAR(30),
  LAST_MODIFIED_BY VARCHAR(36),
  LAST_MODIFIED_DATE TIMESTAMP,
  LAST_MODIFIED_IP VARCHAR(30)
);
CREATE INDEX OWNER_LAST_NAME ON OWNER (LAST_NAME);

CREATE TABLE PET (
  PET_ID INTEGER IDENTITY PRIMARY KEY,
  NAME VARCHAR(30),
  BIRTH_DATE DATE,
  TYPE VARCHAR(20) NOT NULL,
  OWNER_ID INTEGER NOT NULL,
  CREATED_BY VARCHAR(36),
  CREATED_DATE TIMESTAMP,
  CREATED_IP VARCHAR(30),
  LAST_MODIFIED_BY VARCHAR(36),
  LAST_MODIFIED_DATE TIMESTAMP,
  LAST_MODIFIED_IP VARCHAR(30)
);

ALTER TABLE PET ADD CONSTRAINT FK_PET_OWNER FOREIGN KEY (OWNER_ID) REFERENCES OWNER (OWNER_ID);
--ALTER TABLE PET ADD CONSTRAINT FK_PET_TYPE FOREIGN KEY (TYPE_ID) REFERENCES TYPE (TYPE_ID);
CREATE INDEX PET_NAME ON PET (NAME);
