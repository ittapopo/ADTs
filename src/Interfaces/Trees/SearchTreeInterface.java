package Interfaces.Trees;

import java.util.Iterator;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T>
{
    public boolean contains(T entry);

    public T getEntry(T entry);

    public T add(T newEntry);

    public T remove();

    public Iterator<T> getInorderIterator();
}
