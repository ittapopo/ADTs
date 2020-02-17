package JavaInterlude1;

/**
 * A class of ordered pairs of objects having the same data type.
 */
public class OrderedPair<T> implements Pairable<T>
{
    private T first, second;

    public OrderedPair(T firstItem, T secondItem)   //NOTE: no <T> after
    {                                               // constructor name
        first = firstItem;
        second = secondItem;
    } // end constructor

    /** returns the first object in this pair. */
    public T getFirst()
    {
        return first;
    } // end getFirst

    /** returns the second item in this pair. */
    public T getSecond()
    {
        return second;
    } // end getSecond

    public String toString()
    {
        return "(" + first + "," + second + ")";
    }

    public void changeOrder()
    {
        T temp = first;
        first = second;
        second = temp;
    } // change order
} // end OrderedPair
