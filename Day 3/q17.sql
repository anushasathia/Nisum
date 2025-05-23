CREATE TABLE Departments (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(100) UNIQUE NOT NULL,
    hod_name VARCHAR(100)
);

SHOW TABLES;
ALTER TABLE Studentdetails
ADD COLUMN dept_id INT;

ALTER TABLE Courses
ADD COLUMN dept_id INT;

ALTER TABLE Courses
ADD CONSTRAINT fk_dept_course
FOREIGN KEY (dept_id) REFERENCES Departments(dept_id);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) UNIQUE NOT NULL,
    credits DECIMAL(3,1) NOT NULL,
    dept_id INT,
    CONSTRAINT fk_dept_course FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

INSERT INTO Courses (course_name, credits, dept_id) VALUES
('Database Management', 4.0, 1),
('Programming in C++', 3.5, 2),
('Marketing Principles', 3.0, 3),
('Financial Accounting', 4.0, 4),
('Human Resources Basics', 3.0, 1);

INSERT INTO Departments (dept_id, dept_name, hod_name) VALUES
(1, 'Computer Science', 'Dr. Sharma'),
(2, 'Electrical Engineering', 'Dr. Singh'),
(3, 'Business Administration', 'Dr. Patel'),
(4, 'Arts and Humanities', 'Dr. Khan');

INSERT INTO Courses (course_name, credits, dept_id) VALUES
('Database Management', 4.0, 1),
('Programming in C++', 3.5, 2),
('Marketing Principles', 3.0, 3),
('Financial Accounting', 4.0, 4),
('Human Resources Basics', 3.0, 1);

ALTER TABLE studentDetails
ADD COLUMN dept_id INT;

ALTER TABLE studentDetails
ADD CONSTRAINT fk_dept_student
FOREIGN KEY (dept_id) REFERENCES Departments(dept_id);

ALTER TABLE Courses
ADD COLUMN dept_id INT;

ALTER TABLE Courses
ADD CONSTRAINT fk_dept_course
FOREIGN KEY (dept_id) REFERENCES Departments(dept_id);

CREATE TABLE CourseEnrollments (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date DATE NOT NULL,
    grade VARCHAR(2),
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_student_enrollment FOREIGN KEY (student_id) REFERENCES studentDetails(student_id), -- Corrected table name
    CONSTRAINT fk_course_enrollment FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);