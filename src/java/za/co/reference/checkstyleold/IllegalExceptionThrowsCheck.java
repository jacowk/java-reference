package za.co.reference.checkstyleold;

import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class IllegalExceptionThrowsCheck extends Check{

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
		if (identDetailAST.getText().equals("Exception")){ //If an "Exception" exception is thrown
			log(aDetailAST, "Illegal Throws Clause -> " + identDetailAST.getText());
		}
	}

}
