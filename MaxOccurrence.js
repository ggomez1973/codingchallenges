// Encontrar el valor (ó valores, al menos uno) que mas se repite en un arreglo de números 

var arr = [10,20,10,40,10,40];

function getMaxOccurrence(A) {
    var map = {}; 
    var maxCount = 0; 
    var maxValue, value;
    for (var i=0; i<A.length; i++) {
        value = A[i];

        if (!map.hasOwnProperty(value)) {
            map[value] = 0;
        }
        ++map[value];

        if (map[value] > maxCount) {
            maxCount = map[value];
            maxValue = value;
        }
    }
    return maxValue;
}
console.log(getMaxOccurrence(arr));