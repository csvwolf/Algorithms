/**
 * Three Sum Problem: 求出数组中任意三个数相加合为 0 的个数
 * Created by SkyAo on 2017/1/22.
 */
public class ThreeSum {
    private int[] sortedArr;
    private BinarySearch search;
    private int counter;

    public ThreeSum(int[] arr) {
        sortedArr = arr;
        search = new BinarySearch(arr);
    }

    public int countZero() {
        int length = sortedArr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (search.search(-(sortedArr[i] + sortedArr[j])) != -1) counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] sortedArr = {-4, -2, -1, 0, 1, 2, 4};
        ThreeSum threeSum = new ThreeSum(sortedArr);
        System.out.println(threeSum.countZero());
    }
}
