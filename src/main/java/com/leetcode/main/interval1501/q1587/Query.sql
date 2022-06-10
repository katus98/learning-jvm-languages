select name, sum(amount) as balance
from Users join Transactions on Users.account = Transactions.account
group by Transactions.account, name
having sum(amount) > 10000;