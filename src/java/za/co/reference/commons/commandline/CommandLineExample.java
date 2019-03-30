package za.co.reference.commons.commandline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineExample{

	public static void main(String[] args){
		Options options = new Options();
		Option option = new Option("t1", true, "Test One");
		option.setArgName("t1");
		options.addOption(option);
		option = new Option("t2", true, "Test Two");
		option.setArgName("t2");
		options.addOption(option);
		
		CommandLineParser parser = new GnuParser();
		CommandLine commandLine;
		try{
			commandLine = parser.parse(options, args, true);
			if (!commandLine.hasOption("t1")){
				throw new Exception("-t1 option not specified");
			}
			System.out.println("Option -t1 value: " + commandLine.getOptionValue("t1"));
			if (!commandLine.hasOption("t2")){
				throw new Exception("-t1 option not specified");
			}
			System.out.println("Option -t2 value: " + commandLine.getOptionValue("t2"));
		}
		catch (Exception pe){
			pe.printStackTrace();
		}
	}
	
}