package za.co.reference.utility;

public class StringUtilities{
	
	public static boolean isUpperCase(char value){
		return Character.isUpperCase(value);
	}
	
	public static boolean isLowerCase(char value){
		return Character.isLowerCase(value);
	}
	
	public static String stripCommasInQuotes(String data){
		/*
		 * Strips the comma characters that are within quotes in a string like this, but keeps the quotes:
		 * 36,"00218","Allergy: Skin-prick tests: Skin-prick testing: Insect venom, latex and drugs",1
		 * changes to this:
		 * 36,"00218","Allergy: Skin-prick tests: Skin-prick testing: Insect venom latex and drugs",1
		 * */
		StringBuffer unprocessedStringBuffer = new StringBuffer(data);
		StringBuffer processedStringBuffer = new StringBuffer();
		boolean open = false;
		for (int i = 0; i < unprocessedStringBuffer.length(); i++){
			char character = unprocessedStringBuffer.charAt(i);
			if (character == '"'){
				if (open){
					open = false;
				}
				else{
					open = true;
				}
				processedStringBuffer.append(character);
			}
			else if (character == ','){
				if (!open){
					processedStringBuffer.append(character);
				}
			}
			else{
				processedStringBuffer.append(character);
			}
		}
		return processedStringBuffer.toString();
	}
	
	public static String stripLeadingCharacters(String value, char pad){
		StringBuffer paddedStringBuffer = new StringBuffer(value);
		boolean stillInPad = true;
		while (stillInPad){
			if (paddedStringBuffer.length() > 0){
				if (paddedStringBuffer.charAt(0) != pad){
					stillInPad = false;
					break;
				}
				else{
					paddedStringBuffer.deleteCharAt(0);
				}
			}
			else{
				break;
			}
		}
		return paddedStringBuffer.toString();
	}
	
	public static String stripTrailingCharacters(String value, char pad){
		StringBuffer paddedStringBuffer = new StringBuffer(value).reverse();
		boolean stillInPad = true;
		while (stillInPad){
			if (paddedStringBuffer.length() > 0){
				if (paddedStringBuffer.charAt(0) != pad){
					stillInPad = false;
					break;
				}
				else{
					paddedStringBuffer.deleteCharAt(0);
				}
			}
			else{
				break;
			}
		}
		return paddedStringBuffer.reverse().toString();
	}
	
	public static String stripLeadingAndTrailingCharacters(String value, char pad){
		return stripTrailingCharacters(stripLeadingCharacters(value, pad), pad);
	}
	
	public static String stripLeadingSpaces(String value){
		return stripLeadingCharacters(value, ' ');
	}
	
	public static String stripTrailingSpaces(String value){
		return stripTrailingCharacters(value, ' ');
	}
	
	public static String stripLeadingAndTrailingSpaces(String value){
		return stripTrailingCharacters(stripLeadingCharacters(value, ' '), ' ');
	}
	
	public static boolean isNullOrEmpty(String value){
		return ((value == null) || (value == ""));
	}
	
	public static String returnEmptyIfNull(String value){
		if (value == null){
			return "";
		}
		else{
			return value;
		}
	}
	
	public static void main(String[] args){
		System.out.println("removePadPrefix = " + StringUtilities.stripLeadingCharacters("0000003040", '0'));
		System.out.println("removePadPostfix = " + StringUtilities.stripTrailingCharacters("0304000000", '0'));
		System.out.println("isNullOrEmpty = " + StringUtilities.isNullOrEmpty(null));
		System.out.println("isNullOrEmpty = " + StringUtilities.isNullOrEmpty(""));
		System.out.println("isNullOrEmpty = " + StringUtilities.isNullOrEmpty("Test"));
		System.out.println("returnEmptyIfNull = " + StringUtilities.returnEmptyIfNull("Test"));
		System.out.println("returnEmptyIfNull = '" + StringUtilities.returnEmptyIfNull(null) + "'");
	}

}
