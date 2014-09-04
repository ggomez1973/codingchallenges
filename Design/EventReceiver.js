// EventReceiver/s

var AmigaConBeneficios = require('./EventEmitter');
var util = require('util');

var Yamel = new AmigaConBeneficios();
Yamel.emitir();
var start = Date.now();

Yamel.on('solaEnCasa', function myEventCb() {
  console.log('Yamel esta sola en su casa!', Date.now() - start);
});
Yamel.on('cocinandoAlgo', function myEventCb() {
  console.log('Yamel esta cocinando algo!', Date.now() - start);
});
Yamel.on('tenemosQueHablar', function myEventCb() {
  console.log('Yamel quiere hablar!', Date.now() - start);
});
