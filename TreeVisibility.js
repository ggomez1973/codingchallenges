// Fucking Visibility binary tree
// Get the number of visible nodes (Codility Test)

var T = {
	x : 5,
	l : {
		x: 10,
		l: null,
		r: {
			x:1,
			l:null,
			r:null
		}
	},
	r : {
		x:6,
		l:null,
		r:null
	}	
};

function solve(tree){
	if(!tree){
		return 0;
	} else {
		return solution(tree, tree.x);
	}
}
function solution(tree, root){
	if(!tree){
		return 0;
	} else {
		if(tree.x >= root){
			return 1 + solution(tree.l, root) + solution(tree.r, root);
		} else {
			return solution(tree.l, root) + solution(tree.r, root);
		}
	}
}

console.log(solve(T));
