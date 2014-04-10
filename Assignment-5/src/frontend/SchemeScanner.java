package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * SchemeScanner scans a Scheme source file.
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public class SchemeScanner {

    private Scanner fileScanner;

    /**
     * @param schemeSource the Scheme source file to scan
     */
    public SchemeScanner(File schemeSource) throws FileNotFoundException {
        fileScanner = new Scanner(schemeSource);
    }

    /*
     * @return if char is parenthesis
     */
    boolean isParenthesis(char input) {
        return ((input == '(') || (input == ')'));
    }

    /*
     * @return if char is whitespace
     */
    boolean isWhitespace(char input) {
        return (input == ' ');
    }

    /*
     * @return if char is start of comment
     */
    boolean isComment(char input) {
        return (input == ';');
    }

    /**
     * Scans the next token of the file.
     *
     * @return the token as a String
     */
    public String nextToken() {
        return nextToken("");
    }

    /**
     * Scans the next token of the file.
     *
     * @return the token as a String
     */
    private String nextToken(String returnString) {
        //if not at end of file
        if (fileScanner.hasNext()) {
            char nextChar = fileScanner.next(".").charAt(0);
            if (isComment(nextChar)) {
                fileScanner.nextLine();
                return returnString;
            } else if (isParenthesis(nextChar)) {
                returnString.concat(Character.toString(nextChar));
                return returnString;
            } else {
                returnString.concat(Character.toString(nextChar));
                return nextToken(returnString);
            }
        } else {
            return returnString;
        }
    }
}
