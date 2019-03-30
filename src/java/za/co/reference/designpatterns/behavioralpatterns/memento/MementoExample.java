package za.co.reference.designpatterns.behavioralpatterns.memento;

class MementoExample {
	 
    public static void main(String[] args) {
 
        Caretaker caretaker = new Caretaker();
 
        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        caretaker.addMemento(originator.saveToMemento());
        originator.set("State3");
        caretaker.addMemento(originator.saveToMemento());
        originator.set("State4");
 
        originator.restoreFromMemento(caretaker.getMemento(1));
 
    }
 
}