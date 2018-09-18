public class MaximumSumSubarray {

  public int findMaxSumSubarray(int[] arr) {
    if (arr.length == 0)
      return 0;
    int maximum = 0;
    int sumEnding = 0;
    for (int i = 0; i < arr.length; i++) {
      sumEnding = sumEnding + arr[i];
      if (sumEnding < 0)
        sumEnding = 0;
      if (sumEnding > maximum) {
        maximum = sumEnding;
      }
    }
    return maximum;
  }

  public static void main(String...args) {
    MaximumSumSubarray mss = new MaximumSumSubarray();
    int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(mss.findMaxSumSubarray(arr));
  }
}
