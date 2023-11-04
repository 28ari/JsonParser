package Tokens;

import Beans.Token;

import java.util.Arrays;
import java.util.List;

public class OpenBraceToken implements iToken {
    @Override
    public Token getTokenType() {
        return Token.OPEN_BRACE;
    }

    @Override
    public List<Token> getNextValidTokens() {
        return Arrays.asList(Token.CLOSE_BRACE, Token.KEY);
    }
}
