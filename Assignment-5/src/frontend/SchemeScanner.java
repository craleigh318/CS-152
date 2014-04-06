package frontend;

import java.io.File;
import java.io.FileNotFoundException;
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

    /**
     * Scans the next token of the file.
     *
     * @return the token as a String
     */
    public String nextToken() {
        throw new UnsupportedOperationException();
    }
}
