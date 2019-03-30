package za.co.reference.commons.commandline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineTest{
	
	public static void main(String[] args){
		Options options = new Options();
		Option option = new Option("testone", true, "Test One");
		options.addOption(option);
		option = new Option("testtwo", true, "Test Two");
		options.addOption(option);
		CommandLine commandLine = null;
		CommandLineParser parser = new GnuParser();
		try{
			commandLine = parser.parse(options, args, true);
			if (!commandLine.hasOption("testone")){
				throw new Exception("Please specify command line option testone");
			}
			String optionValue = commandLine.getOptionValue("testone");
			System.out.println("testone: " + optionValue);
			
			if (!commandLine.hasOption("testtwo")){
				throw new Exception("Please specify command line option testtwo");
			}
			optionValue = commandLine.getOptionValue("testtwo");
			System.out.println("testtwo: " + optionValue);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}