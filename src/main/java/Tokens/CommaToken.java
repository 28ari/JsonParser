package Tokens;

import Beans.Token;

import java.util.Collections;
import java.util.List;

public class CommaToken implements iToken {
    @Override
    public Token getTokenType() {
        return Token.COMMA;
    }

    @Override
    public List<Token> getNextValidTokens() {
        return Collections.singletonList(Token.KEY);
    }
}
