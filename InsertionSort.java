public class InsertionSort {
  // insert every element to correct position

  public static void main(String...args) {
    int[] arr = { 19, 3, 56, 8, 21, 5, 30 };
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int hole = i;
      int value = arr[hole];

      while (hole > 0 && arr[hole - 1] > value) {
        arr[hole] = arr[hole - 1];
        hole = hole - 1;
      }
      arr[hole] = value;
    }
    
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
