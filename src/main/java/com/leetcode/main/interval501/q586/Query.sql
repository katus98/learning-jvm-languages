with tmp as (select customer_number, count(order_number) as count_order
             from Orders
             group by customer_number)
select customer_number
from tmp
where count_order = (select max(count_order) from tmp);