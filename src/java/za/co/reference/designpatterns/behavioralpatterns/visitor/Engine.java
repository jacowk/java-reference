package za.co.reference.designpatterns.behavioralpatterns.visitor;

public class Engine implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
