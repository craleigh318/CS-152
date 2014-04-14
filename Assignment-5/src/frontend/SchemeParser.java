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
     *
     * TO DO: Add other tokens to switch case.
     */
    public void parse() {
        Token currentToken = scanner.nextToken();
        Token.Type currentTokenType = currentToken.getType();
        String currentTokenName = currentToken.getName();
        symbolTable.addElement(currentTokenName, currentTokenType.toString());
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
            interCode.getLists().add(outerList);
        }
    }
}
