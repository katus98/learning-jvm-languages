update Salary
set sex = if(sex = 'f', 'm', 'f');

update Salary
set sex = (
    case sex when 'f' then 'm' else 'f' end
    );