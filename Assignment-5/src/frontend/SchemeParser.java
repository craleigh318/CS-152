package frontend;

import intermediate.IntermediateCode;
import intermediate.Node;
import intermediate.Tree;
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
    Stack<Tree> currentTree;

    public SchemeParser(IntermediateCode intCode, File file) throws FileNotFoundException {
        inter_Code = intCode;
        scanner = new SchemeScanner2(file);
        currentTree = null;
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
        if (currentTree == null) {
            currentTree = new Stack<>();
        } else {
            currentTree.push(new Tree());
        }
    }

    /**
     * Ends a Scheme list.
     */
    private void endList() {
        if (currentTree.empty()) {
            inter_Code.getTrees().add(currentTree.elementAt(0));
        } else {
            currentTree.pop();
        }
    }

    private Node buildTree() {
        return null;
    }
}
