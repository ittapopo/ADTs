package Chapter1;

/** Item.java
 *  A class of items for sale.
 * @author Frank M. Carrano
 * @version 4.0
 */
public class Item
{
    private String description;
    private int price;
    public Item(String productDescription, int productPrice)
    {
        description = productDescription;
        price = productPrice;
    }
    public String getDescription()
    {
        return description;
    }
    public int getPrice()
    {
        return price;
    }
    public String toString()
    {
        return description + "\t$" + price / 100 + "." + price % 100;
    }
}
