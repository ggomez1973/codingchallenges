// Coding Challenge
// Dado:
// ['Macri','Olmedo','Macri','Espert','Espert','Macri','Urtu','Espert']
// Retornar el que tiene mas votos. Si hay empate, retorna el ultimo en orden alfabetico.

const votes = ['Macri','Olmedo','Macri','Espert','Espert','Macri','Urtu','Espert'];
const pairs = votes.map((item)=> {
    return {key:item, value:1}; 
});
console.log(Object.values(votes));
const grupo = pairs.reduce((acc, currentValue) => {
    return acc + currentValue;
}, 0);

//console.log(pairs);
//console.log(grupo);

// Object.values(votes).map((value) => {
//     return value +1;
// });
// let mapa = new Map();
// votes.map((item) => {
//     // let pair = {key: item, value: 1};
//     return mapa.set(item, 1);
// });

// mapa.reduce((previousValue, currentValue, index, mapa) => {
//     return previousValue.value+currentValue.value;
// }, 0);
//console.log(pairs);


