public class BubbleSort {
  // bubble down the largest number to bottom

  public static void main(String...args) {
    int[] arr = { 19, 3, 56, 8, 21, 5, 30 };
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
