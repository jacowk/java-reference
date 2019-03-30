package za.co.reference.checkstyle.source.com.checkstyle;

import java.util.Arrays;
import java.util.List;
import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public final class IllegalExceptionThrowsCheck extends Check{

	public List<String> illegalExceptionsInThrows;

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
			log(0, "An exception was found of type \"Exception\"");
		}
	}

	public void setIllegalExceptionsInThrows(String illegalExceptionThrowsStr){
        this. illegalExceptionsInThrows = Arrays.asList(illegalExceptionThrowsStr.split(","));
    }


}
