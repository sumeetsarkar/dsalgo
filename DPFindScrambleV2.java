import java.util.HashMap;

public class DPFindScrambleV2 {

  public boolean isScramble(String s1, String s2) {
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    return isScramble_R1(s1, s2, map);
  }

  public boolean isScramble_R1(String s1, String s2, HashMap<String, Boolean> map) {
    if (s1.length() != s2.length())
      return false;
    String s2Reverse = new StringBuilder(s2).reverse().toString();
    return (map.containsKey(s1 + ":" + s2) || isScramble_R2(s1, s2, map))
      || (map.containsKey(s1 + ":" + s2Reverse) || isScramble_R2(s1, s2Reverse, map));
  }

  public boolean isScramble_R2(String s1, String s2, HashMap<String, Boolean> map) {

    if (s1.equals(s2) && !s1.equals(""))
      return true;
    if (s1.length() == 1)
      return false;
    if (s1.equals(new StringBuilder(s2).reverse().toString()))
      return true;

    boolean isSub1Scrambled = false;
    boolean isSub2Scrambled = false;
    // System.out.println("***" + s1 + " " + s2);

    if (map.containsKey(s1 + ":" + s2))
      return true;

    for (int i = 0; i < s1.length() - 1; i++) {

      // System.out.println(i);
      String s1Sub1 = s1.substring(0, i + 1);
      String s2Sub1 = s2.substring(0, i + 1);
      // System.out.println("> " + s1Sub1 + " " + s2Sub1 + "  >> " + s1 + " " + s2);

      String s1Sub2 = s1.substring(i + 1, s1.length());
      String s2Sub2 = s2.substring(i + 1, s2.length());
      // System.out.println("> " + s1Sub2 + " " + s2Sub2 + "  >> " + s1 + " " + s2);

      isSub1Scrambled = map.containsKey(s1Sub1 + ":" + s2Sub1) || isScramble_R1(s1Sub1, s2Sub1, map);
      isSub2Scrambled = map.containsKey(s1Sub2 + ":" + s2Sub2) || isScramble_R1(s1Sub2, s2Sub2, map);
      if (isSub1Scrambled)
        map.put(s1Sub1 + ":" + s2Sub1, isSub1Scrambled);
      if (isSub2Scrambled)
        map.put(s1Sub2 + ":" + s2Sub2, isSub2Scrambled);
      if (isSub1Scrambled && isSub2Scrambled) {
        map.put(s1 + ":" + s2, true);
        return true;
      }
    }
    return false;
  }

  public static void main(String...args) {
    DPFindScrambleV2 obj = new DPFindScrambleV2();
    String s1 = "abcdefghijklmn";
    String s2 = "efghijklmncadb";
    System.out.println(obj.isScramble(s1, s2));
  }
}
