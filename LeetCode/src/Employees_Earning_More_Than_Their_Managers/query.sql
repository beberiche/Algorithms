select b.name as Employee
from employee a
         join employee b
              on a.id = b.managerId and a.salary < b.salary