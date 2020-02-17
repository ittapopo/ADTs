package Chapter2;

import Chapter1.BagInterface;

/**ArrayBag.java
 * A class of bags whose entries are stored in a fixed-size array.
 * @author Frank M. Carrano
 * @version 4.0
 */
public class ArrayBag<T> implements BagInterface<T>
{
    private final T[] bag;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given capacity
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity)
    {
        if (desiredCapacity <= MAX_CAPACITY)
        {
            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity]; //Uncheck cast
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
            //Test that contents are nulls - OK
            //for (int index = 0; index < desiredCapacity; index++)
            //    System.out.print(bag[index] + " ");
            //System.out.println();
        }
        else
            throw new IllegalStateException("Attempt to create a bag "
                + "whose capacity exceeds allowed maximum.");
    }

    /**
     * Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return true if the addiion is successful, or false if not.
     */
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

        /**
         * Retrives all entries that are in this bag.
         * @return A newly allocated array of all the entries in this bag. */
         //public <T> T[] toArray()     //OK
        public T[] toArray()    //OK
        {
            checkInitialization();

            //The cast is sage because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] result = (T[])new Object[numberOfEntries];

            for (int index = 0; index < numberOfEntries; index++)
            {
                result[index] = bag[index];
            }
            return result;
            //Note:
            //The body of this method could consist of one return statement,
            //if you just call Arrays.copyOf().
        }

        /**
         * Test whether this bag is empty
         * @return True if this bag is empty, or false if not.
         */
        public boolean isEmpty()
        {
            return numberOfEntries == 0;
        }

        /**
         * Gets the current number of entries in this bag.
         * @return The integer number of entries currently in this bag.
         */
        public int getCurrentSize()
        {
            return numberOfEntries;
        }

        /**
         * Counts the number of times a given entry appears in this bag.
         * @param anEntry The entry to be counted.
         * @return The number of times anEntry appears in this bag.
         */
        public int getFrequencyOf(T anEntry)
        {
            checkInitialization();
            int counter = 0;
            for (int index = 0; index < numberOfEntries; index++)
            {
                if (anEntry.equals(bag[index]))
                {
                    counter++;
                }
            }
            return counter;
        }

        /**
         * Test whether this bag contains a given entry.
         * @param anEntry The entry to locate.
         * @return true if this bag contains anEntry, or false otherwise.
         */
        public boolean contains(T anEntry)
        {
            checkInitialization();
            return getIndexOf(anEntry) > -1; // or >= 0
        }

        /** Removes all entries from this bag. */
        public void clear()
        {
            while (!isEmpty())
                remove();
        }

        /**
         * Removes one unspecified entry from this bag, if possible.
         * @return Either the removed entry, if the removal was
         * successful, or null.
         */
        public T remove()
        {
            checkInitialization();
            T result = removeEntry(numberOfEntries -1);
            return result;
        }

        /**
         * Removes one occurrence of a given entry from this bag.
         * @param anEntry The entry to be removed.
         * @return True if the removal was successful, or false if not.
         */
        public boolean remove(T anEntry)
        {
            checkInitialization();
            int index = getIndexOf(anEntry);
            T result = removeEntry(index);
            return anEntry.equals(result);
        }

        //Returns true if the array bag is full, or false if not.
        private boolean isArrayFull()
        {
            return numberOfEntries >= bag.length;
        }

        //Locates a given entry within the array bag.
        //Returns the index of the entry if located, -1 otherwise.
        //Pre-condition: checkInitialization() has been called.
        private int getIndexOf(T anEntry)
        {
            int where = -1;
            boolean found = false;
            int index = 0;
            while (!found && (index < numberOfEntries))
            {
                if (anEntry.equals(bag[index]))
                {
                    found = true;
                    where = index;
                }
                index++;
            }
            //Assertion: If where > -1, anEntry is in the array bag, and it
            //equals bag[where]; otherwise, anEntry is not in the array.

            return where;
        }

        //Removes and returns the entry at a given index within the array.
        //If no such entry exists, return null.
        //Pre-condition: 0 <= givenIndex < numberOfEntries.
        //Pre-condition: checkInitialization() has been called.
        private T removeEntry(int givenIndex)
        {
            T result = null;

            if (!isEmpty() && (givenIndex >= 0))
            {
                result = bag[givenIndex]; //Entry to remove
                int lastIndex = numberOfEntries -1;

                //Replace entry to remove with last entry, then
                //remove regerence to last entry and adjust numberOfEntries
                bag[givenIndex] = bag[lastIndex];
                bag[lastIndex] = null;
                numberOfEntries--;
            }
            return result;
        }

        // Throws an exception if this object is not initialized
        private void checkInitialization()
        {
            if (!initialized)
                throw new SecurityException("ArrayBag objcet is not "
                    + "initialized properly.");
        }
}
