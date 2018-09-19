public class ProductofArrayExceptSelf {

  int helper(int[] nums, int index) {
    int prod = 1;
    for (int i = 0; i < nums.length; i++) {
      if (i != index)
        prod *= nums[i];
    }
    return prod;
  }

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = helper(nums, 0);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0)
        result[i] = result[i - 1]/nums[i] * nums[i - 1];
      else
        result[i] = helper(nums, i);
    }
    return result;
  }

  public static void main(String...args) {
    int[] arr = {2, 2, 0, 2, 2};
    ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
    arr = obj.productExceptSelf(arr);
    for (int i : arr)
      System.out.printf("%d ", i);
  }
}

// Try without division - left product and right product in O(n)
