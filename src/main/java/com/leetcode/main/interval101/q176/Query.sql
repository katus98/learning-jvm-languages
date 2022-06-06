with temp as (select id
              from Employee
              where salary = (select max(salary)
                              from Employee))
select max(salary) as SecondHighestSalary
from Employee
where id not in (select id from temp);

select max(salary) as SecondHighestSalary
from Employee
where salary <> (select max(salary) from Employee);

select ifnull(max(salary), null) as SecondHighestSalary
from Employee
where salary <> (select max(salary) from Employee);