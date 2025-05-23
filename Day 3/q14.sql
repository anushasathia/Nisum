UPDATE Course
SET credits = 4.5
WHERE course_id = 1;

UPDATE Course
SET credits = credits + 0.5
WHERE credits < 3.5;

DELETE FROM SalaryDetails
WHERE employee_id = 5 AND effective_date = '2022-02-01';

DELETE FROM SalaryDetails
WHERE bonus_amount IS NOT NULL;

DELETE FROM studentDetails
WHERE student_id = 2001 AND courseId = 3;

DELETE FROM studentDetails
WHERE student_id IN (2044, 2045);

DELETE FROM Employee
WHERE employee_id = 5;

DELETE FROM Employee
WHERE department_id = 104;

DELETE FROM Course
WHERE course_id = 40;

DELETE FROM Course
WHERE credits < 2.0;