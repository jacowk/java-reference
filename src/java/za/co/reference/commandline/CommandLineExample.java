package za.co.reference.commandline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineExample{
	
	public static void main(String[] args){
		Options options = new Options();
		Option optionA = new Option("a", true, "Test a");
		optionA.setArgName("a");
		options.addOption(optionA);
		Option optionB = new Option("b", true, "Test b");
		optionB.setArgName("b");
		options.addOption(optionB);
		CommandLineParser parser = new GnuParser();
		HelpFormatter helpFormatter = new HelpFormatter();
		CommandLine commandLine;
		try{
			if (args.length == 0){
	            throw new Exception("Invalid number of arguments specified.");
	        }
	        commandLine = parser.parse(options, args, true);
	        if (!commandLine.hasOption("a")){
	            throw new Exception("Option A not specified");
	        }
	        if (!commandLine.hasOption("b")){
	            throw new Exception("Option B not specified");
	        }
	        String optionValueA = commandLine.getOptionValue("a");
	        String optionValueB = commandLine.getOptionValue("b");
	        System.out.println("optionValueA = " + optionValueA);
	        System.out.println("optionValueB = " + optionValueB);
		}
		catch (Exception e){
			helpFormatter.printHelp("CommandLineExample", options);
		}
	}

}