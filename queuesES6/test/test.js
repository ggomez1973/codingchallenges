let expect = require('chai').expect;
const Queue = require('../queue_kata');
// Casos de prueba 
// Crear una pila (listo)
// Agregar un elemento (push)(listo)
// Sacar un elemento (pop)(listo)
// Retornar el minino 
let pila;

beforeEach(function(){
    pila = new Queue();
});
describe('FIFO tests', () => {
    it('Deberia crear una pila', function(){
        expect(pila).to.exist;
    });
    it('Deberia agregar un elemento a la pila', function(){
        pila.push(3);
        expect(pila.size()).to.be.equal(1);
    });
    it('Deberia sacar el elemto del tope', function(){
        pila.push(1);
        let result = pila.pop();
        expect(pila.size()).to.be.equal(0);
        expect(result).to.be.equal(1);
    });
    it('Deberia ser FIFO', function(){
        pila.push(1);
        pila.push(2);
        pila.push(3);
        let result = pila.pop();
        expect(result).to.be.equal(1);
    });
    it('Deberia dar error hacer pop de una pila vacia', function(){   
        expect(() =>  pila.pop()).to.throw();
    });

    xit('Deberia retornar el minimo valor de la pila sin afectala', function(){
        expect(true).to.be.false;
    });
});
