public class DPKnapsack {

  private int[][] mem;
  private int[] weight;
  private int[] value;

  public DPKnapsack(int[] weight, int[] value, int capacity) {
    this.weight = weight;
    this.value = value;
    mem = new int[value.length][capacity];
  }

  public int findMaximum(int capacity, int n) {
    if (n < 0 || capacity <= 0)
      return 0;

    if (mem[n][capacity - 1] != 0)
      return mem[n][capacity - 1];
    
    if (weight[n] > capacity)
      return findMaximum(capacity, n - 1);
    
    int maxValue = Math.max(
      value[n] + findMaximum(capacity - weight[n], n - 1),
      findMaximum(capacity, n - 1)
    );
    mem[n][capacity - 1] = maxValue;
    return maxValue;
  }

  public static void main(String...args) {
    int[] weight = { 10, 20, 30 };
    int[] value = { 60, 100, 120 };
    int capacity = 50;
    DPKnapsack obj = new DPKnapsack(weight, value, capacity);
    System.out.println(obj.findMaximum(capacity, weight.length - 1));
  }
}
