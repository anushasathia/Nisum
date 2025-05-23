CREATE TABLE DemoTable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    quantity INT,
    price DECIMAL(10, 2)
);

INSERT INTO DemoTable (product_name, quantity, price) VALUES
('Laptop', 10, 1200.00),
('Mouse', 50, 25.00),
('Keyboard', 30, 75.00),
('Monitor', 15, 300.00),
('Webcam', 20, 50.00);

DELETE FROM DemoTable
WHERE id = 3;

DELETE FROM DemoTable
WHERE quantity < 25;

DELETE FROM DemoTable;

DROP TABLE DemoTable;