package intermediate;

/**
 *
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
    public void addNode(String element)
    {
        Node newNode = new Node(element);
        //If the root is null then the new element is the first element in the tree
        if(root == null)
        {
            root = newNode;
        }
        else//Otherwise add the new node to the tree
        {
            Node currentNode = root;
            Node parent;

            while(true)
            {
                parent = currentNode;
                //Set the left child
                if(/*Some how have to determine how to set the child based on a key or the '(' and ')'*/)
                {
                    currentNode = currentNode.leftChild;

                    if(currentNode == null)
                    {
                        parent.leftChild = newNode;
                        return
                    }
                }
                else//set the right child
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

    private class Node
    {
        String element;
        Node leftChild;
        Node rightChild;

        public Node(String str)
        {
            element = str;
        }

        public String toString()
        {
            return element;
        }
    }
}
