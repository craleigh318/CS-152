package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Scans a Scheme source by each token.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SchemeScanner {

    Scanner fileScanner;
    SymbolMapList symbolMapList;

    /**
     *
     * @param file the file to scan
     * @throws FileNotFoundException
     */
    public SchemeScanner(File file) throws FileNotFoundException {
        fileScanner = new Scanner(file);

    }

    /**
     *
     * @param file the string to scan
     */
    public SchemeScanner(String file) {
        fileScanner = new Scanner(file);

    }

    /**
     *
     * @return the next token in the source
     */
    public Token nextToken() {
        try {
            String currentToken = fileScanner.next();

            if (currentToken.equals("(")) {
                return new Token("(", Token.Type.SPECIAL_SYMBOL);
            } else if (currentToken.equals(")")) {
                return new Token(")", Token.Type.SPECIAL_SYMBOL);
            } else if (SymbolMapList.is_Key_Word(currentToken)) {
                return new Token(currentToken, Token.Type.KEYWORD);
            } else if (SymbolMapList.is_Procedure(currentToken)) {
                return new Token(currentToken, Token.Type.PROCEDURE);
            } else if (SymbolMapList.is_Special_Symbol(currentToken)) {
                return new Token(currentToken, Token.Type.SPECIAL_SYMBOL);
            } else if (currentToken.equals("'(")) {
                String tokenName = currentToken;
                while (!currentToken.equals(")")) {
                    currentToken = fileScanner.next();
                    tokenName += currentToken + " ";
                }
                int index = tokenName.lastIndexOf(" ) ");
                if (index != -1) {
                    tokenName = tokenName.substring(0, index) + ")";
                } else {
                    tokenName = tokenName.substring(0, tokenName.length() - 2) + ")";
                }
                return new Token(tokenName, Token.Type.IDENTIFIER);
            } else if (Character.isDigit(currentToken.charAt(0))) {
                if (currentToken.length() == 1) {
                    return new Token(currentToken, Token.Type.NUMBER);
                } else {
                    for (int i = 1; i < currentToken.length(); i++) {
                        if (!Character.isDigit(currentToken.charAt(i)) && currentToken.charAt(i) != '.') {
                            return new Token(currentToken, Token.Type.ERROR);
                        }
                    }
                }
            }
            return new Token(currentToken, Token.Type.IDENTIFIER);
        } catch (NoSuchElementException e) {
            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
        }
    }
}
