La idea de este ejemplo es implementar un API REST accesible con SSO,roles y permisos. Es un ejemplo "clásico" dentro de la arquitectura de aplicaciones.

* Gestion de identidad y control de acceso al API
* Caching
* Seguridad 

HATEOAS = hypermedia as the engine of application state

Voy a usar Node.js, Express, MongoDB(y Mongoose), Passport para OAuth y alguna otra cosa más seguramente.


NOTE: Don't add behavior to endPoints!!!!
	  PUT no se puede usar para hacer updates parciales. Segun la especificacion es idempotente. Si quisiera usar PUT para hacer un update ó create tengo que pasar TODOS los parametros (TODOS!) 

	  Usar UTC - ISO 8601 para la fechas!!
	  ?_body=false en los POST (retorno lo que mande, siempre que pueda, como payload. Si no quiero el cuerpo sobreescribo el comportamiento por defecto con _body=false)


	  Referenca Expansion (aka Entity Expansion, Link Expansion)
	  ?expand=directory // me trae lo que pedi más el directorio populado.

	  offset & limit para el paginado (pero que pasa cuando no la base de datos es NOSQL y no el offset y/o limit pueden no ser números enteros?)

	  first, previous, next son links!

	  Many-to-Many -> la 3era tabla va como entidad, ademas, cada entidad tiene 2 links mas, A -> B y AB

	  ETags para cache!