with tmp as (select stock_name, operation, sum(price) as p
             from Stocks
             group by stock_name, operation),
     s as (select stock_name, p as sell
           from tmp
           where operation = 'Sell'),
     b as (select stock_name, p as buy
           from tmp
           where operation = 'Buy')
select stock_name, sell - buy as capital_gain_loss
from s
         join b on s.stock_name = b.stock_name;

select stock_name,
       sum(case
               when operation = 'Buy' then -price
               else price end) as 'capital_gain_loss'
from Stocks
group by stock_name;

select stock_name, sum(if(operation = 'Buy', -price, price)) as 'capital_gain_loss'
from Stocks
group by stock_name;