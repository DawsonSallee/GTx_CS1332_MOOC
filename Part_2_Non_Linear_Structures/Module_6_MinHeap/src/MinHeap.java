import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) {
            throw new java.lang.IllegalArgumentException("Error: some exception was thrown");
        }

        if(backingArray.length == size + 1) {
            T[] newbackingArray = (T[]) new Comparable[backingArray.length * 2];
            
            for(int i = 1; i <= size; i++) {
                newbackingArray[i] = backingArray[i];
            }

            backingArray = newbackingArray;
        }

        size++; 
        backingArray[size] = data;

        int itemIndex = size;

        while(itemIndex > 1 && backingArray[itemIndex].compareTo(backingArray[itemIndex/2]) < 0) {

            T temp = backingArray[itemIndex];
            backingArray[itemIndex] = backingArray[itemIndex/2];
            backingArray[itemIndex/2] = temp;

            itemIndex = itemIndex/2;
        }

    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size == 0) {
            throw new java.util.NoSuchElementException("Error: some exception was thrown");
        }

        T removedData = backingArray[1];

        backingArray[1] = backingArray[size];

        backingArray[size] = null;

        size--;

        if (size == 0) { 
            return removedData;
        }

        int itemIndex = 1;


        while (2 * itemIndex <= size) {
            int leftChildIndex = 2 * itemIndex;
            int rightChildIndex = 2 * itemIndex + 1;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex <= size && backingArray[rightChildIndex].compareTo(backingArray[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (backingArray[itemIndex].compareTo(backingArray[smallerChildIndex]) <= 0) {
                break;
            }

            T temp = backingArray[itemIndex];
            backingArray[itemIndex] = backingArray[smallerChildIndex];
            backingArray[smallerChildIndex] = temp;

            itemIndex = smallerChildIndex;
        }

        return removedData;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}