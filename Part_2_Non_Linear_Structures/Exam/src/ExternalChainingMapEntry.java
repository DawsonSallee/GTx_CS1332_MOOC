/**
 * Entry node for an external chaining hash map.
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class ExternalChainingMapEntry<K, V> {

    private K key;
    private V value;
    private ExternalChainingMapEntry<K, V> next;

    /**
     * Constructs a new ExternalChainingMapEntry with the given key and value.
     *
     * @param key   the key in the new entry
     * @param value the value in the new entry
     */
    public ExternalChainingMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Gets the next entry.
     *
     * @return the next entry
     */
    public ExternalChainingMapEntry<K, V> getNext() {
        return next;
    }

    /**
     * Sets the key.
     *
     * @param key the new key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**

     * Sets the next entry.
     *
     * @param next the new next entry
     */
    public void setNext(ExternalChainingMapEntry<K, V> next) {
        this.next = next;
    }
}