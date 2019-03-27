module.exports = class Queue {
    constructor(dataStore = []) {
        this.dataStore = dataStore;
      }
      push(element) {
        this.dataStore.push(element);
      }

      pop() {
        if(this.dataStore.length === 0) {
            throw new Error('empty queue');
        }
        return this.dataStore.shift();
      }

      size() {
        return this.dataStore.length;
      }
}