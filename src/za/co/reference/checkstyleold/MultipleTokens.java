package za.co.reference.checkstyleold;

import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class MultipleTokens extends Check{

	@Override
	public int[] getDefaultTokens(){
		return new int[]{
			TokenTypes.FOR_CONDITION, TokenTypes.LITERAL_WHILE, TokenTypes.DO_WHILE
		};
	}
	
}
