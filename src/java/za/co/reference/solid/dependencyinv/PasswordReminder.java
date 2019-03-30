package za.co.reference.solid.dependencyinv;

/**
 * Dependency Inversion Principle: Entities must depend on abstractions not on concretions. It states that the 
 * high level module must not depend on the low level module, but they should depend on abstractions.
 * Accomplish this by coding to interfaces.
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class PasswordReminder {

	private DatabaseConnection connection;
	
	public PasswordReminder(DatabaseConnection connection)
	{
		this.connection = connection;
	}
	
}
