public class DPFibonacci {
  public static void main(String...args) {
    int n = 10;
    int[] store = new int[n];

    int i;
    for (i = 0; i < n; i++) {
      if (i == 0 || i == 1) {
        store[i] = 1;
      } else {
        store[i] = store[i - 1] + store[i - 2];
      }
    }
    System.out.println(store[i - 1]);
  }
}