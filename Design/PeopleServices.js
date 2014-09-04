// Un servicio cualquiera. Podria tener mas funciones. Creo que es una forma mas prolija que 
// la que ya teniamos. Ademas esta encapsulado en un closure.
'use strict';

function PeopleServices(db){
	if(!(this instanceof PeopleServices)){
		return new PeopleServices(db);
	}
	this.model = db;
};

PeopleServices.prototype.getPersonById = function(personId, callback){
	var result = { 
		'id': personId, 
		'model': this.model
	};
	return callback(null, result);
};

module.exports = PeopleServices;