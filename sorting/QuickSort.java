public class QuickSort {
  
  public int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int pi = start;
    for (int i = start; i <= end - 1; i++) {
      if (arr[i] <= pivot) {
        int temp = arr[i];
        arr[i] = arr[pi];
        arr[pi] = temp;
        pi = pi + 1;
      }
    }
    int temp = arr[pi];
    arr[pi] = arr[end];
    arr[end] = temp;
    return pi;
  }

  public void sort(int[] arr, int start, int end) {
    if (start < end) {
      int p = partition(arr, start, end - 1);
      sort(arr, start, p);
      sort(arr, p + 1, end);
    }
  }

  public static void main(String...args) {
    int[] arr = { 19, 3, 56, 8, 21, 5, 30 };
    int n = arr.length;
    QuickSort quickSort = new QuickSort();
    quickSort.sort(arr, 0, n);
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
