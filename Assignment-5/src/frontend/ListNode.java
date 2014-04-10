/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author BrandonRossi
 */
public class ListNode
{

    String element;
    ListNode car;
    ListNode cdr;
    
    public ListNode(String element)
    {
        this.element = element;
    }

    public String toString()
    {
        return element;
    }
}
