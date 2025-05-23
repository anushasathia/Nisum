create table Student (
    student_id INT PRIMARY KEY AUTO_INCREMENT, 
    student_name VARCHAR(50) NOT NULL,             
    email VARCHAR(100) UNIQUE NOT NULL,        
    date_of_birth DATE,                          
    major VARCHAR(100),                          
    enrollment_date DATE NOT NULL               
);
