package frontend;

import intermediate.IntermediateCode;
import intermediate.SchemeList;
import intermediate.SymbolTable;
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

    IntermediateCode interCode;
    SchemeScanner scanner;
    Stack<SchemeList> currentTree;
    SymbolTable symbolTable;

    /**
     *
     * @param intCode intermediate code to which to compile
     * @param source Scheme source file from which to read
     * @throws FileNotFoundException
     */
    public SchemeParser(IntermediateCode intCode, File source, SymbolTable symbolT) throws FileNotFoundException {
        interCode = intCode;
        symbolTable = symbolT;
        scanner = new SchemeScanner(source);
        currentTree = new Stack<>();

    }

    /**
     *
     * @param intCode intermediate code to which to compile
     * @param source Scheme source string from which to read
     */
    public SchemeParser(IntermediateCode intCode, String source, SymbolTable symbolT) {
        interCode = intCode;
        symbolTable = symbolT;
        scanner = new SchemeScanner(source);
        currentTree = new Stack<>();
    }

    /**
     * Parses the Scheme source.
     */
    public void parse() {
        Token currentToken = scanner.nextToken();
        Token.Type currentTokenType = currentToken.getType();
        String currentTokenName = currentToken.getName();

//        symbolTable.addElement(currentTokenName, "test");
        while (!currentTokenType.equals(Token.Type.END_OF_INPUT)) {

            if (currentTokenName.equals("(")) {
                startList();
            } else if (currentTokenName.equals(")")) {
                endList();
            } else if (!(currentTokenType.equals(Token.Type.ERROR) || currentTokenType.equals(Token.Type.SPECIAL_SYMBOL))) {
                addToken(currentToken);
                if (currentTokenType.equals(Token.Type.IDENTIFIER)) {
                    symbolTable.addElement(currentTokenName, null);
                }

            }
            currentToken = scanner.nextToken();
            currentTokenType = currentToken.getType();
            currentTokenName = currentToken.getName();
        }
    }

    /**
     * For more then 1 procedure in a file check that the closing Parentheses
     * are equal to the opening Parentheses
     *
     * @param leftPeren
     * @param rightPeren
     * @return
     */
    private boolean check_End_Of_Procedure(int leftPeren, int rightPeren) {
        return leftPeren == rightPeren;
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
            interCode.getLists().add(outerList);
        }
    }
}
