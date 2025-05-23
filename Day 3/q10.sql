CREATE TABLE DemoTable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data VARCHAR(50)
);
INSERT INTO DemoTable (data) VALUES ('Row 1'), ('Row 2'), ('Row 3');
SELECT * FROM DemoTable;
TRUNCATE TABLE DemoTable;
SELECT * FROM DemoTable;
INSERT INTO DemoTable (data) VALUES ('New Row 1');
SELECT * FROM DemoTable;
DROP TABLE DemoTable;