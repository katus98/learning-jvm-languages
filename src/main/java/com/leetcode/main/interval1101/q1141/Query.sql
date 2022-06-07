with tmp as (select activity_date, user_id, count(*) as c
             from Activity
             where datediff('2019-07-27', activity_date) >= 0
               and datediff('2019-07-27', activity_date) < 30
             group by activity_date, user_id)
select activity_date as day, count(user_id) as active_users
from tmp
group by activity_date;

select activity_date as day, count(distinct user_id) as active_users
from Activity
where activity_date between '2019-06-28' and '2019-07-27'
group by activity_date;
