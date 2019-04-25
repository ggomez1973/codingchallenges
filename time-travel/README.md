Gamesys Time Travel REST API

General assumptions:
  - Any not empty String could be a valid place. "sed3332" could be a valid place somewhere in the universe.
  - Http status 422 (UNPROCESSABLE_ENTITY) was used for business rules exceptions.
  - Travel repository is an IN MEMORY representation just to keep the implementation simple.
  - getTravelsForCharacter() is provided to validate saveTravelForCharacter()
  - I assumed that a PGI belongs to a Traveller that has travels hence the URI format.
  - TravelValueObject is used to prevent exposing domain objects to API clients.
  - API details can be view with Swagger at http://localhost:8080/swagger-ui.html#/
  - Version number added to the URI (V1). V2 could be a reactive implementation with WebFlux.
  - I decided not implement HATEOAS because it was just 1 endpoint.
  
  
  

