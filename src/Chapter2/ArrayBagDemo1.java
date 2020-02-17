package Chapter2;

import Chapter1.BagInterface;

/**
 * A test of the constructors and the methods add and toArray.
 * as defined in the first draft of the class ArrayBag.
 * @author Frank M. Carrano
 */
public class ArrayBagDemo1
{
    public static void main(String[] args)
    {
        // Adding to an initially empty bag with sufficient capacity
        System.out.println("Testing an initially empty bag with" +
                " the capacity to hold at least 6 strings:");
        BagInterface<String> aBag = new ArrayBag<> ();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);

        // Filling an initially empty bag to capacity
        System.out.println("\nTesting an initially empty bag that " +
                " will be filled to capacity:");
        aBag = new ArrayBag<>(7);
        String[] contentOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(aBag, contentOfBag2);
    } // en main

    //Test the method add.
    private static void testAdd(BagInterface<String> aBag, String[] content)
    {
        System.out.println("Adding the following " + content.length +
                " strings to the bag: ");
        for (int index = 0; index < content.length; index++)
        {
            if (aBag.add(content[index]))
                System.out.println(content[index] + " ");
            else
                System.out.print("\nUnable to add " + content[index] +
                        " to the bag.");
        } //end for
        System.out.println();

        displayBag(aBag);
    } //end testAdd

    // Test the method toArray while displaying the bag.
    private static void displayBag(BagInterface<String> aBag)
    {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++)
        {
            System.out.println(bagArray[index] + " ");
        } // end for

        System.out.println();
    } // end displayBag
} // end ArrayBagDemo1
