import Beans.Token;
import Service.LexerService;
import Exception.InvalidJsonException;
import Service.SyntacticalAnalyser;
import Tokens.iToken;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        String json;
        System.out.print("Give json : ");
        Scanner sc = new Scanner(System.in);
        json = sc.nextLine();
        boolean isValid = false;
        try {
            List<iToken> tokenList = new LexerService().tokenize(json);
            isValid = new SyntacticalAnalyser().isJsonSyntacticallyValid(tokenList);
        } catch (InvalidJsonException invalidJsonException) {
            System.out.println("invalid exception");
        }

        if (isValid) System.out.println("\nValid json");
        else System.out.println("\nInvalid json");
    }
}
