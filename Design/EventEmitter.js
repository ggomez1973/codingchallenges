// No queda claro el proposito de este patrón

var EventEmitter = require('events').EventEmitter;
var util = require('util');

function AmigaConBeneficios(){
    if (!(this instanceof AmigaConBeneficios)){
      return new AmigaConBeneficios();
    }
};

util.inherits(AmigaConBeneficios, EventEmitter);

AmigaConBeneficios.prototype.emitir = function emitir(){
  EventEmitter.call(this);
  var self = this;
  setTimeout(function timeoutCb() {
    self.emit('solaEnCasa');
  }, 3000);
  setTimeout(function timeoutCb() {
    self.emit('cocinandoAlgo');
  }, 5000);
  setTimeout(function timeoutCb() {
    self.emit('tenemosQueHablar');
  }, 2000);
};

module.exports = AmigaConBeneficios; 




