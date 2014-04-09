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
    private String[] tokenSet;

    /**
     * @param schemeSource the Scheme source file to scan
     */
    public SchemeScanner(File schemeSource) throws FileNotFoundException {
        fileScanner = new Scanner(schemeSource);
        tokenSet = initializeTokenSet();
    }

    /*
     * Adds all known tokens to token set.
     */
    private String[] initializeTokenSet() {
        String[] newTokenSet = {"(", "car", "cdr", ")"};
        return newTokenSet;
    }

    /**
     * Scans the next token of the file.
     *
     * @return the token as a String
     */
    public String nextToken() {
        //if not at end of file
        if (fileScanner.hasNext()) {
            String nextString = fileScanner.next();
            //if next string is a Scheme token
            if (Arrays.binarySearch(tokenSet, nextString) >= 0) {
                return nextString;
            } else {
                return nextToken();
            }
        } else {
            return null;
        }
    }
}
