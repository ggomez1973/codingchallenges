// Linked List Length Codility PtrListLen

var LL = {
	value : 'A',
	next : {
		value : 'B',
		next : {
			value : 'C',
			next : null
		}	
	}
}

function counter(List){
	if(!List){
		return 0;
	} else {
		return 1 + counter(List.next);
	}
}

console.log(counter(LL));