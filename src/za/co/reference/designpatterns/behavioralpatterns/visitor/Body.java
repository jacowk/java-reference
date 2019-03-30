package za.co.reference.designpatterns.behavioralpatterns.visitor;

public class Body implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
