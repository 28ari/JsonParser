package Service;

import Beans.Token;
import Tokens.ValueToken;
import Tokens.iToken;

import java.util.List;

public class SyntacticalAnalyser {
    public boolean isJsonSyntacticallyValid (List<iToken> tokenList) {
        int tokenListSize = tokenList.size();

        int openBracketCount = 0, closeBracketCount = 0;

        for (int i = 0; i < tokenListSize; i++) {
            iToken currentToken = tokenList.get(i);

            if (i != tokenListSize-1 && !currentToken.getNextValidTokens().contains(tokenList.get(i+1).getTokenType())) return false;
            if (!ValueToken.isValid(currentToken)) return false;
            if (openBracketCount < closeBracketCount) return false;

            if (currentToken.getTokenType().equals(Token.OPEN_BRACE)) openBracketCount++;
            else if (currentToken.getTokenType().equals(Token.CLOSE_BRACE)) closeBracketCount++;
        }

        return openBracketCount == closeBracketCount;
    }
}
