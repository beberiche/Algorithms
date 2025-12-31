select name as customers
from customers cs
         left join orders os on cs.id = os.customerId
where os.id is null