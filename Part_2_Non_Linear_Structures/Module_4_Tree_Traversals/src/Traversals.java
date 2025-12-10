import java.util.List;
import java.util.ArrayList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        List<T> preorderList = new ArrayList<>();

        preorderHelper(root, preorderList);

        return preorderList;
    }

    private void preorderHelper(TreeNode<T> current, List<T> preorderList) {
        
        if(current == null) {
            return;
        }

        preorderList.add(current.getData());
        preorderHelper(current.getLeft(), preorderList);
        preorderHelper(current.getRight(), preorderList);
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> inorderList = new ArrayList<>();

        inorderHelper(root, inorderList);

        return inorderList;
    }

    private void inorderHelper(TreeNode<T> current, List<T> inorderList) {
        if(current == null) {
            return;
        }

        inorderHelper(current.getLeft(), inorderList);
        inorderList.add(current.getData());
        inorderHelper(current.getRight(), inorderList);

    }
    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> postorderList = new ArrayList<>();
        postorderHelper(root, postorderList);
        return postorderList;
    }

    private void postorderHelper(TreeNode<T> current, List<T> postorderList) {
        if(current == null) {
            return;
        }

        postorderHelper(current.getLeft(), postorderList);
        postorderHelper(current.getRight(), postorderList);
        postorderList.add(current.getData());
    }
}