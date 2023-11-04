package Service;

import Beans.Token;
import Tokens.*;
import Exception.InvalidJsonException;

import java.util.ArrayList;
import java.util.List;

public class LexerService {
    public List<iToken> tokenize(String json) throws InvalidJsonException {
        List<iToken> tokens = new ArrayList<>();

        int jsonLength = json.length();
        int ind = 0;

        while (ind < jsonLength) {
            if (json.charAt(ind) == ' ') continue;

            if (json.charAt(ind) == '{') tokens.add(new OpenBraceToken());
            else if (json.charAt(ind) == '}') tokens.add(new CloseBraceToken());
            else if (json.charAt(ind) == ':') tokens.add(new ColonToken());
            else if (json.charAt(ind) == ',') tokens.add(new CommaToken());
            else if (json.charAt(ind) == '"') {
                Token lastToken = tokens.get(tokens.size()-1).getTokenType();
                int endIndex = json.indexOf('"', ind+1);

                if (endIndex == -1) throw new InvalidJsonException();

                if (lastToken.equals(Token.COMMA) || lastToken.equals(Token.OPEN_BRACE)) tokens.add(new KeyToken());
                else if (tokens.get(tokens.size()-1).getTokenType().equals(Token.COLON)) tokens.add(new ValueToken(json.substring(ind, endIndex+1)));
                else throw new InvalidJsonException();

                ind = endIndex;
            } else {
                int endIndex = json.indexOf(',', ind);
                if (endIndex == -1) endIndex = json.indexOf('}', ind);

                if (endIndex == -1) throw new InvalidJsonException();

                tokens.add(new ValueToken(json.substring(ind, endIndex)));

                ind = endIndex-1;
            }

            ind++;
        }

        return tokens;
    }
}
