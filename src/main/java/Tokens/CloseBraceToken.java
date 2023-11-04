package Tokens;

import Beans.Token;

import java.util.ArrayList;
import java.util.List;

public class CloseBraceToken implements iToken {
    @Override
    public Token getTokenType() {
        return Token.CLOSE_BRACE;
    }

    @Override
    public List<Token> getNextValidTokens() {
        return new ArrayList<>();
    }
}