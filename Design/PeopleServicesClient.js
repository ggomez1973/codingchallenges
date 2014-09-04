// PeopleServices Client
'use strict';

var PeopleService = require('./PeopleServices');

var service = new PeopleService("Jovenes");

service.getPersonById(1, function(error, result){
	if(error){
		console.log(error);
	} else {
		console.log(result);
	}
});