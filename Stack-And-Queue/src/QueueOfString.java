/**
 * Created by SkyAo on 2017/1/22.
 */
public interface QueueOfString {
    public void enqueue(String item);
    public String dequeue();
    public boolean isEmpty();
    public int size();
}
