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
    private char[] specialTokenSet;

    /**
     * @param schemeSource the Scheme source file to scan
     */
    public SchemeScanner(File schemeSource) throws FileNotFoundException {
        fileScanner = new Scanner(schemeSource);
        specialTokenSet = initializeTokenSet();
    }

    /*
     * Adds all known tokens to token set.
     */
    private char[] initializeTokenSet() {
        char[] newTokenSet = {'(', ')', '\'', ' '};
        return newTokenSet;
    }

    private boolean isSpecialToken(char token) {
        return (Arrays.binarySearch(specialTokenSet, token) >= 0);
    }

    /**
     * Scans the next token of the file.
     *
     * @return the token as a String
     */
    public String nextToken() {
        //if not at end of file
        if (fileScanner.hasNext()) {
            char nextChar = fileScanner.next(".").charAt(0);
            //if comment
            if (nextChar == ';') {
                fileScanner.nextLine();
                return nextToken();
            } //if special token
            else if (isSpecialToken(nextChar)) {
                return Character.toString(nextChar);
            } else {
                String returnString = Character.toString(nextChar);
                while (fileScanner.hasNext("\\w")) {
                    returnString = returnString.concat(fileScanner.next("."));
                }
                return returnString;
            }
        } else {
            return null;
        }
    }
}
