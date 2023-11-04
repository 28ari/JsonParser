package Tokens;

import Beans.Token;
import java.util.List;

public interface iToken {
     Token getTokenType();
     List<Token> getNextValidTokens();
}
