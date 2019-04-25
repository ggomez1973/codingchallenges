Gamesys Time Travel REST API

General assumptions:
  - Any not empty String could be a valid place. "sed3332" could be a valid place somewhere in the universe.
  - Http status 422 (UNPROCESSABLE_ENTITY) was used for business rules exceptions.
  - Travel repository is IN MEMORY just to keep the implementation simple.
  - getTravelsForCharacter() is provided to validate saveTravelForCharacter()
  - I assumed that a PGI belongs to a Traveller that has travels hence the URI format.
  - TravelValueObject is used to prevent exposing domain objects to API clients.
  - API details can be view with Swagger at http://localhost:8080/swagger-ui.html#/
  
  

