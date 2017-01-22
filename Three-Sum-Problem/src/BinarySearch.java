/**
 * Created by SkyAo on 2017/1/22.
 */
public class BinarySearch {
    private int[] sortedArr;

    public BinarySearch(int[] arr) {
        sortedArr = arr;
    }

    int search(int key) {
        int low = 0;
        int high = sortedArr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;   // (low + high) / 2 会存在整形溢出的问题
            if (sortedArr[mid] == key) return mid;
            if (sortedArr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
