SELECT COUNT(employee_id) AS TotalEmployees FROM Employee;

SELECT COUNT(DISTINCT job_title) AS UniqueJobTitles FROM Employee;

SELECT SUM(salary) AS TotalSalaries FROM Employee;

SELECT AVG(salary) AS AverageSalary FROM Employee;

SELECT MIN(salary) AS MinimumSalary FROM Employee;
SELECT MAX(salary) AS MaximumSalary FROM Employee;

SELECT department_id, COUNT(employee_id) AS NumberOfEmployees FROM Employee GROUP BY department_id;

SELECT job_title, AVG(salary) AS AverageSalaryPerJob FROM Employee GROUP BY job_title;

SELECT dept_id, SUM(credits) AS TotalCredits FROM Courses GROUP BY dept_id;


SELECT department_id, COUNT(employee_id) AS NumberOfEmployees
FROM Employee
GROUP BY department_id
HAVING COUNT(employee_id) > 10;