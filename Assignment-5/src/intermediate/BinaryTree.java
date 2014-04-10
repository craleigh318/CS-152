package intermediate;

import javax.sound.midi.SysexMessage;

/**
 * BinaryTree is the data structure that holds the code after if has been parsed
 * @author BrandonRossi
 */
public class BinaryTree
{
    //The root node
    Node root;
    public BinaryTree()
    {
        Node root = null;
    }

    /**
     * Adding a new element to the tree
     * @param element the element to be added to the tree
     */
    public void addNode(String element, boolean isElement)
    {
        Node newNode = new Node(element, isElement);
        //If the root is null then the new element is the first element in the tree
        if(root == null)
        {
            root = newNode;
        }
        //Otherwise add the new node to the tree
        else
        {
            Node currentNode = root;
            Node parent;

            while(true)
            {
                parent = currentNode;
                //Set the left child
                /*NOT SURE IF THIS IS RIGHT*/
                if(currentNode.leftChild == null)/*Some how have to determine how to set the child based on a key or the '(' and ')'*/
                {
                    currentNode = currentNode.leftChild;
                    if(currentNode == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                //set the right child
                else
                {
                    currentNode = currentNode.rightChild;
                    if(currentNode == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * If the next token is '(' then add a holder Node to the tree structure
     * This is a place holder that lets the program know that this Node is the
     * beginning of a list and the following is the contents of the list
     */
    public void addListNode()
    {
        this.addNode("(ListNode", false);
    }

    protected class Node
    {
        String element;
        boolean isElement;
        Node leftChild;
        Node rightChild;

        public Node(String str, boolean isElement)
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
