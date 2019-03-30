package za.co.reference.test.classloading;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

public class LoadOne{

	public static void main(String[] args) throws MalformedURLException{
		LoadOne loadOne = new LoadOne();
		List<File> jars = loadOne.listJarFiles(loadOne);
		URL[] jarUrls = new URL[jars.size()];
		for (int i = 0; i < jars.size(); i++){
			jarUrls[i] = jars.get(i).toURI().toURL();
		}
		ClassLoader classLoader = new URLClassLoader(jarUrls);
		System.out.println("This is LoadOne calling LoadTwo:");
		LoadTwo loadTwo = new LoadTwo();
		loadTwo.output();
	}
	
	private List<File> listJarFiles(LoadOne loadOne){
		File directory = new File("C:\\test\\lib");
		String[] entries = directory.list(loadOne.new JarFilenameFilter());
		List<File> jars = new LinkedList<File>();
		for (int i = 0; i < entries.length; i++){
			jars.add(new File(entries[i]));
		}
		return jars;
	}
	
	public class JarFilenameFilter implements FilenameFilter{

		@Override
		public boolean accept(File directory, String name){
			return name.endsWith("jar");
		}
		
	}
	
}