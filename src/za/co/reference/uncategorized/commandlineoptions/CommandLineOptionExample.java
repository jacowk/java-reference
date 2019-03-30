//package za.co.reference.uncategorized.commandlineoptions;
//
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.GnuParser;
//import org.apache.commons.cli.HelpFormatter;
//import org.apache.commons.cli.Option;
//import org.apache.commons.cli.Options;
//
//public class CommandLineOptionExample{
//	
//	public static void main(String[] args){
//		Options options = new Options();
//		Option option = new Option("?", "help", false, "Display this help message.");
//		options.addOption(option);
//		option = new Option("cf", true, "Service Registry's configuration file name.");
//		option.setArgName("file");
//		options.addOption(option);
//		option = new Option("l", true, "Service Registry's logger name. ");
//		option.setArgName("name");
//		options.addOption(option);
//		option = new Option("lf", true, "Service Registry's log4j configuration file name. (Optional)");
//		option.setArgName("file");
//		options.addOption(option);
//		CommandLineParser parser = new GnuParser();
//		HelpFormatter helpFormatter = new HelpFormatter();
//		CommandLine commandLine;
////		Logger logger = null;
////		try{
////			if (args.length == 0){
////				throw new Exception("Invalid number of arguments specified.");
////			}
////			commandLine = parser.parse(options, args, true);
////			if (!commandLine.hasOption("cf")){
////				throw new Exception("Service's configuration file name not specified.");
////			}
////			if (!commandLine.hasOption("l")){
////				throw new Exception("Service Registry's logger name not specified.");
////			}
////			try{
////				if (commandLine.hasOption("lf")){
////					LoggerFactory.setConfigurationFile(commandLine.getOptionValue("lf"));	
////				}
////				logger = LoggerFactory.getLogger(commandLine.getOptionValue("l"));
////				ServiceRegistry serviceRegistry = new ServiceRegistryImpl(logger, new File(commandLine
////					.getOptionValue("cf")));
////			}
////			catch(Exception e){
////				if (logger != null){
////					logger.fatal(e.getMessage());
////				}
////				else{
////					System.out.println(e.getMessage());
////				}
////			}
////		}
////		catch(Exception e){
////			helpFormatter.printHelp("ServiceRegistry", options);
////			System.out.println(System.getProperty("line.separator") + e.getMessage());
////		}
//	}
//
//}
