package za.co.reference.log4j.moreexamples.example2;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JExample{
	
	public static void main(String[] args){
		PropertyConfigurator.configure("src\\za\\co\\javastudent\\log4j\\example2\\log4j.properties");
		CustomerOrder order1 = new CustomerOrder("Beer", 101, 20);
		CustomerOrder order2 = new CustomerOrder("Lemonade", 95, 10);
        CustomerOrder order3 = new CustomerOrder("Chocolate", 223, 5);
		
		Log4JExample example = new Log4JExample();
		example.processOrder(order1);
		example.processOrder(order2);
		example.processOrder(order3);
	}
	
	private void processOrder(CustomerOrder customerOrder){
		log.info(customerOrder.getProductName());
	}
	
	private static Logger log = Logger.getLogger("name");

}
