package za.co.reference.checkstyleold.customcheck;

import java.util.Arrays;
import java.util.List;
import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public final class IllegalExceptionThrowsCheck extends Check{

	@Override
	public int[] getDefaultTokens(){ //This method determines on which to call the check
		return new int[]{
			TokenTypes.LITERAL_THROWS
		};
	}
	
	@Override
	public void visitToken(DetailAST aDetailAST){ //This method is called when the TreeWalker walks through
												  //the tokens listed in getDefaultTokens()
		//DetailAST parameter contains information about the visited token
		DetailAST identDetailAST = aDetailAST.findFirstToken(TokenTypes.IDENT);
		if (illegalExceptionsInThrows.contains(identDetailAST.getText())){ //If an "Exception" exception is thrown
			//Do whatever
		}
	}
	
	public void setIllegalExceptionThrows(String illegalExceptionThrowsStr){
        this. illegalExceptionsInThrows = Arrays.asList(illegalExceptionThrowsStr.split(","));
    }

	
	private List<String> illegalExceptionsInThrows; //See the property name in checkstyle.xml

}
