package za.co.reference.connectivitutils;

public class StringUtils{

	public String stripCommaCharacters(String data){
    	StringBuffer currentStringBuffer = new StringBuffer(data);
    	StringBuffer strippedStringBuffer = new StringBuffer();
    	for (int i = 0; i < currentStringBuffer.length(); i++){
    		if (currentStringBuffer.charAt(i) != ','){
    			strippedStringBuffer.append(currentStringBuffer.charAt(i));
    		}
    	}
    	return strippedStringBuffer.toString();
    }
	
	public String stripLeadingAndTrailingWhiteSpace(String data){
		return data.trim();
	}
	
	public String padBefore(char padValue, int stringlimit, String string){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < (stringlimit - string.length()); i++){
			stringBuffer.append(padValue);
		}
		stringBuffer.append(string);
		return stringBuffer.toString();
	}
	
}