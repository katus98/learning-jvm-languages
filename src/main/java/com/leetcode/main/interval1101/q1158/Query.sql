with o as (select order_id, buyer_id from Orders where year(order_date) = 2019)
select user_id as buyer_id, join_date, count(order_id) as orders_in_2019
from Users
         left outer join o on Users.user_id = o.buyer_id
group by user_id;

select user_id as buyer_id, join_date, count(order_id) orders_in_2019
from Users
         left join Orders
                   on Users.user_id = Orders.buyer_id and year(Orders.order_date) = 2019
group by user_id;

# count() 默认只会统计字段不为null的数值