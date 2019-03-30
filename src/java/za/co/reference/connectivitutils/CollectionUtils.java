package za.co.reference.connectivitutils;

import java.util.List;

public class CollectionUtils {

	public String getSingleStringFromList(List<String> stringList){
		String list = "";
		for (String data: stringList){
			list += data;
		}
		return list;
	}
	
	public void outputList(List<String> list){
		for (String data: list){
			System.out.println(data);
		}
	}
	
	public List<String> copyNextListToPreviousList(List<String> previousList, List<String> nextList){
		for (String data: nextList){
			previousList.add(data);
		}
		return previousList;
	}
	
}
