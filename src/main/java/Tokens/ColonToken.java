package Tokens;

import Beans.Token;

import java.util.Arrays;
import java.util.List;

public class ColonToken implements iToken {
    @Override
    public Token getTokenType() {
        return Token.COLON;
    }

    @Override
    public List<Token> getNextValidTokens() {
        return Arrays.asList(Token.VALUE);
    }
}
