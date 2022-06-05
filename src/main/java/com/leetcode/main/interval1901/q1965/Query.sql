with t as (select Employees.employee_id, name, salary
           from Employees
                    left join Salaries on Employees.employee_id = Salaries.employee_id
           union
           select Salaries.employee_id, name, salary
           from Employees
                    right join Salaries on Employees.employee_id = Salaries.employee_id)
select employee_id
from t
where t.name is null
   or t.salary is null
order by employee_id;

select employee_id
from Employees
where employee_id not in (select employee_id from Salaries)
union
select employee_id
from Salaries
where employee_id not in (select employee_id from Employees)
order by employee_id;