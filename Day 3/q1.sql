create database University_DB;
use University_DB; 
create table Employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(50) NOT NULL,                  
    email VARCHAR(100) UNIQUE NOT NULL,         
    phone_number VARCHAR(20),                   
    hire_date DATE NOT NULL,                    
    job_title VARCHAR(50),                    
    salary DECIMAL(10, 2) NOT NULL,            
    department_id INT                         
);