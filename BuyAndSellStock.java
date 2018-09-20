public class BuyAndSellStock {

  public int maxProfit(int[] prices) {
    if (prices.length == 0)
      return 0;
    int min = prices[0];
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }
      if (profit < prices[i] - min) {
        profit = prices[i] - min;
      }
    }
    return profit;
  }

  public static void main(String...args) {
    int[] arr = { 7, 1, 5, 3, 6, 4 };
    BuyAndSellStock obj = new BuyAndSellStock();
    System.out.println(obj.maxProfit(arr));
  }
}
