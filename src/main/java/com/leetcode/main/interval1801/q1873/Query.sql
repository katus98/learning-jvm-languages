select employee_id, salary as bonus
from Employees
where employee_id % 2 = 1
  and name not like 'M%'
union
select employee_id, 0 as bonus
from Employees
where employee_id % 2 = 0
   or name like 'M%'
order by employee_id;

select employee_id,
       if(employee_id % 2 = 1 and name not like 'M%', salary, 0) as bonus
from Employees;

select employee_id,
       if(employee_id % 2 = 1 && left(name, 1) <> 'M', salary, 0) as bonus
from Employees;