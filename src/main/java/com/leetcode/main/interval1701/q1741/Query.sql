select event_day as day, emp_id, sum(t) as total_time
from (select emp_id, event_day, out_time - in_time as t
      from Employees) as t1
group by event_day, emp_id;

select event_day as day, emp_id, sum(out_time - in_time) as total_time
from Employees
group by event_day, emp_id;