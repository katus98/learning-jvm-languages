with t1 as (select min(id) as id from Person group by email)
delete
from Person
where id not in (select id from t1);

delete p1
from Person p1,
     Person p2
where p1.Email = p2.Email
  and p1.Id > p2.Id;
