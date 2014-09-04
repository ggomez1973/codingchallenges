// Object Factories - Llamo a una función que me retorna lo que yo quiero. 
// La otra seria usar un contructor con prototype ó usar herencia prototipica pura.

function Controller(model, view) {
  view.update(model.value);
  return {
    up: function onUp(evt) {
      model.value++;
      view.update(model.value);
    },
    down: function onDown(evt) {
      model.value--;
      view.update(model.value);
    },
    save: function onSave(evt) {
      model.save();
      view.close();
    }
  };
}

var on = Controller(
  // Inline a mock model
  {
    value: 5,
    save: function save() {
      console.log("Saving value " + this.value + " somewhere");
    }
  },
  // Inline a mock view
  {
    update: function update(newValue) {
      console.log("View now has " + newValue);
    },
    close: function close() {
      console.log("Now hiding view");
    }
  }
);
setTimeout(on.up, 100);
setTimeout(on.down, 200);
setTimeout(on.save, 300);