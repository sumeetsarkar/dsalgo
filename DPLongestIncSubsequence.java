import java.util.Arrays;

public class DPLongestIncSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      System.out.println("i = " + i + " len = " + len + " num = " + num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return len;
  }

  public static void main(String...args) {
    DPLongestIncSubsequence obj = new DPLongestIncSubsequence();
    int[] arr = { 0, 8, 4, 12, 2 };
    System.out.println(obj.lengthOfLIS(arr));
  }
}