with rt as (select id
            from tree
            where p_id is null)
select id, 'Root' as Type
from tree
where p_id is null
union
select id, 'Inner' as Type
from tree
where p_id is not null
  and id in (select distinct p_id from tree)
union
select id, 'Leaf' as Type
from tree
where id not in (select distinct p_id from tree where p_id is not null)
  and id not in (select id from rt);
# 使用not in的时候一定要确保子句里面没有null值

select id,
       case
           when t.p_id is null then 'Root'
           when t.p_id is not null and id in (select p_id from tree) then 'Inner'
           else 'Leaf' end as Type
from tree as t;
