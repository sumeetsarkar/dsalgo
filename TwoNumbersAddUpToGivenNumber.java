import java.util.HashMap;

public class TwoNumbersAddUpToGivenNumber {

  public boolean checkIfTwoNumbersAddUp(int[] arr, int sum) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == sum) {
        break;
      }
      if (map.get(arr[i]) != null)
        return true;
      map.put((sum - arr[i]), i);
    }
    return false;
  }

  public static void main(String...args) {
    int[] arr = { 10, 15, 3, 7 };
    int sum = 17;
    TwoNumbersAddUpToGivenNumber obj = new TwoNumbersAddUpToGivenNumber();
    System.out.println(obj.checkIfTwoNumbersAddUp(arr, sum));
  }
}
