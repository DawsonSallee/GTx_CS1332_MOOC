public class ExternalChainingMapEntry<K, V> {

    private K key;
    private V value;
    private ExternalChainingMapEntry<K, V> next;

    /**
     * Creates a new external chaining map entry.
     *
     * @param key   The key of the entry.
     * @param value The value of the entry.
     */
    public ExternalChainingMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public ExternalChainingMapEntry(K key, V value, ExternalChainingMapEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * Gets the key of the entry.
     *
     * @return The key of the entry.
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value of the entry.
     *
     * @return The value of the entry.
     */
    public V getValue() {
        return value;
    }

    /**
     * Gets the next entry in the chain.
     *
     * @return The next entry in the chain.
     */
    public ExternalChainingMapEntry<K, V> getNext() {
        return next;
    }

    /**
     * Sets the value of the entry.
     *
     * @param value The new value of the entry.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Sets the next entry in the chain.
     *
     * @param next The new next entry in the chain.
     */
    public void setNext(ExternalChainingMapEntry<K, V> next) {
        this.next = next;
    }
}