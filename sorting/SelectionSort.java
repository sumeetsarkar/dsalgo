public class SelectionSort {
  // bring smallest number first

  public static void main(String...args) {
    int[] arr = { 19, 3, 56, 8, 21, 5, 30 };
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min]) {
          int temp = arr[j];
          arr[j] = arr[min];
          arr[min] = temp;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
