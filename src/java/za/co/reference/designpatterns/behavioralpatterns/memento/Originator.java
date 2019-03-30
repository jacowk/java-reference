package za.co.reference.designpatterns.behavioralpatterns.memento;

public class Originator {
 
    private String state;
    /* lots of memory consumptive private data that is not necessary to define the
     * state and should thus not be saved. Hence the small memento object. */
 
    public void set(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }
 
    public Object saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }
 
    public void restoreFromMemento(Object m) {
        if (m instanceof Memento) {
            Memento memento = (Memento) m;
            state = memento.getSavedState();
            System.out.println("Originator: State after restoring from Memento: " + state);
        }
    }
 
    private static class Memento {
 
        private String state;
 
        public Memento(String stateToSave) {
            state = stateToSave;
        }
 
        public String getSavedState() {
            return state;
        }
 
    }
 
}
