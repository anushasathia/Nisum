SELECT name, salary
FROM Employee
WHERE salary > (SELECT AVG(salary) FROM Employee);

SELECT s.student_id, s.student_name
FROM studentDetails s
WHERE s.dept_id IN (SELECT d.dept_id FROM Departments d WHERE d.dept_name = 'Computer Science');

SELECT d.dept_name
FROM Departments d
WHERE EXISTS (SELECT 1 FROM Employee e WHERE e.department_id = d.dept_id);

SELECT
    e.name,
    (SELECT d.dept_name FROM Departments d WHERE d.dept_id = e.department_id) AS DepartmentName
FROM Employee e;

SELECT E.name, D.dept_name
FROM Employee E
INNER JOIN Departments D ON E.department_id = D.dept_id

use University_DB; 
use University_DB; 

SELECT E.name, D.dept_name
FROM Employee E
INNER JOIN Departments D ON E.department_id = D.dept_id

SELECT E.name, E.job_title, D.dept_name
FROM Employee E
LEFT JOIN Departments D ON E.department_id = D.dept_id;

SELECT D.dept_name, C.course_name
FROM Departments D
LEFT JOIN Courses C ON D.dept_id = C.dept_id;

SELECT C.course_name, D.dept_name
FROM Courses C
RIGHT JOIN Departments D ON C.dept_id = D.dept_id;

SELECT E.name, D.dept_name FROM Employee E LEFT JOIN Departments D ON E.department_id = D.dept_id
UNION SELECT E.name, D.dept_name FROM Employee E RIGHT JOIN Departments D ON E.department_id = D.dept_id
WHERE E.employee_id IS NULL;

SELECT E.name, C.course_name
FROM Employee E
CROSS JOIN Courses C
LIMIT 10;

SELECT
    E1.name AS Employee1,
    E2.name AS Employee2,
    D.dept_name
FROM Employee E1
INNER JOIN Employee E2 ON E1.department_id = E2.department_id AND E1.employee_id <> E2.employee_id
INNER JOIN Departments D ON E1.department_id = D.dept_id
ORDER BY D.dept_name, E1.name, E2.name;

CREATE TABLE Students (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DateOfBirth DATE,
    Email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO Students (FirstName, LastName, DateOfBirth, Email) VALUES
('Priya', 'Sharma', '2000-01-15', 'priya.sharma@example.com'),
('Rahul', 'Singh', '1999-03-22', 'rahul.singh@example.com'),
('Ananya', 'Gupta', '2001-07-01', 'ananya.g@example.com'),
('Vikram', 'Yadav', '2000-11-11', 'vikram.y@example.com'),
('Sneha', 'Reddy', '1998-05-30', 'sneha.r@example.com'),
('Arjun', 'Kumar', '2002-02-14', 'arjun.k@example.com'),
('Ishita', 'Patel', '1999-09-05', 'ishita.p@example.com'),
('Karthik', 'Rao', '2001-04-19', 'karthik.r@example.com'),
('Deepa', 'Verma', '2000-08-25', 'deepa.v@example.com'),
('Siddharth', 'Jain', '1998-12-03', 'siddharth.j@example.com'),
('Meera', 'Chopra', '2002-06-10', 'meera.c@example.com'),
('Rohan', 'Das', '2000-02-28', 'rohan.d@example.com'),
('Nisha', 'Mehta', '1999-10-17', 'nisha.m@example.com'),
('Vivek', 'Malhotra', '2001-01-08', 'vivek.m@example.com'),
('Shreya', 'Saxena', '1998-07-07', 'shreya.s@example.com'),
('Aditya', 'Sharma', '2002-03-12', 'aditya.sharma@example.com'),
('Pooja', 'Singh', '2000-04-01', 'pooja.s@example.com'),
('Gaurav', 'Gupta', '1999-11-20', 'gaurav.g@example.com'),
('Divya', 'Yadav', '2001-09-15', 'divya.y@example.com'),
('Akash', 'Reddy', '1998-06-01', 'akash.r@example.com'),
('Sonia', 'Kumar', '2002-01-20', 'sonia.k@example.com'),
('Harish', 'Patel', '2000-03-09', 'harish.p@example.com'),
('Kavita', 'Rao', '1999-07-14', 'kavita.r@example.com'),
('Manish', 'Verma', '2001-05-29', 'manish.v@example.com'),
('Ritika', 'Jain', '1998-09-10', 'ritika.j@example.com');

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100) UNIQUE NOT NULL,
    Credits DECIMAL(3,1) NOT NULL
);

CREATE TABLE AcademicCourses (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100) UNIQUE NOT NULL,
    Credits DECIMAL(3,1) NOT NULL,
    dept_id INT, 
    CONSTRAINT fk_dept_academic_course FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

INSERT INTO AcademicCourses (CourseName, Credits, dept_id) VALUES
('Data Science Fundamentals', 4.0, 1),
('Python Programming', 3.5, 1),
('Digital Marketing Strategies', 3.0, 3),
('Financial Management', 4.0, 3),
('Human Resource Management', 3.0, 4),
('Machine Learning Algorithms', 4.0, 1),
('Cloud Computing Essentials', 3.5, 1),
('Cyber Security Principles', 3.0, 1),
('Business Analytics', 4.0, 3),
('Web Development with React', 3.5, 1),
('Advanced Calculus', 4.0, 2),
('Physics for Engineers', 3.0, 2),
('Organic Chemistry', 3.5, 5),
('Biotechnology Concepts', 4.0, 5),
('Indian History & Culture', 3.0, 4),
('Environmental Studies', 3.0, 5),
('Sociology of India', 3.0, 4),
('Political Science', 3.0, 4),
('Economics of Development', 3.5, 3),
('Psychology Basics', 3.0, 4),
('Communication Skills', 2.0, 4),
('Yoga & Wellness', 1.5, 4),
('Classical Indian Dance', 2.5, 4),
('Sanskrit Literature', 3.0, 4),
('Vedic Mathematics', 2.5, 2);

INSERT INTO Departments (dept_id, dept_name, hod_name) VALUES
(1, 'Computer Science', 'Dr. Sharma'),
(2, 'Electrical Engineering', 'Dr. Singh'),
(3, 'Business Administration', 'Dr. Patel'),
(4, 'Arts and Humanities', 'Dr. Khan'),
(5, 'Life Sciences', 'Dr. Gupta')
ON DUPLICATE KEY UPDATE dept_name = VALUES(dept_name); -- Use UPSERT to avoid errors if some already exist

INSERT INTO AcademicCourses (CourseName, Credits, dept_id) VALUES
('Data Science Fundamentals', 4.0, 1),
('Python Programming', 3.5, 1),
('Digital Marketing Strategies', 3.0, 3),
('Financial Management', 4.0, 3),
('Human Resource Management', 3.0, 4),
('Machine Learning Algorithms', 4.0, 1),
('Cloud Computing Essentials', 3.5, 1),
('Cyber Security Principles', 3.0, 1),
('Business Analytics', 4.0, 3),
('Web Development with React', 3.5, 1),
('Advanced Calculus', 4.0, 2),
('Physics for Engineers', 3.0, 2),
('Organic Chemistry', 3.5, 5),
('Biotechnology Concepts', 4.0, 5),
('Indian History & Culture', 3.0, 4),
('Environmental Studies', 3.0, 5),
('Sociology of India', 3.0, 4),
('Political Science', 3.0, 4),
('Economics of Development', 3.5, 3),
('Psychology Basics', 3.0, 4),
('Communication Skills', 2.0, 4),
('Yoga & Wellness', 1.5, 4),
('Classical Indian Dance', 2.5, 4),
('Sanskrit Literature', 3.0, 4),
('Vedic Mathematics', 2.5, 2);

CREATE TABLE Enrollments (
    EnrollmentID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT NOT NULL,
    CourseID INT NOT NULL, 
    EnrollmentDate DATE NOT NULL,
    CONSTRAINT fk_student_enrollment FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    CONSTRAINT fk_academic_course_enrollment FOREIGN KEY (CourseID) REFERENCES AcademicCourses(CourseID)
);

CREATE TABLE Enrollments (
    EnrollmentID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT NOT NULL,
    CourseID INT NOT NULL,
    EnrollmentDate DATE NOT NULL,
    CONSTRAINT fk_enroll_student FOREIGN KEY (StudentID) REFERENCES Students(StudentID), -- Changed constraint name here
    CONSTRAINT fk_academic_course_enrollment FOREIGN KEY (CourseID) REFERENCES AcademicCourses(CourseID)
);

INSERT INTO Enrollments (StudentID, CourseID, EnrollmentDate) VALUES
(1, 1, '2023-09-01'),
(2, 2, '2023-09-01'),
(3, 3, '2023-09-01'),
(4, 4, '2023-09-01'),
(5, 5, '2023-09-01'),
(6, 6, '2023-09-05'),
(7, 7, '2023-09-05'),
(8, 8, '2023-09-05'),
(9, 9, '2023-09-05'),
(10, 10, '2023-09-05'),
(11, 11, '2023-09-10'),
(12, 12, '2023-09-10'),
(13, 13, '2023-09-10'),
(14, 14, '2023-09-10'),
(15, 15, '2023-09-10'),
(16, 16, '2023-09-15'),
(17, 17, '2023-09-15'),
(18, 18, '2023-09-15'),
(19, 19, '2023-09-15'),
(20, 20, '2023-09-15'),
(21, 21, '2023-09-20'),
(22, 22, '2023-09-20'),
(23, 23, '2023-09-20'),
(24, 24, '2023-09-20'),
(25, 25, '2023-09-20');

INSERT INTO Enrollments (StudentID, CourseID, EnrollmentDate) VALUES
(1, 1, '2023-09-01'),
(2, 2, '2023-09-01'),
(3, 3, '2023-09-01'),
(4, 4, '2023-09-01'),
(5, 5, '2023-09-01'),
(6, 6, '2023-09-05'),
(7, 7, '2023-09-05'),
(8, 8, '2023-09-05'),
(9, 9, '2023-09-05'),
(10, 10, '2023-09-05'),
(11, 11, '2023-09-10'),
(12, 12, '2023-09-10'),
(13, 13, '2023-09-10'),
(14, 14, '2023-09-10'),
(15, 15, '2023-09-10'),
(16, 16, '2023-09-15'),
(17, 17, '2023-09-15'),
(18, 18, '2023-09-15'),
(19, 19, '2023-09-15'),
(20, 20, '2023-09-15'),
(21, 21, '2023-09-20'),
(22, 22, '2023-09-20'),
(23, 23, '2023-09-20'),
(24, 24, '2023-09-20'),
(25, 25, '2023-09-20');

SELECT * FROM Students;

SELECT FirstName, Email FROM Students;

SELECT CourseName, Credits FROM AcademicCourses WHERE Credits = 4.0;

SELECT * FROM Students WHERE DateOfBirth > '2000-01-01';

SELECT *
FROM Students
WHERE FirstName LIKE 'J%';

SELECT AC.CourseName, COUNT(E.StudentID) AS NumberOfStudentsEnrolled
FROM AcademicCourses AC
JOIN Enrollments E ON AC.CourseID = E.CourseID
GROUP BY AC.CourseName
ORDER BY NumberOfStudentsEnrolled DESC;

SELECT S.FirstName, S.LastName, E.EnrollmentDate
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
ORDER BY S.LastName, S.FirstName, E.EnrollmentDate;

SELECT S.FirstName, S.LastName, S.Email
FROM Students S
JOIN Enrollments E ON S.StudentID = E.StudentID
WHERE E.CourseID = 102;

SELECT *
FROM Students
ORDER BY LastName ASC;

SELECT AVG(Credits) AS AverageCredits
FROM AcademicCourses;

SELECT CourseName
FROM AcademicCourses
WHERE CourseName LIKE '%Data%';

SELECT *
FROM Students
ORDER BY DateOfBirth DESC
LIMIT 1;

SELECT LastName, COUNT(StudentID) AS NumberOfStudents
FROM Students
GROUP BY LastName
HAVING COUNT(StudentID) > 1
ORDER BY NumberOfStudents DESC, LastName ASC;

SELECT FirstName, COUNT(StudentID) AS NumberOfStudents
FROM Students
GROUP BY FirstName
HAVING COUNT(StudentID) > 1
ORDER BY NumberOfStudents DESC, FirstName ASC;


