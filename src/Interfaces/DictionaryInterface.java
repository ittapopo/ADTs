package Interfaces;

import java.util.Iterator;

public interface DictionaryInterface<K, V> {

    public V add(K key, V value);

    public V remove(K Key);

    public V getValue(K Key);

    public boolean contains(K Key);

    public Iterator<K> getKeyIterator();

    public Iterator<V> getValueIterator();

    public boolean isEmpty();

    public int getSize();

    public void clear();
}
