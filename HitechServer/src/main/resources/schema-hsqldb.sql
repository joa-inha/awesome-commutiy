use jpub;
CREATE OR REPLACE TABLE TBL_USER (
    uuid BINARY(16) NOT NULL PRIMARY KEY,
    id varchar(40) NOT NULL,
    username varchar(45) NOT NULL,
    password varchar(45) NOT NULL
);