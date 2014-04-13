package frontend;

import intermediate.IntermediateCode;
import intermediate.SchemeList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SchemeParser {

    IntermediateCode inter_Code;
    SchemeScanner2 scanner;
    Stack<SchemeList> currentTree;

    public SchemeParser(IntermediateCode intCode, File file) throws FileNotFoundException {
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
