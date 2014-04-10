package frontend;

/**
 * SchemeParser parses Scheme code.
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public class SchemeParser
{
    ListNode treeStructure;
    SchemeScanner scanner;
    public SchemeParser(SchemeScanner scanner)
    {
        this.scanner = scanner;
    }

    public ListNode parse(String token)
    {
        String currentToken = scanner.nextToken();
        if(currentToken.equalsIgnoreCase(")"))
        {
            return treeStructure;
        }
        if(currentToken.equalsIgnoreCase("("))
        {
            currentToken = scanner.nextToken();
            treeStructure = new ListNode();
        }
        treeStructure.car = currentToken;
        return null;
    }


}
