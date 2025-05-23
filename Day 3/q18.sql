SELECT name FROM Employee;

SELECT employee_id, name, job_title FROM Employee;

SELECT * FROM Employee;

SELECT * FROM Employee WHERE salary > 80000.00;

SELECT * FROM Employee WHERE job_title = 'HR Manager';

SELECT name, salary FROM Employee ORDER BY salary ASC;

SELECT name, hire_date FROM Employee ORDER BY hire_date DESC;

SELECT employee_id, name, job_title FROM Employee LIMIT 5 OFFSET 10;

SELECT employee_id, amount, effective_date FROM SalaryDetails WHERE amount BETWEEN 70000.00 AND 90000.00;

SELECT employee_id, hire_date, job_title FROM Employee WHERE hire_date BETWEEN '2019-01-01' AND '2020-12-31';
SELECT employee_id, name, department_id FROM Employee WHERE department_id IN (101, 105);

SELECT course_name FROM Courses WHERE course_name LIKE 'S%';

SELECT course_name FROM Courses WHERE course_name LIKE '%Data%';
