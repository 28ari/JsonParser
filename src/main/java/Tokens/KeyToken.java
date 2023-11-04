package Tokens;

import Beans.Token;

import java.util.Collections;
import java.util.List;

public class KeyToken implements iToken {

    @Override
    public Token getTokenType() {
        return Token.KEY;
    }

    @Override
    public List<Token> getNextValidTokens() {
        return Collections.singletonList(Token.COLON);
    }
}
