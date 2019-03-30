package za.co.reference.designpatterns.behavioralpatterns.visitor;

public interface CarElement {
    void accept(CarElementVisitor visitor); // CarElements have to provide accept().
}
