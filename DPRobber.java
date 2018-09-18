import java.util.HashMap;

public class DPRobber {

  public int findMax(int[] arr, int index, HashMap<Integer, Integer> map) {
    if(index >= arr.length)
      return 0;

    int nextNode = 0;
    if (index + 1 < arr.length) {
      nextNode = arr[index + 1];
    }
    int currentNode = arr[index];

    int index2 = index + 2;
    int index3 = index + 3;
    int sum1 = 0, sum2 = 0;
    if (map.containsKey(index2)) {
      sum1 = map.get(index2);
    } else {
      sum1 = findMax(arr, index2, map);
      map.put(index2, sum1);
    }
    if (map.containsKey(index3)) {
      sum2 = map.get(index3);
    } else {
      sum2 = findMax(arr, index + 3, map);
      map.put(index3, sum2);
    }
    
    return Math.max(currentNode + sum1, nextNode + sum2);
  }

  public static void main(String...args) {
    int[] arr = {2, 7, 9, 3, 1};
    // int[] arr = {1, 2, 3, 1};
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    DPRobber robber = new DPRobber();
    if (arr.length == 0) {
      System.out.println(0);
    } else if (arr.length == 1) {
      System.out.println(arr[0]);
    } else {
      int max = robber.findMax(arr, 0, map);
      System.out.println(max);
    }
  }
}
