import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL.
 */
public class AVL<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private AVLNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary. This is as simple as calling the balance() method on the
     * current node, before returning it (assuming that your balance method
     * is written correctly from part 1 of this assignment).
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        root = addHelper(root, data);
    }

    /**
     * Private recursive helper method for add.
     * @param current The current node in the traversal.
     * @param data The data to add.
     * @return The root of the modified (and balanced) subtree.
     */
    private AVLNode<T> addHelper(AVLNode<T> current, T data) {
        // Base case: Found the spot to insert the new node.
        if (current == null) {
            size++;
            return new AVLNode<>(data);
        }

        int compare = data.compareTo(current.getData());

        if (compare < 0) {
            current.setLeft(addHelper(current.getLeft(), data));
        } else if (compare > 0) {
            current.setRight(addHelper(current.getRight(), data));
        }
        // If compare == 0, data is a duplicate, so we do nothing and just return.

        // THIS IS THE KEY AVL STEP: Balance the current node on the way back up.
        return balance(current);
    }


    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     *    simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     *    replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     *    replace the data, NOT predecessor. As a reminder, rotations can occur
     *    after removing the successor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary. This is as simple as calling the balance() method on the
     * current node, before returning it (assuming that your balance method
     * is written correctly from part 1 of this assignment).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If the data is null.
     * @throws java.util.NoSuchElementException   If the data is not found.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        AVLNode<T> dummy = new AVLNode<>(null);
        root = removeHelper(root, data, dummy);
        if (dummy.getData() == null) {
            throw new NoSuchElementException("Data is not in the tree.");
        }
        size--;
        return dummy.getData();
    }

    /**
     * Private recursive helper for remove.
     * @param current The current node in the traversal.
     * @param data The data to remove.
     * @param dummy A holder node to capture the data of the removed node.
     * @return The root of the modified (and balanced) subtree.
     */
    private AVLNode<T> removeHelper(AVLNode<T> current, T data, AVLNode<T> dummy) {
        if (current == null) {
            return null; // Data not found
        }

        int compare = data.compareTo(current.getData());

        if (compare < 0) {
            current.setLeft(removeHelper(current.getLeft(), data, dummy));
        } else if (compare > 0) {
            current.setRight(removeHelper(current.getRight(), data, dummy));
        } else {
            // We found the node to remove
            dummy.setData(current.getData());

            if (current.getLeft() == null && current.getRight() == null) {
                return null; // Leaf node
            } else if (current.getLeft() == null) {
                return current.getRight(); // Only right child
            } else if (current.getRight() == null) {
                return current.getLeft(); // Only left child
            } else {
                // Two children case
                AVLNode<T> successorDummy = new AVLNode<>(null);
                current.setRight(removeSuccessor(current.getRight(), successorDummy));
                current.setData(successorDummy.getData());
            }
        }

        return balance(current);
    }

    /**
     * Private helper to find and remove the successor.
     * @param current The current node in the search for the successor.
     * @param dummy A holder node to capture the successor's data.
     * @return The root of the modified (and balanced) subtree.
     */
    private AVLNode<T> removeSuccessor(AVLNode<T> current, AVLNode<T> dummy) {
        if (current.getLeft() == null) {
            dummy.setData(current.getData());
            return current.getRight();
        }
        current.setLeft(removeSuccessor(current.getLeft(), dummy));
        // Balance on the way back up from removing the successor.
        return balance(current);
    }


    /**
     * Updates the height and balance factor of a node.
     */
    private void updateHeightAndBF(AVLNode<T> currentNode) {
        // PASTE YOUR CODE FROM PART 1 HERE
        int leftHeight = (currentNode.getLeft() == null) ? -1 : currentNode.getLeft().getHeight();
        int rightHeight = (currentNode.getRight() == null) ? -1 : currentNode.getRight().getHeight();
        currentNode.setHeight(Math.max(leftHeight, rightHeight) + 1);
        currentNode.setBalanceFactor(leftHeight - rightHeight);
    }

    /**
     * Rotates a current node to the left.
     */
    private AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
        // PASTE YOUR CODE FROM PART 1 HERE
        AVLNode<T> newRoot = currentNode.getRight();
        currentNode.setRight(newRoot.getLeft());
        newRoot.setLeft(currentNode);
        updateHeightAndBF(currentNode);
        updateHeightAndBF(newRoot);
        return newRoot;
    }

    /**
     * Rotates a current node to the right.
     */
    private AVLNode<T> rotateRight(AVLNode<T> currentNode) {
        // PASTE YOUR CODE FROM PART 1 HERE
        AVLNode<T> newRoot = currentNode.getLeft();
        currentNode.setLeft(newRoot.getRight());
        newRoot.setRight(currentNode);
        updateHeightAndBF(currentNode);
        updateHeightAndBF(newRoot);
        return newRoot;
    }

    /**
     * Balances out the tree starting at the node passed in.
     */
    private AVLNode<T> balance(AVLNode<T> currentNode) {
        // PASTE YOUR CODE FROM PART 1 HERE
        updateHeightAndBF(currentNode);

        if (currentNode.getBalanceFactor() < -1) { // Right-heavy
            if (currentNode.getRight().getBalanceFactor() > 0) { // Right-Left case
                currentNode.setRight(rotateRight(currentNode.getRight()));
            }
            currentNode = rotateLeft(currentNode);
        } else if (currentNode.getBalanceFactor() > 1) { // Left-heavy
            if (currentNode.getLeft().getBalanceFactor() < 0) { // Left-Right case
                currentNode.setLeft(rotateLeft(currentNode.getLeft()));
            }
            currentNode = rotateRight(currentNode);
        }

        return currentNode;
    }

    /**
     * Returns the root of the tree.
     */
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}