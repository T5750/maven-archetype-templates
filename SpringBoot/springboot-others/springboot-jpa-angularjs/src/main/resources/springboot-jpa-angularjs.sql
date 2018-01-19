create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   age  INTEGER NOT NULL,
   salary REAL NOT NULL,
   PRIMARY KEY (id)
);

/* Populate USER Table */
INSERT INTO APP_USER(name,age,salary)
VALUES ('Sam',30,70000);

INSERT INTO APP_USER(name,age,salary)
VALUES ('Tom',40,50000);

commit;