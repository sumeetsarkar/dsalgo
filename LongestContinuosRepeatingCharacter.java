import java.util.HashMap;

class Item {
  char data = Character.MIN_VALUE;
  int count = 0;
  Item() {}
  Item(char data, int count) {
    this.data = data;
    this.count = count;
  }
}

public class LongestContinuosRepeatingCharacter {

  public Item find(String s) {
    char[] arr = s.toCharArray();
    char charRepeated = Character.MIN_VALUE;

    if (arr.length == 0)
      return new Item();
    
    int currCharCount = 0;
    int maxCharCount = 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    map.put(arr[0], 1);
    currCharCount = maxCharCount = 1;
    
    for (int i = 1; i < arr.length; i ++) {
      if (arr[i - 1] == arr[i]) {
        currCharCount += 1;
        if (map.get(arr[i]) == null || map.get(arr[i]) < currCharCount) {
          map.put(arr[i], currCharCount);
        }
        if (maxCharCount < currCharCount) {
          maxCharCount = currCharCount;
          charRepeated = arr[i];
        }
      } else {
        currCharCount = 1;
      }
    }
    return new Item(charRepeated, maxCharCount);
  }

  public static void main(String...args) {
    LongestContinuosRepeatingCharacter obj = new LongestContinuosRepeatingCharacter();
    String s = "acabccccbbbdccddd";
    Item item = obj.find(s);
    System.out.println(item.data + " " + item.count);
  }
}
