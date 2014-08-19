// Passing cars

var A = [0,1,1,1,1,0,1,0,1,1,0];

function solution(A) {
    var count = 0;
    var incrementVal = 0;
    for(var i = 0; i < A.length; i++){
        if(A[i]===0) {
            incrementVal++;
        }
        else if(A[i]===1){
            count = count + incrementVal;
        }
        if(count > 1000000000) return -1;
    }
    return count;
}

console.log(solution(A));