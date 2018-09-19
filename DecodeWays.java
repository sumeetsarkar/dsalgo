import java.util.HashMap;

public class DecodeWays {

  public int numDecodings(String s) {
    if (s.equals("0") || s.replace("0", "").equals(""))
      return 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    return findWays(s, map);
  }

  int findWays(String s, HashMap<String, Integer> map) {
    if (s.length() == 0)
      return 0;
    if (s.equals("0"))
        return 0;
    if (s.length() == 1)
      return 1;
    // System.out.println(">>>" + s.substring(0, 1) + " >" + s.substring(1, s.length()) + "<");
    int way1 = 0;
    int way2 = 0;
    if (Integer.parseInt(s.substring(0, 1)) > 0
      && Integer.parseInt(s.substring(0, 1)) <= 26) {
      String s1 = s.substring(1, s.length());
      if (map.containsKey(s1)) {
        way1 = map.get(s1);
      } else {
        way1 = findWays(s1, map);
        map.put(s1, way1);
      }
    }
    if (Integer.parseInt(s.substring(0, 2)) > 0
      && Integer.parseInt(s.substring(0, 2)) <= 26
      && !s.substring(0, 1).equals("0")) {
      // System.out.println(">" + s.substring(0, 2) + "  >" + s.substring(2, s.length()) + "<");
      String s2 = s.substring(2, s.length());
      if (s2.length() > 0) {
        if (map.containsKey(s2)) {
          way2 = map.get(s2);
        } else {
          way2 = findWays(s2, map);
          map.put(s2, way2);
        }
      } else {
        way2 = 1;
      }
    }
    return way1 + way2;
  }

  public static void main(String...args) {
    String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
    DecodeWays obj = new DecodeWays();
    System.out.println(obj.numDecodings(s));
  }
}
