package frontend;

import intermediate.IntermediateCode;
import intermediate.Node;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SchemeParser {

    IntermediateCode inter_Code;
    SchemeScanner2 scanner;
    

    public SchemeParser(IntermediateCode intCode, File file) throws FileNotFoundException {
        inter_Code = intCode;
        scanner = new SchemeScanner2(file);
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

    private void startList() {
    }

    private void endList() {
    }

    public void setUpTree() {
        Node newTree = buildTree();
        inter_Code.getTree().setroot(temp);
    }

    private Node buildTree() {
        return null;
    }
}
