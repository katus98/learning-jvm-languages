select Weather.id as id
from Weather as w1
         join Weather as w2 on datediff(w1.recordDate, w2.recordDate) = 1
where w1.Temperature > w2.Temperature;

# datediff(date1, date2) = date1 - date2 单位是天, 有正负
