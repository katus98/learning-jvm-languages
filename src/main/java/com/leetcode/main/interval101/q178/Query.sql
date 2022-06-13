select score,
       dense_rank() over (order by score desc) as 'rank'
from Scores;

select score,
       (select count(distinct score) from Scores where score >= s.score) as 'rank'
from Scores as s
order by score desc;