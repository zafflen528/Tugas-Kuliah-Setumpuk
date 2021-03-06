package sem2.asd.praktikum.avl;
// Java program for deletion in AVL Tree

class Node
{
    int key, height;
    AvlNode left, right;

    Node(int d)
    {
        key = d;
        height = 1;
    }
}

public class AVLTree
{
    AvlNode root;

    // A utility function to get height of the tree
    int height(AvlNode N)
    {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    AvlNode rightRotate(AvlNode y)
    {
        AvlNode x = y.left;
        AvlNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    AvlNode leftRotate(AvlNode x)
    {
        AvlNode y = x.right;
        AvlNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(AvlNode N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    AvlNode insert(AvlNode avlNode, int key)
    {
        /* 1. Perform the normal BST rotation */
        if (avlNode == null)
            return (new AvlNode(key));

        if (key < avlNode.key)
            avlNode.left = insert(avlNode.left, key);
        else if (key > avlNode.key)
            avlNode.right = insert(avlNode.right, key);
        else // Equal keys not allowed
            return avlNode;

        /* 2. Update height of this ancestor node */
        avlNode.height = 1 + max(height(avlNode.left),
                height(avlNode.right));

		/* 3. Get the balance factor of this ancestor
		node to check whether this node became
		Wunbalanced */
        int balance = getBalance(avlNode);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < avlNode.left.key)
            return rightRotate(avlNode);

        // Right Right Case
        if (balance < -1 && key > avlNode.right.key)
            return leftRotate(avlNode);

        // Left Right Case
        if (balance > 1 && key > avlNode.left.key)
        {
            avlNode.left = leftRotate(avlNode.left);
            return rightRotate(avlNode);
        }

        // Right Left Case
        if (balance < -1 && key < avlNode.right.key)
        {
            avlNode.right = rightRotate(avlNode.right);
            return leftRotate(avlNode);
        }

        /* return the (unchanged) node pointer */
        return avlNode;
    }

    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    AvlNode minValueNode(AvlNode avlNode)
    {
        AvlNode current = avlNode;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    AvlNode deleteNode(AvlNode root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                AvlNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                AvlNode temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // A utility function to print preorder traversal of
    // the tree. The function also prints height of every
    // node
    void preOrder(AvlNode avlNode)
    {
        if (avlNode != null)
        {
            System.out.print(avlNode.key + " ");
            preOrder(avlNode.left);
            preOrder(avlNode.right);
        }
    }
}

// This code has been contributed by Mayank Jaiswal
