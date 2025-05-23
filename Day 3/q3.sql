create table SalaryDetails (
    salary_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    effective_date DATE NOT NULL,
    end_date DATE,
    bonus_amount DECIMAL(10, 2),
    FOREIGN KEY (employee_id) references Employee(employee_id)
);

