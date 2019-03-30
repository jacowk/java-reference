package za.co.reference.binaryhex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Convert{
	
	public static void main(String[] args){
		Convert temp = new Convert();
		
		String hex = "476f6420756e6465727374616e647320757320616c6c2c206e6f206d617474657220686f7720646966666572656e74207765206172652e";
//		temp.hexToString(hex);
		
		String str = "This is a test string";
//		temp.stringToHex(str);
		
//		String binary = "011101000110100001100101001000000111010001101001011011010110010100100000011101110110010100100000011010000110000101110110011001010010000001110011011100000110010101101110011101000010000001101111011011100010000001110100011010000110100101110011001000000110010101100001011100100111010001101000001000000110100101110011001000000110111001101111011101000010000001100101011101100110010101101110001000000110001101101100011011110111001101100101001000000111010001101111001000000111011101101000011000010111010000100000011101110110010100100000011000010111001001100101001000000110011101101111011010010110111001100111001000000111010001101111001000000111001101110000011001010110111001100100001011100010111000101110";
//		String binary = "01001100010011110100110000100000010000100101001001001111001011100010000001000101011010110010000001110111011011110110111001100100011001010111001000100000011010000110111101100101011101100110010101100101011011000010000001101101011001010110111001110011011001010010000001100111011000010110000101101110001000000111011001100101011100100111001101110100011000010110000101101110001000000111011101100001011101000010000001101010011110010010000001110100011100100111100100100000011100110110010100101110001011100010000001101000011001010010000001101000011001010010111000100000010011010110000101100001011100100010000001101101011011110110010101101110011010010110010100100000011101110110111101110010011100100111100100100000011011100110100101100101001011100010111000100000011010100110111101110101001000000100011101110010011011110110111101110100001000000110001001101111011001010111010000100000011101100110010101110010011100110111010001100001011000010110111000100001";
//		String binary = "011011000110111101101100";
		String binary = "011010010110111000100000011001010111010001100101011100100110111001101001011101000111100100100000001110110010110100101001";
		temp.binaryToString(binary);
		
		String str2 = "in eternity ;-)";
//		String str2 = "Hou nou op om my uit die werk uit te hou manne";
//		temp.stringToBinary(str2);
	}
	
	private void hexToString(String hex){
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < hex.length() - 1; i += 2 ){
	      //grab the hex in pairs
	      String output = hex.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      stringBuilder.append((char) decimal);
	      temp.append(decimal);
	  }
	  System.out.println(stringBuilder.toString());
	  writeToFile(stringBuilder.toString());
	}
	
	private void stringToHex(String str){
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for(int i = 0; i < chars.length; i++){
			hex.append(Integer.toHexString((int)chars[i]) + " ");
		}
		System.out.println(hex.toString());
		writeToFile(hex.toString());
	}
	
	private void binaryToString(String binary){
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < binary.length() - 1; i += 8 ){
			try{
				//grab the binary in pairs
			      String output = binary.substring(i, (i + 8));
			      //convert binary to decimal
			      int decimal = Integer.parseInt(output, 2);
			      //convert the decimal to character
			      stringBuilder.append(Character.toString((char) decimal));
			      temp.append(decimal);
			}
			catch (Exception e){
				e.printStackTrace();
			}
	  }
	  System.out.println(stringBuilder.toString());
	  writeToFile(stringBuilder.toString());
	}
	
	private void stringToBinary(String str){
		char[] chars = str.toCharArray();
		StringBuffer binary = new StringBuffer();
		for(int i = 0; i < chars.length; i++){
//			binary.append(Integer.toBinaryString((int) chars[i]) + " ");
//			binary.append(Integer.toBinaryString(chars[i]) + " ");
			binary.append(padBefore('0', 8, Integer.toBinaryString(chars[i])));
		}
		System.out.println(binary.toString());
		writeToFile(binary.toString());
	}
	
	private void writeToFile(String data){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Output.txt", true));
			out.write(data);
			out.newLine();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String padBefore(char padValue, int stringlimit, String string){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < (stringlimit - string.length()); i++){
			stringBuffer.append(padValue);
		}
		stringBuffer.append(string);
		return stringBuffer.toString();
	}
	
}