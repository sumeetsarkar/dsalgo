public class MergeSort {

  public int[] sort(int[] arr) {
    int n = arr.length;
    if (n < 2)
      return arr;
    int mid = n/2;
    int[] left = new int[mid];
    int[] right = new int[n - mid];
    for (int i = 0; i < left.length; i++) {
      left[i] = arr[i];
    }
    for (int i = 0, j = mid; i < right.length; i++, j++) {
      right[i] = arr[j];
    }
    sort(left);
    sort(right);
    return merge(left, right, arr);
  }

  public int[] merge(int[] left, int[] right, int[] arr) {
    int ln = left.length;
    int rn = right.length;
    int i = 0, j = 0, k = 0;
    while(i < ln && j < rn) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    while(i < ln) {
      arr[k] = left[i];
      i++;
      k++;
    }
    while(j < rn) {
      arr[k] = right[j];
      j++;
      k++;
    }
    return arr;
  }
  
  public static void main(String...args) {
    int[] arr = { 19, 3, 56, 8, 21, 5, 30 };
    int n = arr.length;

    MergeSort mergeSort = new MergeSort();
    arr = mergeSort.sort(arr);
    
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", arr[i]);
    }
  }
}
