UPDATE studentDetails
SET email = 'new.roshmi.talukdar@uni.edu.in'
WHERE student_id = 2001 AND courseId = 1;

UPDATE studentDetails
SET enrollment_date = '2024-01-15'
WHERE courseId = 15;

UPDATE Employee
SET job_title = 'Senior HR Manager', designation = 'Sr. Manager'
WHERE employee_id = 1;

UPDATE Employee
SET salary = salary * 1.07
WHERE department_id = 101;

UPDATE SalaryDetails
SET bonus_amount = 3000.00
WHERE employee_id = 1 AND effective_date = '2021-07-10';

UPDATE SalaryDetails
SET end_date = '2023-12-31'
WHERE effective_date < '2020-01-01' AND end_date IS NULL;