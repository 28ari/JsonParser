package Tokens;

import Beans.Token;

import java.util.Arrays;
import java.util.List;

public class ValueToken implements iToken {
    private String valueString;
    public ValueToken(String valueString) {
        this.valueString = valueString;
    }

    public String getValueString() {
        return valueString;
    }

    @Override
    public Token getTokenType() {
        return Token.VALUE;
    }

    @Override
    public List<Token> getNextValidTokens() {
        return Arrays.asList(Token.CLOSE_BRACE, Token.COMMA);
    }

    public static boolean isValid(iToken token) {
        if (!token.getTokenType().equals(Token.VALUE)) return true;

        String valueString = ((ValueToken) token).getValueString();
        return valueString.equals("true")
                || valueString.equals("false")
                || valueString.equals("null")
                || (valueString.charAt(0) == '"' && valueString.charAt(valueString.length()-1) == '"')
                || isNumber(valueString);
    }

    private static boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

        return true;
    }
}
