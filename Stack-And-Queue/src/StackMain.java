/**
 * Created by SkyAo on 2017/1/22.
 */
public class StackMain {
    public static void main(String[] args) {
        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(2);

        stack.push("hello");
        stack.push("world");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
