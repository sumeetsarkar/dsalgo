public class PredictTheWinner {

  public int predictHelper(int[] nums, int i, int j, int turn) {
    if (i == j)
      return turn * nums[i];
    int sumA = (turn * nums[i]) + predictHelper(nums, i + 1, j, turn * -1);
    int sumB = (turn * nums[j]) + predictHelper(nums, i, j - 1, turn * -1);
    return turn * Math.max(turn * sumA, turn * sumB);
  }

  public boolean predict(int[] nums) {
    return predictHelper(nums, 0, nums.length - 1, 1) >= 0;
  }

  public static void main(String...args) {
    PredictTheWinner ptw = new PredictTheWinner();
    int nums[] = {1, 3, 233, 5};
    System.out.println(ptw.predict(nums));
  }
}
