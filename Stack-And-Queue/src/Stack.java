/**
 * Created by SkyAo on 2017/1/17.
 */
public interface Stack {
    /**
     * insert a new string onto stack
     * @param item
     */
    public void push(String item);

    /**
     * remove and return the string most recently added
     * @return
     */
    public String pop();

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
