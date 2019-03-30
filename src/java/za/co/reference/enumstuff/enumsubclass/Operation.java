package za.co.reference.enumstuff.enumsubclass;

/*
 * from http://download.oracle.com/javase/1,5.0/docs/guide/language/enums.html
 * You can override the behaviour of an instance. This effectively give the instance a different sub-class of 
 * the enum with its own implementation.
 */
public enum Operation{
	
	PLUS   { double eval(double x, double y) { return x + y; } },
	MINUS  { double eval(double x, double y) { return x - y; } },
	TIMES  { double eval(double x, double y) { return x * y; } },
	DIVIDE { double eval(double x, double y) { return x / y; } };
	
	// Do arithmetic op represented by this constant
	abstract double eval(double x, double y);
	
}