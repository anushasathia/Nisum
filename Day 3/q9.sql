CREATE TABLE studentDetails (
    student_id INT NOT NULL,
    courseId INT NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    enrollment_date DATE NOT NULL,
    PRIMARY KEY (student_id, courseId)
);
