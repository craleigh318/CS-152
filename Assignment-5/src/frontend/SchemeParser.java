package frontend;

import intermediate.IntermediateCode;
import intermediate.SchemeList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * Parses a Scheme source file.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SchemeParser {

    IntermediateCode inter_Code;
    SchemeScanner2 scanner;
    Stack<SchemeList> currentTree;

    /**
     *
     * @param intCode intermediate code to which to compile
     * @param file Scheme source from which to read
     * @throws FileNotFoundException
     */
    public SchemeParser(IntermediateCode intCode, String file) {
        inter_Code = intCode;
        scanner = new SchemeScanner2(file);
        currentTree = new Stack<>();
    }

    /**
     * Parses the Scheme source.
     */
    public void parse() {
        Token currentToken = scanner.nextToken();
        Token.Type currentTokenType = currentToken.getType();
        String currentTokenName = currentToken.getName();
        System.out.println("Token Name " + currentTokenName + " Token Type " + currentTokenType);
        while (currentTokenType.equals(Token.Type.END_OF_INPUT)) {
            switch (currentTokenName) {
                case "(":
                    startList();
                    break;
                case ")":
                    endList();
                    break;
            }
        }
    }

    /**
     * Adds a token to the current innermost list.
     *
     * @param token the token to add
     */
    private void addToken(Token token) {
        currentTree.peek().add(token);
    }

    /**
     * Adds a Scheme list.
     */
    private void startList() {
        SchemeList newNode = new SchemeList();
        if (!currentTree.isEmpty()) {
            currentTree.peek().add(newNode);
        }
        currentTree.push(newNode);
    }

    /**
     * Ends a Scheme list.
     */
    private void endList() {
        SchemeList outerList = currentTree.pop();
        if (currentTree.empty()) {
            inter_Code.getLists().add(outerList);
        }
    }
}
