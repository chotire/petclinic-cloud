DROP TABLE VISIT IF EXISTS;

CREATE TABLE VISIT (
  VISIT_ID INTEGER IDENTITY PRIMARY KEY,
  PET_ID INTEGER NOT NULL,
  VISIT_DATE DATE,
  DESCRIPTION VARCHAR(8192),
  CREATED_BY VARCHAR(36),
  CREATED_DATE TIMESTAMP,
  CREATED_IP VARCHAR(30),
  LAST_MODIFIED_BY VARCHAR(36),
  LAST_MODIFIED_DATE TIMESTAMP,
  LAST_MODIFIED_IP VARCHAR(30)
);

CREATE INDEX VISIT_PET_ID ON VISIT (PET_ID);