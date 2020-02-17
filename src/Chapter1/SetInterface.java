package Chapter1;

/**
 * An interface that describes the operations of a set of objects.
 */
public interface SetInterface<T>
{
    public int getCurrentSize();
    public boolean isEmpty();

    public boolean add(T newEntry);

    public boolean remove(T anEntry);

    public T remove();
    public void clear();
    public boolean contains(T anEntry);
    public T[] toArray();
} // end SetInterface
