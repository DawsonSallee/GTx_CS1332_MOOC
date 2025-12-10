public class BSTNode<T extends Comparable<? super T>> {
    T data;
    BSTNode<T> left;
    BSTNode<T> right;

    public BSTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return this.right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }
}
