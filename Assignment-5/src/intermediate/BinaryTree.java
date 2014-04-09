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
                if(/*NOT SURE IF THIS IS RIGHT*/currentNode.leftChild == null)/*Some how have to determine how to set the child based on a key or the '(' and ')'*/
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

    public void preOrderTraverse(Node currentNode)
    {
        if(currentNode != null)
        {
            /*
             * Need to have code for if the left child is not an element then open
             * '(' otherwise print the element and dont forget to close the ')'
             * Visit the root.
             *      If the left subtree is not an element node, open a set of parentheses.
             * Visit the left subtree.
             *      If the left subtree is a leaf, print its element.
             * Visit the right subtree.
             */
            if(!currentNode.leftChild.isElement)
            {
                System.out.print("(");
                if(currentNode.leftChild == null)
                {
                    System.out.println(currentNode.element);
                }
                preOrderTraverse(currentNode.leftChild);
                preOrderTraverse(currentNode.rightChild);
                System.out.println(")");
            }
        }
    }

    private class Node
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
