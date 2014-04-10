package frontend;

/**
 * SchemeParser parses Scheme code.
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public class SchemeParser
{

    public ListNode parse(SchemeScanner scanner)
    {
        return null;
    }

    protected class ListNode
    {
        String element;
        boolean isElement;
        ListNode leftChild;
        ListNode rightChild;

        public ListNode(String str, boolean isElement)
        {
            this.isElement = isElement;
            element = str;
        }

        public String toString()
        {
            return element;
        }
    }
}
