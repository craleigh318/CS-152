package frontend;

/**
 * SchemeParser parses Scheme code.
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public class SchemeParser
{

    SchemeScanner scanner;
    public SchemeParser(SchemeScanner scanner)
    {
        this.scanner = scanner;
    }

    public ListNode parse(String token)
    {
        ListNode treeStructure;
        String currentToken = scanner.nextToken();
        if(currentToken.equalsIgnoreCase(")"))
        {
            return treeStructure;
        }
        if(currentToken.equalsIgnoreCase("("))
        {
            currentToken = scanner.nextToken();
            treeStructure = new ListNode(null);
        }
        treeStructure.car = currentToken;
        return null;
    }


}
