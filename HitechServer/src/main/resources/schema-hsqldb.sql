use jpub;
CREATE TABLE TBL_USER (
    uuid BINARY(16) NOT NULL,
    id varchar(40) NOT NULL  PRIMARY KEY,
    username varchar(45) NOT NULL,
    password varchar(45) NOT NULL
);

ALTER TABLE TBL_USER DROP PRIMARY KEY;
ALTER TABLE TBL_USER ADD PRIMARY KEY (id);

CREATE TABLE TBL_BOARD (
    idx int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id varchar(40) NOT NULL,
    title varchar(45) NOT NULL,
    type varchar(10) NOT NULL,
    content text NOT NULL,
    date date,
    FOREIGN KEY(id) REFERENCES TBL_USER(id)
);