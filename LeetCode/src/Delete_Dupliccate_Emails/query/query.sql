delete from person
where id not in (select min(id) from Person group by email)