import java.util.Arrays;

public class BinarySearch {

    public void search(int[] arr, int num) {
        System.out.println("Index of " + num + " \t: " + find(arr, num));
    }

    int find(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start*-1 - 1;
    }

    public static void main(String...args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = { 2, 3, 4, 7, 8, 9, 10 };
        bs.search(arr, 4);
        bs.search(arr, 9);
        bs.search(arr, 10);
        bs.search(arr, 1);
        bs.search(arr, 6);
        bs.search(arr, 11);
    }
}
