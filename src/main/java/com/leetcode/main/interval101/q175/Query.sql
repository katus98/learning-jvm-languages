select Person.FirstName as firstName, Person.LastName as lastName, Address.City as city, Address.State as state
from Person left outer join Address on Person.PersonId = Address.PersonId;