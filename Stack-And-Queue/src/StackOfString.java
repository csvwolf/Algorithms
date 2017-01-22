/**
 * Created by SkyAo on 2017/1/17.
 */
public interface StackOfString<Item> {
    /**
     * insert a new string onto stack
     * @param item
     */
    public void push(Item item);

    /**
     * remove and return the string most recently added
     * @return
     */
    public Item pop();

    /**
     * is the stack empty
     * @return
     */
    public boolean isEmpty();

    /**
     * number of strings in stack
     * @return
     */
    public int size();
}
