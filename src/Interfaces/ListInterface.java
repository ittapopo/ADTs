package Interfaces;

public interface ListInterface<T> {

    public void add(T newEntry);

    public void add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public T replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public T[] toArray();

    public boolean contains(T newEntry);

    public int getLength();

    public boolean isEmpty();
}
